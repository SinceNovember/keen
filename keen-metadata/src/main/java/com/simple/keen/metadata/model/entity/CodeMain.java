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
@TableName(value = "t_code_main")
public class CodeMain {

    /**
     * 参数ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 代码项名
     */
    @TableField(value = "code_name")
    private String codeName;

    /**
     * 参数描述
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

}
