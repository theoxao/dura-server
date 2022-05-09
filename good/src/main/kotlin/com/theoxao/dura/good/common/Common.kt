package com.theoxao.dura.good.common

/**
 * include latest dot
 */
fun String.extension(): String {
    return this.substring(this.lastIndexOf("."))
}