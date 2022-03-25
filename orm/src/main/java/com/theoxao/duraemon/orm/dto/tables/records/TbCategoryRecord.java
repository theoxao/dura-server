/*
 * This file is generated by jOOQ.
 */
package com.theoxao.duraemon.orm.dto.tables.records;


import com.theoxao.duraemon.orm.dto.tables.TbCategory;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbCategoryRecord extends UpdatableRecordImpl<TbCategoryRecord> implements Record4<Integer, String, Integer, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Create a detached TbCategoryRecord
     */
    public TbCategoryRecord() {
        super(TbCategory.TB_CATEGORY);
    }

    /**
     * Getter for <code>public.tb_category.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Create a detached, initialised TbCategoryRecord
     */
    public TbCategoryRecord(Integer id, String name, Integer level, Integer pid) {
        super(TbCategory.TB_CATEGORY);

        setId(id);
        setName(name);
        setLevel(level);
        setPid(pid);
    }

    /**
     * Getter for <code>public.tb_category.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.tb_category.level</code>.
     */
    public void setLevel(Integer value) {
        set(2, value);
    }

    /**
     * Setter for <code>public.tb_category.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Setter for <code>public.tb_category.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.tb_category.pid</code>.
     */
    public Integer getPid() {
        return (Integer) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, Integer, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Integer, String, Integer, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return TbCategory.TB_CATEGORY.ID;
    }

    @Override
    public Field<String> field2() {
        return TbCategory.TB_CATEGORY.NAME;
    }

    @Override
    public Field<Integer> field3() {
        return TbCategory.TB_CATEGORY.LEVEL;
    }

    @Override
    public Field<Integer> field4() {
        return TbCategory.TB_CATEGORY.PID;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public Integer component3() {
        return getLevel();
    }

    @Override
    public Integer component4() {
        return getPid();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public Integer value3() {
        return getLevel();
    }

    @Override
    public Integer value4() {
        return getPid();
    }

    @Override
    public TbCategoryRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public TbCategoryRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public TbCategoryRecord value3(Integer value) {
        setLevel(value);
        return this;
    }

    @Override
    public TbCategoryRecord value4(Integer value) {
        setPid(value);
        return this;
    }

    @Override
    public TbCategoryRecord values(Integer value1, String value2, Integer value3, Integer value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>public.tb_category.level</code>.
     */
    public Integer getLevel() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>public.tb_category.pid</code>.
     */
    public void setPid(Integer value) {
        set(3, value);
    }
}
