package com.simple.keen.message.converter;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.simple.keen.message.model.enums.NotificationMessageType;
import java.io.IOException;
import java.lang.reflect.Type;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/4/3
 */
public class NotificationMessageConverter implements ObjectSerializer, ObjectDeserializer {

    @Override
    public <T> T deserialze(DefaultJSONParser parser, Type type, Object o) {
        Object value = parser.parse();
        return value == null ? null : (T) NotificationMessageType.convert(value.toString());
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }

    @Override
    public void write(JSONSerializer serializer, Object object, Object o1, Type type, int i)
        throws IOException {
        serializer.write(((NotificationMessageType) object).name());
    }
}
