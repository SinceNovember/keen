package com.simple.system.model.enums;

import lombok.AllArgsConstructor;

/**
 * 按钮类别
 */
@AllArgsConstructor
public enum MenuType implements ValueEnum<Integer>{
    DIRECTORY(1, "目录"),
    MENU(2, "菜单"),
    BUTTON(3, "按钮");

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
