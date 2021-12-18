package com.simple.other.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simple.common.utils.StringUtils;
import com.simple.other.dao.ThemeMapper;
import com.simple.other.model.dto.ThemeDTO;
import com.simple.other.model.entity.Theme;
import com.simple.other.model.vo.ThemeCondition;
import com.simple.other.service.ThemeService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ThemeServiceImpl extends ServiceImpl<ThemeMapper, Theme> implements ThemeService {
    
    
    @Override
    public IPage<ThemeDTO> pageTheme(ThemeCondition condition, int pageIndex, int pageSize) {
        LambdaQueryWrapper<Theme> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StringUtils.isNotEmpty(condition.getThemeText()), Theme::getThemeText, condition.getThemeText())
                .like(StringUtils.isNotEmpty(condition.getThemeName()), Theme::getThemeName, condition.getThemeName())
                .orderByDesc(Theme::getOrderNum);

        Page<Theme> page = new Page<>(pageIndex, pageSize);
        IPage<ThemeDTO> configIPage = page(page, queryWrapper).convert(this::convertTo);
        return configIPage;
    }

    @Override
    public ThemeDTO convertTo(Theme theme) {
        Assert.notNull(theme, "theme must not be null");
        return new ThemeDTO().covertFrom(theme);
    }

    @Override
    public List<ThemeDTO> convertTo(List<Theme> themes) {
        if (CollectionUtils.isEmpty(themes)) {
            return Collections.emptyList();
        }
        return themes.stream()
                .map(this::convertTo)
                .collect(Collectors.toList());
    }
}
