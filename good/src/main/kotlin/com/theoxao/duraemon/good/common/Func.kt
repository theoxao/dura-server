package com.theoxao.duraemon.good.common

import com.fasterxml.jackson.databind.ObjectMapper
import org.jooq.DSLContext
import org.jooq.JSON
import org.jooq.impl.DSL


fun DSLContext.trans(context: DSLContext.() -> Unit) = this.transaction { config ->
    context.invoke(DSL.using(config))
}

infix fun ObjectMapper.list2Json(list: List<String>?): String? {
    return list?.let { JSON.valueOf(this.writeValueAsString(it)) } ?: JSON.valueOf("[]")
}