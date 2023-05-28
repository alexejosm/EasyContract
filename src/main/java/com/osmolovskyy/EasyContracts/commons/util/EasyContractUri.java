package com.osmolovskyy.EasyContracts.commons.util;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class EasyContractUri {

    public static final String INDEX = "/";
    public static final String VERSION = "/version";

    public static final String API_V1 = "/api/v1";
    public static final String API_V1_PERSON = API_V1 + "/person";
    public static final String API_V1_PERSON_WITH_ID = API_V1_PERSON + "/{id}";
}