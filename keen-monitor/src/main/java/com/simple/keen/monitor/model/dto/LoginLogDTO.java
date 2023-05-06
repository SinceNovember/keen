package com.simple.keen.monitor.model.dto;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/2/6
 */
@Data
@ToString
public class LoginLogDTO {

    /**
     * id
     */
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

    /**
     * 用户id
     */
    private Integer userId;

}
