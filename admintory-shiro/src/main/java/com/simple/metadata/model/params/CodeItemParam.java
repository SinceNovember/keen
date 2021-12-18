package com.simple.metadata.model.params;

import com.simple.common.model.dto.base.InputConverter;
import com.simple.metadata.model.entity.CodeItem;
import lombok.Data;

@Data
public class CodeItemParam implements InputConverter<CodeItem> {

    private Long itemId;

    private String itemText;

    private String itemValue;

    private Integer orderNum;

    private Long codeId;
}
