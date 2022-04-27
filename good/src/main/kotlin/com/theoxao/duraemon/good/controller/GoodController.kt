package com.theoxao.duraemon.good.controller

import com.theoxao.duraemon.good.common.CommonView
import com.theoxao.duraemon.good.common.PageView
import com.theoxao.duraemon.good.common.success
import com.theoxao.duraemon.good.model.GoodUpdateRequest
import com.theoxao.duraemon.good.service.GoodService
import com.theoxao.duraemon.orm.dto.tables.pojos.TbGoods
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource


@RestController
@RequestMapping("/good")
class GoodController {


    @Resource
    lateinit var goodService: GoodService

    @GetMapping("/{id}")
    fun good(@PathVariable id: Int):CommonView<*>{
        return success(goodService.good(id))
    }

    @GetMapping("/getByName")
    fun getGoodByName(name:String , limit:Int?):CommonView<*>{
        return success(goodService.getByName(name , limit?:10))
    }

    @GetMapping("/candidate")
    fun candidate(name:String):CommonView<*>{
        return success(goodService.candidate(name))
    }

    @GetMapping("/list")
    fun goodList(page: Int, size: Int, cid: Int, keyword: String?): CommonView<PageView<TbGoods>> {
        return success(goodService.list(cid, keyword, page, size))
    }

    @PostMapping("/update")
    fun update(@RequestBody request: GoodUpdateRequest): CommonView<*> {
        goodService.update(request)
        return success()
    }

}