package com.simple.keen.system.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.simple.keen.system.model.enums.PermissionType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/16
 */
@Data
@ToString
@EqualsAndHashCode
@TableName(value = "t_menu_permission")
public class MenuPermission {
    /**
     * 权限ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 菜单ID
     */
    @TableField(value = "menu_id")
    private Integer menuId;

    /**
     * 权限ID
     */
    @TableField(value = "permission_id")
    private Integer permissionId;

    /**
     * 权限类型
     */
    @TableField(value = "permission_type")
    private PermissionType permissionType;

}
