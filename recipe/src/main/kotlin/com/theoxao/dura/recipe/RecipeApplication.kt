package com.theoxao.dura.recipe

import org.jooq.DSLContext
import org.jooq.impl.DSL
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

fun DSLContext.trans(context: DSLContext.() -> Unit) = this.transaction { config ->
    context.invoke(DSL.using(config))
}