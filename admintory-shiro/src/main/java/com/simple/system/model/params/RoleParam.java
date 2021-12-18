package com.simple.system.model.params;

import com.simple.common.model.dto.base.InputConverter;
import com.simple.system.model.entity.Role;
import com.simple.system.model.enums.RoleStatus;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class RoleParam implements InputConverter<Role> {

    private Integer roleId;

    private String roleName;

    private String roleTag;

    private int orderNum;

    private RoleStatus status;

    private String description;

    private List<Integer> userIdList;

}
