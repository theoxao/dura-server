package com.theoxao.dura.good.controller

import com.theoxao.dura.good.common.CommonView
import com.theoxao.dura.good.common.success
import com.theoxao.dura.good.model.BrandAddRequest
import com.theoxao.dura.good.service.BrandService
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource

@RestController
@RequestMapping("/brand")
class BrandController {

    @Resource
    lateinit var brandService: BrandService

    @GetMapping("")
    fun list(cid: Int?): CommonView<*> {
        return success(brandService.list(cid))
    }

    @PutMapping("")
    fun addBrand(@RequestBody request: BrandAddRequest) :CommonView<*>{
        brandService.add(request)
        return success()
    }
}