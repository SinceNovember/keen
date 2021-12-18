package com.simple.chat.server.handler.message;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 消息工厂
 */
@Component
public class MsgHandlerFactory {

    @Resource
    private Map<String, MsgHandler> context = new ConcurrentHashMap<>();

    public MsgHandler getHandler(MsgCode code) {
        return context.get(code.name());
    }
}
