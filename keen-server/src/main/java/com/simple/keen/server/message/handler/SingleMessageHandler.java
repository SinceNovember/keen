package com.simple.keen.server.message.handler;

import com.alibaba.fastjson.JSON;
import com.simple.keen.message.model.entity.ChatMessage;
import com.simple.keen.message.model.enums.ChatMessageReadType;
import com.simple.keen.message.service.IChatMessageService;
import com.simple.keen.server.message.Message;
import com.simple.keen.server.utils.ChannelUtils;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/3/15
 */
@Slf4j
@Component("SINGLE")
@RequiredArgsConstructor
public class SingleMessageHandler extends CommonMessageHandler {

    private final IChatMessageService chatMessageService;

    @Override
    public void handleMessage(ChannelHandlerContext ctx, Message message) {
        //获取接收方与服务器端连接的channel，并向接收方发送数据
        Channel channel = ChannelUtils.getChannel(message.getToId());
        if (channel != null) {
            channel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(message)))
                .addListener(future -> {
                    if (future.isSuccess()) {
                        addMessageHistory(message);
                    }
                });
        }
    }

    /**
     * 添加单人聊天的消息历史
     *
     * @param message 消息
     * @return
     */
    private void addMessageHistory(Message message) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setFromId(message.getFromId());
        chatMessage.setToId(message.getToId());
        chatMessage.setType(message.getType());
        chatMessage.setContentType(message.getContentType());
        chatMessage.setContent(message.getContent());
        chatMessage.setIsRead(ChatMessageReadType.UNREAD);
        chatMessage.setCreateTime(LocalDateTime.now());
        chatMessageService.save(chatMessage);
    }

}
