package com.simple.keen.server.message.handler;

import com.simple.keen.server.message.Message;
import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 心跳消息处理器
 *
 * @author SinceNovember
 * @date 2023/3/20
 */
@Slf4j
@Component("HEARTBEAT")
@RequiredArgsConstructor
public class HeartbeatMessageHandler extends CommonMessageHandler {

    @Override
    public void handleMessage(ChannelHandlerContext ctx, Message message) {
        super.handleMessage(ctx, message);
    }

}
