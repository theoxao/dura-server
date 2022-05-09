/*
 * This file is generated by jOOQ.
 */
package com.theoxao.dura.orm.dto.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String  name;
    private Integer level;
    private Integer pid;

    public TbCategory() {}

    public TbCategory(TbCategory value) {
        this.id = value.id;
        this.name = value.name;
        this.level = value.level;
        this.pid = value.pid;
    }

    public TbCategory(
        Integer id,
        String  name,
        Integer level,
        Integer pid
    ) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.pid = pid;
    }

    /**
     * Getter for <code>public.tb_category.id</code>.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.tb_category.id</code>.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for <code>public.tb_category.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>public.tb_category.name</code>.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for <code>public.tb_category.level</code>.
     */
    public Integer getLevel() {
        return this.level;
    }

    /**
     * Setter for <code>public.tb_category.level</code>.
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * Getter for <code>public.tb_category.pid</code>.
     */
    public Integer getPid() {
        return this.pid;
    }

    /**
     * Setter for <code>public.tb_category.pid</code>.
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TbCategory (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(level);
        sb.append(", ").append(pid);

        sb.append(")");
        return sb.toString();
    }
}