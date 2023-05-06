package com.simple.keen.system.model.query;

import com.simple.keen.system.model.enums.PermissionType;
import java.util.List;
import java.util.Map;
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
public class MenuPermissionQuery {

    private Integer id;

    private Integer menuId;

    private Integer permissionId;

    private PermissionType permissionType;

    Map<PermissionType, List<Integer>> menuPermissionMap;

//    private List<Integer> roleIds;
//
//    private List<Integer> deptIds;
//
//    private List<Integer> userIds;

}
