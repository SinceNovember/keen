package com.simple.metadata.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.simple.metadata.model.dto.CodeMainDTO;
import com.simple.metadata.model.entity.CodeMain;
import com.simple.metadata.model.vo.CodeMainCondition;

import java.util.List;
import java.util.Set;

public interface CodeMainService extends IService<CodeMain> {

    IPage<CodeMainDTO> pageCodeMain(CodeMainCondition condition, int pageIndex, int pageSize);

    void removeCodeMainWithItem(Set<String> codeIdList);

    CodeMainDTO convertTo(CodeMain CodeMain) ;

    List<CodeMainDTO> convertTo(List<CodeMain> CodeMain) ;
}
