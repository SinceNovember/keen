package com.simple.keen.monitor.model.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/4/23
 */
@Data
@ToString
public class RecentLoginLogDTO {

    /**
     * id
     */
    private Integer id;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 登录用户
     */
    private String nickname;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 角色列表
     */
    private List<String> roleNames;

    /**
     * 登录时间
     */
    private LocalDateTime loginTime;

    /**
     * 格式化后的时间
     */
    private String formatTime;

    /**
     * 登录地点
     */
    private String location;

    /**
     * 登录 IP
     */
    private String ip;

}
