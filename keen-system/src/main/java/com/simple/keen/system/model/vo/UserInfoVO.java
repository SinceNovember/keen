package com.simple.keen.system.model.vo;

import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/3/30
 */
@Data
@ToString
public class UserInfoVO extends UserVO {

    private String description;

    private String profileImage;

    private List<Integer> roleIds;

    private List<String> roleNames;

}
