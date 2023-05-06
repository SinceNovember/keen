package com.simple.keen.common.base.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/6
 */

@Data
public class BaseEntity {

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
     * 修改时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    @TableField(value = "deleted")
    private Boolean deleted;
}
