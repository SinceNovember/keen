package com.simple.system.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.simple.common.model.entity.BaseEntity;
import com.simple.system.model.enums.RoleStatus;
import lombok.Data;
import lombok.ToString;

/**
 * 角色
 */
@Data
@ToString
@TableName("t_role")
public class Role extends BaseEntity {

    /**
     * id
     */
    @TableId("role_id")
    private Integer roleId;

    /**
     * 角色名称
     */
    @TableField("role_name")
    private String roleName;

    /**
     * 角色标签
     */
    @TableField("role_tag")
    private String roleTag;

    /**
     * 排序号
     */
    @TableField("order_num")
    private Integer orderNum;

    /**
     * 角色状态
     */
    private RoleStatus status;

    /**
     * 描述
     */
    private String description;

}
