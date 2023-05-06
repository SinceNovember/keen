package com.simple.keen.common.base.enums;

import org.springframework.util.Assert;

import java.util.stream.Stream;

/**
 * 枚举值转换基本接口 .
 *
 * @author SinceNovember
 * @date 2022/11/02
 */
public interface ValueEnum<T> {

    /*
    用于查找指定类中的对应enum 并返回
    传(LogType.class,0)
    返回BLOG_INITIALIZED枚举
     */
    static <V, E extends ValueEnum<V>> E valueToEnum(Class<E> enumType, V value) {
        Assert.notNull(enumType, "Enum type must not be null");
        Assert.notNull(value, "value must not be null");
        Assert.isTrue(enumType.isEnum(), "Type must be an enum type");

        return Stream.of(enumType.getEnumConstants())
            .filter(item -> String.valueOf(item.getValue()).equals(String.valueOf(value)))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Unknown database value: " + value));
    }

    T getValue();
}
