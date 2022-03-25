package com.theoxao.duraemon.good.controller

import com.theoxao.duraemon.good.common.CommonView
import com.theoxao.duraemon.good.common.success
import com.theoxao.duraemon.good.service.ImageService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import javax.annotation.Resource


@RestController
@RequestMapping("/image")
class ImageController {

    @Resource
    lateinit var imageService: ImageService

    @PostMapping("/upload")
    fun upload(@RequestParam image: MultipartFile): CommonView<String?> {
        val key = imageService.upload(image)
        return success(key)
    }


}