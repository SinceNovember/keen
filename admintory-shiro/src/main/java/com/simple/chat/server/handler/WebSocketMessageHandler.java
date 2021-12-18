package com.simple.chat.server.handler;

import com.simple.chat.utils.AttributeKeys;
import com.simple.chat.server.handler.message.Msg;
import com.simple.chat.server.handler.message.MsgHandler;
import com.simple.chat.server.handler.message.MsgHandlerFactory;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
@ChannelHandler.Sharable
public class WebSocketMessageHandler extends SimpleChannelInboundHandler<Msg> {

    @Resource
    private MsgHandlerFactory msgHandlerFactory;

    //存放所有已经连接的Channel
    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Msg msg) throws Exception {
        handlerMsg(ctx, msg);
    }

    private void handlerMsg(ChannelHandlerContext ctx, Msg msg) {
        MsgHandler handler = msgHandlerFactory.getHandler(msg.getType());
        handler.handleMessage(ctx, msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        log.info("Client:" + incoming.remoteAddress() + "在线");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("用户{}断线",ctx.channel().attr(AttributeKeys.USER_ID).get());
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Channel incoming = ctx.channel();
        log.info("Client:" + incoming.remoteAddress() + "异常");
        cause.printStackTrace();
        ctx.close();
    }

}
