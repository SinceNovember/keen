package com.simple.chat.server.handler.message;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.stereotype.Component;

@Component("GROUP_MSG")
public class GroupMsgHandler extends CommonMsgHandler{
    @Override
    public void handleMessage(ChannelHandlerContext ctx, Msg msg) {
        Channel incoming = ctx.channel();
        for (Channel channel : getChannels()) {
            if (channel != incoming) {
                channel.writeAndFlush(new TextWebSocketFrame("[" + incoming.remoteAddress() + "]" + msg.getContent()));
            } else {
                channel.writeAndFlush(new TextWebSocketFrame("[you]" + msg.getContent()));
            }
        }
    }
}
