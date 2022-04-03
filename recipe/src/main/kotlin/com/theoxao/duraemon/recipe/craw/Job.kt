package com.theoxao.duraemon.recipe.craw

import com.fasterxml.jackson.databind.ObjectMapper
import com.theoxao.duraemon.orm.dto.Tables.*
import com.theoxao.duraemon.orm.dto.tables.records.ImageMapperRecord
import com.theoxao.duraemon.recipe.model.ResponseWrapper
import okhttp3.*
import okhttp3.internal.closeQuietly
import org.jooq.DSLContext
import org.jooq.JSON
import org.jooq.impl.DSL
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.io.IOException
import java.time.Duration
import java.util.*
import javax.annotation.PostConstruct
import javax.annotation.Resource

@Component
class Job {

    private val log = LoggerFactory.getLogger(this::class.java)

    @Resource(name = "masterDSLContext")
    lateinit var masterDSLContext: DSLContext

    @Resource
    lateinit var objectMapper: ObjectMapper

    val http = OkHttpClient.Builder()
        .callTimeout(Duration.ofSeconds(30))
        .readTimeout(Duration.ofSeconds(30))
        .writeTimeout(Duration.ofSeconds(30))
        .connectTimeout(Duration.ofSeconds(30)).build()

    fun Any?.toJson(): JSON?=  this?.let { JSON.valueOf(objectMapper.writeValueAsString(it)) }

    @PostConstruct
    fun init(){
        val batch = 1000
        var last:Int? = 0
        while (true){
            val list =masterDSLContext.selectFrom(TB_RECIPE)
                .where(TB_RECIPE.ID.gt(last))
                .orderBy(TB_RECIPE.ID.desc()).limit(batch).fetch()
            last = list.lastOrNull()?.id
            if (list.isEmpty() || last == null) break
            list.forEach { record->
                val request = Request.Builder()
                    .url("https://www.xiachufang.com/juno/api/v2/recipes/show_v2.json?id=${record.id}&mode=full")
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
                        if (response.isSuccessful){
                            val wrapper = objectMapper.readValue(response.body?.string(), ResponseWrapper::class.java)
                            if (wrapper.status != "ok") return
                            log.info("id@{} is ok", record.id)
                            wrapper.content?.get("recipe")?.let { recipe->
                                val mapperList = arrayListOf<ImageMapperRecord>()
                                recipe.image?.ident?.let { ident->
                                    mapperList.add(IMAGE_MAPPER.newRecord().apply {
                                        val id = UUID.randomUUID().toString()
                                        this.uuid= id
                                        recipe.image?.uuid =   id
                                        this.oid = record.id
                                        this.type = 0
                                        this.imageUrl = ident
                                    })
                                }
                                recipe.instruction?.filterNotNull()?.forEach {
                                    it.image?.ident?.let { ident->
                                        mapperList.add(IMAGE_MAPPER.newRecord().apply {
                                            val id = UUID.randomUUID().toString()
                                            this.uuid= id
                                            it.image?.uuid = id
                                            this.oid = record.id
                                            this.type = 0
                                            this.imageUrl = ident
                                        })
                                    }
                                    it.video?.url?.let { url->
                                        mapperList.add(IMAGE_MAPPER.newRecord().apply {
                                            val id = UUID.randomUUID().toString()
                                            this.uuid= id
                                            it.video?.uuid = id
                                            this.oid = record.id
                                            this.type = 1
                                            this.imageUrl = url
                                        })
                                    }
                                }
                                masterDSLContext.transaction { config->
                                    if (mapperList.isNotEmpty())
                                        DSL.using(config).batchInsert(mapperList).execute()
                                    DSL.using(config).update(TB_RECIPE)
                                        .set(TB_RECIPE.INGREDIENT, recipe.ingredient.toJson())
                                        .set(TB_RECIPE.INSTRUCTION , recipe.instruction.toJson())
                                        .where(TB_RECIPE.ID.eq(recipe.id)).execute()
                                }
                            }
                        }
                        response.closeQuietly()
                    }
                })

            }
        }
    }
}