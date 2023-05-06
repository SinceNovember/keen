package com.simple.keen.system.mapping;

import com.simple.keen.system.model.dto.DeptDTO;
import com.simple.keen.system.model.dto.UserDTO;
import com.simple.keen.system.model.entity.Dept;
import com.simple.keen.system.model.query.DeptQuery;
import com.simple.keen.system.model.vo.DeptUserVO;
import com.simple.keen.system.model.vo.DeptVO;
import com.simple.keen.system.model.vo.DeptWithUserVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/10
 */
@Mapper
public interface DeptMapping {

    DeptMapping INSTANCE = Mappers.getMapper(DeptMapping.class);

    List<DeptVO> toDeptVOList(List<DeptDTO> deptDTOS);

    DeptVO toDeptVO(DeptDTO deptDTO);

    List<DeptUserVO> toDeptUserVOList(List<UserDTO> userDTOS);

    DeptUserVO toDeptUserVO(UserDTO deptDTO);

    List<DeptWithUserVO> toDeptWithUserVOList(List<DeptDTO> deptDTOS);

    DeptWithUserVO toDeptWithUserVO(DeptDTO deptDTO);

    DeptVO toDeptVO(Dept dept);

    DeptDTO toDeptDTO(DeptQuery deptQuery);

    Dept toDept(DeptDTO deptDTO);
}
