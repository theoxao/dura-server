/*
 * This file is generated by jOOQ.
 */
package com.theoxao.dura.orm.dto.tables.records;


import com.theoxao.dura.orm.dto.tables.TbGoodCandidate;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbGoodCandidateRecord extends UpdatableRecordImpl<TbGoodCandidateRecord> implements Record8<String, String, String, Integer, Integer, Integer, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.tb_good_candidate.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.tb_good_candidate.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.tb_good_candidate.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.tb_good_candidate.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.tb_good_candidate.from</code>.
     */
    public void setFrom(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.tb_good_candidate.from</code>.
     */
    public String getFrom() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.tb_good_candidate.cate</code>.
     */
    public void setCate(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.tb_good_candidate.cate</code>.
     */
    public Integer getCate() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>public.tb_good_candidate.sub_cate</code>.
     */
    public void setSubCate(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.tb_good_candidate.sub_cate</code>.
     */
    public Integer getSubCate() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>public.tb_good_candidate.count</code>.
     */
    public void setCount(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.tb_good_candidate.count</code>.
     */
    public Integer getCount() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>public.tb_good_candidate.py</code>.
     */
    public void setPy(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.tb_good_candidate.py</code>.
     */
    public String getPy() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.tb_good_candidate.py_short</code>.
     */
    public void setPyShort(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.tb_good_candidate.py_short</code>.
     */
    public String getPyShort() {
        return (String) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row8<String, String, String, Integer, Integer, Integer, String, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    public Row8<String, String, String, Integer, Integer, Integer, String, String> valuesRow() {
        return (Row8) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return TbGoodCandidate.TB_GOOD_CANDIDATE.ID;
    }

    @Override
    public Field<String> field2() {
        return TbGoodCandidate.TB_GOOD_CANDIDATE.NAME;
    }

    @Override
    public Field<String> field3() {
        return TbGoodCandidate.TB_GOOD_CANDIDATE.FROM;
    }

    @Override
    public Field<Integer> field4() {
        return TbGoodCandidate.TB_GOOD_CANDIDATE.CATE;
    }

    @Override
    public Field<Integer> field5() {
        return TbGoodCandidate.TB_GOOD_CANDIDATE.SUB_CATE;
    }

    @Override
    public Field<Integer> field6() {
        return TbGoodCandidate.TB_GOOD_CANDIDATE.COUNT;
    }

    @Override
    public Field<String> field7() {
        return TbGoodCandidate.TB_GOOD_CANDIDATE.PY;
    }

    @Override
    public Field<String> field8() {
        return TbGoodCandidate.TB_GOOD_CANDIDATE.PY_SHORT;
    }

    @Override
    public String component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getFrom();
    }

    @Override
    public Integer component4() {
        return getCate();
    }

    @Override
    public Integer component5() {
        return getSubCate();
    }

    @Override
    public Integer component6() {
        return getCount();
    }

    @Override
    public String component7() {
        return getPy();
    }

    @Override
    public String component8() {
        return getPyShort();
    }

    @Override
    public String value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getFrom();
    }

    @Override
    public Integer value4() {
        return getCate();
    }

    @Override
    public Integer value5() {
        return getSubCate();
    }

    @Override
    public Integer value6() {
        return getCount();
    }

    @Override
    public String value7() {
        return getPy();
    }

    @Override
    public String value8() {
        return getPyShort();
    }

    @Override
    public TbGoodCandidateRecord value1(String value) {
        setId(value);
        return this;
    }

    @Override
    public TbGoodCandidateRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public TbGoodCandidateRecord value3(String value) {
        setFrom(value);
        return this;
    }

    @Override
    public TbGoodCandidateRecord value4(Integer value) {
        setCate(value);
        return this;
    }

    @Override
    public TbGoodCandidateRecord value5(Integer value) {
        setSubCate(value);
        return this;
    }

    @Override
    public TbGoodCandidateRecord value6(Integer value) {
        setCount(value);
        return this;
    }

    @Override
    public TbGoodCandidateRecord value7(String value) {
        setPy(value);
        return this;
    }

    @Override
    public TbGoodCandidateRecord value8(String value) {
        setPyShort(value);
        return this;
    }

    @Override
    public TbGoodCandidateRecord values(String value1, String value2, String value3, Integer value4, Integer value5, Integer value6, String value7, String value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TbGoodCandidateRecord
     */
    public TbGoodCandidateRecord() {
        super(TbGoodCandidate.TB_GOOD_CANDIDATE);
    }

    /**
     * Create a detached, initialised TbGoodCandidateRecord
     */
    public TbGoodCandidateRecord(String id, String name, String from, Integer cate, Integer subCate, Integer count, String py, String pyShort) {
        super(TbGoodCandidate.TB_GOOD_CANDIDATE);

        setId(id);
        setName(name);
        setFrom(from);
        setCate(cate);
        setSubCate(subCate);
        setCount(count);
        setPy(py);
        setPyShort(pyShort);
    }
}
