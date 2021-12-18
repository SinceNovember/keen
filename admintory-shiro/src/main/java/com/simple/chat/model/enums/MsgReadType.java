package com.simple.chat.model.enums;

import com.simple.system.model.enums.ValueEnum;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MsgReadType  implements ValueEnum<Integer> {

    IS_READ(1,"已读"),
    NOT_READ(0,"未读");

    private final Integer value;
    private final String msg;

    @Override
    public Integer getValue() {
        return value;

    }

    public String getMsg() {
        return msg;
    }
}
