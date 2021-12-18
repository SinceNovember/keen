package com.simple.metadata.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_system_config")
public class SystemConfig {

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 参数名称
     */
    @TableField("config_name")
    private String configName;

    /**
     * 参数值
     */
    @TableField("config_value")
    private String configValue;

    /**
     * 参数描述
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
