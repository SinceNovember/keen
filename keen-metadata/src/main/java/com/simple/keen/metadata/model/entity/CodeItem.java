package com.simple.keen.metadata.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/2/4
 */
@Data
@ToString
@EqualsAndHashCode
@TableName(value = "t_code_item")
public class CodeItem {

    /**
     * 参数ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 代码子项文本
     */
    @TableField(value = "item_text")
    private String itemText;

    /**
     * 代码子项值
     */
    @TableField(value = "item_value")
    private String itemValue;

    /**
     * 代码子项描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 排序号
     */
    @TableField(value = "order_num")
    private Integer orderNum;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 代码ID
     */
    @TableField(value = "code_id")
    private Integer codeId;

}
