package com.simple.monitor.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.simple.common.model.dto.base.OutputConverter;
import com.simple.monitor.model.entity.LoginLog;
import lombok.Data;

import java.util.Date;

/**
 * @author MrBird
 */

@Data
public class LoginLogDTO implements OutputConverter<LoginLogDTO, LoginLog> {

    private Long id;

    private String nickname;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date loginTime;

    private String location;

    private String ip;

    private String system;

    private String browser;

}
