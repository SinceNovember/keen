package com.simple.keen.metadata.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/2/3
 */
@Data
@ToString
public class SystemConfigVO {

    private Integer id;

    private String configName;

    private String configValue;

    private String description;

    private Integer orderNum;

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
