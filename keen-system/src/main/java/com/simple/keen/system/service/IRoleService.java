package com.simple.keen.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageSerializable;
import com.simple.keen.common.base.OptionModel;
import com.simple.keen.common.base.TreeModel;
import com.simple.keen.system.model.entity.Role;
import com.simple.keen.system.model.query.RoleQuery;
import com.simple.keen.system.model.vo.RoleVO;

import java.util.List;

public interface IRoleService extends IService<Role> {

    /**
     * 分页获取角色
     *
     * @param roleQuery 角色查询
     * @return 分页角色VO
     */
    PageSerializable<RoleVO> pageRole(RoleQuery roleQuery);

    /**
     * 角色列表选择模型
     *
     */
    List<OptionModel> listRoleOptionModel();

    /**
     * 角色列表树模型
     *
     * @return
     */
    List<TreeModel> listRoleTreeModel();

    /**
     * 添加或更新角色
     *
     * @param roleQuery 角色查询
     */
    void addOrUpdateRole(RoleQuery roleQuery);

    /**
     * 通过id获取角色
     *
     * @param id id
     * @return 角色信息VO
     */
    RoleVO getRoleById(Integer id);




    /**
     * 删除角色
     *
     * @param ids id
     */
    void deleteRole(List<Integer> ids);

}
