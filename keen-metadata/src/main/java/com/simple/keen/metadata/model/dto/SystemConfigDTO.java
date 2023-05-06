package com.simple.keen.metadata.model.dto;

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
public class SystemConfigDTO {

    private Integer id;

    private String configName;

    private String configValue;

    private String description;

    private Integer orderNum;

    private LocalDateTime createTime;

}
