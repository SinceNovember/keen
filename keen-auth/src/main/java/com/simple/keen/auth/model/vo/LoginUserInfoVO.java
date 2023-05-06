package com.simple.keen.auth.model.vo;

import com.simple.keen.system.model.vo.UserInfoVO;
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
public class LoginUserInfoVO extends UserInfoVO {

    private long unreadMessageCount;

}
