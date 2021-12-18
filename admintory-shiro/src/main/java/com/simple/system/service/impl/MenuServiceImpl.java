package com.simple.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.ImmutableMap;
import com.simple.common.exception.AdmintoryException;
import com.simple.common.exception.RelateExistException;
import com.simple.common.utils.StringUtils;
import com.simple.system.dao.MenuMapper;
import com.simple.system.dao.MenuPermissionRelateMapper;
import com.simple.system.model.dto.MenuDTO;
import com.simple.system.model.dto.TreeDTO;
import com.simple.system.model.entity.*;
import com.simple.system.model.enums.MenuType;
import com.simple.system.model.enums.PermissionType;
import com.simple.system.model.vo.MenuCondition;
import com.simple.system.service.MenuPermissionRelateService;
import com.simple.system.service.MenuService;
import com.simple.system.service.RoleService;
import com.simple.system.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import static com.simple.common.model.constant.CommonConstant.*;
import static com.simple.common.utils.StringUtils.*;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Resource
    private UserService userService;

    @Resource
    private MenuMapper menuMapper;

    @Resource
    private MenuPermissionRelateService menuPermissionRelateService;

    @Resource
    private MenuPermissionRelateMapper menuPermissionRelateMapper;

    @Override
    public List<MenuDTO> listUserMenu(Integer userId) {
        List<MenuDTO> menuList = menuMapper.listRootMenu();
        User user = userService.getById(userId);
        return menuList.stream().map(menu ->  fetchMenuPermission(user, menu, "")).filter(menu -> menu != null && menu.getMenuType() != MenuType.BUTTON).collect(Collectors.toList());
    }

    @Override
    public MenuDTO getUserFirstMenu(Integer userId) {
        List<MenuDTO> menuList = menuMapper.listRootMenu();
        User user = userService.getById(userId);
        for (MenuDTO menuDTO : menuList) {
            if (menuPermissionRelateService.hasMenuPermission(user, menuDTO)) {
                return menuDTO;
            }
        }
        return null;

    }


    /**
     * 递归遍历菜单的权限
     * @param user
     * @param menu
     * @return
     */
    private MenuDTO fetchMenuPermission(User user, MenuDTO menu, String basePath){
        if (menu.getMenuType() != MenuType.BUTTON && menuPermissionRelateService.hasMenuPermission(user, menu)) {
            menu.setPath((Objects.equals("/", basePath) ? "" : basePath) + getPath(menu.getPath()));
            List<MenuDTO> childMenuList = menu.getChildren().stream().map(childMenu -> fetchMenuPermission(user, childMenu, menu.getPath())).filter(childMenu -> childMenu != null ).collect(Collectors.toList());
            menu.setChildren(childMenuList);
            return menu;
        }
        return null;

    }

    @Override
    public IPage<MenuDTO> pageMenu(MenuCondition menuCondition, int pageIndex, int pageSize) {
        IPage<MenuDTO> menuIPage = new Page<>();
        List<MenuDTO> menus = menuMapper.listMenu(menuCondition, (pageIndex - 1) * pageSize, pageSize);
        menuIPage.setRecords(menus);
        menuIPage.setTotal(menuMapper.countMenu(menuCondition));
        return menuIPage;
    }

    @Override
    public List<TreeDTO> listMenuTreeModel() {
        return menuMapper.listMenuTree(null);
    }

    @Override
    public MenuDTO getMenuBaseInfo(Integer menuId) {
        MenuDTO menuDTO = menuMapper.getMenuBaseInfoById(menuId);
        return menuDTO;
    }

    @Override
    public MenuDTO getButtonByPathAndRequestMethod(String path, String requestMethod) {
        return menuMapper.getButtonByPathAndRequestMethod(path, requestMethod);
    }

    /**
     * 添加目录
     * @param menu
     * @return
     */
    @Override
    public boolean saveDirectory(Menu menu) {
        menu.setComponent("Layout");
        menu.setMenuType(MenuType.DIRECTORY);
        menu.setPath(getPath(menu.getPath()));
        return menuMapper.insertMenu(menu);
    }

    /**
     * 添加菜单
     * @param menu
     * @return
     */
    @Override
    public boolean saveMenu(Menu menu) {
        menu.setMenuType(MenuType.MENU);
        menu.setPath(getPath(menu.getPath()));
        return menuMapper.insertMenu(menu);
    }

    @Override
    public boolean saveButton(Menu menu) {
        menu.setMenuType(MenuType.BUTTON);
        menu.setPath(getPath(menu.getPath()));
        return menuMapper.insertMenu(menu);
    }

    @Override
    public boolean updateModule(Menu menu) {
        menu.setComponent("Layout");
        menu.setPath(getPath(menu.getPath()));
        return menuMapper.updateMenu(menu);
    }

    @Override
    public boolean updateMenu(Menu menu) {
        menu.setPath(getPath(menu.getPath()));
        return menuMapper.updateMenu(menu);
    }

    @Override
    public boolean updateButton(Menu menu) {
        menu.setPath(getPath(menu.getPath()));
        return  menuMapper.updateMenu(menu);
    }

    @Override
    @Transactional(rollbackFor = AdmintoryException.class)
    public void logicDeleteMenuById(Integer id) {
        LambdaQueryWrapper<Menu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Menu::getParentId, id);
        wrapper.ne(Menu::getDeleted, true);
        Integer count = menuMapper.selectCount(wrapper);
        if(count > 0){
            throw new RelateExistException("菜单下存在子菜单");
        }
        Menu menu = this.getById(id);
        if (null != menu) {
            menu.setDeleted(true);
            this.updateById(menu);

            //删除按钮权限关系
            menuPermissionRelateMapper.deleteByMap(ImmutableMap.of("menu_id", menu.getId()));
        }
    }

    @Override
    public void logicDeleteMenuByIds(Set<String> ids) {
        ids.forEach(id -> this.logicDeleteMenuById(Integer.valueOf(id)));
    }


    public MenuDTO convertTo(Menu menu) {
        Assert.notNull(menu, "menu must not be null");
        return new MenuDTO().covertFrom(menu);
    }

    public List<MenuDTO> convertTo(List<Menu> menus) {
        if (CollectionUtils.isEmpty(menus)) {
            return Collections.emptyList();
        }

        return menus.stream()
                .map(this::convertTo)
                .collect(Collectors.toList());
    }


}
