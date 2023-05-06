package com.simple.keen.system.controller;

import com.simple.keen.common.base.Response;
import com.simple.keen.system.model.query.MenuPermissionQuery;
import com.simple.keen.system.service.IMenuPermissionService;
import javax.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/16
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/system/menu/permission")
public class MenuPermissionController {

    @Resource
    private IMenuPermissionService menuPermissionService;

    @GetMapping
    public Response listMenuPermission(MenuPermissionQuery query) {
        return Response.ok(menuPermissionService.listMenuPermissionIdGroupByType(query));
    }

    @PostMapping
    public Response updateMenuPermission(@RequestBody MenuPermissionQuery query) {
        menuPermissionService.updateMenuPermission(query);
        return Response.ok();
    }
}
