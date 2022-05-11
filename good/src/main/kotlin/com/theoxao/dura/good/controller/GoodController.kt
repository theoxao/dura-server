package com.theoxao.dura.good.controller

import com.theoxao.dura.good.common.CommonView
import com.theoxao.dura.good.common.PageView
import com.theoxao.dura.good.common.success
import com.theoxao.dura.good.model.GoodUpdateRequest
import com.theoxao.dura.good.service.GoodService
import com.theoxao.dura.orm.dto.tables.pojos.TbGoods
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

    @GetMapping("/suggestion")
    fun suggestion(name:String):CommonView<*>{
        return success(goodService.suggestion(name))
    }

    @GetMapping("/list")
    fun goodList(page: Int, size: Int, cid: Int, keyword: String?): CommonView<PageView<TbGoods>> {
        return success(goodService.list(cid, keyword, page, size))
    }

    @PostMapping("/update")
    fun update(@RequestBody request: GoodUpdateRequest): CommonView<*> {
        return success(goodService.update(request))
    }

}