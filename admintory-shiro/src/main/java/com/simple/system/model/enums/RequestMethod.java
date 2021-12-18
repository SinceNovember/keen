package com.simple.system.model.enums;

import lombok.AllArgsConstructor;

/**
 * Api请求方式
 */
@AllArgsConstructor
public enum RequestMethod implements ValueEnum<String>{
    GET("GET"),
    POST( "POST"),
    PUT( "PUT"),
    DELETE("DELETE");

    private final String value;


    @Override
    public String getValue() {
        return value;
    }


}
