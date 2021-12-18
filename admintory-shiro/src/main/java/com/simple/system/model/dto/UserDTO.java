package com.simple.system.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.simple.common.model.dto.base.OutputConverter;
import com.simple.system.model.entity.User;
import com.simple.system.model.enums.SexType;
import com.simple.system.model.enums.UserStatus;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDTO implements OutputConverter<UserDTO, User> {

    private Integer userId;

    private String username;

    private String nickname;

    private Integer deptId;

    private String deptName;

    private String email;

    private String mobile;

    private UserStatus status;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastLoginTime;

    private SexType ssex;

    private Integer isTab;

    private String theme;

    private String avatar;

    private String description;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private List<Integer> roleId;

    private List<String> roleNameList;

    private boolean online;


}
