package com.simple.keen.auth.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.github.pagehelper.PageSerializable;
import com.simple.keen.auth.mapper.AuthMapper;
import com.simple.keen.auth.model.query.AuthQuery;
import com.simple.keen.auth.model.vo.LoginUserInfoVO;
import com.simple.keen.auth.service.IAuthService;
import com.simple.keen.common.consts.MsgConsts;
import com.simple.keen.common.exception.KeenException;
import com.simple.keen.message.service.IChatMessageService;
import com.simple.keen.monitor.model.query.LoginLogQuery;
import com.simple.keen.monitor.model.query.OperateLogQuery;
import com.simple.keen.monitor.model.vo.LoginLogVO;
import com.simple.keen.monitor.service.ILoginLogService;
import com.simple.keen.monitor.service.IOperateLogService;
import com.simple.keen.system.model.entity.User;
import com.simple.keen.system.model.enums.StatusType;
import com.simple.keen.system.model.vo.UserVO;
import com.simple.keen.system.service.IUserService;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/18
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

    private final AuthMapper authMapper;

    private final IUserService userService;

    private final IChatMessageService messageHistoryService;

    private final ILoginLogService loginLogService;

    private final IOperateLogService operateLogService;


    @Override
    public LoginUserInfoVO getLoginUserInfo() {
        LoginUserInfoVO userInfoDetailVO = new LoginUserInfoVO();
        userInfoDetailVO.setUnreadMessageCount(
            messageHistoryService.countUnreadChatMessage(null, StpUtil.getLoginIdAsInt()));
        BeanUtils.copyProperties(userService.getUserInfoById(StpUtil.getLoginIdAsInt()),
            userInfoDetailVO);
        return userInfoDetailVO;
    }

    @Override
    public PageSerializable<LoginLogVO> pageUserLoginLog(LoginLogQuery loginLogQuery) {
        loginLogQuery.setUserId(StpUtil.getLoginIdAsInt());
        return loginLogService.pageLoginLog(loginLogQuery);
    }

    @Override
    public Object pageUserOperateLog(OperateLogQuery operateLogQuery) {
        operateLogQuery.setUserId(StpUtil.getLoginIdAsInt());
        return operateLogService.pageOperateLog(operateLogQuery);
    }

    @Override
    public SaTokenInfo login(AuthQuery query) {
        UserVO userVO = authMapper.selectUserIdByUsernameAndPassword(query);
        if (userVO == null) {
            throw new KeenException(MsgConsts.LOGIN_ERROR_MSG);
        }
        if (userVO.getStatus() == StatusType.LOCK) {
            throw new KeenException(MsgConsts.USER_LOCK_MSG);
        }
        StpUtil.login(userVO.getId(), query.isRememberMe());
        loginLogService.addLoginLog(userVO.getNickname());
        return StpUtil.getTokenInfo();
    }

    @Override
    public void logout(String token) {
        StpUtil.logoutByTokenValue(token);
    }

    @Override
    public void updateUsername(AuthQuery authQuery) {
        User user = userService.getById(StpUtil.getLoginIdAsInt());
        if (!Objects.equals(authQuery.getPassword(), user.getPassword())) {
            throw new KeenException(MsgConsts.PASSWORD_ERROR_MSG);
        }
        user.setUsername(authQuery.getUsername());
        userService.updateById(user);
    }

    @Override
    public void updatePassword(AuthQuery authQuery) {
        User user = userService.getById(StpUtil.getLoginIdAsInt());
        if (!Objects.equals(authQuery.getPassword(), user.getPassword())) {
            throw new KeenException(MsgConsts.PASSWORD_ERROR_MSG);
        }
        user.setPassword(authQuery.getNewPassword());
        userService.updateById(user);
    }
}
