package com.simple.keen.message.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.simple.keen.message.model.entity.ChatMessageUserHidden;
import com.simple.keen.message.model.query.ChatMessageQuery;

public interface IChatMessageUserHiddenService extends IService<ChatMessageUserHidden> {

    void addContactUserHidden(ChatMessageQuery query);

    void deleteContactUserHidden(ChatMessageQuery query);

}
