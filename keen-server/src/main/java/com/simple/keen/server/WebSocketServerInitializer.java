package com.simple.keen.server;

import com.simple.keen.server.handler.AuthFilterHandler;
import com.simple.keen.server.handler.TextToMessageHandler;
import com.simple.keen.server.handler.WebSocketMessageHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketFrameDecoder;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketServerCompressionHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
        channel.pipeline()
            .addLast(new LoggingHandler(LogLevel.TRACE))
            // HttpRequestDecoder和HttpResponseEncoder的一个组合，针对http协议进行编解码
            .addLast(new HttpServerCodec())
            // 分块向客户端写数据，防止发送大文件时导致内存溢出， channel.write(new ChunkedFile(new File("bigFile.mkv")))
            .addLast(new ChunkedWriteHandler())
            // 将HttpMessage和HttpContents聚合到一个完成的 FullHttpRequest或FullHttpResponse中,具体是FullHttpRequest对象还是FullHttpResponse对象取决于是请求还是响应
            // 需要放到HttpServerCodec这个处理器后面
            .addLast(new HttpObjectAggregator(10240))
            // webSocket 数据压缩扩展，当添加这个的时候WebSocketServerProtocolHandler的第三个参数需要设置成true
            .addLast(new WebSocketServerCompressionHandler())
            .addLast(authFilterHandler)
            // 服务器端向外暴露的 web socket 端点，当客户端传递比较大的对象时，maxFrameSize参数的值需要调大
            .addLast(new WebSocketServerProtocolHandler("/ws", null, true, 2 << 20))
            // 自定义处理器 - 处理 web socket 文本消息
            .addLast(textToMessageHandler)
            // 自定义处理器 - 处理 web socket 二进制消息
            .addLast(webSocketMessageHandler);
    }

}
