package com.theoxao.dura.good.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import org.jooq.JSON
import org.springframework.beans.factory.InitializingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter
import org.springframework.core.convert.support.GenericConversionService
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.annotation.PostConstruct
import javax.annotation.Resource


@Configuration
class CustomWebMvcConfig : InitializingBean {

    @Resource
    lateinit var objectMapper: ObjectMapper

    @Resource
    lateinit var requestMappingHandlerAdapter:RequestMappingHandlerAdapter

    override fun afterPropertiesSet() {
        val sm = SimpleModule()
//        sm.addSerializer(BaseView::class.java, MicroViewSerializer())
        sm.addSerializer(JSON::class.java, JsonViewSerializer(objectMapper))
        objectMapper.registerModule(sm)
        val initializer = requestMappingHandlerAdapter.webBindingInitializer as ConfigurableWebBindingInitializer
        if (initializer.conversionService != null) {
            val genericConversionService = initializer.conversionService as GenericConversionService
            genericConversionService.addConverter(LocalDateConvertor())
        }
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


class LocalDateConvertor : Converter<String ,LocalDate>{
    override fun convert(source: String): LocalDate? {
        if(source.length==10){
            if (source.contains("-"))
                return LocalDate.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            if(source.contains("/"))
                return LocalDate.parse(source, DateTimeFormatter.ofPattern("yyyy/MM/dd"))
        }
        if(source.length==19){
            if (source.contains("-"))
                return LocalDateTime.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toLocalDate()
            if(source.contains("/"))
                return LocalDateTime.parse(source, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")).toLocalDate()
        }
        return null
    }

}