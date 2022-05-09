package com.theoxao.dura.good.service

import com.theoxao.dura.good.common.CommonException
import com.theoxao.dura.good.common.ResponseCode
import com.theoxao.dura.good.common.extension
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File

@Service
class ImageService {

    @Value("\${dura.filePath}")
    lateinit var filePath: String

    @Value("\${dura.httpBase}")
    lateinit var httpBase: String
    

    fun upload(image: MultipartFile): String? {
        val ext = image.originalFilename?.extension() ?: throw CommonException(ResponseCode.FILE_EXTENSION_ERROR)
        val fileName = System.currentTimeMillis().toString() + ext
        val file = File("$filePath/$fileName")
        image.transferTo(file)
        return file.absolutePath.replace(filePath,httpBase)

    }

}