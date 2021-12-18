package com.simple.chat.server.handler;

import com.simple.common.utils.JsonUtils;
import com.simple.chat.server.handler.message.Msg;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 将文本节解码为Message
 */
@Component
@ChannelHandler.Sharable
public class TextToMessageHandler extends MessageToMessageDecoder<TextWebSocketFrame> {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame, List<Object> list) throws Exception {
        String text = textWebSocketFrame.text();
        list.add(JsonUtils.jsonToPojo(text, Msg.class));
    }
}
