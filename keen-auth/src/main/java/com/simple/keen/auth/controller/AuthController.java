package com.simple.keen.auth.controller;

import com.simple.keen.auth.model.query.AuthQuery;
import com.simple.keen.auth.service.IAuthService;
import com.simple.keen.common.base.Response;
import com.simple.keen.monitor.model.query.LoginLogQuery;
import com.simple.keen.monitor.model.query.OperateLogQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/18
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final IAuthService authService;

    @GetMapping("userInfo")
    public Response getUserInfo() {
        return Response.ok(authService.getLoginUserInfo());
    }

    @GetMapping("/loginLog")
    public Response pageUserLoginLog(LoginLogQuery loginLogQuery) {
        return Response.ok(authService.pageUserLoginLog(loginLogQuery));
    }

    @GetMapping("/operateLog")
    public Response pageUserOperateLog(OperateLogQuery operateLogQuery) {
        return Response.ok(authService.pageUserOperateLog(operateLogQuery));
    }

    @PostMapping("login")
    public Response login(@RequestBody AuthQuery query) {
        return Response.ok(authService.login(query));
    }

    @PostMapping("logout")
    public Response logout(@RequestBody AuthQuery query) {
        authService.logout(query.getTokenValue());
        return Response.ok();
    }

    @PutMapping("username")
    public Response updateUsername(@RequestBody AuthQuery query) {
        authService.updateUsername(query);
        return Response.ok();
    }

    @PutMapping("password")
    public Response updatePassword(@RequestBody AuthQuery query) {
        authService.updatePassword(query);
        return Response.ok();
    }
}
