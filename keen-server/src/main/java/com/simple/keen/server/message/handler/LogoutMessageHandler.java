package com.simple.keen.server.message.handler;

import com.simple.keen.common.utils.ThreadLocalUtils;
import com.simple.keen.server.message.Message;
import com.simple.keen.server.utils.ChannelUtils;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.stereotype.Component;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/3/15
 */
@Component("LOGOUT")
public class LogoutMessageHandler extends CommonMessageHandler {

    @Override
    public void handleMessage(ChannelHandlerContext ctx, Message message) {
        ChannelUtils.removeAndNotify(ThreadLocalUtils.get("userId"), message);
    }

}
