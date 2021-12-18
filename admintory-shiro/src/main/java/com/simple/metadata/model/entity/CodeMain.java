package com.simple.metadata.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_code_main")
public class CodeMain implements Serializable {

    /**
     * id
     */
    @TableId(value = "code_id", type = IdType.AUTO)
    private Long codeId;

    /**
     * 代码名称
     */
    @TableField("code_name")
    private String codeName;

    /**
     * 代码说明
     */
    @TableField("description")
    private String description;

    /**
     * 序号
     */
    @TableField("order_num")
    private Integer orderNum;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
}
