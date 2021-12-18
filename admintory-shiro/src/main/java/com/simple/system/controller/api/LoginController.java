package com.simple.system.controller.api;

import com.simple.common.controller.AbstractController;
import com.simple.common.model.entity.Response;
import com.simple.common.model.entity.ResponseData;
import com.simple.common.utils.RedisUtils;
import com.simple.monitor.service.LoginLogService;
import com.simple.monitor.service.SessionService;
import com.simple.system.model.entity.User;
import com.simple.system.model.enums.UserStatus;
import com.simple.system.model.params.LoginParam;
import com.simple.system.service.UserService;
import com.simple.system.service.UserTokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/system")
public class LoginController extends AbstractController {

    @Resource
    private UserService userService;

    @Resource
    private UserTokenService userTokenService;

    @Resource
    private LoginLogService loginLogService;

    @Resource
    private SessionService sessionService;

    @Resource
    private RedisUtils redisUtils;

    @PostMapping("/login")
    public ResponseData login(@RequestBody LoginParam loginParam) {
        User user = userService.getUserByUsername(loginParam.getUsername());
        if (user == null || !Objects.equals(user.getPassword(), loginParam.getPassword())) {
            return Response.fail("账号密码错误");
        }
        if (user.getStatus() == UserStatus.LOCK) {
            return Response.fail("账号已被锁定,请联系管理员");
        }
        loginLogService.saveLoginLog(user.getNickname());
        //获取token
        Map<String, Object> map = userTokenService.createToken(user.getUserId());
        return Response.ok(map);
    }

    /**
     * 退出
     */
    @PostMapping("/logout")
    public ResponseData logout() {
        sessionService.logout(getActiveUser());
        return Response.ok();
    }

}
