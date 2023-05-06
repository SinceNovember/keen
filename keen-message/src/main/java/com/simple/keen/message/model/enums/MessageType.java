package com.simple.keen.message.model.enums;

import com.simple.keen.common.base.enums.ValueEnum;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/3/15
 */
@AllArgsConstructor
public enum MessageType implements ValueEnum {

    LOGIN(0, "登录"),
    SINGLE(1, "私聊"),
    GROUP(2, "群聊"),
    NOTIFICATION(8, "通知"),
    HEARTBEAT(9, "心跳"),
    LOGOUT(-1, "退出");

    private final int code;

    private final String text;

    private static final Map<Integer, MessageType> CODE_MAP = new HashMap<>();

    static {
        Arrays.stream(MessageType.values()).forEach(msgCode -> {
            CODE_MAP.put(msgCode.getCode(), msgCode);
        });
    }

    public int getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public static MessageType getMessageCode(int code) {
        return CODE_MAP.get(code);
    }

    @Override
    public Object getValue() {
        return code;
    }

}
