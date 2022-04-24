package com.theoxao.duraemon.good.controller

import com.theoxao.duraemon.good.common.CommonView
import com.theoxao.duraemon.good.common.PageView
import com.theoxao.duraemon.good.common.success
import com.theoxao.duraemon.good.model.ItemDetailUpdateRequest
import com.theoxao.duraemon.good.model.ItemDetailView
import com.theoxao.duraemon.good.model.ItemUpdateRequest
import com.theoxao.duraemon.good.model.ItemView
import com.theoxao.duraemon.good.service.ItemService
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource


@RestController
@RequestMapping("/item")
class ItemController {

    @Resource
    lateinit var itemService: ItemService

    /**
     * 查询物品下面所有item
     * @param gid: good id
     */
    @GetMapping("/list/{gid}")
    fun itemList(@PathVariable gid: Int, page: Int, size: Int): CommonView<PageView<ItemView>> {
        return success(itemService.itemList(gid, page, size))
    }

    @GetMapping("/{tid}")
    fun item (@PathVariable tid: Int): CommonView<*> {
        return success(itemService.item(tid))
    }

    @PostMapping("/update")
    fun updateItem(@RequestBody request: ItemUpdateRequest): CommonView<*> {
        itemService.updateItem(request)
        return success()
    }

    /**
     * 查询item下面所有item_detail
     * @param tid: item id
     */
    @GetMapping("/detail/list/{tid}")
    fun itemDetailList(@PathVariable tid: Int, page: Int, size: Int): CommonView<PageView<ItemDetailView>> {
        return success(itemService.itemDetailList(tid, page, size))
    }

    @PostMapping("/detail/update")
    fun updateItemDetail(@RequestBody request: ItemDetailUpdateRequest): CommonView<*> {
        itemService.updateItemDetail(request)
        return success()
    }

    @PostMapping("/detail/{did}/expiry")
    fun expiryDetail(@PathVariable did: Int): CommonView<*> {
        itemService.expiryDetail(did)
        return success()
    }

    @GetMapping("/detail/{did}")
    fun itemDetail(@PathVariable did: Int): CommonView<*> {
        return success(itemService.itemDetail(did))
    }

    @GetMapping("/detailByGood/{gid}")
    fun getDetailListByGood(@PathVariable gid: Int, offset:Int, limit:Int?, order:String):CommonView<*>{
        return success(itemService.getDetailListByGood(gid, offset , limit , order))
    }

}