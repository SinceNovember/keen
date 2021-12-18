package com.simple.system.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.simple.common.model.entity.BaseEntity;
import com.simple.system.model.enums.RequestMethod;
import com.simple.system.model.enums.MenuType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@TableName("t_menu")
public class Menu extends BaseEntity {

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 路径
     */
    private String path;

    /**
     * 上级Id
     */
    @TableField("pid")
    private Integer parentId;

    /**
     * 组件地址
     */
    private String component;

    /**
     * 名称
     */
    private String name;

    /**
     * 重定向地址
     */
    private String redirect;

    @TableField(exist = false)
    private Meta meta;

    /**
     * 按钮类别
     */
    @TableField("type")
    private MenuType menuType;

    /**
     * 请求方式
     */
    @TableField("request_method")
    private RequestMethod requestMethod;

    /**
     * 是否总是展示
     */
    @TableField("always_show")
    private Boolean alwaysShow;

    /**
     * 排序号
     */
    @TableField("order_num")
    private Integer orderNum;

    /**
     * 是否隐藏
     */
    private Boolean hidden;

    /**
     * 是否默认展开
     */
    @TableField("is_expand")
    private Boolean isExpand;

    @Data
    @NoArgsConstructor
    @ToString
    public static class Meta {

        /**
         * 菜单名称
         */
        private String title;

        /**
         * 惨淡图标
         */
        private String icon;

        /**
         * 是否固定标签
         */
        private Boolean affix;

        @TableField("no_cache")
        private Boolean noCache;

        @TableField("bread_crumb")
        private Boolean breadCrumb;
    }
}
