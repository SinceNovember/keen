package com.simple.keen.server.message.handler;

import com.simple.keen.common.utils.ThreadLocalUtils;
import com.simple.keen.server.message.Message;
import com.simple.keen.server.utils.ChannelUtils;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.stereotype.Component;

/**
 * 处理登录的消息请求，主要是为了加入到ChannelGroup中
 *
 * @author SinceNovember
 * @date 2023/3/15
 */
@Component("LOGIN")
public class LoginMessageHandler extends CommonMessageHandler {

    @Override
    public void handleMessage(ChannelHandlerContext ctx, Message message) {
        ChannelUtils.saveAndNotify(ThreadLocalUtils.get("userId"), message, ctx.channel());
    }

}
