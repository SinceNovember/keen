package com.simple.keen.system.model.query;

import com.simple.keen.common.base.query.PageQuery;
import com.simple.keen.system.model.enums.StatusType;
import lombok.Data;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/6
 */
@Data
public class RoleQuery extends PageQuery {

    private Integer id;

    private String roleName;

    private String roleTag;

    private Integer orderNum;

    private StatusType status;

    private String description;

}
