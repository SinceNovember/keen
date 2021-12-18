package com.simple.metadata.controller.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.simple.common.annotation.ControllerEndpoint;
import com.simple.common.model.constant.CommonConstant;
import com.simple.common.model.constant.Strings;
import com.simple.common.model.entity.Response;
import com.simple.common.model.entity.ResponseData;
import com.simple.metadata.model.dto.CodeMainDTO;
import com.simple.metadata.model.entity.CodeMain;
import com.simple.metadata.model.params.CodeMainParam;
import com.simple.metadata.model.vo.CodeMainCondition;
import com.simple.metadata.service.CodeMainService;
import lombok.NonNull;
import org.apache.shiro.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/api/metadata/code/main")
public class CodeMainController {

    @Resource
    private CodeMainService codeMainService;

    @GetMapping("/list")
    @ControllerEndpoint(exceptionMessage = "获取代码项列表失败")
    public ResponseData listCodeMain(CodeMainCondition condition, @RequestParam(defaultValue = "1",value = "currentPage") Integer pageNumber, @RequestParam(defaultValue = "10") Integer pageSize){
        IPage<CodeMainDTO> configIPage = codeMainService.pageCodeMain(condition, pageNumber, pageSize);
        return Response.ok(configIPage);
    }

    @GetMapping
    @ControllerEndpoint(exceptionMessage = "获取代码项失败")
    public ResponseData getCodeMain(@NonNull Integer codeId){
        CodeMainDTO configDTO = codeMainService.convertTo(codeMainService.getById(codeId));
        return Response.ok(configDTO);
    }

    @PostMapping
    @ControllerEndpoint(operation = "新增代码项", exceptionMessage = "新增代码项失败")
    public ResponseData addCodeMain(@NonNull @RequestBody CodeMainParam configParam){
        CodeMain codeMain = configParam.convertTo();
        codeMain.setCreateTime(new Date());
        codeMainService.save(codeMain);
        return Response.ok();
    }

    @PutMapping
    @ControllerEndpoint(operation = "修改代码项", exceptionMessage = "修改代码项")
    public ResponseData updateCodeMain(@NonNull @RequestBody CodeMainParam configParam){
        CodeMain CodeMain = configParam.convertTo();
        codeMainService.updateById(CodeMain);
        return Response.ok();
    }

    @DeleteMapping
    @ControllerEndpoint(operation = "删除代码项", exceptionMessage = "删除代码项")
    public ResponseData removeRole(@NonNull  @RequestParam("ids") String ids) {
        codeMainService.removeCodeMainWithItem(StringUtils.splitToSet(ids, Strings.COMMA));
        return Response.ok(CommonConstant.DELETE_SUCCESS_TEXT);
    }
}
