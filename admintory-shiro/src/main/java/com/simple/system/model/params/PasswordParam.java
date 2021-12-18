package com.simple.system.model.params;

import lombok.Data;
import sun.security.util.Password;

@Data
public class PasswordParam {

    private Integer userId;

    private String password;

    private String newPassword;

}
