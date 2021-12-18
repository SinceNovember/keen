package com.simple.system.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.simple.common.model.entity.BaseEntity;
import com.simple.system.model.enums.SexType;
import com.simple.system.model.enums.UserStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 用户
 */
@Data
@NoArgsConstructor
@ToString
@TableName("t_user")
public class User extends BaseEntity {

    /**
     * id
     */
    @TableId(value="user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 显示名称
     */
    private String nickname;

    /**
     * 性别
     */
    @TableField("ssex")
    private SexType ssex;

    /**
     * 部门Id
     */
    @TableField("dept_id")
    private Integer deptId;

    /**
     * 点击邮件
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 状态
     */
    private UserStatus status;

    /**
     * 最后登陆时间
     */
    @TableField("last_login_time")
    private Date lastLoginTime;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 简介
     */
    private String description;

    private Integer isTab;

    private String theme;


}
