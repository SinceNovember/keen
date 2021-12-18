package com.simple.other.model.params;

import com.simple.common.model.dto.base.InputConverter;
import com.simple.other.model.entity.Theme;
import lombok.Data;

@Data
public class ThemeParam implements InputConverter<Theme> {

    private Long id;

    private String themeText;

    private String themeName;

    private String picUrl;

    private Integer orderNum;
}
