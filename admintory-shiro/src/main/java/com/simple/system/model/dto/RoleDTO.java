package com.simple.system.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.simple.common.model.dto.base.OutputConverter;
import com.simple.system.model.entity.Role;
import com.simple.system.model.enums.RoleStatus;
import lombok.Data;

import java.util.Date;

/**
 * 角色DTO
 */
@Data
public class RoleDTO implements OutputConverter<RoleDTO, Role> {

    private int roleId;

    private String roleName;

    private String roleTag;

    private int orderNum;

    private RoleStatus status;

    private String description;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
