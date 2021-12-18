package com.simple.chat.utils;

import com.alibaba.fastjson.JSON;
import com.simple.chat.server.handler.message.Msg;
import com.simple.chat.server.handler.message.MsgCode;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.NonNull;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChannelUtils {

    //定义一个Map结构存储userID映射到channel
    private static final Map<String, Channel> userIdChannel = new ConcurrentHashMap<>();

    public static void saveChannel(String userId, Channel channel) {
        userIdChannel.put(userId, channel);
    }

    //当用户退出后删除用户channel
    public static void removeChannel(String userId){

        if(userIdChannel.containsKey(userId)){
            userIdChannel.remove(userId);
        }
    }

    //通过userId查找channel
    public static Channel getChannel(String userId){
        return userIdChannel.get(userId);
    }

    public static Collection<Channel> getChannels(){
        return userIdChannel.values();
    }

    /**
     * 像所有Channnel中发送消息
     * @param msg
     */
    public static void notify(Msg msg) {
        getChannels().forEach(channel -> {
            channel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(msg)));
        });
    }

    public static void removeAndNotify(@NonNull String userId) {
        removeChannel(userId);

        Msg msg = new Msg();
        msg.setFromId(userId);
        msg.setType(MsgCode.LOGOUT_MSG);
        notify(msg);
    }

}
