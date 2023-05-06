package com.simple.keen.system.model.query;

import com.simple.keen.common.base.query.PageQuery;
import com.simple.keen.system.model.enums.MenuType;
import com.simple.keen.system.model.enums.RequestMethod;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * .
 *
 * @author SinceNovember
 * @date 2022/11/22
 */
@Data
@ToString
public class MenuQuery extends PageQuery {

    private Integer id;

    private String path;

    private Integer parentId;

    private String component;

    private String name;

    private String redirect;

    @NotNull(message = "title 不可空")
    private String title;

    private String icon;

    private MenuType type;

    private RequestMethod requestMethod;

    private Integer orderNum;

    private boolean hidden;

    private boolean breadCrumb;

    private boolean expand;

    private boolean alwaysShow;

}
