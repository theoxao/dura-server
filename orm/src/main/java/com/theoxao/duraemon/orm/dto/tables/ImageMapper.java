/*
 * This file is generated by jOOQ.
 */
package com.theoxao.duraemon.orm.dto.tables;


import com.theoxao.duraemon.orm.dto.Public;
import com.theoxao.duraemon.orm.dto.tables.records.ImageMapperRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.Name;
import org.jooq.Row6;
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
public class ImageMapper extends TableImpl<ImageMapperRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.image_mapper</code>
     */
    public static final ImageMapper IMAGE_MAPPER = new ImageMapper();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ImageMapperRecord> getRecordType() {
        return ImageMapperRecord.class;
    }

    /**
     * The column <code>public.image_mapper.uuid</code>.
     */
    public final TableField<ImageMapperRecord, String> UUID = createField(DSL.name("uuid"), SQLDataType.VARCHAR(128).nullable(false), this, "");

    /**
     * The column <code>public.image_mapper.oid</code>.
     */
    public final TableField<ImageMapperRecord, Integer> OID = createField(DSL.name("oid"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.image_mapper.image_url</code>.
     */
    public final TableField<ImageMapperRecord, String> IMAGE_URL = createField(DSL.name("image_url"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.image_mapper.insert_time</code>.
     */
    public final TableField<ImageMapperRecord, LocalDateTime> INSERT_TIME = createField(DSL.name("insert_time"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.image_mapper.type</code>.
     */
    public final TableField<ImageMapperRecord, Integer> TYPE = createField(DSL.name("type"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.image_mapper.download</code>.
     */
    public final TableField<ImageMapperRecord, Boolean> DOWNLOAD = createField(DSL.name("download"), SQLDataType.BOOLEAN.defaultValue(DSL.field("false", SQLDataType.BOOLEAN)), this, "");

    private ImageMapper(Name alias, Table<ImageMapperRecord> aliased) {
        this(alias, aliased, null);
    }

    private ImageMapper(Name alias, Table<ImageMapperRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.image_mapper</code> table reference
     */
    public ImageMapper(String alias) {
        this(DSL.name(alias), IMAGE_MAPPER);
    }

    /**
     * Create an aliased <code>public.image_mapper</code> table reference
     */
    public ImageMapper(Name alias) {
        this(alias, IMAGE_MAPPER);
    }

    /**
     * Create a <code>public.image_mapper</code> table reference
     */
    public ImageMapper() {
        this(DSL.name("image_mapper"), null);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<ImageMapperRecord> getPrimaryKey() {
        return Internal.createUniqueKey(ImageMapper.IMAGE_MAPPER, DSL.name("image_mapper_pkey"), new TableField[] { ImageMapper.IMAGE_MAPPER.UUID }, true);
    }

    @Override
    public List<UniqueKey<ImageMapperRecord>> getKeys() {
        return Arrays.<UniqueKey<ImageMapperRecord>>asList(
              Internal.createUniqueKey(ImageMapper.IMAGE_MAPPER, DSL.name("image_mapper_pkey"), new TableField[] { ImageMapper.IMAGE_MAPPER.UUID }, true)
        );
    }

    @Override
    public ImageMapper as(String alias) {
        return new ImageMapper(DSL.name(alias), this);
    }

    @Override
    public ImageMapper as(Name alias) {
        return new ImageMapper(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ImageMapper rename(String name) {
        return new ImageMapper(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ImageMapper rename(Name name) {
        return new ImageMapper(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<String, Integer, String, LocalDateTime, Integer, Boolean> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}
