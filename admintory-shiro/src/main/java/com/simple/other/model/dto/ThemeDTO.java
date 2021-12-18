package com.simple.other.model.dto;

import com.simple.common.model.dto.base.OutputConverter;
import com.simple.other.model.entity.Theme;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ThemeDTO implements OutputConverter<ThemeDTO, Theme> {

    private Long id;

    private String themeText;

    private String themeName;

    private String picUrl;

    private Integer orderNum;

}
