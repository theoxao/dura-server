/*
 * This file is generated by jOOQ.
 */
package com.theoxao.duraemon.orm.dto.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbIngredient implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer       id;
    private String        name;
    private LocalDateTime insertTime;

    public TbIngredient() {}

    public TbIngredient(TbIngredient value) {
        this.id = value.id;
        this.name = value.name;
        this.insertTime = value.insertTime;
    }

    public TbIngredient(
        Integer       id,
        String        name,
        LocalDateTime insertTime
    ) {
        this.id = id;
        this.name = name;
        this.insertTime = insertTime;
    }

    /**
     * Getter for <code>public.tb_ingredient.id</code>.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.tb_ingredient.id</code>.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for <code>public.tb_ingredient.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>public.tb_ingredient.name</code>.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for <code>public.tb_ingredient.insert_time</code>.
     */
    public LocalDateTime getInsertTime() {
        return this.insertTime;
    }

    /**
     * Setter for <code>public.tb_ingredient.insert_time</code>.
     */
    public void setInsertTime(LocalDateTime insertTime) {
        this.insertTime = insertTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TbIngredient (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(insertTime);

        sb.append(")");
        return sb.toString();
    }
}
