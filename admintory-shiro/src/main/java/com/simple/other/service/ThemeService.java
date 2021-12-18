package com.simple.other.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import com.simple.other.model.dto.ThemeDTO;
import com.simple.other.model.entity.Theme;
import com.simple.other.model.vo.ThemeCondition;

import java.util.List;

public interface ThemeService extends IService<Theme> {

    IPage<ThemeDTO> pageTheme(ThemeCondition condition, int pageIndex, int pageSize);

    ThemeDTO convertTo(Theme Theme) ;

    List<ThemeDTO> convertTo(List<Theme> Theme) ;
}
