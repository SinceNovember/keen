package com.simple.chat.server.handler.message;

import io.netty.channel.ChannelHandlerContext;

public interface MsgHandler {

    void handleMessage(ChannelHandlerContext ctx, Msg msg);
}
