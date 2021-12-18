package com.simple.chat.utils;

import io.netty.util.AttributeKey;

public class AttributeKeys {

    public static AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");

    public static AttributeKey<String> USER_ID = AttributeKey.newInstance("userId");

}
