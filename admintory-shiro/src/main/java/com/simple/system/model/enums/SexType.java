package com.simple.system.model.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SexType implements ValueEnum<Integer>{

    MALE(0, "男"),
    FEMALE(1, "女"),
    UNKNOWN(2, "未知");

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