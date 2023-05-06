package com.simple.keen.metadata.controller;

import com.simple.keen.common.base.Response;
import com.simple.keen.metadata.model.query.SystemConfigQuery;
import com.simple.keen.metadata.service.ISystemConfigService;
import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/2/3
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/metadata/systemConfig")
public class SystemConfigController {

    private final ISystemConfigService systemConfigService;

    @GetMapping("page")
    public Response pageSystemConfig(SystemConfigQuery systemConfigQuery) {
        return Response.ok(systemConfigService.pageSystemConfig(systemConfigQuery));
    }

    @GetMapping
    public Response getSystemConfig(@NotNull Integer id) {
        return Response.ok(systemConfigService.getSystemConfigById(id));
    }

    @PostMapping
    public Response addOrUpdateSystemConfig(
        @Validated @RequestBody SystemConfigQuery systemConfigQuery) {
        systemConfigService.addOrUpdateSystemConfig(systemConfigQuery);
        return Response.ok();
    }

    @PostMapping("delete")
    public Response deleteSystemConfig(@NotNull @RequestBody SystemConfigQuery systemConfigQuery) {
        systemConfigService.deleteSystemConfig(systemConfigQuery.getIds());
        return Response.ok();
    }
}
