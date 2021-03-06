package com.theoxao.dura.good.service

import com.theoxao.dura.orm.dto.tables.pojos.TbLocation
import org.jooq.DSLContext
import org.springframework.http.HttpHeaders.LOCATION
import org.springframework.stereotype.Service
import javax.annotation.Resource

@Service
class LocationService {

    @Resource
    lateinit var dslContext: DSLContext

    fun list(): MutableList<TbLocation> {
        return dslContext.selectFrom(LOCATION).fetchInto(TbLocation::class.java)
    }

}