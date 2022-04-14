package com.theoxao.duraemon.recipe.controller

import com.theoxao.duraemon.recipe.craw.Crawler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

@RestController
@RequestMapping("/trigger")
class TriggerController {

    @Resource
    lateinit var crawler: Crawler


    @GetMapping("/{operate}")
    fun craw(@PathVariable operate: String):String{
        when(operate){
            "ingredient"->crawler.ingredient()
            "scheduled"->  crawler.scheduled()
            "relate"->crawler.relateIngredient()
        }
        return "ok"
    }

}