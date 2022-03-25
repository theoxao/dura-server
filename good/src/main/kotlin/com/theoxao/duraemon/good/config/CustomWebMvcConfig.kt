package com.theoxao.duraemon.good.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import org.jooq.JSON
import org.springframework.beans.factory.InitializingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import javax.annotation.Resource


@Configuration
class CustomWebMvcConfig : InitializingBean {

    @Resource
    lateinit var objectMapper: ObjectMapper

    override fun afterPropertiesSet() {
        val sm = SimpleModule()
//        sm.addSerializer(BaseView::class.java, MicroViewSerializer())
        sm.addSerializer(JSON::class.java, JsonViewSerializer(objectMapper))
        objectMapper.registerModule(sm)
    }

    @Bean
    fun corsConfigurer(): WebMvcConfigurer? {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry.addMapping("/**")
                    .allowedOrigins("*").allowedMethods("*")
                    .allowedHeaders("*")
                    .exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(3600L)
            }
        }
    }


//    @Bean
//    fun cookieProcessorCustomizer(): WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
//        return WebServerFactoryCustomizer<TomcatServletWebServerFactory> { factory ->
//            factory.addContextCustomizers ({ context ->
//                context.cookieProcessor = LegacyCookieProcessor()
//            })
//        }
//    }
}
