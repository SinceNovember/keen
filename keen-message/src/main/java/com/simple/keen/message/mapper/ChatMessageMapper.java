package com.simple.keen.message.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.keen.message.model.dto.ChatMessageDTO;
import com.simple.keen.message.model.entity.ChatMessage;
import com.simple.keen.message.model.query.ChatMessagePageQuery;
import com.simple.keen.system.model.dto.UserDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ChatMessageMapper extends BaseMapper<ChatMessage> {

    @Select("<script> "
        + "select * from ("
        + "select "
        + "a.*, b.nickname 'fromName', c.nickname 'toName' "
        + "from "
        + "t_message_chat a "
        + "left join t_user b on a.from_id = b.id "
        + "left join t_user c on a.to_id = c.id "
        + ")a"
        + "<where>"
        + "<if test=\"fromName != null and fromName != ''\">"
        + "and fromName like concat('%', #{fromName}, '%') "
        + "</if>"
        + "<if test=\"toName != null and toName != ''\">"
        + "and toName like concat('%', #{toName}, '%') "
        + "</if>"
        + "<if test=\"content != null and content != ''\">"
        + "and content like concat('%', #{content}, '%') "
        + "</if>"
        + "</where>"
        + "</script>")
    List<ChatMessageDTO> selectChatMessageList(ChatMessagePageQuery chatMessagePageQuery);

    @Select("<script> "
        + "select a.*,b.dept_name as deptName from ("
        + "select * from t_user a where exists ( select id from t_message_chat b where (from_id = #{userId} or to_id = #{userId}) and (a.id = b.from_id or a.id = b.to_id)) and id != #{userId}) a "
        + "join t_dept b on a. dept_id = b.id"
        + "</script>")
    List<UserDTO> selectContactUserListByUserId(@Param("userId") Integer userId);

    @Select("<script> "
        + "select * from ("
        + "select * from(select *, 'me' as `from` from t_message_chat where from_id = #{fromId} and to_id = #{toId} "
        + "union all "
        + "select *, 'other' as `from` from t_message_chat where from_id = #{toId} and to_id = #{fromId} ) as total "
        + "order by create_time desc limit 150 "
        + ")b order by create_time"
        + "</script>")
    List<ChatMessageDTO> selectChatMessageByFromAndToId(@Param("fromId") Integer fromId,
        @Param("toId") Integer toId);

}
