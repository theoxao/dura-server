package com.theoxao.duraemon.recipe.craw

import com.fasterxml.jackson.databind.ObjectMapper
import com.theoxao.duraemon.orm.dto.Tables.RECIPE_JSON
import com.theoxao.duraemon.orm.dto.Tables.TB_RECIPE
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
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.annotation.PostConstruct
import javax.annotation.Resource

val datetimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

@Component
class Crawler {

    private val log = LoggerFactory.getLogger(this::class.java)

    @Resource
    lateinit var dslContext: DSLContext


    @Resource
    lateinit var objectMapper: ObjectMapper

    val http = OkHttpClient.Builder()
        .callTimeout(Duration.ofSeconds(30))
        .readTimeout(Duration.ofSeconds(30))
        .writeTimeout(Duration.ofSeconds(30))
        .connectTimeout(Duration.ofSeconds(30)).build()

    @PostConstruct
    fun initSchedule(){
        scheduled()
        Thread.sleep(Duration.ofMinutes(5).toMillis())
    }


    @Scheduled(cron = "0 0 0 1/1 * ?")
    fun scheduled() {
        val max = dslContext.select(DSL.max(TB_RECIPE.ID)).from(TB_RECIPE).fetchAny()?.value1()!!
        (max..(max+2000)).toMutableList().craw()
    }

    @Scheduled(cron = "0 20 0 1/1 * ?")
    fun init(){
        val batch = 20
        while (true){
           val list =  dslContext.selectFrom(RECIPE_JSON).where(RECIPE_JSON.TO_OBJ.eq(false))
                .orderBy(RECIPE_JSON.ID).limit(batch).fetch()
                if (list.isEmpty()) break
           val  records = list.map {
                val json = it.recipeJson.data()
                val resp = objectMapper.readValue(json, ResponseWrapper::class.java)
                return@map  resp.content?.get("recipe")?.let {recipe->
                    TB_RECIPE.newRecord().apply {
                        this.id = recipe.id
                        this.desc = recipe.desc
                        this.difficulty = recipe.difficulty.toJson()
                        this.ident = recipe.ident
                        this.image = recipe.image.toJson()
                        this.name = recipe.name
                        this.photo = mapOf(
                            "photo" to recipe.photo,
                            "photo80" to recipe.photo80,
                            "photo90" to recipe.photo90,
                            "photo140" to recipe.photo140,
                            "photo280" to recipe.photo280,
                            "photo340" to recipe.photo340,
                            "photo526" to recipe.photo526,
                            "photo580" to recipe.photo580,
                            "photo640" to recipe.photo640,
                        ).toJson()
                        this.score = recipe.score
                        this.summary = recipe.summary
                        this.thumb = recipe.thumb
                        this.tips = recipe.tips
                        this.url = recipe.url
                        this.author = recipe.author.toJson()
                        this.label = recipe.labels.toJson()
                        this.createTime = recipe.createTime?.let { LocalDateTime.parse(it, datetimeFormatter) }
                        this.ingredient = recipe.ingredient.toJson()
                        this.instruction = recipe.instruction.toJson()
                        this.duration = recipe.duration.toJson()
                        this.recipeCats = recipe.recipeCats.toJson()
                        this.stats = recipe.stats.toJson()
                        this.equipmentRelatedInfo = recipe.equipmentRelatedInfo.toJson()
                        this.videoUrl = recipe.videoUrl
                        this.videoPageUrl = recipe.videoPageUrl
                        this.coverMicroVideo = recipe.coverMicroVideo.toJson()
                        this.vodVideo = recipe.vodVideo.toJson()
                        this.summaryDesc = recipe.summaryDesc
                    }
                }
            }
            dslContext.transaction { config->
                DSL.using(config).loadInto(TB_RECIPE).batchAll().onDuplicateKeyIgnore().loadRecords(records).fields(*TB_RECIPE.fields()).execute()
                DSL.using(config).update(RECIPE_JSON).set(RECIPE_JSON.TO_OBJ, true).where(RECIPE_JSON.ID.`in`(list.map { ce->ce.id })).execute()
            }
        }

    }
    fun Any?.toJson(): JSON?=  this?.let { JSON.valueOf(objectMapper.writeValueAsString(it)) }

    fun MutableList<Int>.craw(){
        this.chunked(2000).forEach { ids ->
            ids.forEach { id ->
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
                        if (LocalDateTime.now().second==0){
                            log.info(">>>>>queued call count:{}",  http.dispatcher.queuedCallsCount())
                        }
                        if (response.isSuccessful) {
                            response.body?.string()?.let { json ->
                                val raw = RECIPE_JSON.newRecord().apply {
                                    this.id = id
                                    this.recipeJson = JSON.valueOf(json)
                                }
                                dslContext.transaction { config->
                                    DSL.using(config).insertInto(RECIPE_JSON).set(raw).onConflictDoNothing().execute()
                                }
                            }
                        }
                        log.info("request@{}, response code:{} ", id, response.code)
                        response.closeQuietly()
                    }
                })
            }
        }
    }
}

