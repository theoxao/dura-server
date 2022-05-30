package com.theoxao.dura.good.service

import com.theoxao.dura.orm.dto.Tables.TB_BRAND
import com.theoxao.dura.orm.dto.tables.pojos.TbBrand
import org.jooq.DSLContext
import org.jooq.JSON
import org.jooq.impl.DSL
import org.springframework.stereotype.Service
import javax.annotation.Resource

@Service
class BrandService {

    @Resource
    lateinit var dslContext: DSLContext

    fun list(cid: Int?): Any {
        return dslContext.selectFrom(TB_BRAND).where(DSL.trueCondition()).apply {
            if (cid!=null && cid > 0)  and(DSL.jsonArray(TB_BRAND.CATE).contains(JSON.valueOf(cid.toString())))
        }.orderBy(TB_BRAND.ITEM_COUNT.desc()).fetchInto(TbBrand::class.java)
    }

}