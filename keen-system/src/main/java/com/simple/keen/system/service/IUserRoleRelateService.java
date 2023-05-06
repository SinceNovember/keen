package com.simple.keen.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.simple.keen.system.model.dto.RoleDTO;
import com.simple.keen.system.model.entity.UserRoleRelate;
import java.util.List;

public interface IUserRoleRelateService extends IService<UserRoleRelate> {

    /**
     * 通过用户id列表角色
     *
     * @param userId 用户id
     * @return 角色列表
     */
    List<RoleDTO> listRoleByUserId(Integer userId);

    /**
     * 通过用户id列表获取角色名
     *
     * @param userId 用户id
     * @return 角色名列表
     */
    List<String> listRoleNameByUserId(Integer userId);

}
