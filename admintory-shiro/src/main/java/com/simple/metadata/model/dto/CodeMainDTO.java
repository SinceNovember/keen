package com.simple.metadata.model.dto;

import com.simple.common.model.dto.base.OutputConverter;
import com.simple.metadata.model.entity.CodeMain;
import lombok.Data;

@Data
public class CodeMainDTO implements OutputConverter<CodeMainDTO, CodeMain> {

    private Long codeId;

    private String codeName;

    private String description;

    private Integer orderNum;

}
