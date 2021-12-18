package com.simple.monitor.controller.api;

import com.simple.common.annotation.ControllerEndpoint;
import com.simple.common.model.entity.Response;
import com.simple.common.model.entity.ResponseData;
import com.simple.monitor.model.entity.ActiveUser;
import com.simple.monitor.service.SessionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/monitor/session")
public class SessionController {

    @Resource
    private SessionService sessionService;

    @GetMapping("/list")
    @ControllerEndpoint(exceptionMessage = "获取在线用户失败")
    public ResponseData listActiveUser(String username){
        List<ActiveUser> list = sessionService.listActiveUser(username);
        return Response.ok(list);
    }

    @DeleteMapping
    @ControllerEndpoint(operation = "踢出用户", exceptionMessage = "踢出用户失败")
    public ResponseData forceLogout(ActiveUser activeUser) {
        if (activeUser.isCurrent()) {
            sessionService.logout(activeUser);
        } else {
            sessionService.forceLogout(activeUser);
        }
        return Response.ok();
    }
}
