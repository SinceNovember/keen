package com.simple.keen.server.message.handler;

import com.simple.keen.server.message.Message;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.stereotype.Component;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/3/15
 */
@Component("GROUP")
public class GroupMessageHandler extends CommonMessageHandler {

    @Override
    public void handleMessage(ChannelHandlerContext ctx, Message msg) {
        Channel incoming = ctx.channel();
        for (Channel channel : getChannels()) {
            if (channel != incoming) {
                channel.writeAndFlush(new TextWebSocketFrame(
                    "[" + incoming.remoteAddress() + "]" + msg.getContent()));
            } else {
                channel.writeAndFlush(new TextWebSocketFrame("[you]" + msg.getContent()));
            }
        }
    }

}
