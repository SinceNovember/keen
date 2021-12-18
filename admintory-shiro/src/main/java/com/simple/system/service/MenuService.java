package com.simple.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.simple.system.model.dto.MenuDTO;
import com.simple.system.model.dto.TreeDTO;
import com.simple.system.model.entity.Menu;
import com.simple.system.model.entity.Role;
import com.simple.system.model.vo.DeptCondition;
import com.simple.system.model.vo.MenuCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface MenuService extends IService<Menu> {

    List<MenuDTO> listUserMenu(Integer userId);

    MenuDTO getUserFirstMenu(Integer userId);

    IPage<MenuDTO> pageMenu(MenuCondition menuCondition, int pageIndex, int pageSize);

    List<TreeDTO> listMenuTreeModel();

    MenuDTO getMenuBaseInfo(Integer menuId);

    MenuDTO getButtonByPathAndRequestMethod(String path, String requestMethod);

    boolean saveDirectory(Menu menu);

    boolean saveMenu(Menu menu);

    boolean saveButton(Menu menu);

    boolean updateModule(Menu menu);

    boolean updateMenu(Menu menu);

    boolean updateButton(Menu menu);

    void logicDeleteMenuById(Integer id);

    void logicDeleteMenuByIds(Set<String> ids);

    MenuDTO convertTo(Menu menu) ;

    List<MenuDTO> convertTo(List<Menu> menus) ;

    }
