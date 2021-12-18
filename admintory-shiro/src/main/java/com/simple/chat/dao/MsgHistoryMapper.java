package com.simple.chat.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.chat.model.dto.MsgHistoryDTO;
import com.simple.chat.model.dto.MsgHistoryWithNameDTO;
import com.simple.chat.model.entity.MsgHistory;
import com.simple.system.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MsgHistoryMapper extends BaseMapper<MsgHistory> {

    @Select("select * from (select * from(select a.*, b.avatar, 'me' as `from` from t_msg a left join t_user b on a.from_id = b.user_id  where from_id = #{fromId} and to_id = #{toId} union all select a.*, b.avatar, 'other' as `from` from t_msg a left join t_user b on a.from_id = b.user_id  where from_id = #{toId} and to_id = #{fromId} ) as total order by create_time desc limit 150)b order by create_time")
    List<MsgHistoryDTO> listMsgHistory(Integer fromId, Integer toId);

    @Select("select a.*, b.nickname, b.avatar from t_msg a join t_user b on a.from_id = b.user_id where to_id = #{toId} and is_read = 0 order by a.create_time desc")
    List<MsgHistoryWithNameDTO> listUnreadMsgHistory(Integer toId);

    @Select("select * from t_user a where exists ( select id from t_msg b where (from_id = #{userId} or to_id = #{userId}) and (a.user_id = b.from_id or a.user_id = b.to_id)) and user_id <> #{userId}")
    List<UserDTO> listRelatedUserByUserId(Integer userId);
}
