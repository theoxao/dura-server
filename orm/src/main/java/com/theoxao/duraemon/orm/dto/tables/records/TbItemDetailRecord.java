/*
 * This file is generated by jOOQ.
 */
package com.theoxao.duraemon.orm.dto.tables.records;


import com.theoxao.duraemon.orm.dto.tables.TbItemDetail;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.JSON;
import org.jooq.Record1;
import org.jooq.Record17;
import org.jooq.Row17;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbItemDetailRecord extends UpdatableRecordImpl<TbItemDetailRecord> implements Record17<Integer, Integer, Integer, String, JSON, String, LocalDate, Integer, Integer, Integer, String, String, String, Integer, LocalDateTime, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.tb_item_detail.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.tb_item_detail.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.tb_item_detail.item_id</code>.
     */
    public void setItemId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.tb_item_detail.item_id</code>.
     */
    public Integer getItemId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>public.tb_item_detail.good_id</code>.
     */
    public void setGoodId(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.tb_item_detail.good_id</code>.
     */
    public Integer getGoodId() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>public.tb_item_detail.name</code>.
     */
    public void setName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.tb_item_detail.name</code>.
     */
    public String getName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.tb_item_detail.images</code>.
     */
    public void setImages(JSON value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.tb_item_detail.images</code>.
     */
    public JSON getImages() {
        return (JSON) get(4);
    }

    /**
     * Setter for <code>public.tb_item_detail.desc</code>.
     */
    public void setDesc(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.tb_item_detail.desc</code>.
     */
    public String getDesc() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.tb_item_detail.pd</code>. 生产日期
     */
    public void setPd(LocalDate value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.tb_item_detail.pd</code>. 生产日期
     */
    public LocalDate getPd() {
        return (LocalDate) get(6);
    }

    /**
     * Setter for <code>public.tb_item_detail.qty</code>. 数量
     */
    public void setQty(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.tb_item_detail.qty</code>. 数量
     */
    public Integer getQty() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>public.tb_item_detail.best_favor</code>. 保质期
     */
    public void setBestFavor(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.tb_item_detail.best_favor</code>. 保质期
     */
    public Integer getBestFavor() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>public.tb_item_detail.shelf_life</code>.
     */
    public void setShelfLife(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.tb_item_detail.shelf_life</code>.
     */
    public Integer getShelfLife() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>public.tb_item_detail.storage</code>. 储存方式-未拆封
     */
    public void setStorage(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.tb_item_detail.storage</code>. 储存方式-未拆封
     */
    public String getStorage() {
        return (String) get(10);
    }

    /**
     * Setter for <code>public.tb_item_detail.used_storage</code>. 储存方式-已拆封
     */
    public void setUsedStorage(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.tb_item_detail.used_storage</code>. 储存方式-已拆封
     */
    public String getUsedStorage() {
        return (String) get(11);
    }

    /**
     * Setter for <code>public.tb_item_detail.batch_code</code>. 批次编号
     */
    public void setBatchCode(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.tb_item_detail.batch_code</code>. 批次编号
     */
    public String getBatchCode() {
        return (String) get(12);
    }

    /**
     * Setter for <code>public.tb_item_detail.cost</code>. 价格
     */
    public void setCost(Integer value) {
        set(13, value);
    }

    /**
     * Getter for <code>public.tb_item_detail.cost</code>. 价格
     */
    public Integer getCost() {
        return (Integer) get(13);
    }

    /**
     * Setter for <code>public.tb_item_detail.expiry</code>.
     */
    public void setExpiry(LocalDateTime value) {
        set(14, value);
    }

    /**
     * Getter for <code>public.tb_item_detail.expiry</code>.
     */
    public LocalDateTime getExpiry() {
        return (LocalDateTime) get(14);
    }

    /**
     * Setter for <code>public.tb_item_detail.create_time</code>.
     */
    public void setCreateTime(LocalDateTime value) {
        set(15, value);
    }

    /**
     * Getter for <code>public.tb_item_detail.create_time</code>.
     */
    public LocalDateTime getCreateTime() {
        return (LocalDateTime) get(15);
    }

    /**
     * Setter for <code>public.tb_item_detail.update_time</code>.
     */
    public void setUpdateTime(LocalDateTime value) {
        set(16, value);
    }

    /**
     * Getter for <code>public.tb_item_detail.update_time</code>.
     */
    public LocalDateTime getUpdateTime() {
        return (LocalDateTime) get(16);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record17 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row17<Integer, Integer, Integer, String, JSON, String, LocalDate, Integer, Integer, Integer, String, String, String, Integer, LocalDateTime, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row17) super.fieldsRow();
    }

    @Override
    public Row17<Integer, Integer, Integer, String, JSON, String, LocalDate, Integer, Integer, Integer, String, String, String, Integer, LocalDateTime, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row17) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return TbItemDetail.TB_ITEM_DETAIL.ID;
    }

    @Override
    public Field<Integer> field2() {
        return TbItemDetail.TB_ITEM_DETAIL.ITEM_ID;
    }

    @Override
    public Field<Integer> field3() {
        return TbItemDetail.TB_ITEM_DETAIL.GOOD_ID;
    }

    @Override
    public Field<String> field4() {
        return TbItemDetail.TB_ITEM_DETAIL.NAME;
    }

    @Override
    public Field<JSON> field5() {
        return TbItemDetail.TB_ITEM_DETAIL.IMAGES;
    }

    @Override
    public Field<String> field6() {
        return TbItemDetail.TB_ITEM_DETAIL.DESC;
    }

    @Override
    public Field<LocalDate> field7() {
        return TbItemDetail.TB_ITEM_DETAIL.PD;
    }

    @Override
    public Field<Integer> field8() {
        return TbItemDetail.TB_ITEM_DETAIL.QTY;
    }

    @Override
    public Field<Integer> field9() {
        return TbItemDetail.TB_ITEM_DETAIL.BEST_FAVOR;
    }

    @Override
    public Field<Integer> field10() {
        return TbItemDetail.TB_ITEM_DETAIL.SHELF_LIFE;
    }

    @Override
    public Field<String> field11() {
        return TbItemDetail.TB_ITEM_DETAIL.STORAGE;
    }

    @Override
    public Field<String> field12() {
        return TbItemDetail.TB_ITEM_DETAIL.USED_STORAGE;
    }

    @Override
    public Field<String> field13() {
        return TbItemDetail.TB_ITEM_DETAIL.BATCH_CODE;
    }

    @Override
    public Field<Integer> field14() {
        return TbItemDetail.TB_ITEM_DETAIL.COST;
    }

    @Override
    public Field<LocalDateTime> field15() {
        return TbItemDetail.TB_ITEM_DETAIL.EXPIRY;
    }

    @Override
    public Field<LocalDateTime> field16() {
        return TbItemDetail.TB_ITEM_DETAIL.CREATE_TIME;
    }

    @Override
    public Field<LocalDateTime> field17() {
        return TbItemDetail.TB_ITEM_DETAIL.UPDATE_TIME;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public Integer component2() {
        return getItemId();
    }

    @Override
    public Integer component3() {
        return getGoodId();
    }

    @Override
    public String component4() {
        return getName();
    }

    @Override
    public JSON component5() {
        return getImages();
    }

    @Override
    public String component6() {
        return getDesc();
    }

    @Override
    public LocalDate component7() {
        return getPd();
    }

    @Override
    public Integer component8() {
        return getQty();
    }

    @Override
    public Integer component9() {
        return getBestFavor();
    }

    @Override
    public Integer component10() {
        return getShelfLife();
    }

    @Override
    public String component11() {
        return getStorage();
    }

    @Override
    public String component12() {
        return getUsedStorage();
    }

    @Override
    public String component13() {
        return getBatchCode();
    }

    @Override
    public Integer component14() {
        return getCost();
    }

    @Override
    public LocalDateTime component15() {
        return getExpiry();
    }

    @Override
    public LocalDateTime component16() {
        return getCreateTime();
    }

    @Override
    public LocalDateTime component17() {
        return getUpdateTime();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public Integer value2() {
        return getItemId();
    }

    @Override
    public Integer value3() {
        return getGoodId();
    }

    @Override
    public String value4() {
        return getName();
    }

    @Override
    public JSON value5() {
        return getImages();
    }

    @Override
    public String value6() {
        return getDesc();
    }

    @Override
    public LocalDate value7() {
        return getPd();
    }

    @Override
    public Integer value8() {
        return getQty();
    }

    @Override
    public Integer value9() {
        return getBestFavor();
    }

    @Override
    public Integer value10() {
        return getShelfLife();
    }

    @Override
    public String value11() {
        return getStorage();
    }

    @Override
    public String value12() {
        return getUsedStorage();
    }

    @Override
    public String value13() {
        return getBatchCode();
    }

    @Override
    public Integer value14() {
        return getCost();
    }

    @Override
    public LocalDateTime value15() {
        return getExpiry();
    }

    @Override
    public LocalDateTime value16() {
        return getCreateTime();
    }

    @Override
    public LocalDateTime value17() {
        return getUpdateTime();
    }

    @Override
    public TbItemDetailRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public TbItemDetailRecord value2(Integer value) {
        setItemId(value);
        return this;
    }

    @Override
    public TbItemDetailRecord value3(Integer value) {
        setGoodId(value);
        return this;
    }

    @Override
    public TbItemDetailRecord value4(String value) {
        setName(value);
        return this;
    }

    @Override
    public TbItemDetailRecord value5(JSON value) {
        setImages(value);
        return this;
    }

    @Override
    public TbItemDetailRecord value6(String value) {
        setDesc(value);
        return this;
    }

    @Override
    public TbItemDetailRecord value7(LocalDate value) {
        setPd(value);
        return this;
    }

    @Override
    public TbItemDetailRecord value8(Integer value) {
        setQty(value);
        return this;
    }

    @Override
    public TbItemDetailRecord value9(Integer value) {
        setBestFavor(value);
        return this;
    }

    @Override
    public TbItemDetailRecord value10(Integer value) {
        setShelfLife(value);
        return this;
    }

    @Override
    public TbItemDetailRecord value11(String value) {
        setStorage(value);
        return this;
    }

    @Override
    public TbItemDetailRecord value12(String value) {
        setUsedStorage(value);
        return this;
    }

    @Override
    public TbItemDetailRecord value13(String value) {
        setBatchCode(value);
        return this;
    }

    @Override
    public TbItemDetailRecord value14(Integer value) {
        setCost(value);
        return this;
    }

    @Override
    public TbItemDetailRecord value15(LocalDateTime value) {
        setExpiry(value);
        return this;
    }

    @Override
    public TbItemDetailRecord value16(LocalDateTime value) {
        setCreateTime(value);
        return this;
    }

    @Override
    public TbItemDetailRecord value17(LocalDateTime value) {
        setUpdateTime(value);
        return this;
    }

    @Override
    public TbItemDetailRecord values(Integer value1, Integer value2, Integer value3, String value4, JSON value5, String value6, LocalDate value7, Integer value8, Integer value9, Integer value10, String value11, String value12, String value13, Integer value14, LocalDateTime value15, LocalDateTime value16, LocalDateTime value17) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TbItemDetailRecord
     */
    public TbItemDetailRecord() {
        super(TbItemDetail.TB_ITEM_DETAIL);
    }

    /**
     * Create a detached, initialised TbItemDetailRecord
     */
    public TbItemDetailRecord(Integer id, Integer itemId, Integer goodId, String name, JSON images, String desc, LocalDate pd, Integer qty, Integer bestFavor, Integer shelfLife, String storage, String usedStorage, String batchCode, Integer cost, LocalDateTime expiry, LocalDateTime createTime, LocalDateTime updateTime) {
        super(TbItemDetail.TB_ITEM_DETAIL);

        setId(id);
        setItemId(itemId);
        setGoodId(goodId);
        setName(name);
        setImages(images);
        setDesc(desc);
        setPd(pd);
        setQty(qty);
        setBestFavor(bestFavor);
        setShelfLife(shelfLife);
        setStorage(storage);
        setUsedStorage(usedStorage);
        setBatchCode(batchCode);
        setCost(cost);
        setExpiry(expiry);
        setCreateTime(createTime);
        setUpdateTime(updateTime);
    }
}
