package com.simple.metadata.controller.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.simple.common.annotation.ControllerEndpoint;
import com.simple.common.model.constant.CommonConstant;
import com.simple.common.model.constant.Strings;
import com.simple.common.model.entity.Response;
import com.simple.common.model.entity.ResponseData;
import com.simple.metadata.model.dto.CodeItemDTO;
import com.simple.metadata.model.entity.CodeItem;
import com.simple.metadata.model.params.CodeItemParam;
import com.simple.metadata.model.vo.CodeItemCondition;
import com.simple.metadata.service.CodeItemService;
import lombok.NonNull;
import org.apache.shiro.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/api/metadata/code/item")
public class CodeItemController {

    @Resource
    private CodeItemService codeItemService;

    @GetMapping("/list")
    @ControllerEndpoint(exceptionMessage = "获取代码子项失败")
    public ResponseData listCodeItem(CodeItemCondition condition, @RequestParam(defaultValue = "1",value = "currentPage") Integer pageNumber, @RequestParam(defaultValue = "10") Integer pageSize){
        IPage<CodeItemDTO> configIPage = codeItemService.pageCodeItem(condition, pageNumber, pageSize);
        return Response.ok(configIPage);
    }

    @GetMapping
    @ControllerEndpoint(exceptionMessage = "获取代码子项失败")
    public ResponseData getCodeItem(@NonNull Integer itemId){
        CodeItemDTO configDTO = codeItemService.convertTo(codeItemService.getById(itemId));
        return Response.ok(configDTO);
    }

    @PostMapping
    @ControllerEndpoint(operation = "新增代码子项", exceptionMessage = "新增代码子项失败")
    public ResponseData addCodeItem(@NonNull @RequestBody CodeItemParam configParam){
        CodeItem codeItem = configParam.convertTo();
        codeItem.setCreateTime(new Date());
        codeItemService.save(codeItem);
        return Response.ok();
    }

    @PutMapping
    @ControllerEndpoint(operation = "修改代码子项", exceptionMessage = "修改代码子项")
    public ResponseData updateCodeItem(@NonNull @RequestBody CodeItemParam configParam){
        CodeItem codeItem = configParam.convertTo();
        codeItemService.updateById(codeItem);
        return Response.ok();
    }

    @DeleteMapping
    @ControllerEndpoint(operation = "删除代码子项", exceptionMessage = "删除代码子项")
    public ResponseData removeRole(@NonNull  @RequestParam("ids") String ids) {
        codeItemService.removeByIds(StringUtils.splitToSet(ids, Strings.COMMA));
        return Response.ok(CommonConstant.DELETE_SUCCESS_TEXT);
    }
}
