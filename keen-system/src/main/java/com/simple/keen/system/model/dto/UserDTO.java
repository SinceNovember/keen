package com.simple.keen.system.model.dto;

import com.simple.keen.common.base.dto.BaseDTO;
import com.simple.keen.system.model.enums.StatusType;
import com.simple.keen.system.model.enums.UserSex;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 * 用户dto
 *
 * @author SinceNovember
 * @date 2022/12/16
 */
@Data
@ToString
public class UserDTO extends BaseDTO {

    private Integer id;

    private String username;

    private String password;

    private UserSex sex;

    private String email;

    private String mobile;

    private String nickname;

    private String avatar;

    private String description;

    private Integer deptId;

    private String deptName;

    private String profileImage;

    private List<Integer> roleIds;

    private List<String> roleNames;

    private StatusType status;

    private boolean online;

    private LocalDateTime lastLoginTime;

}
