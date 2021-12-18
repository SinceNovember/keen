package com.simple.chat.model.enums;

import com.simple.system.model.enums.ValueEnum;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MsgType implements ValueEnum<Integer> {

    TEXT(1,"文本"),
    PIC(2,"图片");

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
