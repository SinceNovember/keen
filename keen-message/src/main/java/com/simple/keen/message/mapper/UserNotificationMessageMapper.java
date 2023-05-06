package com.simple.keen.message.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.keen.message.model.dto.UserNotificationMessageDTO;
import com.simple.keen.message.model.entity.UserNotificationMessage;
import com.simple.keen.message.model.query.UserNotificationMessageQuery;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserNotificationMessageMapper extends BaseMapper<UserNotificationMessage> {

    @Select("<script>"
        + "select * from t_message_notification_user"
        + "<where> "
        + "user_id = #{userId} "
        + "<if test=\"title != null and title != ''\">"
        + "and title like concat('%', #{title}, '%') "
        + "</if>"
        + "</where> "
        + "order by create_time desc "
        + "</script>")
    List<UserNotificationMessageDTO> selectUserNotificationMessageList(
        UserNotificationMessageQuery query);

}
