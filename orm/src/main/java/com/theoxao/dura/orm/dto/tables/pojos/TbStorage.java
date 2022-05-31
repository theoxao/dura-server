/*
 * This file is generated by jOOQ.
 */
package com.theoxao.dura.orm.dto.tables.pojos;


import java.io.Serializable;

import org.jooq.JSON;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbStorage implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String  name;
    private JSON    cates;

    public TbStorage() {}

    public TbStorage(TbStorage value) {
        this.id = value.id;
        this.name = value.name;
        this.cates = value.cates;
    }

    public TbStorage(
        Integer id,
        String  name,
        JSON    cates
    ) {
        this.id = id;
        this.name = name;
        this.cates = cates;
    }

    /**
     * Getter for <code>public.tb_storage.id</code>.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.tb_storage.id</code>.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for <code>public.tb_storage.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>public.tb_storage.name</code>.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for <code>public.tb_storage.cates</code>.
     */
    public JSON getCates() {
        return this.cates;
    }

    /**
     * Setter for <code>public.tb_storage.cates</code>.
     */
    public void setCates(JSON cates) {
        this.cates = cates;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TbStorage (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(cates);

        sb.append(")");
        return sb.toString();
    }
}