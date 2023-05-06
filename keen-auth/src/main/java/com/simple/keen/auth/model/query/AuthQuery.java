package com.simple.keen.auth.model.query;

import lombok.Data;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/18
 */
@Data
@ToString
public class AuthQuery {

    private String username;

    private String password;

    private String newPassword;

    private boolean rememberMe;

    private String tokenValue;

}
