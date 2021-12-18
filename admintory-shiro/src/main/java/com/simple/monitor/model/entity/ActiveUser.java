package com.simple.monitor.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.simple.system.model.dto.UserDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 在线用户
 */
@Data
public class ActiveUser implements Serializable {
    private static final long serialVersionUID = -1277171780468841527L;

    public static final String ONLINE = "1";
    public static final String OFFLINE = "0";
    /**
     * session id
     */
    private String id;
    /**
     * 用户 id
     */
    private Integer userId;
    /**
     * 用户名称
     */
    private String nickname;
    /**
     * 用户主机地址
     */
    private String host;
    /**
     * 用户登录时系统 IP
     */
    private String systemHost;
    /**
     * 状态
     */
    private String status;
    /**
     * session 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date startTime;
    /**
     * session 最后访问时间
     */
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date lastAccessTime;
    /**
     * 超时时间
     */
    private Long timeout;
    /**
     * 所在地
     */
    private String location;
    /**
     * 是否为当前登录用户
     */
    private boolean current;

    private UserDTO user;
}
