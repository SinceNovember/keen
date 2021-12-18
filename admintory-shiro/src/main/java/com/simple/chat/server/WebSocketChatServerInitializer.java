package com.simple.chat.server;

import com.simple.chat.server.handler.OAuthFilterHandler;
import com.simple.chat.server.handler.TextToMessageHandler;
import com.simple.chat.server.handler.WebSocketMessageHandler;
import io.netty.channel.*;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
@ChannelHandler.Sharable
public class WebSocketChatServerInitializer extends ChannelInitializer<Channel> {

    @Resource
    private OAuthFilterHandler oAuthFilterHandler;

    @Resource
    private TextToMessageHandler textToMessageHandler;

    @Resource
    private WebSocketMessageHandler webSocketMessageHandler;

    @Override
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();

        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new HttpObjectAggregator(64 * 1024));
        pipeline.addLast(new ChunkedWriteHandler());
//        pipeline.addLast(new HttpRequestHandler("/ws"));
        pipeline.addLast(oAuthFilterHandler);
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        pipeline.addLast(textToMessageHandler);
        pipeline.addLast(webSocketMessageHandler);

    }
}
