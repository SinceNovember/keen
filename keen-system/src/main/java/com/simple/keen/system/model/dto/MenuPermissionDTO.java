package com.simple.keen.system.model.dto;

import com.simple.keen.system.model.enums.PermissionType;
import lombok.Data;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/16
 */
@Data
@ToString
public class MenuPermissionDTO {

    private Integer id;

    private String menuId;

    private String permissionId;

    private PermissionType permissionType;

}
