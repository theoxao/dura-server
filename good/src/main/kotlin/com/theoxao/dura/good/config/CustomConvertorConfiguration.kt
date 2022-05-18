package com.theoxao.dura.good.config

import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter
import org.springframework.core.convert.support.GenericConversionService
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.annotation.PostConstruct
import javax.annotation.Resource

@Configuration
class CustomConvertorConfiguration {

    @Resource
    lateinit var requestMappingHandlerAdapter: RequestMappingHandlerAdapter

    @PostConstruct
    fun init(){
        val initializer = requestMappingHandlerAdapter.webBindingInitializer as ConfigurableWebBindingInitializer
        if (initializer.conversionService != null) {
            val genericConversionService = initializer.conversionService as GenericConversionService
            genericConversionService.addConverter(LocalDateConvertor())
        }
    }
}


class LocalDateConvertor : Converter<String, LocalDate> {
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