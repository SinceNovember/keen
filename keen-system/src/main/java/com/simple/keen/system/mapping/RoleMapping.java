package com.simple.keen.system.mapping;

import com.simple.keen.system.model.dto.RoleDTO;
import com.simple.keen.system.model.entity.Role;
import com.simple.keen.system.model.query.RoleQuery;
import com.simple.keen.system.model.vo.RoleVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * .
 *
 * @author SinceNovember
 * @date 2022/12/16
 */
@Mapper
public interface RoleMapping {

    RoleMapping INSTANCE = Mappers.getMapper(RoleMapping.class);

    List<RoleVO> toRoleVOList(List<RoleDTO> roleDTOS);

    RoleVO toRoleVO(RoleDTO roleDTO);

    RoleVO toRoleVO(Role role);

    RoleDTO toRoleDTO(RoleQuery roleQuery);

    Role toRole(RoleDTO roleDTO);
}
