package com.simple.chat.server.handler.message;

import com.simple.chat.utils.ChannelUtils;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.stereotype.Component;

/**
 * 退出登陆消息处理
 */
@Component("LOGOUT_MSG")
public class LogoutMsgHandler extends CommonMsgHandler{
    @Override
    public void handleMessage(ChannelHandlerContext ctx, Msg msg) {
        ChannelUtils.removeAndNotify(msg.getFromId());

    }
}
