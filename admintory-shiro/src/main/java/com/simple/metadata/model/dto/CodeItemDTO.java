package com.simple.metadata.model.dto;

import com.simple.common.model.dto.base.OutputConverter;
import com.simple.metadata.model.entity.CodeItem;
import lombok.Data;

@Data
public class CodeItemDTO implements OutputConverter<CodeItemDTO, CodeItem> {

    private Long itemId;

    private String itemText;

    private String itemValue;

    private Integer orderNum;

    private Long codeId;
}
