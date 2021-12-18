package com.simple.system.model.vo;

import com.simple.system.model.enums.SexType;
import com.simple.system.model.enums.UserStatus;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserCondition {

    private String nickname;

    private Integer deptId;

    private SexType ssex;

    private UserStatus status;
}
