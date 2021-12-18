package com.simple.common.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
public class BaseEntity implements Serializable {

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime = new Date();

    @TableField("deleted")
    private Boolean deleted = false;

}
