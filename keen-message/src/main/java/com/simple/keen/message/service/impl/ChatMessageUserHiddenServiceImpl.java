package com.simple.keen.message.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simple.keen.message.mapper.ChatMessageUserHiddenMapper;
import com.simple.keen.message.model.entity.ChatMessageUserHidden;
import com.simple.keen.message.model.query.ChatMessageQuery;
import com.simple.keen.message.service.IChatMessageUserHiddenService;
import org.springframework.stereotype.Service;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/3/25
 */
@Service
public class ChatMessageUserHiddenServiceImpl extends
    ServiceImpl<ChatMessageUserHiddenMapper, ChatMessageUserHidden> implements
    IChatMessageUserHiddenService {

    @Override
    public void addContactUserHidden(ChatMessageQuery query) {
        ChatMessageUserHidden messageUserHidden = new ChatMessageUserHidden();
        messageUserHidden.setFromId(StpUtil.getLoginIdAsInt());
        messageUserHidden.setToId(query.getToId());
        this.save(messageUserHidden);
    }

    @Override
    public void deleteContactUserHidden(ChatMessageQuery query) {
        this.remove(Wrappers.<ChatMessageUserHidden>lambdaQuery()
            .eq(ChatMessageUserHidden::getFromId, StpUtil.getLoginIdAsInt())
            .eq(ChatMessageUserHidden::getToId, query.getToId()));
    }
}
