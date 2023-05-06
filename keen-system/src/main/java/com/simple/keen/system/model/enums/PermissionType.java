package com.simple.keen.system.model.enums;

import com.simple.keen.common.base.enums.ValueEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PermissionType implements ValueEnum<Integer> {

    ROLE(1, "角色"),
    DEPT( 2, "部门"),
    USER( 3, "用户");

    private final Integer code;
    private final String msg;

    @Override
    public Integer getValue() {
        return code;
    }

}
