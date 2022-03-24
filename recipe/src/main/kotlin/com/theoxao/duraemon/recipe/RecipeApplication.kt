package com.theoxao.duraemon.recipe

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.theoxao"])
class RecipeApplication

fun main(args: Array<String>) {
    runApplication<RecipeApplication>(*args)
}