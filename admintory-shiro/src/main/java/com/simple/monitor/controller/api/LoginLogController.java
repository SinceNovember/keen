package com.simple.monitor.controller.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.simple.common.annotation.ControllerEndpoint;
import com.simple.common.model.constant.CommonConstant;
import com.simple.common.model.entity.Response;
import com.simple.common.model.entity.ResponseData;
import com.simple.monitor.model.dto.LoginLogDTO;
import com.simple.monitor.model.vo.LoginLogCondition;
import com.simple.monitor.service.LoginLogService;
import lombok.NonNull;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/api/monitor/log/login")
public class LoginLogController {

    @Resource
    private LoginLogService loginLogService;

    @GetMapping("/list")
    @ControllerEndpoint(exceptionMessage = "获取登陆日志列表失败")
    public ResponseData listLog(LoginLogCondition condition, @RequestParam(defaultValue = "1",value = "currentPage") Integer pageNumber, @RequestParam(defaultValue = "10") Integer pageSize){
        IPage<LoginLogDTO> loginLogIPage = loginLogService.pageLoginLog(condition, pageNumber, pageSize);
        return Response.ok(loginLogIPage);
    }

    @GetMapping("/count")
    public ResponseData countLog(){
        return Response.ok(loginLogService.count());
    }

    @GetMapping("/count/history")
    public ResponseData countLogHistory() {
        return  Response.ok(loginLogService.countLoginLogByDateScope(DateUtils.addDays(new Date(), - DateUtils.RANGE_MONTH_MONDAY), new Date()));
    }

    @DeleteMapping
    @ControllerEndpoint(operation = "删除登陆日志", exceptionMessage = "删除登陆日志失败")
    public ResponseData removeLog(@NonNull @RequestParam("ids") String ids) {
        loginLogService.removeLogByIds(ids);
        return Response.ok(CommonConstant.DELETE_SUCCESS_TEXT);
    }


}
