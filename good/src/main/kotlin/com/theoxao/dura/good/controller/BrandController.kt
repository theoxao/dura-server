package com.theoxao.dura.good.controller

import com.theoxao.dura.good.common.CommonView
import com.theoxao.dura.good.common.success
import com.theoxao.dura.good.service.BrandService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

@RestController
@RequestMapping("/brand")
class BrandController {

    @Resource
    lateinit var brandService: BrandService

    @GetMapping("/list")
    fun list(cid:Int?):CommonView<*>{
        return success(brandService.list(cid))
    }
}