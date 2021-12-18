package com.simple.system.model.enums;

import org.springframework.util.Assert;

import java.util.stream.Stream;

public interface ValueEnum<T> {
    /*
    用于查找指定类中的对应enum 并返回
    传(LogType.class,0)
    返回BLOG_INITIALIZED枚举
     */
    static <V, E extends ValueEnum<V>> E valueToEnum(Class<E> enumType, V value ){
        Assert.notNull(enumType, "enum type must not be null");
        Assert.notNull(value, "value must not be null");
        Assert.isTrue(enumType.isEnum(), "type must be an enum type");

        return  Stream.of(enumType.getEnumConstants()).filter(item -> String.valueOf(item.getValue()).equals(String.valueOf(value)))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("unknown database value: " + value));
    }

    T getValue();
}
