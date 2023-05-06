package com.simple.keen.metadata.controller;

import com.simple.keen.common.base.Response;
import com.simple.keen.common.consts.CodeItemConsts;
import com.simple.keen.metadata.service.ICodeMainService;
import javax.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/2/6
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/metadata/option")
public class OptionController {

    private final ICodeMainService codeMainService;

    @GetMapping("sex")
    public Response getSexOption() {
        return Response.ok(codeMainService.listOptionModelByCodeName(CodeItemConsts.SEX_CODE_ITEM_NAME));
    }

    @GetMapping("status")
    public Response getStatusOption() {
        return Response.ok(codeMainService.listOptionModelByCodeName(CodeItemConsts.STATUS_CODE_ITEM_NAME));
    }


}
