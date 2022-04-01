package com.theoxao.duraemon.recipe.craw

import com.fasterxml.jackson.databind.ObjectMapper
import com.theoxao.duraemon.orm.dto.Tables.*
import com.theoxao.duraemon.orm.dto.tables.records.ImageMapperRecord
import com.theoxao.duraemon.recipe.model.ResponseWrapper
import okhttp3.OkHttpClient
import org.jooq.DSLContext
import org.jooq.JSON
import org.jooq.impl.DSL
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.time.Duration
import java.util.*
import javax.annotation.PostConstruct
import javax.annotation.Resource

@Component
class Job {

    private val log = LoggerFactory.getLogger(this::class.java)

    @Resource(name = "masterDSLContext")
    lateinit var masterDSLContext: DSLContext


    @Resource(name="slaveDSLContext")
    lateinit var slaveDSLContent: DSLContext

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
            val list =slaveDSLContent.selectFrom(RECIPE_JSON)
                .where(RECIPE_JSON.ID.gt(last))
                .orderBy(RECIPE_JSON.ID).limit(batch).fetch()
            last = list.lastOrNull()?.id
            if (list.isEmpty() || last == null) break
            list.forEach { record->
                log.info("id@{}", record.id)
                val wrapper = objectMapper.readValue(record.recipeJson.data(), ResponseWrapper::class.java)
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
        }
    }
}