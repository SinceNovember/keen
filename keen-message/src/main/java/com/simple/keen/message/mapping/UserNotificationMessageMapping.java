package com.simple.keen.message.mapping;

import com.simple.keen.message.model.dto.UserNotificationMessageDTO;
import com.simple.keen.message.model.entity.UserNotificationMessage;
import com.simple.keen.message.model.query.UserNotificationMessageQuery;
import com.simple.keen.message.model.vo.UserNotificationMessageVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/4/1
 */
@Mapper
public interface UserNotificationMessageMapping {

    UserNotificationMessageMapping INSTANCE = Mappers.getMapper(
        UserNotificationMessageMapping.class);

    List<UserNotificationMessageVO> toUserNotificationMessageVOList(
        List<UserNotificationMessageDTO> roleDTOS);

    UserNotificationMessageVO toUserNotificationMessageVO(UserNotificationMessageDTO roleDTO);

    UserNotificationMessageVO toUserNotificationMessageVO(UserNotificationMessage role);

    UserNotificationMessageDTO toUserNotificationMessageDTO(UserNotificationMessageQuery roleQuery);

    UserNotificationMessage toUserNotificationMessage(UserNotificationMessageDTO roleDTO);

}
