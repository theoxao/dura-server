/*
 * This file is generated by jOOQ.
 */
package com.theoxao.duraemon.orm.dto.tables;


import com.theoxao.duraemon.orm.dto.Public;
import com.theoxao.duraemon.orm.dto.tables.records.TbIngredientRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Row5;
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
public class TbIngredient extends TableImpl<TbIngredientRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.tb_ingredient</code>
     */
    public static final TbIngredient TB_INGREDIENT = new TbIngredient();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TbIngredientRecord> getRecordType() {
        return TbIngredientRecord.class;
    }

    /**
     * The column <code>public.tb_ingredient.id</code>.
     */
    public final TableField<TbIngredientRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.tb_ingredient.name</code>.
     */
    public final TableField<TbIngredientRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(1024), this, "");

    /**
     * The column <code>public.tb_ingredient.insert_time</code>.
     */
    public final TableField<TbIngredientRecord, LocalDateTime> INSERT_TIME = createField(DSL.name("insert_time"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.tb_ingredient.py</code>.
     */
    public final TableField<TbIngredientRecord, String> PY = createField(DSL.name("py"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.tb_ingredient.py_short</code>.
     */
    public final TableField<TbIngredientRecord, String> PY_SHORT = createField(DSL.name("py_short"), SQLDataType.VARCHAR(31), this, "");

    private TbIngredient(Name alias, Table<TbIngredientRecord> aliased) {
        this(alias, aliased, null);
    }

    private TbIngredient(Name alias, Table<TbIngredientRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.tb_ingredient</code> table reference
     */
    public TbIngredient(String alias) {
        this(DSL.name(alias), TB_INGREDIENT);
    }

    /**
     * Create an aliased <code>public.tb_ingredient</code> table reference
     */
    public TbIngredient(Name alias) {
        this(alias, TB_INGREDIENT);
    }

    /**
     * Create a <code>public.tb_ingredient</code> table reference
     */
    public TbIngredient() {
        this(DSL.name("tb_ingredient"), null);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<TbIngredientRecord, Integer> getIdentity() {
        return (Identity<TbIngredientRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<TbIngredientRecord> getPrimaryKey() {
        return Internal.createUniqueKey(TbIngredient.TB_INGREDIENT, DSL.name("tb_ingredient_pkey"), new TableField[] { TbIngredient.TB_INGREDIENT.ID }, true);
    }

    @Override
    public List<UniqueKey<TbIngredientRecord>> getKeys() {
        return Arrays.<UniqueKey<TbIngredientRecord>>asList(
              Internal.createUniqueKey(TbIngredient.TB_INGREDIENT, DSL.name("tb_ingredient_pkey"), new TableField[] { TbIngredient.TB_INGREDIENT.ID }, true)
        );
    }

    @Override
    public TbIngredient as(String alias) {
        return new TbIngredient(DSL.name(alias), this);
    }

    @Override
    public TbIngredient as(Name alias) {
        return new TbIngredient(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TbIngredient rename(String name) {
        return new TbIngredient(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TbIngredient rename(Name name) {
        return new TbIngredient(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, LocalDateTime, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
