package com.theoxao.dura.good.controller

import com.theoxao.duraemon.good.common.CommonView
import com.theoxao.duraemon.good.common.success
import com.theoxao.duraemon.good.model.CategoryUpdateRequest
import com.theoxao.duraemon.good.service.CateService
import com.theoxao.duraemon.orm.dto.tables.pojos.TbCategory
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource


@RestController
@RequestMapping("/category")
class CateController {

    @Resource
    lateinit var cateService: CateService

    @GetMapping("")
    fun category():CommonView<*>{
        return success(cateService.categories())
    }

    /**
     * @param level 分类级别
     */
    @GetMapping("/list")
    fun categoryList(level: Int? = 1): CommonView<MutableList<TbCategory>> {
        return success(cateService.list(level))
    }

    @PostMapping("/update")
    fun updateCategory(@RequestBody request: CategoryUpdateRequest): CommonView<*> {
        cateService.updateCategory(request)
        return success()
    }

}