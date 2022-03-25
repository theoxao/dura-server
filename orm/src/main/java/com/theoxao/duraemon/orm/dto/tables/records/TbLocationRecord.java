/*
 * This file is generated by jOOQ.
 */
package com.theoxao.duraemon.orm.dto.tables.records;


import com.theoxao.duraemon.orm.dto.tables.TbLocation;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbLocationRecord extends UpdatableRecordImpl<TbLocationRecord> implements Record5<Integer, String, String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.tb_location.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Create a detached TbLocationRecord
     */
    public TbLocationRecord() {
        super(TbLocation.TB_LOCATION);
    }

    /**
     * Setter for <code>public.tb_location.room</code>.
     */
    public void setRoom(String value) {
        set(1, value);
    }

    /**
     * Create a detached, initialised TbLocationRecord
     */
    public TbLocationRecord(Integer id, String room, String location, String locShort, String locCode) {
        super(TbLocation.TB_LOCATION);

        setId(id);
        setRoom(room);
        setLocation(location);
        setLocShort(locShort);
        setLocCode(locCode);
    }

    /**
     * Getter for <code>public.tb_location.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Getter for <code>public.tb_location.location</code>.
     */
    public String getLocation() {
        return (String) get(2);
    }

    /**
     * Getter for <code>public.tb_location.room</code>.
     */
    public String getRoom() {
        return (String) get(1);
    }

    /**
     * Getter for <code>public.tb_location.loc_short</code>.
     */
    public String getLocShort() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.tb_location.location</code>.
     */
    public void setLocation(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.tb_location.loc_code</code>.
     */
    public String getLocCode() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, String, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Integer, String, String, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return TbLocation.TB_LOCATION.ID;
    }

    @Override
    public Field<String> field2() {
        return TbLocation.TB_LOCATION.ROOM;
    }

    @Override
    public Field<String> field3() {
        return TbLocation.TB_LOCATION.LOCATION;
    }

    @Override
    public Field<String> field4() {
        return TbLocation.TB_LOCATION.LOC_SHORT;
    }

    @Override
    public Field<String> field5() {
        return TbLocation.TB_LOCATION.LOC_CODE;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getRoom();
    }

    @Override
    public String component3() {
        return getLocation();
    }

    @Override
    public String component4() {
        return getLocShort();
    }

    @Override
    public String component5() {
        return getLocCode();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getRoom();
    }

    @Override
    public String value3() {
        return getLocation();
    }

    @Override
    public String value4() {
        return getLocShort();
    }

    @Override
    public String value5() {
        return getLocCode();
    }

    @Override
    public TbLocationRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public TbLocationRecord value2(String value) {
        setRoom(value);
        return this;
    }

    @Override
    public TbLocationRecord value3(String value) {
        setLocation(value);
        return this;
    }

    @Override
    public TbLocationRecord value4(String value) {
        setLocShort(value);
        return this;
    }

    @Override
    public TbLocationRecord value5(String value) {
        setLocCode(value);
        return this;
    }

    @Override
    public TbLocationRecord values(Integer value1, String value2, String value3, String value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Setter for <code>public.tb_location.loc_short</code>.
     */
    public void setLocShort(String value) {
        set(3, value);
    }

    /**
     * Setter for <code>public.tb_location.loc_code</code>.
     */
    public void setLocCode(String value) {
        set(4, value);
    }
}
