package com.simple.keen.system.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.simple.keen.common.base.entity.BaseEntity;
import com.simple.keen.system.model.enums.UserSex;
import com.simple.keen.system.model.enums.StatusType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 用户信息表
 *
 * @author SinceNovember
 * @date 2022/12/16
 */
@Data
@ToString
@EqualsAndHashCode
@TableName(value = "t_user")
public class User extends BaseEntity {
    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 性别
     */
    @TableField(value = "sex")
    private UserSex sex;

    /**
     * 电子邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 电话号码
     */
    @TableField(value = "mobile")
    private String mobile;

    /**
     * 昵称
     */
    @TableField(value = "nickname")
    private String nickname;

    /**
     * 头像
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 部门Id
     */
    @TableField(value = "dept_id")
    private Integer deptId;

    /**
     * 简介背景
     */
    @TableField(value = "profile_image")
    private String profileImage;

    /**
     * 状态
     */
    @TableField(value = "status")
    private StatusType status;

    /**
     * 最后登录时间
     */
    @TableField(value = "last_login_time")
    private LocalDateTime lastLoginTime;

}
