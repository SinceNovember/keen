package com.simple.keen.system.mapping;

import com.simple.keen.system.model.dto.UserDTO;
import com.simple.keen.system.model.entity.User;
import com.simple.keen.system.model.query.UserQuery;
import com.simple.keen.system.model.vo.UserInfoVO;
import com.simple.keen.system.model.vo.UserVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

/**
 * .
 *
 * @author SinceNovember
 * @date 2022/12/16
 */
@Mapper
public interface UserMapping {

    UserMapping INSTANCE = Mappers.getMapper(UserMapping.class);

    List<UserVO> toUserVOList(List<UserDTO> userDTOS);

    UserVO toUserVO(UserDTO userDTO);

    @Named(value = "toUserInfoVO")
    UserInfoVO toUserInfoVO(UserDTO userDTO);

    UserDTO toUserDTO(User user);

    UserDTO toUserDTO(UserQuery userQuery);

    User toUser(UserDTO userDTO);
}
