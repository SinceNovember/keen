package com.simple.system.model.params;

import com.simple.common.model.dto.base.InputConverter;
import com.simple.system.model.entity.MenuPermissionRelate;
import com.simple.system.model.enums.PermissionType;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class MenuPermissionRelateParam implements InputConverter<MenuPermissionRelate> {

    private Integer menuId;

    private PermissionType type;

    private List<Integer> permissionIdList;

}
