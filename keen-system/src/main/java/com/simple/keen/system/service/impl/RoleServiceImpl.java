package com.simple.keen.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageSerializable;
import com.simple.keen.common.base.OptionModel;
import com.simple.keen.common.base.TreeModel;
import com.simple.keen.common.utils.PageHelperUtils;
import com.simple.keen.system.mapper.RoleMapper;
import com.simple.keen.system.mapping.RoleMapping;
import com.simple.keen.system.model.dto.RoleDTO;
import com.simple.keen.system.model.entity.Role;
import com.simple.keen.system.model.query.RoleQuery;
import com.simple.keen.system.model.vo.RoleVO;
import com.simple.keen.system.service.IRoleService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/6
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public PageSerializable<RoleVO> pageRole(RoleQuery roleQuery) {
        PageHelperUtils.startPage(roleQuery);
        return PageHelperUtils.convertPageDto2Vo(baseMapper.selectRoleList(roleQuery),
            RoleMapping.INSTANCE::toRoleVOList);
    }

    @Override
    public List<OptionModel> listRoleOptionModel() {
        return baseMapper.selectRoleOptionModelList();
    }

    @Override
    public List<TreeModel> listRoleTreeModel() {
        return baseMapper.selectRoleTreeModelList();
    }

    @Override
    public void addOrUpdateRole(RoleQuery roleQuery) {
        RoleDTO roleDTO = RoleMapping.INSTANCE.toRoleDTO(roleQuery);
        roleDTO.setUpdateTime(LocalDateTime.now());
        if (roleQuery.getId() == null) {
            roleDTO.setCreateTime(LocalDateTime.now());
        }
        this.saveOrUpdate(RoleMapping.INSTANCE.toRole(roleDTO));
    }

    @Override
    public RoleVO getRoleById(Integer id) {
        return RoleMapping.INSTANCE.toRoleVO(getById(id));
    }

    @Override
    public void deleteRole(List<Integer> ids) {
        update(Wrappers.<Role>lambdaUpdate()
            .set(Role::getDeleted, true)
            .in(Role::getId, ids));
    }

}
