package com.simple.keen.message.model.enums;

import com.simple.keen.common.base.enums.ValueEnum;
import lombok.RequiredArgsConstructor;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/3/18
 */
@RequiredArgsConstructor
public enum ChatMessageContentType implements ValueEnum<Integer> {

    TEXT(1, "文本"),
    IMAGE(2, "图片");

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
