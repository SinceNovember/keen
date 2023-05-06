package com.simple.keen.system.model.enums;

import com.simple.keen.common.base.enums.ValueEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * .
 *
 * @author SinceNovember
 * @date 2022/12/16
 */
@Getter
@AllArgsConstructor
public enum UserSex implements ValueEnum<Integer> {

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
