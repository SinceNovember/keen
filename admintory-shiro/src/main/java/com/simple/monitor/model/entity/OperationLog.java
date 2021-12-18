package com.simple.monitor.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_log")
public class OperationLog implements Serializable {

    /**
     * 日志ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 操作地点
     */
    @TableField("location")
    private String location;

}
