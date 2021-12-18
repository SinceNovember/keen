package com.simple.system.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.simple.system.model.enums.PermissionType;
import lombok.Data;
import lombok.ToString;

/**
 * 按钮权限关系
 */
@Data
@ToString
@TableName("t_menu_permission")
public class MenuPermissionRelate {

    /**
     * Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 按钮Id
     */
    @TableField("menu_id")
    private Integer menuId;

    /**
     * 权限Id
     */
    @TableField("permission_id")
    private Integer permissionId;

    /**
     * 权限类别
     */
    @TableField("permission_type")
    private PermissionType permissionType;

}
