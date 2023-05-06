package com.simple.keen.auth.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.github.pagehelper.PageSerializable;
import com.simple.keen.auth.model.query.AuthQuery;
import com.simple.keen.auth.model.vo.LoginUserInfoVO;
import com.simple.keen.monitor.model.query.LoginLogQuery;
import com.simple.keen.monitor.model.query.OperateLogQuery;
import com.simple.keen.monitor.model.vo.LoginLogVO;

public interface IAuthService {

    /**
     * 获取登录用户信息
     *
     * @return 用户信息VO
     */
    LoginUserInfoVO getLoginUserInfo();

    /**
     * 当前用户的登录日志
     *
     * @param loginLogQuery 登录日志查询
     */
    PageSerializable<LoginLogVO> pageUserLoginLog(LoginLogQuery loginLogQuery);

    /**
     * 当前用户的操作日志
     *
     * @param operateLogQuery 操作日志查询
     */
    Object pageUserOperateLog(OperateLogQuery operateLogQuery);


    /**
     * 登录
     *
     * @param query 查询
     * @return
     */
    SaTokenInfo login(AuthQuery query);

    /**
     * 注销
     *
     * @param token 令牌
     * @return
     */
    void logout(String token);

    /**
     * 修改用户名
     *
     * @param authQuery 身份验证查询
     */
    void updateUsername(AuthQuery authQuery);

    /**
     * 修改密码
     *
     * @param authQuery 身份验证查询
     */
    void updatePassword(AuthQuery authQuery);

}
