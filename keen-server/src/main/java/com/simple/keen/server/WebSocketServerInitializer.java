package com.simple.keen.server;

import com.simple.keen.server.handler.AuthFilterHandler;
import com.simple.keen.server.handler.TextToMessageHandler;
import com.simple.keen.server.handler.WebSocketMessageHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/3/14
 */
@Slf4j
@Component
@RequiredArgsConstructor
@ChannelHandler.Sharable
public class WebSocketServerInitializer extends ChannelInitializer<Channel> {

    private final AuthFilterHandler authFilterHandler;

    private final TextToMessageHandler textToMessageHandler;

    private final WebSocketMessageHandler webSocketMessageHandler;

    @Override
    protected void initChannel(Channel channel) {
        ChannelPipeline pipeline = channel.pipeline();
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new HttpObjectAggregator(64 * 1024));
        pipeline.addLast(new ChunkedWriteHandler());
//        pipeline.addLast(new HttpRequestHandler("/ws"));
        pipeline.addLast(authFilterHandler);
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        pipeline.addLast(textToMessageHandler);
        pipeline.addLast(webSocketMessageHandler);
    }

}
