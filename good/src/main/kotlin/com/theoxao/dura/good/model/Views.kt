package com.theoxao.dura.good.model

import org.jooq.JSON
import java.io.Serializable
import java.time.LocalDate
import java.time.LocalDateTime

interface BaseView : Serializable

class ItemView : BaseView {
    var id: Int? = null
    var goodId: Int? = null
    var name: String? = null
    var images: JSON? = null
    var spec: String? = null
    var price: Int? = null
    var isbn: String? = null
    var bestFavor: Int? = null
    var shelfLife: Int? = null
    var storage: String? = null
    var usedStorage: String? = null
    var remark: String? = null
    var createTime: LocalDateTime? = null
    var updateTime: LocalDateTime? = null
    var details: List<ItemDetailView> = arrayListOf()
    var ingredient:String? = null
    var brand:String? = null
}

class ItemDetailView : BaseView {
    var id: Int? = null
    var itemId: Int? = null
    var goodId: Int? = null
    var name: String? = null
    var images: JSON? = null
    var pd: LocalDate? = null
    var qty: Int? = null
    var bestFavor: Int? = null
    var shelfLife: Int? = null
    var storage: String? = null
    var usedStorage: String? = null
    var batchCode: String? = null
    var cost: Int? = null
    var createTime: LocalDateTime? = null
    var updateTime: LocalDateTime? = null
}