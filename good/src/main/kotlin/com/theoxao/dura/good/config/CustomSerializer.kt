package com.theoxao.dura.good.config

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.node.JsonNodeType
import org.jooq.JSON


class JsonViewSerializer(private val objectMapper: ObjectMapper) : JsonSerializer<JSON>() {
    override fun serialize(json: JSON, gen: JsonGenerator, serializers: SerializerProvider) {
        val type = objectMapper.readTree(json.data()).nodeType
        when (type) {
            JsonNodeType.OBJECT -> gen.writeObject(objectMapper.readValue(json.data(), Map::class.java))
            JsonNodeType.ARRAY -> {
                val list = objectMapper.readValue(json.data(), List::class.java)
                gen.writeObject(list)
            }
            JsonNodeType.BINARY -> gen.writeBinary(json.data().toByteArray())
            JsonNodeType.NULL -> gen.writeNull()
            JsonNodeType.NUMBER -> gen.writeNumber(json.data().toInt())
            JsonNodeType.POJO -> gen.writeObject(objectMapper.readValue(json.data(), Map::class.java))
            JsonNodeType.STRING -> gen.writeString(json.data())
            else -> gen.writeString(json.data())
        }
    }
}