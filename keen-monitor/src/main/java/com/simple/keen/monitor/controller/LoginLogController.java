package com.simple.keen.monitor.controller;

import com.simple.keen.common.base.Response;
import com.simple.keen.monitor.model.query.LoginLogQuery;
import com.simple.keen.monitor.service.ILoginLogService;
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
 * @date 2023/2/6
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/monitor/loginLog")
public class LoginLogController {

    private final ILoginLogService loginLogService;

    @GetMapping("page")
    public Response pageLoginLog(LoginLogQuery loginLogQuery) {
        return Response.ok(loginLogService.pageLoginLog(loginLogQuery));
    }

    @GetMapping
    public Response getLoginLog(@NotNull Integer id) {
        return Response.ok(loginLogService.getLoginLogById(id));
    }

    @GetMapping("recent")
    public Response getRecentLoginLog() {
        return Response.ok(loginLogService.getRecentLoginLog());
    }

    @GetMapping("allCount")
    public Response getLoginLogAllCount() {
        return Response.ok(loginLogService.getLoginLogAllCount());
    }

    @GetMapping("todayCount")
    public Response getLoginLogTodayCount() {
        return Response.ok(loginLogService.getLoginLogTodayCount());
    }

    @GetMapping("weekChart")
    public Response getLoginLogWeekChart() {
        return Response.ok(loginLogService.getLoginLogWeekChart());
    }

    @PostMapping
    public Response addOrUpdateLoginLog(@Validated @RequestBody LoginLogQuery loginLogQuery) {
        loginLogService.addLoginLog(loginLogQuery);
        return Response.ok();
    }

    @PostMapping("delete")
    public Response deleteLoginLog(@NotNull @RequestBody LoginLogQuery loginLogQuery) {
        loginLogService.deleteLoginLog(loginLogQuery.getIds());
        return Response.ok();
    }

}
