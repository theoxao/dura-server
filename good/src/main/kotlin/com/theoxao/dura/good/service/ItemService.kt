package com.theoxao.dura.good.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.theoxao.dura.good.common.*
import com.theoxao.dura.good.model.ItemDetailUpdateRequest
import com.theoxao.dura.good.model.ItemDetailView
import com.theoxao.dura.good.model.ItemUpdateRequest
import com.theoxao.dura.good.model.ItemView
import com.theoxao.dura.orm.dto.Tables.TB_ITEM
import com.theoxao.dura.orm.dto.Tables.TB_ITEM_DETAIL
import com.theoxao.dura.orm.dto.tables.pojos.TbItem
import com.theoxao.dura.orm.dto.tables.pojos.TbItemDetail
import org.jooq.DSLContext
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.annotation.Resource

@Service
class ItemService {

    @Resource
    lateinit var dslContext: DSLContext

    @Resource
    lateinit var objectMapper: ObjectMapper

    fun itemList(gid: Int, page: Int, size: Int): PageView<ItemView> {
        val sql = dslContext.selectFrom(TB_ITEM).where(TB_ITEM.GOOD_ID.eq(gid))
        val total = dslContext.fetchCount(sql)
        val list = sql.limit(size).offset((page - 1) * size).fetchInto(ItemView::class.java).onEach {
            it.details = dslContext.selectFrom(TB_ITEM_DETAIL).where(TB_ITEM_DETAIL.ITEM_ID.eq(it.id))
//                .and(TB_ITEM_DETAIL.EXPIRY.eq(0))
                .orderBy(TB_ITEM_DETAIL.UPDATE_TIME.desc())
                .limit(10)
                .fetchInto(ItemDetailView::class.java)
        }
        return PageView(list, total)
    }

    fun updateItem(request: ItemUpdateRequest) {
        if (request.id != null) {
            //update
            dslContext.trans {
                val item = dslContext.selectFrom(TB_ITEM).where(TB_ITEM_DETAIL.ID.eq(request.id)).fetchAny()
                    ?: throw CommonException(ResponseCode.RECORD_NOT_FOUND)
                item.name = request.name
                item.images = objectMapper list2Json request.images
                item.spec = request.spec
                item.price = request.price
                item.isbn = request.isbn
                item.bestFavor = request.bestFavor
                item.shelfLife = request.shelfLife
                item.storage = request.storage
                item.usedStorage = request.usedStorage
                item.remark = request.remark
                this.executeUpdate(item)
            }
        } else {
            //create
            dslContext.trans {
                TB_ITEM.newRecord().apply {
                    this.name = request.name
                    this.images = objectMapper list2Json request.images
                    this.spec = request.spec
                    this.price = request.price
                    this.isbn = request.isbn
                    this.bestFavor = request.bestFavor
                    this.shelfLife = request.shelfLife
                    this.storage = request.storage
                    this.usedStorage = request.usedStorage
                    this.remark = request.remark
                }.let(this::executeInsert)
            }
        }
    }

    fun itemDetailList(tid: Int, page: Int, size: Int): PageView<ItemDetailView> {
        val sql = dslContext.selectFrom(TB_ITEM_DETAIL).where(TB_ITEM_DETAIL.ITEM_ID.eq(tid))
//            .and(TB_ITEM_DETAIL.EXPIRY.eq(0))
        val total = dslContext.fetchCount(sql)
        val list = sql.orderBy(TB_ITEM_DETAIL.UPDATE_TIME.desc()).limit(size).offset((page - 1) * size)
            .fetchInto(ItemDetailView::class.java)
        return PageView(list, total)
    }

    fun updateItemDetail(request: ItemDetailUpdateRequest) {
        if (request.id != null) {
            dslContext.trans {
                val detail =
                    selectFrom(TB_ITEM_DETAIL).where(TB_ITEM_DETAIL.ID.eq(request.id)).fetchAny() ?: throw CommonException(
                        ResponseCode.RECORD_NOT_FOUND
                    )
                detail.name = request.name
                detail.images = objectMapper list2Json request.images
                detail.pd =request.pd
                detail.qty = request.qty
                detail.bestFavor = request.bestFavor
                detail.shelfLife = request.shelfLife
                detail.storage = request.storage
                detail.usedStorage = request.usedStorage
                detail.batchCode = request.batchCode
                detail.cost = request.cost
                executeUpdate(detail)
            }
        } else {
            dslContext.trans {
                val detail = TB_ITEM_DETAIL.newRecord()
                detail.itemId = request.itemId
                detail.goodId = request.goodId
                detail.name = request.name
                detail.images = objectMapper list2Json request.images
                detail.pd = request.pd
                detail.qty = request.qty
                detail.bestFavor = request.bestFavor
                detail.shelfLife = request.shelfLife
                detail.storage = request.storage
                detail.usedStorage = request.usedStorage
                detail.batchCode = request.batchCode
                detail.cost = request.cost
                executeInsert(detail)
            }
        }
    }

    fun expiryDetail(did: Int) {
        dslContext.trans {
            update(TB_ITEM_DETAIL).set(TB_ITEM_DETAIL.EXPIRY, LocalDateTime.now()).where(TB_ITEM_DETAIL.ID.eq(did)).execute()
        }
    }

    fun item(tid: Int): Any? {
        return dslContext.selectFrom(TB_ITEM).where(TB_ITEM.ID.eq(tid)).fetchAnyInto(TbItem::class.java)
    }

    fun itemDetail(did: Int): Any? {
        return dslContext.selectFrom(TB_ITEM_DETAIL).where(TB_ITEM_DETAIL.ID.eq(did)).fetchAnyInto(TbItemDetail::class.java)
    }

    fun getDetailListByGood(gid: Int, offset: Int, limit: Int?, order: String): Any {
        return dslContext.selectFrom(TB_ITEM_DETAIL).where(TB_ITEM_DETAIL.GOOD_ID.eq(gid))
            .orderBy(when(order){
                "update_time" -> TB_ITEM_DETAIL.UPDATE_TIME.desc()
                "expiry_time" -> TB_ITEM_DETAIL.BEST_FAVOR
                else-> throw CommonException(ResponseCode.PARAMETER_ERROR)
            }).offset(offset).limit(limit?:5).fetchInto(TbItemDetail::class.java)
    }

}