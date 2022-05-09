package com.theoxao.dura.good.common

import java.io.Serializable

class CommonView<T>(var status: Int = 200, var data: T?, var error: String?) : Serializable


class PageView<T>(var list: List<T>?, var total: Int?) : Serializable {

    companion object {
        fun <T> default() = PageView(arrayListOf<T>(), 0)
    }

    var page: Int? = 0
    var size: Int? = 0

    fun withPageInfo(page: Int, size: Int) = this.apply {
        this.page = page
        this.size = size
    }


}

fun success(): CommonView<Any?> {
    return CommonView(200, null, null)
}

fun <T> success(t: T): CommonView<T> {
    return CommonView(200, t, null)
}

fun <T> internalError(message: String): CommonView<*> {
    return CommonView(500, null, message)
}

fun error(res: ResponseCode): CommonView<*> {
    return CommonView(res.code, null, res.message)
}

fun <T> error(data: T?, code: Int): CommonView<T> {
    return CommonView(code, data, "")
}

fun error(msg: String?, code: Int): CommonView<*> {
    return CommonView(code, null, msg)
}


fun <T> unAuthorize(): CommonView<*> = CommonView(400, null, "un-authorized")