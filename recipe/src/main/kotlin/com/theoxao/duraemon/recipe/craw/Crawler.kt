package com.theoxao.duraemon.recipe.craw

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.PropertyNamingStrategy
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


    @Scheduled(cron = "0 0 0 1/1 * ?")
    fun scheduled() {
        val max = dslContext.select(DSL.max(TB_RECIPE.ID)).from(TB_RECIPE).fetchAny()?.value1()!!
        val list = (max..(max+1000)).toMutableList().craw()
    }

    @PostConstruct
    fun init(){
        (107000000 downTo 100000000).toMutableList().craw()
    }

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
                                    this.json = JSON.valueOf(json)
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

