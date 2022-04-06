package com.theoxao.duraemon.recipe.craw

import com.fasterxml.jackson.databind.ObjectMapper
import com.theoxao.duraemon.orm.dto.Tables.IMAGE_MAPPER
import com.theoxao.duraemon.orm.dto.Tables.TB_RECIPE
import com.theoxao.duraemon.orm.dto.tables.records.ImageMapperRecord
import com.theoxao.duraemon.recipe.model.RecipeModel
import com.theoxao.duraemon.recipe.model.ResponseWrapper
import com.theoxao.duraemon.recipe.trans
import okhttp3.*
import okhttp3.internal.closeQuietly
import org.jooq.DSLContext
import org.jooq.JSON
import org.jooq.impl.DSL
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.io.File
import java.time.Duration
import java.util.*
import javax.annotation.PostConstruct
import javax.annotation.Resource

@Component
class Video {

    @Resource
    lateinit var objectMapper: ObjectMapper

    private val log = LoggerFactory.getLogger(this::class.java)

    @Resource(name = "masterDSLContext")
    lateinit var dslContext: DSLContext

    val http = OkHttpClient.Builder()
        .callTimeout(Duration.ofSeconds(0))
        .readTimeout(Duration.ofSeconds(0))
        .writeTimeout(Duration.ofSeconds(0))
        .connectTimeout(Duration.ofSeconds(0)).build()

    private val baseDir = "/home/theo/static/recipe"

    fun Any?.toJson(): JSON? = this?.let { JSON.valueOf(objectMapper.writeValueAsString(it)) }

    @PostConstruct
    fun init() {
        val where = dslContext.select(DSL.field("t2.oid", Int::class.java)).from(
            DSL.select(IMAGE_MAPPER.OID).from(IMAGE_MAPPER).where(IMAGE_MAPPER.TYPE.eq(2)).groupBy(IMAGE_MAPPER.OID)
                .asTable("t2")
        ).leftJoin(
            DSL.select(IMAGE_MAPPER.OID).from(IMAGE_MAPPER).where(IMAGE_MAPPER.TYPE.eq(4)).groupBy(IMAGE_MAPPER.OID)
                .asTable("t4")
        ).on(DSL.field("t4.oid", Int::class.java).eq(DSL.field("t2.oid", Int::class.java)))
            .where(DSL.field("t4.oid").isNull)
        log.info("{}", where)
        where.fetch().map { it.value1() }
            .forEach { oid ->
                log.info("oid:{}", oid)
                val mapperList = arrayListOf<ImageMapperRecord>()
                val recipe = getRecipe(oid) ?: return@forEach
                val origin = dslContext.selectFrom(TB_RECIPE).where(TB_RECIPE.ID.eq(oid)).fetchAny() ?: return@forEach
                origin.instruction = recipe.instruction?.onEach {
                    it ?: return@onEach
                    it.video?.url?.let { url ->
                        mapperList.add(IMAGE_MAPPER.newRecord().apply {
                            val id = UUID.randomUUID().toString()
                            this.uuid = id
                            it.video?.uuid = id
                            this.oid = oid
                            this.type = 4
                            this.imageUrl = url
                        })
                    }
                }.toJson()
                mapperList.forEach { mapper ->
                    log.info("mapper:{}", mapper.uuid)
                    val request = Request.Builder().url(mapper.imageUrl).get().build()
                    val response =   http.newCall(request).execute()
                    if (response.isSuccessful) {
                        val base = File(baseDir, "${mapper.oid.mod(100)}/${mapper.oid}")
                        if (!base.exists()) {
                            base.mkdirs()
                        }
                        val file = File(base, "${mapper.uuid}.${mapper.imageUrl.substringAfterLast(".").substringBefore("?")}")
                        response.body?.bytes()?.let {
                            file.writeBytes(it)
                            dslContext.transaction { config ->
                                DSL.using(config).update(IMAGE_MAPPER).set(IMAGE_MAPPER.DOWNLOAD, 1)
                                    .where(IMAGE_MAPPER.UUID.eq(mapper.uuid)).execute()
                            }
                        }
                    }
                    response.closeQuietly()
                    mapper.download = 1
                }
                dslContext.trans {
                    executeUpdate(origin)
                    batchInsert(mapperList).execute()
                }
            }
    }

    fun getRecipe(id: Int): RecipeModel? {
        val request = Request.Builder()
            .url("https://www.xiachufang.com/juno/api/v2/recipes/show_v2.json?id=${id}&mode=full")
            .get()
            .addHeader(
                "User-Agent",
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.83 Safari/537.36"
            )
            .build()
        val response = http.newCall(request).execute()
        response.use { resp ->
            if (resp.isSuccessful) {
                val raw = resp.body?.string() ?: return null
                val wrapper = objectMapper.readValue(raw, ResponseWrapper::class.java)
                if (wrapper.status != "ok") {
                    log.error("request@{} is not ok", id)
                    return null
                }
                log.error("request@{} is ok", id)
                return wrapper.content?.get("recipe")
            }
        }
        return null
    }
}