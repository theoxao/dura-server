/*
 * This file is generated by jOOQ.
 */
package com.theoxao.duraemon.orm.dto.tables.pojos;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbItemDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer       id;
    private Integer       itemId;
    private Integer       goodId;
    private String        name;
    private String        images;
    private String        desc;
    private LocalDate     pd;
    private Integer       qty;
    private Integer       bestFavor;
    private Integer       shelfLife;
    private String        storage;
    private String        usedStorage;
    private String        batchCode;
    private Integer       cost;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer       expiry;

    public TbItemDetail() {}

    public TbItemDetail(TbItemDetail value) {
        this.id = value.id;
        this.itemId = value.itemId;
        this.goodId = value.goodId;
        this.name = value.name;
        this.images = value.images;
        this.desc = value.desc;
        this.pd = value.pd;
        this.qty = value.qty;
        this.bestFavor = value.bestFavor;
        this.shelfLife = value.shelfLife;
        this.storage = value.storage;
        this.usedStorage = value.usedStorage;
        this.batchCode = value.batchCode;
        this.cost = value.cost;
        this.createTime = value.createTime;
        this.updateTime = value.updateTime;
        this.expiry = value.expiry;
    }

    public TbItemDetail(
        Integer       id,
        Integer       itemId,
        Integer       goodId,
        String        name,
        String        images,
        String        desc,
        LocalDate     pd,
        Integer       qty,
        Integer       bestFavor,
        Integer       shelfLife,
        String        storage,
        String        usedStorage,
        String        batchCode,
        Integer       cost,
        LocalDateTime createTime,
        LocalDateTime updateTime,
        Integer       expiry
    ) {
        this.id = id;
        this.itemId = itemId;
        this.goodId = goodId;
        this.name = name;
        this.images = images;
        this.desc = desc;
        this.pd = pd;
        this.qty = qty;
        this.bestFavor = bestFavor;
        this.shelfLife = shelfLife;
        this.storage = storage;
        this.usedStorage = usedStorage;
        this.batchCode = batchCode;
        this.cost = cost;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.expiry = expiry;
    }

    /**
     * Getter for <code>public.tb_item_detail.id</code>.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.tb_item_detail.id</code>.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for <code>public.tb_item_detail.item_id</code>.
     */
    public Integer getItemId() {
        return this.itemId;
    }

    /**
     * Setter for <code>public.tb_item_detail.item_id</code>.
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    /**
     * Getter for <code>public.tb_item_detail.good_id</code>.
     */
    public Integer getGoodId() {
        return this.goodId;
    }

    /**
     * Setter for <code>public.tb_item_detail.good_id</code>.
     */
    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    /**
     * Getter for <code>public.tb_item_detail.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>public.tb_item_detail.name</code>.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for <code>public.tb_item_detail.images</code>.
     */
    public String getImages() {
        return this.images;
    }

    /**
     * Setter for <code>public.tb_item_detail.images</code>.
     */
    public void setImages(String images) {
        this.images = images;
    }

    /**
     * Getter for <code>public.tb_item_detail.desc</code>.
     */
    public String getDesc() {
        return this.desc;
    }

    /**
     * Setter for <code>public.tb_item_detail.desc</code>.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Getter for <code>public.tb_item_detail.pd</code>. 生产/制作日期
     */
    public LocalDate getPd() {
        return this.pd;
    }

    /**
     * Setter for <code>public.tb_item_detail.pd</code>. 生产/制作日期
     */
    public void setPd(LocalDate pd) {
        this.pd = pd;
    }

    /**
     * Getter for <code>public.tb_item_detail.qty</code>. 数量
     */
    public Integer getQty() {
        return this.qty;
    }

    /**
     * Setter for <code>public.tb_item_detail.qty</code>. 数量
     */
    public void setQty(Integer qty) {
        this.qty = qty;
    }

    /**
     * Getter for <code>public.tb_item_detail.best_favor</code>. 最佳赏味（单位小时）
     */
    public Integer getBestFavor() {
        return this.bestFavor;
    }

    /**
     * Setter for <code>public.tb_item_detail.best_favor</code>. 最佳赏味（单位小时）
     */
    public void setBestFavor(Integer bestFavor) {
        this.bestFavor = bestFavor;
    }

    /**
     * Getter for <code>public.tb_item_detail.shelf_life</code>. 保质期（单位小时）
     */
    public Integer getShelfLife() {
        return this.shelfLife;
    }

    /**
     * Setter for <code>public.tb_item_detail.shelf_life</code>. 保质期（单位小时）
     */
    public void setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
    }

    /**
     * Getter for <code>public.tb_item_detail.storage</code>. 推荐保存方式
     */
    public String getStorage() {
        return this.storage;
    }

    /**
     * Setter for <code>public.tb_item_detail.storage</code>. 推荐保存方式
     */
    public void setStorage(String storage) {
        this.storage = storage;
    }

    /**
     * Getter for <code>public.tb_item_detail.used_storage</code>. 拆分后保存方式
     */
    public String getUsedStorage() {
        return this.usedStorage;
    }

    /**
     * Setter for <code>public.tb_item_detail.used_storage</code>. 拆分后保存方式
     */
    public void setUsedStorage(String usedStorage) {
        this.usedStorage = usedStorage;
    }

    /**
     * Getter for <code>public.tb_item_detail.batch_code</code>.
     */
    public String getBatchCode() {
        return this.batchCode;
    }

    /**
     * Setter for <code>public.tb_item_detail.batch_code</code>.
     */
    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    /**
     * Getter for <code>public.tb_item_detail.cost</code>.
     */
    public Integer getCost() {
        return this.cost;
    }

    /**
     * Setter for <code>public.tb_item_detail.cost</code>.
     */
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    /**
     * Getter for <code>public.tb_item_detail.create_time</code>.
     */
    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    /**
     * Setter for <code>public.tb_item_detail.create_time</code>.
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * Getter for <code>public.tb_item_detail.update_time</code>.
     */
    public LocalDateTime getUpdateTime() {
        return this.updateTime;
    }

    /**
     * Setter for <code>public.tb_item_detail.update_time</code>.
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * Getter for <code>public.tb_item_detail.expiry</code>.
     */
    public Integer getExpiry() {
        return this.expiry;
    }

    /**
     * Setter for <code>public.tb_item_detail.expiry</code>.
     */
    public void setExpiry(Integer expiry) {
        this.expiry = expiry;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TbItemDetail (");

        sb.append(id);
        sb.append(", ").append(itemId);
        sb.append(", ").append(goodId);
        sb.append(", ").append(name);
        sb.append(", ").append(images);
        sb.append(", ").append(desc);
        sb.append(", ").append(pd);
        sb.append(", ").append(qty);
        sb.append(", ").append(bestFavor);
        sb.append(", ").append(shelfLife);
        sb.append(", ").append(storage);
        sb.append(", ").append(usedStorage);
        sb.append(", ").append(batchCode);
        sb.append(", ").append(cost);
        sb.append(", ").append(createTime);
        sb.append(", ").append(updateTime);
        sb.append(", ").append(expiry);

        sb.append(")");
        return sb.toString();
    }
}
