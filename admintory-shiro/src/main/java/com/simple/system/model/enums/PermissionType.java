package com.simple.system.model.enums;

import lombok.AllArgsConstructor;

/**
 * 授权类别
 */
@AllArgsConstructor
public enum PermissionType implements ValueEnum<Integer>{

    ROLE(1, "角色"),
    DEPT(2, "部门"),
    USER(3, "用户");

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
