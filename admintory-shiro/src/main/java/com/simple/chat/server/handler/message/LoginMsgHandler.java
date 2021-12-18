package com.simple.chat.server.handler.message;

import com.simple.chat.utils.AttributeKeys;
import com.simple.chat.utils.ChannelUtils;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.stereotype.Component;

/**
 * 处理登录的消息请求，主要是为了加入到ChannelGroup中
 */
@Component("LOGIN_MSG")
public class LoginMsgHandler extends CommonMsgHandler{
    @Override
    public void handleMessage(ChannelHandlerContext ctx, Msg msg) {

        //给其他在线的用户发送该用户登陆信息
        ChannelUtils.notify(msg);
        //设置登陆属性
        ctx.channel().attr(AttributeKeys.LOGIN).set(true);
        // 为channel添加userId属性，方便在删除channel时能快速从Map中查找并删除
        ctx.channel().attr(AttributeKeys.USER_ID).set(msg.getFromId());
        //保存到ChannelGroup中
        ChannelUtils.saveChannel(msg.getFromId(), ctx.channel());
    }
}
