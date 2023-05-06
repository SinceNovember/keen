package com.simple.keen.system.model.enums;

import com.simple.keen.common.base.enums.ValueEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 按钮类别
 *
 * @author SinceNovember
 * @date 2022/11/20
 */
@Getter
@AllArgsConstructor
public enum MenuType implements ValueEnum<Integer> {
    DIRECTORY(1, "目录"),
    MENU(2, "菜单"),
    BUTTON(3, "按钮");

    private final Integer code;
    private final String msg;

    @Override
    public Integer getValue() {
        return code;
    }

}
