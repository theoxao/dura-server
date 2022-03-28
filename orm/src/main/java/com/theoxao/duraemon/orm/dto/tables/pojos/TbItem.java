/*
 * This file is generated by jOOQ.
 */
package com.theoxao.duraemon.orm.dto.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;

import org.jooq.JSON;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer       id;
    private Integer       goodId;
    private String        name;
    private JSON          images;
    private String        desc;
    private String        spec;
    private Integer       price;
    private String        isbn;
    private Integer       bestFavor;
    private Integer       shelfLife;
    private String        storage;
    private String        usedStorage;
    private String        remark;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public TbItem() {}

    public TbItem(TbItem value) {
        this.id = value.id;
        this.goodId = value.goodId;
        this.name = value.name;
        this.images = value.images;
        this.desc = value.desc;
        this.spec = value.spec;
        this.price = value.price;
        this.isbn = value.isbn;
        this.bestFavor = value.bestFavor;
        this.shelfLife = value.shelfLife;
        this.storage = value.storage;
        this.usedStorage = value.usedStorage;
        this.remark = value.remark;
        this.createTime = value.createTime;
        this.updateTime = value.updateTime;
    }

    public TbItem(
        Integer       id,
        Integer       goodId,
        String        name,
        JSON          images,
        String        desc,
        String        spec,
        Integer       price,
        String        isbn,
        Integer       bestFavor,
        Integer       shelfLife,
        String        storage,
        String        usedStorage,
        String        remark,
        LocalDateTime createTime,
        LocalDateTime updateTime
    ) {
        this.id = id;
        this.goodId = goodId;
        this.name = name;
        this.images = images;
        this.desc = desc;
        this.spec = spec;
        this.price = price;
        this.isbn = isbn;
        this.bestFavor = bestFavor;
        this.shelfLife = shelfLife;
        this.storage = storage;
        this.usedStorage = usedStorage;
        this.remark = remark;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     * Getter for <code>public.tb_item.id</code>.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.tb_item.id</code>.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for <code>public.tb_item.good_id</code>.
     */
    public Integer getGoodId() {
        return this.goodId;
    }

    /**
     * Setter for <code>public.tb_item.good_id</code>.
     */
    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    /**
     * Getter for <code>public.tb_item.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>public.tb_item.name</code>.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for <code>public.tb_item.images</code>.
     */
    public JSON getImages() {
        return this.images;
    }

    /**
     * Setter for <code>public.tb_item.images</code>.
     */
    public void setImages(JSON images) {
        this.images = images;
    }

    /**
     * Getter for <code>public.tb_item.desc</code>.
     */
    public String getDesc() {
        return this.desc;
    }

    /**
     * Setter for <code>public.tb_item.desc</code>.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Getter for <code>public.tb_item.spec</code>.
     */
    public String getSpec() {
        return this.spec;
    }

    /**
     * Setter for <code>public.tb_item.spec</code>.
     */
    public void setSpec(String spec) {
        this.spec = spec;
    }

    /**
     * Getter for <code>public.tb_item.price</code>.
     */
    public Integer getPrice() {
        return this.price;
    }

    /**
     * Setter for <code>public.tb_item.price</code>.
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * Getter for <code>public.tb_item.isbn</code>.
     */
    public String getIsbn() {
        return this.isbn;
    }

    /**
     * Setter for <code>public.tb_item.isbn</code>.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Getter for <code>public.tb_item.best_favor</code>.
     */
    public Integer getBestFavor() {
        return this.bestFavor;
    }

    /**
     * Setter for <code>public.tb_item.best_favor</code>.
     */
    public void setBestFavor(Integer bestFavor) {
        this.bestFavor = bestFavor;
    }

    /**
     * Getter for <code>public.tb_item.shelf_life</code>.
     */
    public Integer getShelfLife() {
        return this.shelfLife;
    }

    /**
     * Setter for <code>public.tb_item.shelf_life</code>.
     */
    public void setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
    }

    /**
     * Getter for <code>public.tb_item.storage</code>.
     */
    public String getStorage() {
        return this.storage;
    }

    /**
     * Setter for <code>public.tb_item.storage</code>.
     */
    public void setStorage(String storage) {
        this.storage = storage;
    }

    /**
     * Getter for <code>public.tb_item.used_storage</code>.
     */
    public String getUsedStorage() {
        return this.usedStorage;
    }

    /**
     * Setter for <code>public.tb_item.used_storage</code>.
     */
    public void setUsedStorage(String usedStorage) {
        this.usedStorage = usedStorage;
    }

    /**
     * Getter for <code>public.tb_item.remark</code>.
     */
    public String getRemark() {
        return this.remark;
    }

    /**
     * Setter for <code>public.tb_item.remark</code>.
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * Getter for <code>public.tb_item.create_time</code>.
     */
    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    /**
     * Setter for <code>public.tb_item.create_time</code>.
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * Getter for <code>public.tb_item.update_time</code>.
     */
    public LocalDateTime getUpdateTime() {
        return this.updateTime;
    }

    /**
     * Setter for <code>public.tb_item.update_time</code>.
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TbItem (");

        sb.append(id);
        sb.append(", ").append(goodId);
        sb.append(", ").append(name);
        sb.append(", ").append(images);
        sb.append(", ").append(desc);
        sb.append(", ").append(spec);
        sb.append(", ").append(price);
        sb.append(", ").append(isbn);
        sb.append(", ").append(bestFavor);
        sb.append(", ").append(shelfLife);
        sb.append(", ").append(storage);
        sb.append(", ").append(usedStorage);
        sb.append(", ").append(remark);
        sb.append(", ").append(createTime);
        sb.append(", ").append(updateTime);

        sb.append(")");
        return sb.toString();
    }
}
