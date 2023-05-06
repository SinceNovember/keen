package com.simple.keen.message.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageSerializable;
import com.simple.keen.message.model.entity.ChatMessage;
import com.simple.keen.message.model.query.ChatMessagePageQuery;
import com.simple.keen.message.model.query.ChatMessageQuery;
import com.simple.keen.message.model.vo.ChatMessageContactUserVO;
import com.simple.keen.message.model.vo.ChatMessagePageVO;
import java.util.List;

public interface IChatMessageService extends IService<ChatMessage> {

    /**
     * 分页聊天信息
     *
     * @param query 查询
     * @return
     */
    PageSerializable<ChatMessagePageVO> pageChatMessage(ChatMessagePageQuery query);


    /**
     * 获取联系用户以及消息列表
     *
     * @return
     */
    List<ChatMessageContactUserVO> listContactUserAndChatMessage();

    /**
     * 统计未读消息数量
     *
     * @param fromId 发送id
     * @param toId   接受id
     */
    long countUnreadChatMessage(Integer fromId, Integer toId);

    /**
     * 清除未读消息历史
     *
     * @param query 查询
     */
    void clearUnreadChatMessage(ChatMessageQuery query);

    /**
     * 删除聊天消息
     *
     * @param ids id
     * @return
     */
    void deleteChatMessage(List<Integer> ids);

}
