package com.simple.keen.metadata.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/2/4
 */
@Data
@ToString
public class CodeMainVO {

    private Integer id;

    private String codeName;

    private String description;

    private Integer orderNum;

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
