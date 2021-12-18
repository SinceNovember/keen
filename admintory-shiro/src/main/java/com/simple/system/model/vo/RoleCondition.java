package com.simple.system.model.vo;

import com.simple.system.model.enums.RoleStatus;
import com.simple.system.model.enums.SexType;
import com.simple.system.model.enums.UserStatus;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RoleCondition {

    private String roleName;

    private String roleTag;

    private RoleStatus status;

}
