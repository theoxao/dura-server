package com.theoxao.dura.good.controller

import com.theoxao.dura.good.common.CommonView
import com.theoxao.dura.good.common.success
import com.theoxao.dura.good.model.CategoryUpdateRequest
import com.theoxao.dura.good.service.CateService
import com.theoxao.dura.orm.dto.tables.pojos.TbCategory
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