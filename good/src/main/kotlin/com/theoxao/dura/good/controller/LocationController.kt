package com.theoxao.dura.good.controller

import com.theoxao.dura.good.common.CommonView
import com.theoxao.dura.good.common.success
import com.theoxao.dura.good.service.LocationService
import com.theoxao.dura.orm.dto.tables.pojos.TbLocation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

@RestController
@RequestMapping("/location")
class LocationController {

    @Resource
    lateinit var locationService: LocationService


    @GetMapping("/list")
    fun list(): CommonView<MutableList<TbLocation>> {
        return success(locationService.list())
    }
}