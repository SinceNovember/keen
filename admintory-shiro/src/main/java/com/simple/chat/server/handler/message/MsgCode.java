package com.simple.chat.server.handler.message;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public enum  MsgCode {
    LOGIN_MSG(0, "登录"),
    SINGLE_MSG(1, "私聊"),
    GROUP_MSG(2, "群聊"),
    LOGOUT_MSG(-1, "退出");
    private final int code;

    private final String text;

    private static final Map<Integer, MsgCode> CODE_MAP = new HashMap<Integer, MsgCode>();

    static {
        Arrays.stream(MsgCode.values()).forEach(msgCode -> {
            CODE_MAP.put(msgCode.getCode(), msgCode);
        });
    }


    public int getCode() {
        return code;
    }

    public String getText() {
        return text;
    }
    public static MsgCode getMsgCode(int code){
        return CODE_MAP.get(code);
    }
}