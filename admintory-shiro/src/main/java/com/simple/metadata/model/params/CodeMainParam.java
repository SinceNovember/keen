package com.simple.metadata.model.params;

import com.simple.common.model.dto.base.InputConverter;
import com.simple.metadata.model.entity.CodeMain;
import lombok.Data;

@Data
public class CodeMainParam implements InputConverter<CodeMain> {

    private Long codeId;

    private String codeName;

    private String description;

    private Integer orderNum;

}
