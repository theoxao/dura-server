/*
 * This file is generated by jOOQ.
 */
package com.theoxao.dura.orm.dto;


import com.theoxao.dura.orm.dto.tables.Ing;
import com.theoxao.dura.orm.dto.tables.TbCategory;
import com.theoxao.dura.orm.dto.tables.TbGoodCandidate;
import com.theoxao.dura.orm.dto.tables.TbGoods;
import com.theoxao.dura.orm.dto.tables.TbIngRecipeRel;
import com.theoxao.dura.orm.dto.tables.TbIngredient;
import com.theoxao.dura.orm.dto.tables.TbItem;
import com.theoxao.dura.orm.dto.tables.TbItemDetail;
import com.theoxao.dura.orm.dto.tables.TbLocation;
import com.theoxao.dura.orm.dto.tables.TbRecipe;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.ing</code>.
     */
    public final Ing ING = Ing.ING;

    /**
     * The table <code>public.tb_category</code>.
     */
    public final TbCategory TB_CATEGORY = TbCategory.TB_CATEGORY;

    /**
     * The table <code>public.tb_good_candidate</code>.
     */
    public final TbGoodCandidate TB_GOOD_CANDIDATE = TbGoodCandidate.TB_GOOD_CANDIDATE;

    /**
     * The table <code>public.tb_goods</code>.
     */
    public final TbGoods TB_GOODS = TbGoods.TB_GOODS;

    /**
     * The table <code>public.tb_ing_recipe_rel</code>.
     */
    public final TbIngRecipeRel TB_ING_RECIPE_REL = TbIngRecipeRel.TB_ING_RECIPE_REL;

    /**
     * The table <code>public.tb_ingredient</code>.
     */
    public final TbIngredient TB_INGREDIENT = TbIngredient.TB_INGREDIENT;

    /**
     * The table <code>public.tb_item</code>.
     */
    public final TbItem TB_ITEM = TbItem.TB_ITEM;

    /**
     * The table <code>public.tb_item_detail</code>.
     */
    public final TbItemDetail TB_ITEM_DETAIL = TbItemDetail.TB_ITEM_DETAIL;

    /**
     * The table <code>public.tb_location</code>.
     */
    public final TbLocation TB_LOCATION = TbLocation.TB_LOCATION;

    /**
     * The table <code>public.tb_recipe</code>.
     */
    public final TbRecipe TB_RECIPE = TbRecipe.TB_RECIPE;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            Ing.ING,
            TbCategory.TB_CATEGORY,
            TbGoodCandidate.TB_GOOD_CANDIDATE,
            TbGoods.TB_GOODS,
            TbIngRecipeRel.TB_ING_RECIPE_REL,
            TbIngredient.TB_INGREDIENT,
            TbItem.TB_ITEM,
            TbItemDetail.TB_ITEM_DETAIL,
            TbLocation.TB_LOCATION,
            TbRecipe.TB_RECIPE);
    }
}