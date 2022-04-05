package com.theoxao.duraemon.recipe.craw

import com.fasterxml.jackson.databind.ObjectMapper
import com.theoxao.duraemon.orm.dto.Tables
import com.theoxao.duraemon.orm.dto.Tables.RECIPE_JSON
import com.theoxao.duraemon.orm.dto.Tables.TB_RECIPE
import com.theoxao.duraemon.orm.dto.tables.records.ImageMapperRecord
import com.theoxao.duraemon.orm.dto.tables.records.TbRecipeRecord
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
import java.io.IOException
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.annotation.PostConstruct
import javax.annotation.Resource

val datetimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

@Component
class Crawler {

    private val log = LoggerFactory.getLogger(this::class.java)

    @Resource(name = "masterDSLContext")
    lateinit var masterDSLContext: DSLContext

    @Resource
    lateinit var objectMapper: ObjectMapper

//    val http = OkHttpClient.Builder()
//        .callTimeout(Duration.ofSeconds(30))
//        .readTimeout(Duration.ofSeconds(30))
//        .writeTimeout(Duration.ofSeconds(30))
//        .connectTimeout(Duration.ofSeconds(30)).build()

    //    @Scheduled(cron = "* * 12 1/1 * ?")
    fun scheduled() {
        val max = masterDSLContext.select(DSL.max(TB_RECIPE.ID)).from(TB_RECIPE).fetchAny()?.value1()!!
        ((max - 2000)..(max + 2000)).toMutableList().craw()
    }

    fun RecipeModel?.toRecipe(): TbRecipeRecord? {
        return this?.let { recipe ->
            TB_RECIPE.newRecord().apply {
                this.id = recipe.id
                this.desc = recipe.desc
                this.difficulty = recipe.difficulty.toJson()
                this.image = recipe.image.toJson()
                this.name = recipe.name
                this.summary = recipe.summary
                this.tips = recipe.tips
                this.label = recipe.labels.toJson()
                this.createTime = recipe.createTime?.let { LocalDateTime.parse(it, datetimeFormatter) }
                this.updateTime = LocalDate.of(1970, 1, 1).atStartOfDay()
                this.ingredient = recipe.ingredient.toJson()
                this.instruction = recipe.instruction.toJson()
                this.duration = recipe.duration.toJson()
                this.authorName = recipe.author?.name
                this.authorId = recipe.author?.id
                this.pv = recipe.stats?.nPv
                this.collect = recipe.stats?.nCollects
                this.comment = recipe.stats?.nComments
                this.cooked = recipe.stats?.nCooked
            }
        }
    }

    //    @PostConstruct
    fun i() {
        (106724821 downTo 100000000).toMutableList().craw()
    }

    @PostConstruct
    fun ii() {
        val batch = 1000
        while (true) {
            val mapperList = arrayListOf<ImageMapperRecord>()
            val list = masterDSLContext.selectFrom(RECIPE_JSON).where(RECIPE_JSON.TO_OBJ.eq(false)).limit(batch).fetch()
            val ids = list.map { it.id }
            val records = list
                .map { json ->
                    val resp = objectMapper.readValue(json.recipeJson.data()
                        .replace("\u0000" , "")
                        .replace("0x00", "")
                        .replace("\\u0000",""),
                        ResponseWrapper::class.java)
                    if (resp.status != "ok") {
                        log.error("request@{} is not ok", json.id)
                        return@map  null
                    }
                    log.error("request@{} is ok", json.id)
                    return@map  resp.content?.get("recipe")?.let { origin ->
                        val record = origin.toRecipe()?:return@let null
                        val image = objectMapper.readValue(record.image.data(), RecipeModel.Image::class.java)
                        image?.ident?.let { ident ->
                            mapperList.add(Tables.IMAGE_MAPPER.newRecord().apply {
                                val uid = UUID.randomUUID().toString()
                                this.uuid = uid
                                image.uuid = uid
                                record.image = image.toJson()
                                this.oid = record.id
                                this.type = 0
                                this.imageUrl = ident
                            })
                        }
                        val instrs = objectMapper.readValue<List<RecipeModel.Instruction>>(
                            record.instruction.data(),
                            objectMapper.typeFactory.constructParametricType(
                                List::class.java,
                                RecipeModel.Instruction::class.java
                            )
                        )
                        instrs?.forEach {
                            it.image?.ident?.let { ident ->
                                mapperList.add(Tables.IMAGE_MAPPER.newRecord().apply {
                                    val id = UUID.randomUUID().toString()
                                    this.uuid = id
                                    it.image?.uuid = id
                                    this.oid = record.id
                                    this.type = 0
                                    this.imageUrl = ident
                                })
                            }
                            it.video?.url?.let { url ->
                                mapperList.add(Tables.IMAGE_MAPPER.newRecord().apply {
                                    val id = UUID.randomUUID().toString()
                                    this.uuid = id
                                    it.video?.uuid = id
                                    this.oid = record.id
                                    this.type = 1
                                    this.imageUrl = url
                                })
                            }
                        }
                        record.instruction = instrs.toJson()
                        return@let record
                    }
                }.filterNotNull()
            masterDSLContext.trans {
                batchInsert(records).execute()
                batchInsert(mapperList).execute()
                update(RECIPE_JSON).set(RECIPE_JSON.TO_OBJ, true).where(RECIPE_JSON.ID.`in`(ids)).execute()
            }
        }

    }

    fun Any?.toJson(): JSON? = this?.let { JSON.valueOf(objectMapper.writeValueAsString(it)) }

    val base = "/home/theo/recipe"

    val http = OkHttpClient.Builder()
        .callTimeout(Duration.ofSeconds(30))
        .readTimeout(Duration.ofSeconds(30))
        .writeTimeout(Duration.ofSeconds(30))
        .connectTimeout(Duration.ofSeconds(30)).build()

    fun List<Int>.craw() {
        this.forEach { id ->
            val request = Request.Builder()
                .url("https://www.xiachufang.com/juno/api/v2/recipes/show_v2.json?id=${id}&mode=full")
                .get()
                .addHeader(
                    "User-Agent",
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.83 Safari/537.36"
                )
                .build()
            http.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    log.error(e.message, e)
                }

                override fun onResponse(call: Call, response: Response) {
                    if (response.isSuccessful) {
                        log.error("request@{} is ok", id)
                        response.body?.string()?.let { bytes ->
                            masterDSLContext.transaction { config ->
                                RECIPE_JSON.newRecord().apply {
                                    this.id = id
                                    this.recipeJson = JSON.valueOf(bytes)
                                }.let {
                                    DSL.using(config).executeInsert(it)
                                }
                            }
//                                val resp = objectMapper.readValue(json, ResponseWrapper::class.java)
//                                if ( resp.status != "ok") {
//                                    log.error("request@{} is not ok" , id)
//                                    response.closeQuietly()
//                                    return@let
//                                }
//                                log.error("request@{} is ok" , id)
//                                resp.content?.get("recipe")?.let { recipe->
//                                    val mapperList = arrayListOf<ImageMapperRecord>()
//                                    recipe.image?.ident?.let { ident->
//                                        mapperList.add(Tables.IMAGE_MAPPER.newRecord().apply {
//                                            val uid = UUID.randomUUID().toString()
//                                            this.uuid= uid
//                                            recipe.image?.uuid =   uid
//                                            this.oid = recipe.id
//                                            this.type = 0
//                                            this.imageUrl = ident
//                                        })
//                                    }
//                                    recipe.instruction?.filterNotNull()?.forEach {
//                                        it.image?.ident?.let { ident->
//                                            mapperList.add(Tables.IMAGE_MAPPER.newRecord().apply {
//                                                val uid = UUID.randomUUID().toString()
//                                                this.uuid= uid
//                                                it.image?.uuid = uid
//                                                this.oid = recipe.id
//                                                this.type = 0
//                                                this.imageUrl = ident
//                                            })
//                                        }
//                                        it.video?.url?.let { url->
//                                            mapperList.add(Tables.IMAGE_MAPPER.newRecord().apply {
//                                                val uid = UUID.randomUUID().toString()
//                                                this.uuid= uid
//                                                it.video?.uuid = uid
//                                                this.oid = recipe.id
//                                                this.type = 1
//                                                this.imageUrl = url
//                                            })
//                                        }
//                                    }
//                                    val record = recipe.toRecipe()
//                                    masterDSLContext.transaction { config ->
//                                        record?.let {
//                                            DSL.using(config).insertInto(TB_RECIPE).set(it).onConflictDoNothing().execute()
//                                        }
//                                        if (mapperList.isNotEmpty()){
//                                            DSL.using(config).batchInsert(mapperList).execute()
//                                        }
//                                    }
//                                }
                        }
                    }
                    response.closeQuietly()
                }
            })
        }
    }
}