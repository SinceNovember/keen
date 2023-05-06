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
 * @date 2023/2/3
 */
@Data
@ToString
@EqualsAndHashCode
@TableName(value = "t_system_config")
public class SystemConfig {

    /**
     * 参数ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 参数名
     */
    @TableField(value = "config_name")
    private String configName;

    /**
     * 参数值
     */
    @TableField(value = "config_value")
    private String configValue;


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
