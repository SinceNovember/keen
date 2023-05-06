package com.simple.keen.system.model.dto;

import com.simple.keen.common.base.dto.BaseDTO;
import com.simple.keen.system.model.enums.StatusType;
import lombok.Data;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/6
 */
@Data
public class RoleDTO extends BaseDTO {

    private Integer id;

    private String roleName;

    private String roleTag;

    private StatusType status;

    private String description;

}
