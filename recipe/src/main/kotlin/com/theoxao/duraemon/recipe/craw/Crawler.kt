package com.theoxao.duraemon.recipe.craw

import com.fasterxml.jackson.databind.ObjectMapper
import com.theoxao.duraemon.orm.dto.Tables
import com.theoxao.duraemon.orm.dto.Tables.RECIPE_JSON
import com.theoxao.duraemon.orm.dto.Tables.TB_RECIPE
import com.theoxao.duraemon.orm.dto.tables.records.ImageMapperRecord
import com.theoxao.duraemon.orm.dto.tables.records.TbRecipeRecord
import com.theoxao.duraemon.recipe.model.RecipeModel
import com.theoxao.duraemon.recipe.model.ResponseWrapper
import okhttp3.*
import okhttp3.internal.closeQuietly
import org.jooq.DSLContext
import org.jooq.JSON
import org.jooq.impl.DSL
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
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
        ((max-2000)..(max+2000)).toMutableList().craw()
    }

    fun RecipeModel?.toRecipe():TbRecipeRecord? {
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
                this.updateTime = LocalDate.of(1970,1,1).atStartOfDay()
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

    @PostConstruct
    fun i() {
        (106724821 downTo 100000000).toMutableList().craw()
    }

    fun Any?.toJson(): JSON?=  this?.let { JSON.valueOf(objectMapper.writeValueAsString(it)) }

    fun List<Int>.craw() {
        val http = OkHttpClient.Builder()
            .callTimeout(Duration.ofSeconds(30))
            .readTimeout(Duration.ofSeconds(30))
            .writeTimeout(Duration.ofSeconds(30))
            .connectTimeout(Duration.ofSeconds(30)).build()
        http.dispatcher.maxRequestsPerHost=200
        http.dispatcher.maxRequests = 200
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
                            response.body?.string()?.let { json ->
                                masterDSLContext.transaction { config->
                                    RECIPE_JSON.newRecord().apply{
                                        this.id = id
                                        this.recipeJson = JSON.valueOf(json)
                                    }
                                }
                                val resp = objectMapper.readValue(json, ResponseWrapper::class.java)
                                if ( resp.status != "ok") {
                                    log.error("request@{} is not ok")
                                    response.closeQuietly()
                                    return@let
                                }
                                log.error("request@{} is ok")
                                resp.content?.get("recipe")?.let { recipe->
                                    val mapperList = arrayListOf<ImageMapperRecord>()
                                    recipe.image?.ident?.let { ident->
                                        mapperList.add(Tables.IMAGE_MAPPER.newRecord().apply {
                                            val uid = UUID.randomUUID().toString()
                                            this.uuid= uid
                                            recipe.image?.uuid =   uid
                                            this.oid = recipe.id
                                            this.type = 0
                                            this.imageUrl = ident
                                        })
                                    }
                                    recipe.instruction?.filterNotNull()?.forEach {
                                        it.image?.ident?.let { ident->
                                            mapperList.add(Tables.IMAGE_MAPPER.newRecord().apply {
                                                val uid = UUID.randomUUID().toString()
                                                this.uuid= uid
                                                it.image?.uuid = uid
                                                this.oid = recipe.id
                                                this.type = 0
                                                this.imageUrl = ident
                                            })
                                        }
                                        it.video?.url?.let { url->
                                            mapperList.add(Tables.IMAGE_MAPPER.newRecord().apply {
                                                val uid = UUID.randomUUID().toString()
                                                this.uuid= uid
                                                it.video?.uuid = uid
                                                this.oid = recipe.id
                                                this.type = 1
                                                this.imageUrl = url
                                            })
                                        }
                                    }
                                    val record = recipe.toRecipe()
                                    masterDSLContext.transaction { config ->
                                        record?.let {
                                            DSL.using(config).insertInto(TB_RECIPE).set(it).onConflictDoNothing().execute()
                                        }
                                        if (mapperList.isNotEmpty()){
                                            DSL.using(config).batchInsert(mapperList).execute()
                                        }
                                    }
                                }
                            }
                        }
                        response.closeQuietly()
                    }
                })
        }
    }
}