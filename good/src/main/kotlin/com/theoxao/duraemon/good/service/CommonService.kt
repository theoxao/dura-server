package com.theoxao.duraemon.good.service

import com.theoxao.duraemon.good.common.CommonSearchView
import com.theoxao.duraemon.orm.dto.Tables.*
import org.jooq.DSLContext
import org.jooq.impl.DSL
import org.springframework.stereotype.Service
import javax.annotation.Resource

@Service
class CommonService {

    @Resource
    lateinit var dslContext: DSLContext

    /**
     * 搜索物品接口
     * @param type: 0-所有类型 1-good 2-item 3-item_detail
     * @param keyword: 搜索关键字
     */
    fun search(keyword: String, type: Int, page: Int, size: Int): Any {
        return when (type) {
            0 -> {
                val query = DSL.select(TB_GOODS.ID, TB_GOODS.NAME, TB_GOODS.DESC, DSL.`val`(1).`as`("type"), TB_GOODS.IMAGES)
                    .from(TB_GOODS).unionAll(
                        DSL.select(TB_ITEM.ID, TB_ITEM.NAME, TB_ITEM.DESC, DSL.`val`(2).`as`("type"), TB_ITEM.IMAGES)
                            .from(TB_ITEM)
                    ).unionAll(
                        DSL.select(
                            TB_ITEM_DETAIL.ID,
                            TB_ITEM_DETAIL.NAME,
                            TB_ITEM_DETAIL.DESC,
                            DSL.`val`(3).`as`("type"),
                            TB_ITEM_DETAIL.IMAGES
                        )
                            .from(TB_ITEM_DETAIL)
                    ).asTable("unionized")
                return dslContext.selectFrom(query).where(
                    query.field("name")?.like("%$keyword%")
                        ?.or(query.field("desc")?.like("%$keyword%")) ?: DSL.falseCondition()
                )
                    .orderBy(query.field("id")?.desc()).limit(size).offset((page - 1) * size)
                    .fetchInto(CommonSearchView::class.java)
            }
            1 -> {
                return dslContext.select(TB_GOODS.ID, TB_GOODS.NAME, TB_GOODS.DESC, DSL.`val`(1).`as`("type"), TB_GOODS.IMAGES)
                    .from(TB_GOODS).where(TB_GOODS.NAME.like("%$keyword%").or(TB_GOODS.DESC.like("%$keyword%")))
                    .orderBy(TB_GOODS.UPDATE_TIME.desc())
                    .limit(size).offset((page - 1) * size).fetchInto(CommonSearchView::class.java)
            }
            2 -> {
                return dslContext.select(TB_ITEM.ID, TB_ITEM.NAME, TB_ITEM.DESC, DSL.`val`(2).`as`("type"), TB_ITEM.IMAGES)
                    .from(TB_ITEM).where(TB_ITEM.NAME.like("%$keyword%").or(TB_ITEM.DESC.like("%$keyword%")))
                    .orderBy(TB_GOODS.UPDATE_TIME.desc())
                    .limit(size).offset((page - 1) * size).fetchInto(CommonSearchView::class.java)
            }
            3 -> {
                return dslContext.select(
                    TB_ITEM_DETAIL.ID,
                    TB_ITEM_DETAIL.NAME,
                    TB_ITEM_DETAIL.DESC,
                    DSL.`val`(3).`as`("type"),
                    TB_ITEM_DETAIL.IMAGES
                )
                    .from(TB_ITEM_DETAIL)
                    .where(TB_ITEM_DETAIL.NAME.like("%$keyword%").or(TB_ITEM_DETAIL.DESC.like("%$keyword%")))
                    .orderBy(TB_GOODS.UPDATE_TIME.desc())
                    .limit(size).offset((page - 1) * size).fetchInto(CommonSearchView::class.java)
            }
            else -> arrayListOf<CommonSearchView>()
        }
    }
}