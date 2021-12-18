package com.simple.common.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

public class ConvertUtils {
    private ConvertUtils(){
    }

    public static <T> T transformFrom(@Nullable Object source, @NonNull Class<T> targetClass) {
        Assert.notNull(targetClass, "Target class must not be null");
        if (source == null) {
            return null;
        }
        try {
            T targetInstance = targetClass.newInstance();
            updateProperties(source,targetInstance);
            return targetInstance;
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to new " + targetClass.getName() + " instance or copy properties", e);
        }
    }

    /*
    将source上的属性复制到target上
     */
    public static void updateProperties(@NonNull Object source, @NonNull Object target) {
        Assert.notNull(source, "source object must not be null");
        Assert.notNull(target, "target object must not be null");

        try {
            BeanUtils.copyProperties(source, target,getNullPropertyNames(source));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private static String[] getNullPropertyNames(@NonNull Object source) {
        return getNullPropertyNameSet(source).toArray(new String[0]);
    }
    /*
    获取source中值为空的属性名
     */
    private static Set<String> getNullPropertyNameSet(@NonNull Object source) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(source);
        //获取所有的属性
        PropertyDescriptor[] propertyDescriptors = beanWrapper.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            String propertyName = propertyDescriptor.getName();
            Object propertyValue = beanWrapper.getPropertyValue(propertyName);

            //如果属性值为空，加入Set,用于上面复制参数时进行忽略
            if (propertyValue == null) {
                emptyNames.add(propertyName);
            }
        }
        return emptyNames;
    }
}
