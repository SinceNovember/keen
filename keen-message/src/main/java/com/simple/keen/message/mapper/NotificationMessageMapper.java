package com.simple.keen.message.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.keen.message.model.dto.NotificationMessageDTO;
import com.simple.keen.message.model.entity.NotificationMessage;
import com.simple.keen.message.model.query.NotificationMessageQuery;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface NotificationMessageMapper extends BaseMapper<NotificationMessage> {

    @Select("<script>"
        + "select a.*, b.nickname createUserName "
        + "from t_message_notification a left join t_user b on a.create_user_id = b.id"
        + "<where> "
        + "<if test=\"title != null and title != ''\">"
        + "and title like concat('%', #{title}, '%') "
        + "</if>"
        + "<if test=\"content != null and content != ''\">"
        + "and content like concat('%', #{content}, '%') "
        + "</if>"
        + "</where>"
        + "</script>")
    List<NotificationMessageDTO> selectNotificationMessageList(NotificationMessageQuery query);

}
