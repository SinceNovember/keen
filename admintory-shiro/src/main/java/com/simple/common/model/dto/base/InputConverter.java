package com.simple.common.model.dto.base;

import com.simple.common.utils.ConvertUtils;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public interface InputConverter<DOMAIN> {
    default DOMAIN convertTo() {
        Class<DOMAIN> currentType = (Class<DOMAIN>)parameterizedType(0);

        return ConvertUtils.transformFrom(this, currentType);

    }

    @Nullable
    default Type parameterizedType(int index) {
        Assert.isTrue(index >= 0 && index <= 1, "type index must be between 0 to 1");
        return ((ParameterizedType) this.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[index];

    }
}
