package com.theoxao.duraemon.good.common

import java.lang.RuntimeException

class CommonException(val code: ResponseCode) : RuntimeException() {

    fun toView(): CommonView<Any> {
        return CommonView(code.code, null, code.message)
    }
}