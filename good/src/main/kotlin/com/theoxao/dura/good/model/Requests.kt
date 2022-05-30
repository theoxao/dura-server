package com.theoxao.dura.good.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.theoxao.dura.good.config.LocalDateJsonFormatter
import java.io.Serializable
import java.time.LocalDate

class GoodUpdateRequest : Serializable {
    var id: Int? = null
    var name: String? = null
    var desc:String? = null
    var cate: Int? = null
    var subCate: Int? = null
    var remainBatch: Int? = null
    var recentPrice: Int? = null
    var images: List<String>? = null
    var needBuy: Int? = null
}


class ItemUpdateRequest : Serializable {
    var id: Int? = null
    var name: String? = null
    var images: List<String>? = null
    var spec: String? = null
    var price: Int? = null
    var isbn: String? = null
    var bestFavor: Int? = null
    var shelfLife: Int? = null
    var storage: String? = null
    var brand:String? =  null
    var usedStorage: String? = null
    var remark: String? = null
}

class ItemDetailUpdateRequest : Serializable {
    var id: Int? = null
    var itemId: Int? = null
    var goodId: Int? = null
    var name: String? = null
    var images: List<String>? = arrayListOf()
    @JsonDeserialize(using = LocalDateJsonFormatter::class)
    var pd: LocalDate? = null
    var qty: Int? = null
    var bestFavor: Int? = null
    var shelfLife: Int? = null
    var storage: String? = null
    var usedStorage: String? = null
    var batchCode: String? = null
    var cost: Int? = null
}

/**
 * @field pid 父分类ID
 */
class CategoryUpdateRequest : Serializable {
    var id: Int? = null
    var name: String? = null
    var pid: Int? = null
}