package com.simple.keen.system.controller;

import com.simple.keen.common.base.Response;
import com.simple.keen.system.model.query.RoleQuery;
import com.simple.keen.system.service.IRoleService;
import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/6
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/system/role")
public class RoleController {

    @Resource
    private IRoleService roleService;

    @GetMapping("page")
    public Response pageRole(RoleQuery roleQuery) {
        return Response.ok(roleService.pageRole(roleQuery));
    }

    @GetMapping
    public Response getRole(@NotNull Integer id) {
        return Response.ok(roleService.getRoleById(id));
    }

    @GetMapping("option")
    public Response listOptionModel() {
        return Response.ok(roleService.listRoleOptionModel());
    }

    @GetMapping("tree")
    public Response listTreeModel() {
        return Response.ok(roleService.listRoleTreeModel());
    }

    @PostMapping
    public Response addOrUpdateRole(@Validated @RequestBody RoleQuery roleQuery) {
        roleService.addOrUpdateRole(roleQuery);
        return Response.ok();
    }

    @PostMapping("delete")
    public Response deleteRole(@NotNull @RequestBody RoleQuery roleQuery) {
        roleService.deleteRole(roleQuery.getIds());
        return Response.ok();
    }
}
