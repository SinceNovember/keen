package com.simple.keen.message.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageSerializable;
import com.simple.keen.common.consts.Consts;
import com.simple.keen.common.utils.OnlineUtils;
import com.simple.keen.common.utils.PageHelperUtils;
import com.simple.keen.message.mapper.ChatMessageMapper;
import com.simple.keen.message.mapping.ChatMessageMapping;
import com.simple.keen.message.model.entity.ChatMessage;
import com.simple.keen.message.model.entity.ChatMessageUserHidden;
import com.simple.keen.message.model.enums.ChatMessageReadType;
import com.simple.keen.message.model.query.ChatMessagePageQuery;
import com.simple.keen.message.model.query.ChatMessageQuery;
import com.simple.keen.message.model.vo.ChatMessageContactUserVO;
import com.simple.keen.message.model.vo.ChatMessagePageVO;
import com.simple.keen.message.model.vo.ChatMessageVO;
import com.simple.keen.message.service.IChatMessageService;
import com.simple.keen.message.service.IChatMessageUserHiddenService;
import com.simple.keen.system.mapping.UserMapping;
import com.simple.keen.system.model.dto.UserDTO;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/3/18
 */
@Service
@RequiredArgsConstructor
public class ChatMessageImpl extends ServiceImpl<ChatMessageMapper, ChatMessage> implements
    IChatMessageService {

    private final IChatMessageUserHiddenService messageUserHiddenService;

    private static final int TIME_LINE_SEPARATE_MINUTES = 3;

    @Override
    public PageSerializable<ChatMessagePageVO> pageChatMessage(ChatMessagePageQuery query) {
        PageHelperUtils.startPage(query, Consts.CREATE_TIME_FIELD);
        return PageHelperUtils.convertPageDto2Vo(baseMapper.selectChatMessageList(query),
            ChatMessageMapping.INSTANCE::toChatMessagePageVOList);
    }

    @Override
    public List<ChatMessageContactUserVO> listContactUserAndChatMessage() {
        List<UserDTO> userDTOList = baseMapper.selectContactUserListByUserId(
            StpUtil.getLoginIdAsInt());
        return userDTOList.stream()
            .map(userDTO -> {
                ChatMessageContactUserVO contactUserMessageVO = new ChatMessageContactUserVO();
                contactUserMessageVO.setUser(UserMapping.INSTANCE.toUserVO(userDTO));
                //设置联系人是否隐藏
                contactUserMessageVO.setHidden(
                    messageUserHiddenService.count(
                        Wrappers.<ChatMessageUserHidden>lambdaQuery()
                            .eq(ChatMessageUserHidden::getFromId,
                                StpUtil.getLoginIdAsInt())
                            .eq(ChatMessageUserHidden::getToId, userDTO.getId()))
                        > 0);
                //设置消息列表
                contactUserMessageVO.setMessageList(
                    ChatMessageMapping.INSTANCE.INSTANCE.toChatMessageVOList(
                        baseMapper.selectChatMessageByFromAndToId(
                            StpUtil.getLoginIdAsInt(), userDTO.getId())));
                //设置对该用户是否有未读的消息数
                contactUserMessageVO.setUnreadMessageCount(
                    countUnreadChatMessage(userDTO.getId(), StpUtil.getLoginIdAsInt()));
                //设置是否在线
                contactUserMessageVO.getUser().setOnline(OnlineUtils.isOnline(userDTO.getId()));
                //添加时间线
                lookupChatMessageTimeLine(contactUserMessageVO.getMessageList());
                return contactUserMessageVO;
            })
            .sorted(Comparator.<ChatMessageContactUserVO, LocalDateTime>comparing(
                user -> user.getMessageList()
                    .get(user.getMessageList().size() - 1)
                    .getCreateTime()).reversed())
            .collect(Collectors.toList());

    }

    private void lookupChatMessageTimeLine(List<ChatMessageVO> messageHistoryVOList) {
        if (CollectionUtil.isNotEmpty(messageHistoryVOList)) {
            for (int i = 0; i < messageHistoryVOList.size(); i++) {
                if (i == 0 || (Duration.between(
                    messageHistoryVOList.get(i - 1).getCreateTime(),
                    messageHistoryVOList.get(i).getCreateTime()).toMinutes()
                    > TIME_LINE_SEPARATE_MINUTES)) {
                    messageHistoryVOList.get(i).setTimeLine(
                        LocalDateTimeUtil.format(messageHistoryVOList.get(i).getCreateTime(),
                            LocalDateTimeUtil.isSameDay(LocalDateTime.now(),
                                messageHistoryVOList.get(i).getCreateTime())
                                ? "HH:mm" : "MM-dd HH:mm"));
                }
            }
        }
    }

    @Override
    public long countUnreadChatMessage(Integer fromId, Integer toId) {
        return count(Wrappers.<ChatMessage>lambdaQuery()
            .eq(fromId != null, ChatMessage::getFromId, fromId)
            .eq(ChatMessage::getToId, toId)
            .eq(ChatMessage::getIsRead, ChatMessageReadType.UNREAD));
    }

    @Override
    public void clearUnreadChatMessage(ChatMessageQuery query) {
        update(Wrappers.<ChatMessage>lambdaUpdate()
            .set(ChatMessage::getIsRead, ChatMessageReadType.READ)
            .eq(ChatMessage::getFromId, query.getFromId())
            .eq(ChatMessage::getToId, StpUtil.getLoginIdAsInt()));
    }

    @Override
    public void deleteChatMessage(List<Integer> ids) {
        this.removeByIds(ids);
    }

}
