package com.theoxao.duraemon.recipe

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication(scanBasePackages = ["com.theoxao"], exclude = [DataSourceAutoConfiguration::class])
@EnableScheduling
class RecipeApplication

fun main(args: Array<String>) {
    runApplication<RecipeApplication>(*args)
}