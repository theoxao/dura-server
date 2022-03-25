package com.theoxao.duraemon.good.common

import com.theoxao.duraemon.good.model.BaseView
import org.jooq.JSON


class CommonSearchView : BaseView {
    var id: Int? = null
    var name: String? = null
    var desc: String? = null
    var images: JSON? = null
    var type: Int? = null
}