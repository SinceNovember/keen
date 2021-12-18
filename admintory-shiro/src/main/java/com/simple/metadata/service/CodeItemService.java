package com.simple.metadata.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.simple.metadata.model.dto.CodeItemDTO;
import com.simple.metadata.model.entity.CodeItem;
import com.simple.metadata.model.vo.CodeItemCondition;

import java.util.List;
import java.util.Map;

public interface CodeItemService extends IService<CodeItem> {

    IPage<CodeItemDTO> pageCodeItem(CodeItemCondition condition, int pageIndex, int pageSize);

    void removeCodeItemByCodeId(Long codeId);

    List<Map<String, Object>> listCodeItemMapByCodeName(String codeName);

    CodeItemDTO convertTo(CodeItem CodeItem) ;

    List<CodeItemDTO> convertTo(List<CodeItem> CodeItem) ;
}
