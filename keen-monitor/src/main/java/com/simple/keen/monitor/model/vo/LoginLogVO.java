package com.simple.keen.monitor.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class LoginLogVO {

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
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
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
