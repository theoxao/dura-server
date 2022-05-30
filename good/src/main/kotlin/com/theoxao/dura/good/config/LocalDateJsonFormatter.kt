package com.theoxao.dura.good.config

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class LocalDateJsonFormatter: JsonDeserializer<LocalDate>() {
    override fun deserialize(jsonParser: JsonParser, ctx: DeserializationContext): LocalDate? {
        val text = jsonParser.text
        return  when{
            text.isNullOrBlank()->null
            text.length == 10 && text.contains("-") ->LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            text.length == 10 && text.contains("/") ->LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy/MM/dd"))
            text.length == 19 && text.contains("-") -> LocalDateTime.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toLocalDate()
            text.length == 19 && text.contains("/") -> LocalDateTime.parse(text, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")).toLocalDate()
            else -> null
        }
    }

}