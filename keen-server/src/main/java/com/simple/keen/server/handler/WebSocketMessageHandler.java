package com.simple.keen.server.handler;

import com.simple.keen.common.utils.ThreadLocalUtils;
import com.simple.keen.server.message.Message;
import com.simple.keen.server.message.MessageHandler;
import com.simple.keen.message.model.enums.MessageType;
import com.simple.keen.server.message.handler.MessageHandlerFactory;
import com.simple.keen.server.utils.AttributeKeys;
import com.simple.keen.server.utils.ChannelUtils;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
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
@Component
@RequiredArgsConstructor
@ChannelHandler.Sharable
public class WebSocketMessageHandler extends SimpleChannelInboundHandler<Message> {

    private final MessageHandlerFactory handlerFactory;

    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Message message) {
        handleMessage(channelHandlerContext, message);
    }

    private void handleMessage(ChannelHandlerContext ctx, Message message) {
        message.setFromId(ThreadLocalUtils.get("userId"));
        MessageHandler handler = handlerFactory.getHandler(message.getType());
        handler.handleMessage(ctx, message);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        Channel incoming = ctx.channel();
        log.info("Client:" + incoming.remoteAddress() + "在线");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        Message message = new Message();
        message.setFromId(ThreadLocalUtils.get("userId"));
        message.setType(MessageType.LOGOUT);
        ChannelUtils.removeAndNotify(ThreadLocalUtils.get("userId"), message);
        log.info("用户{}断线", ctx.channel().attr(AttributeKeys.USER_ID).get());
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        Channel incoming = ctx.channel();
        log.info("Client:" + incoming.remoteAddress() + "异常");
        cause.printStackTrace();
        ctx.close();
    }

}
