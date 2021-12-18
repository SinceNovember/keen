package com.simple.metadata.controller.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.simple.common.annotation.ControllerEndpoint;
import com.simple.common.model.constant.CommonConstant;
import com.simple.common.model.constant.Strings;
import com.simple.common.model.entity.Response;
import com.simple.common.model.entity.ResponseData;
import com.simple.metadata.model.dto.SystemConfigDTO;
import com.simple.metadata.model.entity.SystemConfig;
import com.simple.metadata.model.params.SystemConfigParam;
import com.simple.metadata.model.vo.SystemConfigCondition;
import com.simple.metadata.service.SystemConfigService;
import lombok.NonNull;
import org.apache.shiro.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/api/metadata/system")
public class SystemConfigController {

    @Resource
    private SystemConfigService systemConfigService;

    @GetMapping("/list")
    @ControllerEndpoint(exceptionMessage = "获取系统参数列表失败")
    public ResponseData listSystemConfig(SystemConfigCondition condition, @RequestParam(defaultValue = "1",value = "currentPage") Integer pageNumber, @RequestParam(defaultValue = "10") Integer pageSize){
        IPage<SystemConfigDTO> configIPage = systemConfigService.pageSystemConfig(condition, pageNumber, pageSize);
        return Response.ok(configIPage);
    }

    @GetMapping
    @ControllerEndpoint(exceptionMessage = "获取系统参数失败")
    public ResponseData getSystemConfig(@NonNull Integer configId){
        SystemConfigDTO configDTO = systemConfigService.convertTo(systemConfigService.getById(configId));
        return Response.ok(configDTO);
    }

    @PostMapping
    @ControllerEndpoint(operation = "新增系统参数", exceptionMessage = "新增系统参数失败")
    public ResponseData addSystemConfig(@NonNull @RequestBody SystemConfigParam configParam){
        SystemConfig systemConfig = configParam.convertTo();
        systemConfig.setCreateTime(new Date());
        systemConfigService.save(systemConfig);
        return Response.ok();
    }

    @PutMapping
    @ControllerEndpoint(operation = "修改系统参数", exceptionMessage = "修改系统参数")
    public ResponseData updateSystemConfig(@NonNull @RequestBody SystemConfigParam configParam){
        SystemConfig systemConfig = configParam.convertTo();
        systemConfigService.updateById(systemConfig);
        return Response.ok();
    }

    @DeleteMapping
    @ControllerEndpoint(operation = "删除系统参数", exceptionMessage = "删除系统参数")
    public ResponseData removeRole(@NonNull  @RequestParam("ids") String ids) {
        systemConfigService.removeByIds(StringUtils.splitToSet(ids, Strings.COMMA));
        return Response.ok(CommonConstant.DELETE_SUCCESS_TEXT);
    }

}
