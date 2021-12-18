package com.simple.system.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.simple.common.model.dto.base.OutputConverter;
import com.simple.system.model.entity.Dept;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 部门实体
 */
@Data
public class DeptDTO implements OutputConverter<DeptDTO, Dept> {

    private int deptId;

    private int parentId;

    private String deptName;

    private int orderNum;

    private int createUserId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private String deptShortName;

    private String description;

    private List<UserDTO> memberList;

    private UserDTO createUser;

    private List<DeptDTO> children;


}
