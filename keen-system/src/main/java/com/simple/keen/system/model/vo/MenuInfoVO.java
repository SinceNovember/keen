package com.simple.keen.system.model.vo;

import com.simple.keen.system.model.enums.MenuType;
import com.simple.keen.system.model.enums.RequestMethod;
import lombok.Data;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2022/12/10
 */
@Data
@ToString
public class MenuInfoVO {

    private Integer id;

    private String path;

    private Integer parentId;

    private String parentTitle;

    private String component;

    private String name;

    private String redirect;

    private String title;

    private String icon;

    private MenuType type;

    private RequestMethod requestMethod;

    private Integer orderNum;

    private boolean hidden;

    private boolean breadCrumb;

    private boolean alwaysShow;

    private boolean expand;
}
