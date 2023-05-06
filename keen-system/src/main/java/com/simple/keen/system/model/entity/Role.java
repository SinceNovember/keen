package com.simple.keen.system.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.simple.keen.common.base.entity.BaseEntity;
import com.simple.keen.system.model.enums.StatusType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/6
 */
@Data
@ToString
@EqualsAndHashCode
@TableName(value = "t_role")
public class Role extends BaseEntity {
    /**
     * 角色ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名
     */
    @TableField(value = "role_name")
    private String roleName;

    /**
     * 角色标志
     */
    @TableField(value = "role_tag")
    private String roleTag;

    /**
     * 角色状态
     */
    @TableField(value = "status")
    private StatusType status;

    /**
     * 角色描述
     */
    @TableField(value = "description")
    private String description;

}
