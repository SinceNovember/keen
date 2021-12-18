package com.simple.metadata.model.dto;

import com.simple.common.model.dto.base.OutputConverter;
import com.simple.metadata.model.entity.SystemConfig;
import lombok.Data;


@Data
public class SystemConfigDTO implements OutputConverter<SystemConfigDTO, SystemConfig> {

    private Integer id;

    private String configName;

    private String configValue;

    private String description;

    private Integer orderNum;

}
