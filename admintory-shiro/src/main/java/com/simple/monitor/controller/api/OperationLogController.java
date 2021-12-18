package com.simple.monitor.controller.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.simple.common.annotation.ControllerEndpoint;
import com.simple.common.model.constant.CommonConstant;
import com.simple.common.model.entity.Response;
import com.simple.common.model.entity.ResponseData;
import com.simple.monitor.model.dto.OperationLogDTO;
import com.simple.monitor.model.vo.OperationLogCondition;
import com.simple.monitor.service.OperationLogService;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/monitor/log/operation")
public class OperationLogController {

    @Resource
    private OperationLogService operationLogService;

    @GetMapping("/list")
    @ControllerEndpoint(exceptionMessage = "获取操作日志列表失败")
    public ResponseData listLog(OperationLogCondition condition, @RequestParam(defaultValue = "1",value = "currentPage") Integer pageNumber, @RequestParam(defaultValue = "10") Integer pageSize){
        IPage<OperationLogDTO> operationLogIPage = operationLogService.pageOperationLog(condition, pageNumber, pageSize);
        return Response.ok(operationLogIPage);
    }

    @DeleteMapping
    @ControllerEndpoint(operation = "删除操作日志", exceptionMessage = "删除操作日志失败")
    public ResponseData removeLog(@NonNull @RequestParam("ids") String ids) {
        operationLogService.removeLogByIds(ids);
        return Response.ok(CommonConstant.DELETE_SUCCESS_TEXT);
    }}
