package com.simple.keen.auth.interceptor;

import cn.dev33.satoken.error.SaErrorCode;
import cn.dev33.satoken.exception.SaTokenException;
import cn.dev33.satoken.fun.SaParamFunction;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.hutool.extra.spring.SpringUtil;
import com.simple.keen.common.consts.MsgConsts;
import com.simple.keen.system.model.enums.RequestMethod;
import com.simple.keen.system.service.IUserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限验证拦截器
 *
 * @author SinceNovember
 * @date 2023/2/3
 */
public class PermissionVerifyInterceptor extends SaInterceptor {

    private final IUserService userService;

    public PermissionVerifyInterceptor(SaParamFunction<Object> auth) {
        super(auth);
        userService = SpringUtil.getBean(IUserService.class);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
        Object handler) throws Exception {
        //登录认证通过
        if (super.preHandle(request, response, handler)) {
            //检查当前用户是否可以访问当前路径
            boolean hasApiPermission = userService.checkCurrentUserApiPermission(
                request.getRequestURI(),
                RequestMethod.valueOf(request.getMethod()));
            if (!hasApiPermission) {
                throw new SaTokenException(SaErrorCode.CODE_11051,
                    MsgConsts.USER_NO_API_PERMISSION);
            }
            return true;
        }
        return false;
    }
}
