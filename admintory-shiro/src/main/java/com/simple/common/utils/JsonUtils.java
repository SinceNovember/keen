package com.simple.common.utils;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

@Slf4j
public class JsonUtils {

    /**
     * 对象转换成json字符串
     * @param object
     * @return
     */
    public static String objectToJson(Object object) {
        Assert.notNull(object, "object must not be null");
        try {
            return JSON.toJSONString(object);
        } catch (Exception e) {
            log.error("转换成Json字符串失败");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * json转成Bean
     * @param json
     * @param beanClass
     * @param <T>
     * @return
     */
    public static <T> T jsonToPojo(String json, Class<T> beanClass) {
        Assert.notNull(json, "json must not be null");
        Assert.notNull(beanClass, "beanClass object must not be null");
        try {
            return JSON.parseObject(json, beanClass);
        } catch (Exception e) {
            log.error("Json转换Bean失败");
            e.printStackTrace();
        }
        return null;
    }
}
