package com.simple.keen.server.message;

import io.netty.channel.ChannelHandlerContext;

/**
 * 消息处理接口
 *
 * @author SinceNovember
 * @date 2023/03/15
 */
public interface MessageHandler {

    default void handleMessage(ChannelHandlerContext ctx, Message message) {
        ctx.fireChannelRead(message);
    }

}
