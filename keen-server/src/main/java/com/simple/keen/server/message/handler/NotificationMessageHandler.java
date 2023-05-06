package com.simple.keen.server.message.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.simple.keen.message.converter.NotificationMessageConverter;
import com.simple.keen.message.model.enums.MessageType;
import com.simple.keen.message.model.enums.NotificationMessageType;
import com.simple.keen.message.service.INotificationMessageService;
import com.simple.keen.server.message.Message;
import com.simple.keen.server.utils.ChannelUtils;
import io.netty.channel.ChannelHandlerContext;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 通知消息处理器
 *
 * @author SinceNovember
 * @date 2023/4/1
 */
@Slf4j
@Component("NOTIFICATION")
@RequiredArgsConstructor
public class NotificationMessageHandler extends CommonMessageHandler {

    private final INotificationMessageService notificationMessageService;

    @Override
    public void handleMessage(ChannelHandlerContext ctx, Message message) {
        Notification notification = JSON.parseObject(message.getContent(), Notification.class);
        notification.setNotificationTime(LocalDateTime.now());
        notification.setType(MessageType.NOTIFICATION);
        notificationMessageService.updateLastNotificationTime(notification.getId(),
            LocalDateTime.now());
        ChannelUtils.notify(JSON.toJSONString(notification));
    }

    @Data
    @ToString
    private static class Notification {

        private Integer id;

        private String title;

        private String content;

        @JSONField(serializeUsing = NotificationMessageConverter.class, deserializeUsing = NotificationMessageConverter.class)
        private NotificationMessageType notificationMessageType;

        private LocalDateTime notificationTime;

        private MessageType type;

    }

}
