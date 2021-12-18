package com.simple.metadata.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simple.common.utils.StringUtils;
import com.simple.metadata.dao.SystemConfigMapper;
import com.simple.metadata.model.dto.SystemConfigDTO;
import com.simple.metadata.model.entity.SystemConfig;
import com.simple.metadata.model.vo.SystemConfigCondition;
import com.simple.metadata.service.SystemConfigService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SystemConfigServiceImpl extends ServiceImpl<SystemConfigMapper, SystemConfig> implements SystemConfigService {

    @Override
    public IPage<SystemConfigDTO> pageSystemConfig(SystemConfigCondition condition, int pageIndex, int pageSize) {
        LambdaQueryWrapper<SystemConfig> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StringUtils.isNotEmpty(condition.getConfigName()), SystemConfig::getConfigName, condition.getConfigName())
                .like(StringUtils.isNotEmpty(condition.getDescription()), SystemConfig::getDescription, condition.getDescription())
                .orderByDesc(SystemConfig::getOrderNum);

        Page<SystemConfig> page = new Page<>(pageIndex, pageSize);
        IPage<SystemConfigDTO> configIPage = page(page, queryWrapper).convert(this::convertTo);
        return configIPage;
    }

    @Override
    public String getConfigValueByConfigName(String name) {
        LambdaQueryWrapper<SystemConfig> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.select(SystemConfig::getConfigValue).eq(SystemConfig::getConfigName, name);

        return Optional.ofNullable(getOne(queryWrapper)).map(SystemConfig::getConfigValue).orElse("");
    }

    @Override
    public SystemConfigDTO convertTo(SystemConfig systemConfig) {
        Assert.notNull(systemConfig, "systemConfig must not be null");
        return new SystemConfigDTO().covertFrom(systemConfig);
    }

    @Override
    public List<SystemConfigDTO> convertTo(List<SystemConfig> systemConfigs) {
        if (CollectionUtils.isEmpty(systemConfigs)) {
            return Collections.emptyList();
        }
        return systemConfigs.stream()
                .map(this::convertTo)
                .collect(Collectors.toList());
    }
}
