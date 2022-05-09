package com.theoxao.dura.good.controller

import com.theoxao.duraemon.good.common.CommonView
import com.theoxao.duraemon.good.common.success
import com.theoxao.duraemon.good.service.LocationService
import com.theoxao.duraemon.orm.dto.tables.pojos.TbLocation
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