package com.simple.keen.system.model.query;

import com.simple.keen.common.base.query.PageQuery;
import com.simple.keen.system.model.enums.UserSex;
import com.simple.keen.system.model.enums.StatusType;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * .
 *
 * @author SinceNovember
 * @date 2022/12/16
 */
@Data
@ToString
public class UserQuery extends PageQuery {

    private Integer id;

    private String username;

    private String password;

    private String nickname;

    private UserSex sex;

    private String email;

    private String mobile;

    private String avatar;

    private String description;

    private Integer deptId;

    private String profileImage;

    private List<Integer> roleIds;

    private StatusType status;

    private Integer orderNum;

}
