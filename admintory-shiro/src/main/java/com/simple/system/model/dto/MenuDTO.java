package com.simple.system.model.dto;

import com.simple.common.model.dto.base.OutputConverter;
import com.simple.system.model.entity.Menu;
import com.simple.system.model.enums.RequestMethod;
import com.simple.system.model.enums.MenuType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class MenuDTO implements OutputConverter<MenuDTO,Menu> {

    private Integer id;

    private String path;

    private Integer parentId;

    private String component;

    private String name;

    private String redirect;

    private MenuType menuType;

    private RequestMethod requestMethod;

    private List<MenuDTO> children;

    private Menu.Meta meta;

    private Integer orderNum;

    private Boolean alwaysShow;

    private Boolean hidden;

    private Boolean isExpand;


}

