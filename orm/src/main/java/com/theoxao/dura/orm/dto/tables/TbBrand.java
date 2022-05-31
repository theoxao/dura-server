/*
 * This file is generated by jOOQ.
 */
package com.theoxao.dura.orm.dto.tables;


import com.theoxao.dura.orm.dto.Public;
import com.theoxao.dura.orm.dto.tables.records.TbBrandRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.JSON;
import org.jooq.Name;
import org.jooq.Row4;
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
public class TbBrand extends TableImpl<TbBrandRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.tb_brand</code>
     */
    public static final TbBrand TB_BRAND = new TbBrand();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TbBrandRecord> getRecordType() {
        return TbBrandRecord.class;
    }

    /**
     * The column <code>public.tb_brand.id</code>.
     */
    public final TableField<TbBrandRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.tb_brand.name</code>.
     */
    public final TableField<TbBrandRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.tb_brand.cate</code>.
     */
    public final TableField<TbBrandRecord, JSON> CATE = createField(DSL.name("cate"), SQLDataType.JSON, this, "");

    /**
     * The column <code>public.tb_brand.item_count</code>.
     */
    public final TableField<TbBrandRecord, Integer> ITEM_COUNT = createField(DSL.name("item_count"), SQLDataType.INTEGER, this, "");

    private TbBrand(Name alias, Table<TbBrandRecord> aliased) {
        this(alias, aliased, null);
    }

    private TbBrand(Name alias, Table<TbBrandRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.tb_brand</code> table reference
     */
    public TbBrand(String alias) {
        this(DSL.name(alias), TB_BRAND);
    }

    /**
     * Create an aliased <code>public.tb_brand</code> table reference
     */
    public TbBrand(Name alias) {
        this(alias, TB_BRAND);
    }

    /**
     * Create a <code>public.tb_brand</code> table reference
     */
    public TbBrand() {
        this(DSL.name("tb_brand"), null);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<TbBrandRecord, Integer> getIdentity() {
        return (Identity<TbBrandRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<TbBrandRecord> getPrimaryKey() {
        return Internal.createUniqueKey(TbBrand.TB_BRAND, DSL.name("tb_brand_pkey"), new TableField[] { TbBrand.TB_BRAND.ID }, true);
    }

    @Override
    public List<UniqueKey<TbBrandRecord>> getKeys() {
        return Arrays.<UniqueKey<TbBrandRecord>>asList(
              Internal.createUniqueKey(TbBrand.TB_BRAND, DSL.name("tb_brand_pkey"), new TableField[] { TbBrand.TB_BRAND.ID }, true)
        );
    }

    @Override
    public TbBrand as(String alias) {
        return new TbBrand(DSL.name(alias), this);
    }

    @Override
    public TbBrand as(Name alias) {
        return new TbBrand(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TbBrand rename(String name) {
        return new TbBrand(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TbBrand rename(Name name) {
        return new TbBrand(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, JSON, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}