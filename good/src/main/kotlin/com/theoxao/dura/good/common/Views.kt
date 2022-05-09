package com.theoxao.dura.good.common

import com.theoxao.duraemon.good.model.BaseView
import org.jooq.JSON
import java.time.LocalDateTime


class CommonSearchView : BaseView {
    var id: Int? = null
    var name: String? = null
    var desc: String? = null
    var images: JSON? = null
    var type: Int? = null
}

class GoodDetailView:BaseView{
    var id: Int? = null
    var name: String? = null
    var desc: String? = null
    var cate: Int? = null
    var cateStr:String? = null
    var subCate: Int? = null
    var subCateStr:String? = null
    var remainBatch: Int? = null
    var recentPrice: Int? = null
    var images: JSON? = null
    var needBuy: Int? = null
    var createTime: LocalDateTime? = null
    var updateTime: LocalDateTime? = null
}

class GoodCandidateView:BaseView{
    var id: String? = null
    var name: String? = null
    var from: String? = null
    var cate: Int? = null
    var cateStr:String? = null
    var subCate: Int? = null
    var subCateStr:String? = null
    var count: Int? = null
    var goodId:Int? = null
}

class CategoryView:BaseView{
    var id: Int? = null
    var name: String? = null
    var level: Int? = null
    var pid: Int? = null
    var children:List<CategoryView>? = null
}