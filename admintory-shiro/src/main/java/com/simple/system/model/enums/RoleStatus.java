package com.simple.system.model.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RoleStatus implements ValueEnum<Integer>{

    LOCK(0,"禁用"),
    VALID(1,"启用");

    private final Integer value;
    private final String msg;


    @Override
    public Integer getValue() {
        return value;
    }

    public String getMsg() {
        return msg;
    }

}
