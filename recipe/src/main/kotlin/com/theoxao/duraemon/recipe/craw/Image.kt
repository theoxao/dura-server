package com.theoxao.duraemon.recipe.craw

import com.theoxao.duraemon.orm.dto.Tables.IMAGE_MAPPER
import okhttp3.*
import okhttp3.internal.closeQuietly
import org.jooq.DSLContext
import org.jooq.impl.DSL
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.io.File
import java.io.IOException
import java.time.Duration
import javax.annotation.PostConstruct
import javax.annotation.Resource

@Component
class Image {

    private val log = LoggerFactory.getLogger(this::class.java)

    @Resource(name = "masterDSLContext")
    lateinit var masterDSLContext: DSLContext

    val http = OkHttpClient.Builder()
        .callTimeout(Duration.ofSeconds(0))
        .readTimeout(Duration.ofSeconds(0))
        .writeTimeout(Duration.ofSeconds(0))
        .connectTimeout(Duration.ofSeconds(0)).build()

    private val baseDir = "/Users/theo/workspace/theo/static/recipe"

    @PostConstruct
    fun init(){
        while (true){
            val list = masterDSLContext.selectFrom(IMAGE_MAPPER).where(IMAGE_MAPPER.DOWNLOAD.eq(0))
                .and(IMAGE_MAPPER.TYPE.notIn(2,3))
                .limit(1000).fetch()
            if (list.isEmpty()){
                break
            }
            list.forEach {
                it.download = -1
            }
            masterDSLContext.transaction { config->
                DSL.using(config).batchUpdate(list).execute()
            }
            list.forEach { mapper->
                log.info("mapper:{}" , mapper.uuid)
                val request = if (mapper.type ==0){
                    Request.Builder().url("https://i2.chuimg.com/${mapper.imageUrl}").get().build()
                }else{
                    Request.Builder().url(mapper.imageUrl).get().build()
                }
                http.newCall(request).enqueue(object:Callback{
                    override fun onFailure(call: Call, e: IOException) {
                        log.error(e.message,e)
                    }
                    override fun onResponse(call: Call, response: Response) {
                        if (response.isSuccessful){
                            val base =File(baseDir, "${mapper.oid.mod(100)}/${mapper.oid}")
                            if (!base.exists()){
                                base.mkdirs()
                            }
                            val file = File(base,"${mapper.uuid}.${mapper.imageUrl.substringAfterLast(".")}")
                            response.body?.bytes()?.let {
                                file.writeBytes(it)
                                masterDSLContext.transaction { config->
                                    DSL.using(config).update(IMAGE_MAPPER).set(IMAGE_MAPPER.DOWNLOAD,1)
                                        .where(IMAGE_MAPPER.UUID.eq(mapper.uuid)).execute()
                                }
                            }
                        }
                        response.closeQuietly()
                    }
                })
            }
            Thread.sleep(Duration.ofMinutes(1).toMillis())
        }
    }
}