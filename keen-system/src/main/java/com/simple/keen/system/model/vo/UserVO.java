package com.simple.keen.system.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.simple.keen.system.model.enums.StatusType;
import com.simple.keen.system.model.enums.UserSex;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2022/12/16
 */
@Data
@ToString
public class UserVO {

    private Integer id;

    private String username;

    private UserSex sex;

    private String email;

    private String mobile;

    private String nickname;

    private String avatar;

    private Integer deptId;

    private String deptName;

    private StatusType status;

    private Integer orderNum;

    private boolean online;

    @JsonFormat(pattern ="yyyy-MM-dd")
    private LocalDateTime createTime;
}
