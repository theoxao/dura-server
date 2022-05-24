/*
 * This file is generated by jOOQ.
 */
package com.theoxao.dura.orm.dto.tables;


import com.theoxao.dura.orm.dto.Public;
import com.theoxao.dura.orm.dto.tables.records.TbItemRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.JSON;
import org.jooq.Name;
import org.jooq.Row17;
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
public class TbItem extends TableImpl<TbItemRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.tb_item</code>
     */
    public static final TbItem TB_ITEM = new TbItem();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TbItemRecord> getRecordType() {
        return TbItemRecord.class;
    }

    /**
     * The column <code>public.tb_item.id</code>.
     */
    public final TableField<TbItemRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.tb_item.good_id</code>.
     */
    public final TableField<TbItemRecord, Integer> GOOD_ID = createField(DSL.name("good_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.tb_item.name</code>.
     */
    public final TableField<TbItemRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.tb_item.images</code>.
     */
    public final TableField<TbItemRecord, JSON> IMAGES = createField(DSL.name("images"), SQLDataType.JSON, this, "");

    /**
     * The column <code>public.tb_item.desc</code>.
     */
    public final TableField<TbItemRecord, String> DESC = createField(DSL.name("desc"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.tb_item.spec</code>.
     */
    public final TableField<TbItemRecord, String> SPEC = createField(DSL.name("spec"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.tb_item.price</code>.
     */
    public final TableField<TbItemRecord, Integer> PRICE = createField(DSL.name("price"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.tb_item.isbn</code>.
     */
    public final TableField<TbItemRecord, String> ISBN = createField(DSL.name("isbn"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.tb_item.best_favor</code>.
     */
    public final TableField<TbItemRecord, Integer> BEST_FAVOR = createField(DSL.name("best_favor"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.tb_item.shelf_life</code>.
     */
    public final TableField<TbItemRecord, Integer> SHELF_LIFE = createField(DSL.name("shelf_life"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.tb_item.storage</code>.
     */
    public final TableField<TbItemRecord, String> STORAGE = createField(DSL.name("storage"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.tb_item.used_storage</code>.
     */
    public final TableField<TbItemRecord, String> USED_STORAGE = createField(DSL.name("used_storage"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.tb_item.remark</code>.
     */
    public final TableField<TbItemRecord, String> REMARK = createField(DSL.name("remark"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.tb_item.create_time</code>.
     */
    public final TableField<TbItemRecord, LocalDateTime> CREATE_TIME = createField(DSL.name("create_time"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.tb_item.update_time</code>.
     */
    public final TableField<TbItemRecord, LocalDateTime> UPDATE_TIME = createField(DSL.name("update_time"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.tb_item.ingrendient</code>.
     */
    public final TableField<TbItemRecord, String> INGRENDIENT = createField(DSL.name("ingrendient"), SQLDataType.VARCHAR(1024), this, "");

    /**
     * The column <code>public.tb_item.brand</code>.
     */
    public final TableField<TbItemRecord, String> BRAND = createField(DSL.name("brand"), SQLDataType.VARCHAR(256), this, "");

    private TbItem(Name alias, Table<TbItemRecord> aliased) {
        this(alias, aliased, null);
    }

    private TbItem(Name alias, Table<TbItemRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.tb_item</code> table reference
     */
    public TbItem(String alias) {
        this(DSL.name(alias), TB_ITEM);
    }

    /**
     * Create an aliased <code>public.tb_item</code> table reference
     */
    public TbItem(Name alias) {
        this(alias, TB_ITEM);
    }

    /**
     * Create a <code>public.tb_item</code> table reference
     */
    public TbItem() {
        this(DSL.name("tb_item"), null);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<TbItemRecord, Integer> getIdentity() {
        return (Identity<TbItemRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<TbItemRecord> getPrimaryKey() {
        return Internal.createUniqueKey(TbItem.TB_ITEM, DSL.name("tb_item_pkey"), new TableField[] { TbItem.TB_ITEM.ID }, true);
    }

    @Override
    public List<UniqueKey<TbItemRecord>> getKeys() {
        return Arrays.<UniqueKey<TbItemRecord>>asList(
              Internal.createUniqueKey(TbItem.TB_ITEM, DSL.name("tb_item_pkey"), new TableField[] { TbItem.TB_ITEM.ID }, true)
        );
    }

    @Override
    public TbItem as(String alias) {
        return new TbItem(DSL.name(alias), this);
    }

    @Override
    public TbItem as(Name alias) {
        return new TbItem(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TbItem rename(String name) {
        return new TbItem(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TbItem rename(Name name) {
        return new TbItem(name, null);
    }

    // -------------------------------------------------------------------------
    // Row17 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row17<Integer, Integer, String, JSON, String, String, Integer, String, Integer, Integer, String, String, String, LocalDateTime, LocalDateTime, String, String> fieldsRow() {
        return (Row17) super.fieldsRow();
    }
}
