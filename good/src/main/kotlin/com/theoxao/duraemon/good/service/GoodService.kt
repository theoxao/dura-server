package com.theoxao.duraemon.good.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.theoxao.duraemon.good.common.*
import com.theoxao.duraemon.good.common.ResponseCode.RECORD_NOT_FOUND
import com.theoxao.duraemon.good.model.GoodUpdateRequest
import com.theoxao.duraemon.orm.dto.Tables.TB_CATEGORY
import com.theoxao.duraemon.orm.dto.Tables.TB_GOODS
import com.theoxao.duraemon.orm.dto.tables.pojos.TbGoods
import org.jooq.DSLContext
import org.springframework.stereotype.Service
import javax.annotation.Resource

@Service
class GoodService {

    @Resource
    lateinit var dslContext: DSLContext

    @Resource
    lateinit var objectMapper: ObjectMapper

    fun list(cid: Int, keyword: String?, page: Int, size: Int): PageView<TbGoods> {
        val sql = dslContext.selectFrom(TB_GOODS).where(TB_GOODS.CATE.eq(cid)).apply {
            if (!keyword.isNullOrBlank())
                and(TB_GOODS.NAME.like("%$keyword%").or(TB_GOODS.DESC.like("%$keyword%")))
        }
        val total = dslContext.fetchCount(sql)
        val list = sql.limit(size).offset((page - 1) * size)
            .fetchInto(TbGoods::class.java)
        return PageView(list, total).withPageInfo(page, size)
    }

    fun update(request: GoodUpdateRequest) {
        if (request.id != null) {
            dslContext.trans {
                val good = selectFrom(TB_GOODS).where(TB_GOODS.ID.eq(request.id)).fetchAny() ?: throw CommonException(
                    RECORD_NOT_FOUND
                )
                good.name = request.name
                good.cate = request.cate
                good.subCate = request.subCate
                good.remainBatch = request.remainBatch
                good.recentPrice = request.recentPrice
                good.images = objectMapper list2Json request.images
                good.needBuy = request.needBuy
                executeUpdate(good)
            }
        } else {
            dslContext.trans {
                TB_GOODS.newRecord().apply {
                    this.name = request.name
                    this.cate = request.cate
                    this.subCate = request.subCate
                    this.remainBatch = request.remainBatch
                    this.recentPrice = request.recentPrice
                    this.images = objectMapper list2Json request.images
                    this.needBuy = request.needBuy ?: 0
                }.let(this::executeInsert)
            }
        }
    }

    fun good(id: Int): Any {
        val cateMap = dslContext.selectFrom(TB_CATEGORY).fetch().associateBy({it.id}, {it.name})
        val view = dslContext.selectFrom(TB_GOODS).where(TB_GOODS.ID.eq(id)).fetchAnyInto(GoodDetailView::class.java)?:throw CommonException(RECORD_NOT_FOUND)
        return view.apply {
            this.cateStr = cateMap[this.cate]
            this.subCateStr = cateMap[this.subCate]
        }
    }

    fun getByName(name: String , limit:Int): Any {
        val cateMap = dslContext.selectFrom(TB_CATEGORY).fetch().associateBy({it.id}, {it.name})
        return dslContext.selectFrom(TB_GOODS).where(TB_GOODS.NAME.like("$name%")).limit(limit).fetchInto(GoodDetailView::class.java).onEach {
            it.cateStr = cateMap[it.cate]
            it.subCateStr = cateMap[it.subCate]
        }
    }


}