package com.simple.keen.server.utils;

import io.netty.util.AttributeKey;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/3/15
 */
public class AttributeKeys {

    public static AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");

    public static AttributeKey<Integer> USER_ID = AttributeKey.newInstance("userId");

}
