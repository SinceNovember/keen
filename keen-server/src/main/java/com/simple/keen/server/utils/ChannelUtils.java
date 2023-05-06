package com.simple.keen.server.utils;

import com.alibaba.fastjson.JSON;
import com.simple.keen.common.utils.OnlineUtils;
import com.simple.keen.common.utils.ThreadLocalUtils;
import com.simple.keen.server.message.Message;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import lombok.NonNull;

public class ChannelUtils {

    //定义一个Map结构存储userID映射到channel
    private static final Map<Integer, Channel> userIdChannel = new ConcurrentHashMap<>();

    public static void saveChannel(Integer userId, Channel channel) {
        userIdChannel.putIfAbsent(userId, channel);
        OnlineUtils.online(userId);
    }

    public static void saveAndNotify(Integer userId, Message message, Channel channel) {
        //设置登陆属性
        channel.attr(AttributeKeys.LOGIN).set(true);
        // 为channel添加userId属性，方便在删除channel时能快速从Map中查找并删除
        channel.attr(AttributeKeys.USER_ID).set(userId);
        notify(JSON.toJSONString(message));
        //保存到ChannelGroup中
        saveChannel(userId, channel);
    }

    //当用户退出后删除用户channel
    public static void removeChannel(Integer userId) {
        if (userIdChannel.containsKey(userId)) {
            userIdChannel.remove(userId);
        }
        OnlineUtils.offline(userId);
    }

    public static void removeAndNotify(@NonNull Integer userId, Message message) {
        removeChannel(userId);
        notify(JSON.toJSONString(message));
    }

    //通过userId查找channel
    public static Channel getChannel(Integer userId) {
        return userIdChannel.get(userId);
    }

    public static Collection<Channel> getChannels() {
        return userIdChannel.values();
    }

    public static void notify(String message) {
        notify(message, false);
    }

    /**
     * 通知
     *
     * @param message     消息
     * @param includeSelf 包含自己
     */
    public static void notify(String message, boolean includeSelf) {
        userIdChannel.entrySet().stream()
            .filter(channel -> includeSelf || !Objects.equals(
                channel.getKey(),
                ThreadLocalUtils.get("userId")))
            .map(Entry::getValue)
            .forEach(channel -> channel.writeAndFlush(
                new TextWebSocketFrame(message)));
    }


}
