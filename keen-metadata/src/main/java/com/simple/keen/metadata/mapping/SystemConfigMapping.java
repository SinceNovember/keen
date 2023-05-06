package com.simple.keen.metadata.mapping;

import com.simple.keen.metadata.model.dto.SystemConfigDTO;
import com.simple.keen.metadata.model.entity.SystemConfig;
import com.simple.keen.metadata.model.query.SystemConfigQuery;
import com.simple.keen.metadata.model.vo.SystemConfigVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/2/3
 */
@Mapper
public interface SystemConfigMapping {

    SystemConfigMapping INSTANCE = Mappers.getMapper(SystemConfigMapping.class);

    List<SystemConfigVO> toSystemConfigVOList(List<SystemConfigDTO> systemConfigDTOS);

    SystemConfigVO toSystemConfigVO(SystemConfigDTO systemConfigDTO);

    SystemConfigVO toSystemConfigVO(SystemConfig systemConfig);

    SystemConfigDTO toSystemConfigDTO(SystemConfigQuery systemConfigQuery);

    SystemConfig toSystemConfig(SystemConfigDTO systemConfigDTO);

}
