package com.osmolovskyy.EasyContracts.commons.persistence;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class DatabaseConstants {

    // Database Constants
    public static final String TABLE_DEBT = "debt";
    public static final String TABLE_PAYMENT = "payment";
    public static final String TABLE_PERSON = "person";
    public static final String TABLE_PROVIDER = "provider";

    // DB fields
    public static final String FIELD_ID = "id";
    public static final String FIELD_CREATED = "created";
    public static final String FIELD_MODIFIED = "modified";

    public static final String FIELD_PERSON_ID = "person_id";
    public static final String FIELD_FIRST_NAME = "first_name";
    public static final String FIELD_LAST_NAME = "last_name";
    public static final String TYPE_JSONB = "jsonb";
    public static final String TYPE_JSON = "json";
}