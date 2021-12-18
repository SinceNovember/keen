package com.simple.system.controller.api;

import com.simple.common.annotation.ControllerEndpoint;
import com.simple.common.model.entity.ResponseData;
import com.simple.common.model.entity.Response;
import com.simple.system.model.enums.PermissionType;
import com.simple.system.model.params.MenuPermissionRelateParam;
import com.simple.system.service.MenuPermissionRelateService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/system/menu/permission")
public class MenuPermissionController {

    @Resource
    private MenuPermissionRelateService menuPermissionRelateService;

    /**
     * 按照授权类别获取菜单权限分组
     * @param menuId
     * @return
     */
    @GetMapping
    @ControllerEndpoint(exceptionMessage = "获取按钮权限失败")
    public ResponseData getMenuPermission(Integer menuId) {
        Map<PermissionType, List<Integer>> menuPermissionRelateMap = menuPermissionRelateService.listMenuPermissionIdGroupByType (menuId);
        return Response.ok(menuPermissionRelateMap);
    }

    @PutMapping
    @ControllerEndpoint(operation = "更新按钮权限", exceptionMessage = "更新按钮权限失败")
    public ResponseData updateMenuPermission(@RequestBody MenuPermissionRelateParam menuPermissionRelateParam){
        menuPermissionRelateService.updateMenuPermission(menuPermissionRelateParam);
        return Response.ok();

    }
}
