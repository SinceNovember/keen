package com.simple.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.simple.system.model.entity.UserRoleRelate;

import java.util.List;

public interface UserRoleRelateService extends IService<UserRoleRelate>  {

    /**
     * 根据角色获取拥有的用户Id
     * @return
     */
    List<Integer> listUserIdByRoleId(Integer roleId);

    List<Integer> listRoleIdByUserId(Integer userId);

    boolean updateUserRoleRelate(Integer userId, List<Integer> roleIdList);

    boolean updateRoleUserRelate(Integer roleId, List<Integer> userIdList);

}
