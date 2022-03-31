/*
 * This file is generated by jOOQ.
 */
package com.theoxao.duraemon.orm.dto.tables;


import com.theoxao.duraemon.orm.dto.Public;
import com.theoxao.duraemon.orm.dto.tables.records.TbLocationRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.Name;
import org.jooq.Row7;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbLocation extends TableImpl<TbLocationRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.tb_location</code>
     */
    public static final TbLocation TB_LOCATION = new TbLocation();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TbLocationRecord> getRecordType() {
        return TbLocationRecord.class;
    }

    /**
     * The column <code>public.tb_location.id</code>.
     */
    public final TableField<TbLocationRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.tb_location.room</code>.
     */
    public final TableField<TbLocationRecord, String> ROOM = createField(DSL.name("room"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.tb_location.location</code>.
     */
    public final TableField<TbLocationRecord, String> LOCATION = createField(DSL.name("location"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.tb_location.loc_short</code>.
     */
    public final TableField<TbLocationRecord, String> LOC_SHORT = createField(DSL.name("loc_short"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.tb_location.loc_code</code>.
     */
    public final TableField<TbLocationRecord, String> LOC_CODE = createField(DSL.name("loc_code"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.tb_location.create_time</code>.
     */
    public final TableField<TbLocationRecord, LocalDateTime> CREATE_TIME = createField(DSL.name("create_time"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.tb_location.update_time</code>.
     */
    public final TableField<TbLocationRecord, LocalDateTime> UPDATE_TIME = createField(DSL.name("update_time"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "");

    private TbLocation(Name alias, Table<TbLocationRecord> aliased) {
        this(alias, aliased, null);
    }

    private TbLocation(Name alias, Table<TbLocationRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.tb_location</code> table reference
     */
    public TbLocation(String alias) {
        this(DSL.name(alias), TB_LOCATION);
    }

    /**
     * Create an aliased <code>public.tb_location</code> table reference
     */
    public TbLocation(Name alias) {
        this(alias, TB_LOCATION);
    }

    /**
     * Create a <code>public.tb_location</code> table reference
     */
    public TbLocation() {
        this(DSL.name("tb_location"), null);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<TbLocationRecord> getPrimaryKey() {
        return Internal.createUniqueKey(TbLocation.TB_LOCATION, DSL.name("tb_location_pkey"), new TableField[] { TbLocation.TB_LOCATION.ID }, true);
    }

    @Override
    public List<UniqueKey<TbLocationRecord>> getKeys() {
        return Arrays.<UniqueKey<TbLocationRecord>>asList(
              Internal.createUniqueKey(TbLocation.TB_LOCATION, DSL.name("tb_location_pkey"), new TableField[] { TbLocation.TB_LOCATION.ID }, true)
        );
    }

    @Override
    public TbLocation as(String alias) {
        return new TbLocation(DSL.name(alias), this);
    }

    @Override
    public TbLocation as(Name alias) {
        return new TbLocation(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TbLocation rename(String name) {
        return new TbLocation(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TbLocation rename(Name name) {
        return new TbLocation(name, null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, String, String, String, String, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row7) super.fieldsRow();
    }
}