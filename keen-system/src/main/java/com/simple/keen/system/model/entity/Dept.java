package com.simple.keen.system.model.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.simple.keen.common.base.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/10
 */
@Data
@ToString
@EqualsAndHashCode
@TableName(value = "t_dept")
public class Dept extends BaseEntity {

    /**
     * 部门ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 部门名称
     */
    @TableField(value = "dept_name")
    private String deptName;

    /**
     * 部门缩写名称
     */
    @TableField(value = "dept_short_name")
    private String deptShortName;

    /**
     * 创建人id
     */
    @TableField(value = "create_user_id")
    private Integer createUserId;

    /**
     * 介绍
     */
    @TableField(value = "description")
    private String description;

    /**
     * 父ID
     */
    @TableField(value = "parent_id", updateStrategy = FieldStrategy.IGNORED)
    private Integer parentId;
}
