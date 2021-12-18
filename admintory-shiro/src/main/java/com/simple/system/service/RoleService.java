package com.simple.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.simple.system.model.dto.DeptDTO;
import com.simple.system.model.dto.OptionDTO;
import com.simple.system.model.dto.RoleDTO;
import com.simple.system.model.entity.Dept;
import com.simple.system.model.entity.Role;
import com.simple.system.model.vo.DeptCondition;
import com.simple.system.model.vo.RoleCondition;

import java.util.List;
import java.util.Map;

public interface RoleService extends IService<Role>  {

    IPage<RoleDTO> pageRole(RoleCondition deptCondition, int pageIndex, int pageSize);

    RoleDTO getRoleDetailById(int id);

    List<Integer> listRoleIdByUserId(Integer userId);

    List<Map<String, Integer>> countRoleMemberTop6();

    void logicDeleteRoleByIds(String ids);

    void logicDeleteRoleById(int id);

    void enableOrDisableRole(String ids);

    List<OptionDTO> listRoleOption();

    RoleDTO convertTo(Role role) ;

    List<RoleDTO> convertTo(List<Role> roles) ;
}
