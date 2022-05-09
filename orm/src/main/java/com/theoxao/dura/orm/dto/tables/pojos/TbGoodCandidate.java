/*
 * This file is generated by jOOQ.
 */
package com.theoxao.dura.orm.dto.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbGoodCandidate implements Serializable {

    private static final long serialVersionUID = 1L;

    private String  id;
    private String  name;
    private String  from;
    private Integer cate;
    private Integer subCate;
    private Integer count;
    private String  py;
    private String  pyShort;

    public TbGoodCandidate() {}

    public TbGoodCandidate(TbGoodCandidate value) {
        this.id = value.id;
        this.name = value.name;
        this.from = value.from;
        this.cate = value.cate;
        this.subCate = value.subCate;
        this.count = value.count;
        this.py = value.py;
        this.pyShort = value.pyShort;
    }

    public TbGoodCandidate(
        String  id,
        String  name,
        String  from,
        Integer cate,
        Integer subCate,
        Integer count,
        String  py,
        String  pyShort
    ) {
        this.id = id;
        this.name = name;
        this.from = from;
        this.cate = cate;
        this.subCate = subCate;
        this.count = count;
        this.py = py;
        this.pyShort = pyShort;
    }

    /**
     * Getter for <code>public.tb_good_candidate.id</code>.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.tb_good_candidate.id</code>.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter for <code>public.tb_good_candidate.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>public.tb_good_candidate.name</code>.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for <code>public.tb_good_candidate.from</code>.
     */
    public String getFrom() {
        return this.from;
    }

    /**
     * Setter for <code>public.tb_good_candidate.from</code>.
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * Getter for <code>public.tb_good_candidate.cate</code>.
     */
    public Integer getCate() {
        return this.cate;
    }

    /**
     * Setter for <code>public.tb_good_candidate.cate</code>.
     */
    public void setCate(Integer cate) {
        this.cate = cate;
    }

    /**
     * Getter for <code>public.tb_good_candidate.sub_cate</code>.
     */
    public Integer getSubCate() {
        return this.subCate;
    }

    /**
     * Setter for <code>public.tb_good_candidate.sub_cate</code>.
     */
    public void setSubCate(Integer subCate) {
        this.subCate = subCate;
    }

    /**
     * Getter for <code>public.tb_good_candidate.count</code>.
     */
    public Integer getCount() {
        return this.count;
    }

    /**
     * Setter for <code>public.tb_good_candidate.count</code>.
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * Getter for <code>public.tb_good_candidate.py</code>.
     */
    public String getPy() {
        return this.py;
    }

    /**
     * Setter for <code>public.tb_good_candidate.py</code>.
     */
    public void setPy(String py) {
        this.py = py;
    }

    /**
     * Getter for <code>public.tb_good_candidate.py_short</code>.
     */
    public String getPyShort() {
        return this.pyShort;
    }

    /**
     * Setter for <code>public.tb_good_candidate.py_short</code>.
     */
    public void setPyShort(String pyShort) {
        this.pyShort = pyShort;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TbGoodCandidate (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(from);
        sb.append(", ").append(cate);
        sb.append(", ").append(subCate);
        sb.append(", ").append(count);
        sb.append(", ").append(py);
        sb.append(", ").append(pyShort);

        sb.append(")");
        return sb.toString();
    }
}