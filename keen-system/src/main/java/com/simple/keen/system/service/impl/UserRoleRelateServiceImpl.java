package com.simple.keen.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simple.keen.system.mapper.UserRoleRelateMapper;
import com.simple.keen.system.model.dto.RoleDTO;
import com.simple.keen.system.model.entity.UserRoleRelate;
import com.simple.keen.system.service.IUserRoleRelateService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/2/2
 */
@Service
public class UserRoleRelateServiceImpl extends
    ServiceImpl<UserRoleRelateMapper, UserRoleRelate> implements IUserRoleRelateService {

    @Override
    public List<RoleDTO> listRoleByUserId(Integer userId) {
        return baseMapper.selectRoleListByUserId(userId);
    }

    @Override
    public List<String> listRoleNameByUserId(Integer userId) {
        return baseMapper.selectRoleNameListByUserId(userId);
    }

}
