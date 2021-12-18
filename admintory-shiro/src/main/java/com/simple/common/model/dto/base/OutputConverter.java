package com.simple.common.model.dto.base;

import com.simple.common.utils.ConvertUtils;
import org.springframework.lang.NonNull;

public interface OutputConverter <DTO extends OutputConverter<DTO,DOMAIN>,DOMAIN>{

    //<T extends DTO> 限定了返回的类型界限必须即形成了DTO的类型，例如DTO为BlogDTO,则返回为BLogDTO
    default  <T extends DTO> T covertFrom(@NonNull DOMAIN domain) {
        ConvertUtils.updateProperties(domain,this);
        return (T) this;
    }
}
