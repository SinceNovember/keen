package com.simple.keen.common.base.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/6
 */
@Data
public class BaseDTO {

    private Integer orderNum;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Boolean deleted;

}
