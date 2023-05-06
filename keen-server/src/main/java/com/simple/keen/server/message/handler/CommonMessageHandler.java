package com.simple.keen.server.message.handler;

import com.simple.keen.server.handler.WebSocketMessageHandler;
import com.simple.keen.server.message.MessageHandler;
import io.netty.channel.group.ChannelGroup;
import org.springframework.stereotype.Component;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/3/15
 */
@Component
public abstract class CommonMessageHandler implements MessageHandler {

    protected ChannelGroup getChannels() {
        return WebSocketMessageHandler.channels;
    }

}
