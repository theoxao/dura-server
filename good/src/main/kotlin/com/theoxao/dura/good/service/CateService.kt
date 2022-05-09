package com.theoxao.dura.good.service

import com.theoxao.dura.good.common.CategoryView
import com.theoxao.dura.good.common.CommonException
import com.theoxao.dura.good.common.ResponseCode
import com.theoxao.dura.good.common.trans
import com.theoxao.dura.good.model.CategoryUpdateRequest
import com.theoxao.dura.orm.dto.Tables.TB_CATEGORY
import com.theoxao.dura.orm.dto.tables.pojos.TbCategory
import org.jooq.DSLContext
import org.springframework.stereotype.Service
import javax.annotation.Resource

@Service
class CateService {

    @Resource
    lateinit var dslContext: DSLContext

    var cateMap: Map<Int, String> = mutableMapOf()
        get() = field.ifEmpty { dslContext.selectFrom(TB_CATEGORY).fetch().associateBy({ it.id }, { it.name }) }


    fun list(level: Int?): MutableList<TbCategory> {
        return dslContext.selectFrom(TB_CATEGORY).apply {
            if (level != null) where(TB_CATEGORY.LEVEL.eq(level))
        }.fetchInto(TbCategory::class.java)
    }

    fun updateCategory(request: CategoryUpdateRequest) {
        dslContext.trans {
            if (request.id != null) {
                val parent = selectFrom(TB_CATEGORY).where(TB_CATEGORY.ID.eq(request.pid)).fetchAny()
                TB_CATEGORY.newRecord().apply {
                    this.name = request.name
                    this.level = parent?.level?.let { it + 1 } ?: 1
                    this.pid = request.pid
                }.let(this::executeInsert)
            } else {
                val cate =
                    selectFrom(TB_CATEGORY).where(TB_CATEGORY.ID.eq(request.id)).fetchAny() ?: throw CommonException(
                        ResponseCode.RECORD_NOT_FOUND
                    )
                cate.name = request.name
                cate.pid = request.pid
                executeUpdate(cate)
            }
        }
    }

    fun categories(): Any {
        val categories = dslContext.selectFrom(TB_CATEGORY).fetchInto(CategoryView::class.java)
        val root = categories.filter { it.pid == null || it.pid == 0 || it.level == 1 }
        val map = categories.groupBy { it.pid }
        fun List<CategoryView>.mapChildren() {
            this.forEach {
                it.children = map[it.id]?.apply { this.mapChildren() }
            }
        }
        root.mapChildren()
        return root
    }


}