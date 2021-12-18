package com.simple.system.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.simple.common.model.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 部门实体
 */
@Data
@NoArgsConstructor
@ToString
@TableName("t_dept")
public class Dept  extends BaseEntity {

    /**
     * Id
     */
    @TableId("dept_id")
    private Integer deptId;

    /**
     * 上级Id
     */
    @TableField("parent_id")
    private Integer parentId;


    /**
     * 部门名称
     */
    @TableField("dept_name")
    private String deptName;

    /**
     * 排序号
     */
    @TableField("order_num")
    private Integer orderNum;

    /**
     * 创建者Id
     */
    @TableField("create_user_id")
    private Integer createUserId;

    /**
     * 部门缩写名称
     */
    @TableField("dept_short_name")
    private String deptShortName;

    /**
     * 描述
     */
    private String description;

}
