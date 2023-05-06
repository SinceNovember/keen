package com.simple.keen.system.controller;

import com.simple.keen.common.base.Response;
import com.simple.keen.system.model.query.MenuQuery;
import com.simple.keen.system.service.IMenuService;
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
 * 菜单controller
 *
 * @author SinceNovember
 * @date 2022/11/21
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/system/menu")
public class MenuController {

    @Resource
    private IMenuService menuService;

    @GetMapping("page")
    public Response pageMenu(MenuQuery menuQuery) {
        return Response.ok(menuService.pageMenu(menuQuery));
    }

    /**
     * 左侧栏展示的菜单
     *
     * @return
     */
    @GetMapping("all")
    public Response allMenus() {
        return Response.ok(menuService.listAllShowMenu());
    }

    @GetMapping("tree")
    public Response listTreeModel() {
        return Response.ok(menuService.listMenuTreeModel());
    }

    @GetMapping
    public Response getMenu(@NotNull Integer id) {
        return Response.ok(menuService.getMenuById(id));
    }

    @PostMapping
    public Response addOrUpdateMenu(@Validated @RequestBody MenuQuery menuQuery) {
        menuService.addOrUpdateMenu(menuQuery);
        return Response.ok();
    }

    @PostMapping("delete")
    public Response deleteMenu(@NotNull @RequestBody MenuQuery menuQuery) {
        menuService.deleteMenu(menuQuery.getIds());
        return Response.ok();
    }
}
