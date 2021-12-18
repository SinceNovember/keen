package com.simple.metadata.model.params;

import com.simple.common.model.dto.base.InputConverter;
import com.simple.metadata.model.entity.SystemConfig;
import lombok.Data;

@Data
public class SystemConfigParam implements InputConverter<SystemConfig> {

    private Integer id;

    private String configName;

    private String configValue;

    private String description;

    private Integer orderNum;

}
