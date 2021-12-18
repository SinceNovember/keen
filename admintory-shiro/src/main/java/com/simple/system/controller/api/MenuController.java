package com.simple.system.controller.api;

import com.simple.common.annotation.ControllerEndpoint;
import com.simple.common.controller.AbstractController;
import com.simple.common.model.constant.CommonConstant;
import com.simple.common.model.constant.Strings;
import com.simple.common.model.entity.ResponseData;
import com.simple.common.model.entity.Response;
import com.simple.system.model.dto.MenuDTO;
import com.simple.system.model.entity.Menu;
import com.simple.system.model.enums.MenuType;
import com.simple.system.model.params.MenuParam;
import com.simple.system.model.vo.MenuCondition;
import com.simple.system.service.MenuService;
import lombok.NonNull;
import org.apache.shiro.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import static com.simple.common.utils.StringUtils.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/system/menu")
public class MenuController extends AbstractController {
    @Resource
    private MenuService menuService;

    /**
     * 左侧栏展示的菜单
     * @return
     */
    @GetMapping("/all")
    @ControllerEndpoint(exceptionMessage = "获取菜单失败")
    public ResponseData allMenus() {
        List<MenuDTO> menus = menuService.listUserMenu(getUserId());
        return Response.ok(menus);
    }

    /**
     * 第一个菜单，用于根据不用用户权限获取首个菜单
     * @return
     */
    @GetMapping("/first")
    @ControllerEndpoint(exceptionMessage = "获取菜单失败")
    public ResponseData firstMenu() {
        MenuDTO menu = menuService.getUserFirstMenu(getUserId());
        return Response.ok(menu);
    }

    /**
     * 菜单列表中的菜单数据
     * @param menuCondition
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    @ControllerEndpoint(exceptionMessage = "获取菜单失败")
    public ResponseData menus(MenuCondition menuCondition, @RequestParam(defaultValue = "1",value = "currentPage") Integer pageNumber, @RequestParam(defaultValue = "10") Integer pageSize) {
        return Response.ok(menuService.pageMenu(menuCondition, pageNumber, pageSize));
    }

    @GetMapping("/tree")
    @ControllerEndpoint(exceptionMessage = "获取菜单树模型")
    public ResponseData menuTreeModel() {
        return Response.ok(menuService.listMenuTreeModel());
    }

    @GetMapping
    public ResponseData getMenu(@NonNull Integer menuId) {
        MenuDTO menu = menuService.getMenuBaseInfo(menuId);
        return Response.ok(menu);
    }

    @PostMapping
    @ControllerEndpoint(operation = "新增菜单", exceptionMessage = "新增菜单失败")
    public ResponseData addMenu(@RequestBody MenuParam menuParam){
        Menu menu = menuParam.convertTo();
        menu.setCreateTime(new Date());
        menu.setComponent(getComponentPath(menu.getComponent()));
        //目录
        if(menuParam.getMenuType() == MenuType.DIRECTORY){
            menuService.saveDirectory(menu);
        } else if(menuParam.getMenuType() == MenuType.MENU){
            menuService.saveMenu(menu);
        } else {
            menuService.saveButton(menu);
        }
        return Response.ok();
    }

    @PutMapping
    @ControllerEndpoint(operation = "修改菜单", exceptionMessage = "修改菜单失败")
    public ResponseData updateMenu(@RequestBody MenuParam menuParam){
        Menu menu = menuParam.convertTo();
        menu.setUpdateTime(new Date());
        menu.setComponent(getComponentPath(menu.getComponent()));
        //目录
        if(menuParam.getMenuType() == MenuType.DIRECTORY){
            menuService.updateModule(menu);
        } else if(menuParam.getMenuType() == MenuType.MENU){
            menuService.updateMenu(menu);
        } else {
            menuService.updateButton(menu);
        }
        return Response.ok();
    }

    @DeleteMapping
    @ControllerEndpoint(operation = "删除菜单", exceptionMessage = "删除菜单失败")
    public ResponseData removeMenu(@NonNull @RequestParam("ids")  String ids) {
        menuService.logicDeleteMenuByIds(StringUtils.splitToSet(ids, Strings.COMMA));
        return Response.ok(CommonConstant.DELETE_SUCCESS_TEXT);
    }

}
