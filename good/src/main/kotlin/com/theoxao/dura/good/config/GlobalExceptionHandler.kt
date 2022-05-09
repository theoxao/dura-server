package com.theoxao.dura.good.config

import com.theoxao.duraemon.good.common.CommonException
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.HandlerExceptionResolver
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.view.json.MappingJackson2JsonView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Configuration
class GlobalExceptionHandler : HandlerExceptionResolver {
    private val log = LoggerFactory.getLogger(this::class.java)
    override fun resolveException(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any?,
        ex: Exception
    ): ModelAndView? {
        val modelAndView = ModelAndView(MappingJackson2JsonView())
        if (ex is CommonException) {
            modelAndView.addObject("status", ex.code.code)
            modelAndView.addObject("error", ex.code.message)
            return modelAndView
        }
        modelAndView.addObject("status", 500)
        modelAndView.addObject("error", "接口异常")
        log.error("", ex)
        return modelAndView
    }
}