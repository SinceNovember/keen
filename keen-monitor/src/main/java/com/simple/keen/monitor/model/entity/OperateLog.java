package com.simple.keen.monitor.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 操作日志实体
 *
 */
@Data
@ToString
@EqualsAndHashCode
@TableName("t_operate_log")
public class OperateLog implements Serializable {

    /**
     * 日志ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 操作用户
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 操作内容
     */
    @TableField("operation")
    private String operation;

    /**
     * 耗时
     */
    @TableField("time")
    private Long time;

    /**
     * 操作方法
     */
    @TableField("method")
    private String method;

    /**
     * 方法参数
     */
    @TableField("params")
    private String params;

    /**
     * 操作者IP
     */
    @TableField("ip")
    private String ip;

    /**
     * 操作时间
     */
    @TableField("operate_time")
    private LocalDateTime operateTime;

    /**
     * 操作地点
     */
    @TableField("location")
    private String location;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Integer userId;

}
