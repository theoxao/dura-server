package com.theoxao.dura.good.controller

import com.theoxao.dura.good.common.CommonView
import com.theoxao.dura.good.common.success
import com.theoxao.dura.good.service.CommonService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

@RestController
@RequestMapping("/")
class CommonController {

    @Resource
    lateinit var commonService: CommonService

    @GetMapping("/search")
    fun search(keyword: String, offset:Int, type: Int): CommonView<*> {
        return success(commonService.search(keyword, type, offset))
    }

}