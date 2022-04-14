package com.theoxao.duraemon.recipe.craw

import com.fasterxml.jackson.databind.ObjectMapper
import com.theoxao.duraemon.orm.dto.Tables.*
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
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.io.IOException
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.annotation.PostConstruct
import javax.annotation.Resource

val datetimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

@Component
class Crawler {

    private val log = LoggerFactory.getLogger(this::class.java)

    @Resource(name = "masterDSLContext")
    lateinit var dslContext: DSLContext

    @Resource
    lateinit var objectMapper: ObjectMapper

    fun ingredient(){
        val batch = 1000
        while (true){
            val list = dslContext.selectFrom(TB_RECIPE).where(TB_RECIPE.STATUS.eq(0))
                .orderBy(TB_RECIPE.ID).limit(batch).fetch()
            if (list.isEmpty()) break
            val result = list.flatMap {recipe->
                log.info("id:{}", recipe.id)
                objectMapper.readValue<List<RecipeModel.Ingredient>>(recipe.ingredient.data(), objectMapper.typeFactory.constructParametricType(List::class.java, RecipeModel.Ingredient::class.java))
                    .onEach { it.oid = recipe.id }
            }.map { recipe->
                    TB_ING_RECIPE_REL.newRecord().apply {
                        this.rid = recipe.oid
                        this.amount = recipe.amount
                        this.cat = recipe.cat
                        this.name = recipe.name
                    }
            }
            dslContext.trans {
                batchUpdate(list.onEach {
                    it.status = 1
                }).execute()
                batchInsert(result).execute()
            }
        }
    }

    @Scheduled(cron = "* * 12 1/1 * ?")
    fun scheduled() {
        val max = dslContext.select(DSL.max(TB_RECIPE.ID)).from(TB_RECIPE).fetchAny()?.value1()!!
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
                            val resp = objectMapper.readValue(bytes, ResponseWrapper::class.java)
                            if (resp.status != "ok") {
                                log.error("request@{} is not ok", id)
                                response.closeQuietly()
                                return@let
                            }
                            log.error("request@{} is ok", id)
                            resp.content?.get("recipe")?.let { recipe ->
                                val record = recipe.toRecipe()
                                dslContext.trans {
                                    record?.let {
                                       insertInto(TB_RECIPE).set(record).onConflictDoNothing()
                                            .execute()
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