package com.theoxao.duraemon.recipe

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.Resource

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RecipeApplicationTest {

    @Resource
    lateinit var objectMapper: ObjectMapper

    @Test
    fun testJsonParse() {
        this::class.java.classLoader.getResourceAsStream("101833732.json")


    }

}