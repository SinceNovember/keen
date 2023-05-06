package com.simple.keen.message.model.enums;

import com.simple.keen.common.base.enums.ValueEnum;
import java.util.Arrays;
import java.util.Objects;
import lombok.RequiredArgsConstructor;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/4/3
 */
@RequiredArgsConstructor
public enum NotificationMessageType implements ValueEnum<Integer> {

    DEFAULT(0, "默认"),
    SUCCESS(1, "成功"),
    INFO(2, "信息"),
    WARNING(3, "警告"),
    ERROR(4, "错误");

    private final Integer value;

    private final String msg;


    @Override
    public Integer getValue() {
        return value;
    }

    public static NotificationMessageType convert(String name) {
        return Arrays.stream(NotificationMessageType.values())
                .filter(type -> Objects.equals(type.name(), name))
                .findFirst()
                .get();
    }

}
