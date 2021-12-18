package com.simple.system.model.params;

import com.simple.common.model.dto.base.InputConverter;
import com.simple.system.model.entity.Menu;
import com.simple.system.model.enums.RequestMethod;
import com.simple.system.model.enums.MenuType;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MenuParam implements InputConverter<Menu> {

    private Integer id;

    /**
     * 保存的菜单类型， 1为目录，2为菜单，3为按钮。
     */
    private MenuType menuType;

    private String path;

    private Integer parentId;

    private String component;

    private String name;

    private String redirect;

    private Menu.Meta meta;

    private Integer orderNum;

    private Boolean hidden;

    private Boolean isExpand;

    private RequestMethod requestMethod;

    private Boolean alwaysShow;


}
