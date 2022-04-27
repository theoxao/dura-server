/*
 * This file is generated by jOOQ.
 */
package com.theoxao.duraemon.orm.dto.tables.records;


import com.theoxao.duraemon.orm.dto.tables.Ing;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class IngRecord extends TableRecordImpl<IngRecord> implements Record2<String, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.ing.name</code>.
     */
    public void setName(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.ing.name</code>.
     */
    public String getName() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.ing.cnt</code>.
     */
    public void setCnt(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.ing.cnt</code>.
     */
    public Long getCnt() {
        return (Long) get(1);
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, Long> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<String, Long> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Ing.ING.NAME;
    }

    @Override
    public Field<Long> field2() {
        return Ing.ING.CNT;
    }

    @Override
    public String component1() {
        return getName();
    }

    @Override
    public Long component2() {
        return getCnt();
    }

    @Override
    public String value1() {
        return getName();
    }

    @Override
    public Long value2() {
        return getCnt();
    }

    @Override
    public IngRecord value1(String value) {
        setName(value);
        return this;
    }

    @Override
    public IngRecord value2(Long value) {
        setCnt(value);
        return this;
    }

    @Override
    public IngRecord values(String value1, Long value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached IngRecord
     */
    public IngRecord() {
        super(Ing.ING);
    }

    /**
     * Create a detached, initialised IngRecord
     */
    public IngRecord(String name, Long cnt) {
        super(Ing.ING);

        setName(name);
        setCnt(cnt);
    }
}
