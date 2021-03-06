/*
 * This file is generated by jOOQ.
 */
package com.theoxao.dura.orm.dto.tables;


import com.theoxao.dura.orm.dto.Public;
import com.theoxao.dura.orm.dto.tables.records.TbIngRecipeRelRecord;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Row7;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbIngRecipeRel extends TableImpl<TbIngRecipeRelRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.tb_ing_recipe_rel</code>
     */
    public static final TbIngRecipeRel TB_ING_RECIPE_REL = new TbIngRecipeRel();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TbIngRecipeRelRecord> getRecordType() {
        return TbIngRecipeRelRecord.class;
    }

    /**
     * The column <code>public.tb_ing_recipe_rel.id</code>.
     */
    public final TableField<TbIngRecipeRelRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.tb_ing_recipe_rel.rid</code>.
     */
    public final TableField<TbIngRecipeRelRecord, Integer> RID = createField(DSL.name("rid"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.tb_ing_recipe_rel.amount</code>.
     */
    public final TableField<TbIngRecipeRelRecord, String> AMOUNT = createField(DSL.name("amount"), SQLDataType.VARCHAR(1024), this, "");

    /**
     * The column <code>public.tb_ing_recipe_rel.cat</code>.
     */
    public final TableField<TbIngRecipeRelRecord, String> CAT = createField(DSL.name("cat"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.tb_ing_recipe_rel.name</code>.
     */
    public final TableField<TbIngRecipeRelRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(1024), this, "");

    /**
     * The column <code>public.tb_ing_recipe_rel.iid</code>.
     */
    public final TableField<TbIngRecipeRelRecord, Integer> IID = createField(DSL.name("iid"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.tb_ing_recipe_rel.piid</code>.
     */
    public final TableField<TbIngRecipeRelRecord, Integer> PIID = createField(DSL.name("piid"), SQLDataType.INTEGER, this, "");

    private TbIngRecipeRel(Name alias, Table<TbIngRecipeRelRecord> aliased) {
        this(alias, aliased, null);
    }

    private TbIngRecipeRel(Name alias, Table<TbIngRecipeRelRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.tb_ing_recipe_rel</code> table reference
     */
    public TbIngRecipeRel(String alias) {
        this(DSL.name(alias), TB_ING_RECIPE_REL);
    }

    /**
     * Create an aliased <code>public.tb_ing_recipe_rel</code> table reference
     */
    public TbIngRecipeRel(Name alias) {
        this(alias, TB_ING_RECIPE_REL);
    }

    /**
     * Create a <code>public.tb_ing_recipe_rel</code> table reference
     */
    public TbIngRecipeRel() {
        this(DSL.name("tb_ing_recipe_rel"), null);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<TbIngRecipeRelRecord, Integer> getIdentity() {
        return (Identity<TbIngRecipeRelRecord, Integer>) super.getIdentity();
    }

    @Override
    public TbIngRecipeRel as(String alias) {
        return new TbIngRecipeRel(DSL.name(alias), this);
    }

    @Override
    public TbIngRecipeRel as(Name alias) {
        return new TbIngRecipeRel(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TbIngRecipeRel rename(String name) {
        return new TbIngRecipeRel(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TbIngRecipeRel rename(Name name) {
        return new TbIngRecipeRel(name, null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, Integer, String, String, String, Integer, Integer> fieldsRow() {
        return (Row7) super.fieldsRow();
    }
}
