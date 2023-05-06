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
public enum StatusType implements ValueEnum<Integer> {

    LOCK(0,"禁用"),
    VALID(1,"启用");

    private final Integer value;
    private final String msg;

    @Override
    public Integer getValue() {
        return value;
    }
}
