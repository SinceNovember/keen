package com.simple.metadata.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_code_item")
public class CodeItem {

    /**
     * id
     */
    @TableId(value = "item_id", type = IdType.AUTO)
    private Long itemId;

    /**
     * 代码子项文本
     */
    @TableField("item_text")
    private String itemText;

    /**
     * 代码子项值
     */
    @TableField("item_value")
    private String itemValue;

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

    /**
     * 所属代码Id
     */
    @TableField("code_id")
    private Long codeId;

}
