package com.simple.chat.server.handler.message;

import com.alibaba.fastjson.JSON;
import com.simple.chat.service.MsgHistoryService;
import com.simple.chat.utils.ChannelUtils;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 私聊消息处理
 */
@Slf4j
@Component("SINGLE_MSG")
public class SingleMsgHandler extends CommonMsgHandler{

    @Resource
    private MsgHistoryService msgHistoryService;

    @Override
    public void handleMessage(ChannelHandlerContext ctx, Msg msg) {
        //获取接收方与服务器端连接的channel，并向接收方发送数据
        Channel channel = ChannelUtils.getChannel(msg.getToId());
        if(channel != null){
            channel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(msg))).addListener(future -> {
                log.info("发送给对方消息{}", msg);
            });
        }
        msgHistoryService.saveMsg(msg);
    }

}
