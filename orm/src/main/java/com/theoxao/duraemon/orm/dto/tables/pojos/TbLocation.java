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
public class TbLocation implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer       id;
    private String        room;
    private String        location;
    private String        locShort;
    private String        locCode;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public TbLocation() {}

    public TbLocation(TbLocation value) {
        this.id = value.id;
        this.room = value.room;
        this.location = value.location;
        this.locShort = value.locShort;
        this.locCode = value.locCode;
        this.createTime = value.createTime;
        this.updateTime = value.updateTime;
    }

    public TbLocation(
        Integer       id,
        String        room,
        String        location,
        String        locShort,
        String        locCode,
        LocalDateTime createTime,
        LocalDateTime updateTime
    ) {
        this.id = id;
        this.room = room;
        this.location = location;
        this.locShort = locShort;
        this.locCode = locCode;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     * Getter for <code>public.tb_location.id</code>.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.tb_location.id</code>.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for <code>public.tb_location.room</code>.
     */
    public String getRoom() {
        return this.room;
    }

    /**
     * Setter for <code>public.tb_location.room</code>.
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * Getter for <code>public.tb_location.location</code>.
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * Setter for <code>public.tb_location.location</code>.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Getter for <code>public.tb_location.loc_short</code>.
     */
    public String getLocShort() {
        return this.locShort;
    }

    /**
     * Setter for <code>public.tb_location.loc_short</code>.
     */
    public void setLocShort(String locShort) {
        this.locShort = locShort;
    }

    /**
     * Getter for <code>public.tb_location.loc_code</code>.
     */
    public String getLocCode() {
        return this.locCode;
    }

    /**
     * Setter for <code>public.tb_location.loc_code</code>.
     */
    public void setLocCode(String locCode) {
        this.locCode = locCode;
    }

    /**
     * Getter for <code>public.tb_location.create_time</code>.
     */
    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    /**
     * Setter for <code>public.tb_location.create_time</code>.
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * Getter for <code>public.tb_location.update_time</code>.
     */
    public LocalDateTime getUpdateTime() {
        return this.updateTime;
    }

    /**
     * Setter for <code>public.tb_location.update_time</code>.
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TbLocation (");

        sb.append(id);
        sb.append(", ").append(room);
        sb.append(", ").append(location);
        sb.append(", ").append(locShort);
        sb.append(", ").append(locCode);
        sb.append(", ").append(createTime);
        sb.append(", ").append(updateTime);

        sb.append(")");
        return sb.toString();
    }
}
