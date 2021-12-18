package com.simple.metadata.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.simple.metadata.model.dto.SystemConfigDTO;
import com.simple.metadata.model.entity.SystemConfig;
import com.simple.metadata.model.vo.SystemConfigCondition;

import java.util.List;

public interface SystemConfigService extends IService<SystemConfig> {

    IPage<SystemConfigDTO> pageSystemConfig(SystemConfigCondition condition, int pageIndex, int pageSize);

    /**
     * 根据配置名称获取配置值
     * @param name
     * @return
     */
    String getConfigValueByConfigName(String name);

    SystemConfigDTO convertTo(SystemConfig systemConfig) ;

    List<SystemConfigDTO> convertTo(List<SystemConfig> systemConfig) ;


}
