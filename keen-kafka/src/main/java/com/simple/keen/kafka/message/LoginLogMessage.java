package com.simple.keen.kafka.message;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/3/5
 */
@Data
public class LoginLogMessage {

    public static final String TOPIC = "LOGIN_LOG";


    private Integer id;

    /**
     * 登录用户
     */
    private String nickname;

    /**
     * 登录时间
     */
    private LocalDateTime loginTime;

    /**
     * 登录地点
     */
    private String location;
    /**
     * 登录 IP
     */
    private String ip;
    /**
     * 操作系统
     */
    private String system;
    /**
     * 登录浏览器
     */
    private String browser;

}
