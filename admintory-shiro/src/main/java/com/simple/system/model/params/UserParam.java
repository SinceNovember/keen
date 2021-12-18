package com.simple.system.model.params;

import com.simple.common.model.dto.base.InputConverter;
import com.simple.system.model.entity.User;
import com.simple.system.model.enums.SexType;
import com.simple.system.model.enums.UserStatus;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class UserParam  implements InputConverter<User> {

    private Integer userId;

    private String username;

    private String password;

    private String nickname;

    private String mobile;

    private String email;

    private SexType ssex;

    private UserStatus status;

    private Integer deptId;

    private List<Integer> roleId;

    private String description;

    private String avatar;

}
