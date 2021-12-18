package com.simple.common.factory;

import com.simple.system.model.enums.ValueEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * 字符串转枚举类型工厂
 */
public class StringToEnumConverterFactory implements ConverterFactory<String, ValueEnum> {

    /*
    T为ValueEnum的子类行 即枚举类
     */
    @Override
    public <T extends ValueEnum> Converter getConverter(Class<T> targetType) {
        return new StringToEnumConvert(targetType);
    }

    private static class StringToEnumConvert<T extends ValueEnum> implements  Converter<String ,T>{

        private Class<T> enumType;

        public StringToEnumConvert(Class<T> enumType) {
                this.enumType = enumType;
        }
        @Override
        public T convert(String source) {
            return (T) T.valueToEnum(this.enumType,source);
        }
    }
}
