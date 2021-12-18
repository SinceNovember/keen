package com.simple.other.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.other.model.entity.Theme;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ThemeMapper extends BaseMapper<Theme> {
}
