package com.theoxao.dura.good.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.theoxao.dura.good.common.*
import com.theoxao.dura.good.common.ResponseCode.RECORD_NOT_FOUND
import com.theoxao.dura.good.model.GoodUpdateRequest
import com.theoxao.dura.good.utils.py
import com.theoxao.dura.good.utils.pys
import com.theoxao.dura.orm.dto.Tables.*
import com.theoxao.dura.orm.dto.tables.pojos.TbGoods
import com.theoxao.dura.orm.dto.tables.pojos.TbItemDetail
import com.theoxao.dura.orm.dto.tables.pojos.TbStorage
import org.jooq.DSLContext
import org.jooq.impl.DSL
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct
import javax.annotation.Resource

@Service
class GoodService {

    @Resource
    lateinit var dslContext: DSLContext

    @Resource
    lateinit var objectMapper: ObjectMapper

    @Resource
    lateinit var cateService: CateService

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

    fun update(request: GoodUpdateRequest):Any? {
        val cateMap =cateService.cateMap
        var result: GoodDetailView? = null
        if (request.id != null) {
            dslContext.trans {
                val good = selectFrom(TB_GOODS).where(TB_GOODS.ID.eq(request.id)).fetchAny() ?: throw CommonException(
                    RECORD_NOT_FOUND
                )
                good.name = request.name
                good.cate = request.cate
                good.desc = request.desc
                good.subCate = request.subCate
                good.remainBatch = request.remainBatch
                good.recentPrice = request.recentPrice
                good.images = objectMapper list2Json request.images
                good.needBuy = request.needBuy
                good.py = request.name?.py()
                good.pyShort = request.name?.pys()
                executeUpdate(good)
            }
           result = dslContext.selectFrom(TB_GOODS).where(TB_GOODS.ID.eq(request.id)).fetchAnyInto(GoodDetailView::class.java).apply {
                this?.cateStr = cateMap[this?.cate]
                this?.subCateStr = cateMap[this?.subCate]
            }
        } else {
            dslContext.trans {
                val candidate =TB_GOOD_CANDIDATE.newRecord().apply {
                    this.name = request.name
                    this.from = "user"
                    this.cate = request.cate
                    this.subCate = request.subCate
                    this.py = request.name?.py()
                    this.pyShort = request.name?.pys()
                }
                insertInto(TB_GOOD_CANDIDATE).set(candidate).onConflictDoNothing().execute()
                val good = TB_GOODS.newRecord().apply {
                    this.name = request.name
                    this.desc = request.desc
                    this.cate = request.cate
                    this.subCate = request.subCate
                    this.remainBatch = request.remainBatch
                    this.recentPrice = request.recentPrice
                    this.images = objectMapper list2Json request.images
                    this.needBuy = request.needBuy ?: 0
                    this.py = request.name?.py()
                    this.pyShort = request.name?.pys()
                }
               result = insertInto(TB_GOODS).set(good).onConflictDoNothing().returning().fetchOne()?.into(GoodDetailView::class.java).apply {
                    this?.cateStr = cateMap[this?.cate]
                    this?.subCateStr = cateMap[this?.subCate]
                }
            }
        }
        return result
    }

    fun good(id: Int): Any {
        val cateMap =cateService.cateMap
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

    fun suggestion(name: String): Any {
        return dslContext.select().from(TB_GOOD_CANDIDATE)
            .leftJoin(TB_GOODS).on(TB_GOODS.NAME.eq(TB_GOOD_CANDIDATE.NAME))
            .where(TB_GOOD_CANDIDATE.NAME.startsWith(name))
            .orderBy(DSL.length(TB_GOOD_CANDIDATE.NAME),TB_GOOD_CANDIDATE.COUNT.desc()).limit(20)
            .fetch {
                it.into(TB_GOOD_CANDIDATE).into(GoodCandidateView::class.java).apply {
                    this.goodId = it.get(TB_GOODS.ID)
                    this.cateStr = cateService.cateMap[this.cate]
                    this.subCateStr  = cateService.cateMap[this.subCate]
                }
            }
    }

    fun storage(gid: Int?, cid: Int?): Any {
        val storages = dslContext.selectFrom(TB_STORAGE).fetchInto(TbStorage::class.java)
        var result = storages
        if (cid!=null){
            result = storages.filter {
                objectMapper.readValue<List<Int>>(it.cates.data(), objectMapper.typeFactory.constructParametricType(List::class.java, Int::class.java))
                .contains(cid)
            }
        }
        return result
    }

}