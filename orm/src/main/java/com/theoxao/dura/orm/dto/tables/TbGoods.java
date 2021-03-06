/*
 * This file is generated by jOOQ.
 */
package com.theoxao.dura.orm.dto.tables;


import com.theoxao.dura.orm.dto.Public;
import com.theoxao.dura.orm.dto.tables.records.TbGoodsRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.JSON;
import org.jooq.Name;
import org.jooq.Row13;
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
public class TbGoods extends TableImpl<TbGoodsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.tb_goods</code>
     */
    public static final TbGoods TB_GOODS = new TbGoods();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TbGoodsRecord> getRecordType() {
        return TbGoodsRecord.class;
    }

    /**
     * The column <code>public.tb_goods.id</code>.
     */
    public final TableField<TbGoodsRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.tb_goods.name</code>.
     */
    public final TableField<TbGoodsRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.tb_goods.desc</code>. 描述
     */
    public final TableField<TbGoodsRecord, String> DESC = createField(DSL.name("desc"), SQLDataType.CLOB, this, "描述");

    /**
     * The column <code>public.tb_goods.cate</code>. 分类ID
     */
    public final TableField<TbGoodsRecord, Integer> CATE = createField(DSL.name("cate"), SQLDataType.INTEGER, this, "分类ID");

    /**
     * The column <code>public.tb_goods.sub_cate</code>. 子分类ID
     */
    public final TableField<TbGoodsRecord, Integer> SUB_CATE = createField(DSL.name("sub_cate"), SQLDataType.INTEGER, this, "子分类ID");

    /**
     * The column <code>public.tb_goods.remain_batch</code>. 剩余批次
     */
    public final TableField<TbGoodsRecord, Integer> REMAIN_BATCH = createField(DSL.name("remain_batch"), SQLDataType.INTEGER.defaultValue(DSL.field("0", SQLDataType.INTEGER)), this, "剩余批次");

    /**
     * The column <code>public.tb_goods.recent_price</code>. 最近购买价格
     */
    public final TableField<TbGoodsRecord, Integer> RECENT_PRICE = createField(DSL.name("recent_price"), SQLDataType.INTEGER.defaultValue(DSL.field("0", SQLDataType.INTEGER)), this, "最近购买价格");

    /**
     * The column <code>public.tb_goods.images</code>.
     */
    public final TableField<TbGoodsRecord, JSON> IMAGES = createField(DSL.name("images"), SQLDataType.JSON.defaultValue(DSL.field("'[]'::json", SQLDataType.JSON)), this, "");

    /**
     * The column <code>public.tb_goods.need_buy</code>. 是否需要购买-购买优先级
     */
    public final TableField<TbGoodsRecord, Integer> NEED_BUY = createField(DSL.name("need_buy"), SQLDataType.INTEGER.defaultValue(DSL.field("0", SQLDataType.INTEGER)), this, "是否需要购买-购买优先级");

    /**
     * The column <code>public.tb_goods.create_time</code>.
     */
    public final TableField<TbGoodsRecord, LocalDateTime> CREATE_TIME = createField(DSL.name("create_time"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.tb_goods.update_time</code>.
     */
    public final TableField<TbGoodsRecord, LocalDateTime> UPDATE_TIME = createField(DSL.name("update_time"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.tb_goods.py</code>.
     */
    public final TableField<TbGoodsRecord, String> PY = createField(DSL.name("py"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.tb_goods.py_short</code>.
     */
    public final TableField<TbGoodsRecord, String> PY_SHORT = createField(DSL.name("py_short"), SQLDataType.VARCHAR(31), this, "");

    private TbGoods(Name alias, Table<TbGoodsRecord> aliased) {
        this(alias, aliased, null);
    }

    private TbGoods(Name alias, Table<TbGoodsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.tb_goods</code> table reference
     */
    public TbGoods(String alias) {
        this(DSL.name(alias), TB_GOODS);
    }

    /**
     * Create an aliased <code>public.tb_goods</code> table reference
     */
    public TbGoods(Name alias) {
        this(alias, TB_GOODS);
    }

    /**
     * Create a <code>public.tb_goods</code> table reference
     */
    public TbGoods() {
        this(DSL.name("tb_goods"), null);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<TbGoodsRecord, Integer> getIdentity() {
        return (Identity<TbGoodsRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<TbGoodsRecord> getPrimaryKey() {
        return Internal.createUniqueKey(TbGoods.TB_GOODS, DSL.name("tb_goods_pkey"), new TableField[] { TbGoods.TB_GOODS.ID }, true);
    }

    @Override
    public List<UniqueKey<TbGoodsRecord>> getKeys() {
        return Arrays.<UniqueKey<TbGoodsRecord>>asList(
              Internal.createUniqueKey(TbGoods.TB_GOODS, DSL.name("tb_goods_pkey"), new TableField[] { TbGoods.TB_GOODS.ID }, true)
        );
    }

    @Override
    public TbGoods as(String alias) {
        return new TbGoods(DSL.name(alias), this);
    }

    @Override
    public TbGoods as(Name alias) {
        return new TbGoods(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TbGoods rename(String name) {
        return new TbGoods(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TbGoods rename(Name name) {
        return new TbGoods(name, null);
    }

    // -------------------------------------------------------------------------
    // Row13 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row13<Integer, String, String, Integer, Integer, Integer, Integer, JSON, Integer, LocalDateTime, LocalDateTime, String, String> fieldsRow() {
        return (Row13) super.fieldsRow();
    }
}
