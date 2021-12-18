package com.simple.chat.server.handler.message;

import com.simple.chat.server.handler.WebSocketMessageHandler;
import io.netty.channel.group.ChannelGroup;
import org.springframework.stereotype.Component;

@Component
public abstract class CommonMsgHandler implements MsgHandler{

    protected ChannelGroup getChannels(){
        return WebSocketMessageHandler.channels;
    }

}
