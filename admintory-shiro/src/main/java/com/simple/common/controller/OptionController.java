package com.simple.common.controller;

import com.simple.common.model.constant.CommonConstant;
import com.simple.common.model.entity.Response;
import com.simple.common.model.entity.ResponseData;
import com.simple.metadata.service.CodeItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/api/option")
public class OptionController {

    @Resource
    private CodeItemService codeItemService;

    @GetMapping("/sex")
    public ResponseData getSexOption(){
        return Response.ok(codeItemService.listCodeItemMapByCodeName(CommonConstant.SEX_OPTION));
    }

    @GetMapping("/status")
    public ResponseData getStatusOption(){
        return Response.ok(codeItemService.listCodeItemMapByCodeName(CommonConstant.STATUS_OPTION));
    }
}
