package com.simple.keen.message.mapping;

import com.simple.keen.message.model.dto.NotificationMessageDTO;
import com.simple.keen.message.model.entity.NotificationMessage;
import com.simple.keen.message.model.query.NotificationMessageQuery;
import com.simple.keen.message.model.vo.NotificationMessageVO;
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
public interface NotificationMessageMapping {

    NotificationMessageMapping INSTANCE = Mappers.getMapper(NotificationMessageMapping.class);

    List<NotificationMessageVO> toNotificationMessageVOList(List<NotificationMessageDTO> roleDTOS);

    NotificationMessageVO toNotificationMessageVO(NotificationMessageDTO roleDTO);

    NotificationMessageVO toNotificationMessageVO(NotificationMessage role);

    NotificationMessageDTO toNotificationMessageDTO(NotificationMessageQuery roleQuery);

    NotificationMessage toNotificationMessage(NotificationMessageDTO roleDTO);

}
