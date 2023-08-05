package com.simple.keen.server.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.simple.keen.server.message.Message;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 将文本节解码为Message
 *
 * @author SinceNovember
 * @date 2023/3/15
 */
@Component
@ChannelHandler.Sharable
public class TextToMessageHandler extends MessageToMessageDecoder<TextWebSocketFrame> {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext,
        TextWebSocketFrame textWebSocketFrame, List<Object> list) {
        list.add(JSON.parseObject(textWebSocketFrame.text(), Message.class));
    }

}
