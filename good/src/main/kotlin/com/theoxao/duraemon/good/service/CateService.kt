package com.theoxao.duraemon.good.service

import com.theoxao.duraemon.good.common.CommonException
import com.theoxao.duraemon.good.common.ResponseCode
import com.theoxao.duraemon.good.common.trans
import com.theoxao.duraemon.good.model.CategoryUpdateRequest
import com.theoxao.duraemon.orm.dto.Tables.TB_CATEGORY
import com.theoxao.duraemon.orm.dto.tables.pojos.TbCategory
import org.jooq.DSLContext
import org.springframework.stereotype.Service
import javax.annotation.Resource

@Service
class CateService {

    @Resource
    lateinit var dslContext: DSLContext

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
                val cate = selectFrom(TB_CATEGORY).where(TB_CATEGORY.ID.eq(request.id)).fetchAny() ?: throw CommonException(
                    ResponseCode.RECORD_NOT_FOUND
                )
                cate.name = request.name
                cate.pid = request.pid
                executeUpdate(cate)
            }
        }
    }


}