package com.simple.keen.system.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.simple.keen.common.base.entity.BaseEntity;
import com.simple.keen.system.model.enums.MenuType;
import com.simple.keen.system.model.enums.RequestMethod;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 菜单表
 *
 * @author SinceNovember
 * @date 2022/11/20
 */
@Data
@ToString
@EqualsAndHashCode
@TableName(value = "t_menu")
public class Menu extends BaseEntity {
    /**
     * 菜单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 路由地址
     */
    @TableField(value = "`path`")
    private String path;

    /**
     * 组件地址
     */
    @TableField(value = "component")
    private String component;

    /**
     * 名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 重定向地址
     */
    @TableField(value = "redirect")
    private String redirect;

    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 是否隐藏
     */
    @TableField(value = "hidden")
    private boolean hidden;

    /**
     * 是否公开
     */
    @TableField(value = "always_show")
    private boolean alwaysShow;

    /**
     * 面包屑
     */
    @TableField("bread_crumb")
    private boolean breadCrumb;

    /**
     * 是否默认展开
     */
    @TableField(value = "expand")
    private boolean expand;


    /**
     * 父ID
     */
    @TableField(value = "pid")
    private Integer parentId;

    /**
     * （1、目录，2、菜单，3、按钮）
     */
    @TableField(value = "`type`")
    private MenuType type;

    /**
     * 请求方法
     */
    @TableField(value = "request_method")
    private RequestMethod requestMethod;
}
