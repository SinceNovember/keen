package com.simple.keen.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageSerializable;
import com.simple.keen.common.base.TreeModel;
import com.simple.keen.system.model.dto.UserDTO;
import com.simple.keen.system.model.entity.Menu;
import com.simple.keen.system.model.enums.RequestMethod;
import com.simple.keen.system.model.query.MenuQuery;
import com.simple.keen.system.model.vo.MenuInfoVO;
import com.simple.keen.system.model.vo.MenuVO;
import java.util.List;

public interface IMenuService extends IService<Menu> {

    /**
     * 分页获取菜单
     *
     * @param menuQuery 菜单查询
     * @return 分页菜单VO
     */
    PageSerializable<MenuVO> pageMenu(MenuQuery menuQuery);

    /**
     * 获取所有显示的菜单
     *
     * @return 分页菜单VO
     */
    List<MenuVO> listAllShowMenu();

    /**
     * 获取用户菜单列表 (按照权限获取）
     *
     * @param userDTO 用户id
     * @return 菜单列表
     */
    List<MenuVO> listMenuByUserDTO(UserDTO userDTO);

    /**
     * 由父id获取菜单列表
     *
     * @param parentId 父id
     * @return 分页菜单VO
     */
    List<MenuVO> listMenuByParentId(Integer parentId);

    /**
     * 添加或更新菜单
     *
     * @param menuQuery 菜单查询
     */
    void addOrUpdateMenu(MenuQuery menuQuery);

    /**
     * 菜单树模型列表
     *
     * @return
     */
    List<TreeModel> listMenuTreeModel();

    /**
     * 通过id获取菜单
     *
     * @param id id
     * @return 菜单信息VO
     */
    MenuInfoVO getMenuById(Integer id);

    /**
     * 检查当前用户是否拥有对应路径和方法的权限
     *
     * @param userDTO       用户dto
     * @param path          路径
     * @param requestMethod 请求方法
     * @return
     */
    boolean checkMenuPermissionByUserAndPath(UserDTO userDTO, String path,
            RequestMethod requestMethod);

    /**
     * 删除菜单
     *
     * @param ids
     */
    void deleteMenu(List<Integer> ids);

}
