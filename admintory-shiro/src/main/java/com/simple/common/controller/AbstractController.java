package com.simple.common.controller;

import com.simple.monitor.model.entity.ActiveUser;
import com.simple.system.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;

/**
 * 公共组件
 */
@Slf4j
public abstract class AbstractController {

    protected User getUser() {
        return (User)SecurityUtils.getSubject().getPrincipal();
    }

    protected Integer getUserId() {
        return getUser().getUserId();
    }

    protected String getUserSession(){
        return (String)SecurityUtils.getSubject().getSession().getId();

    }

    protected ActiveUser getActiveUser(){
        ActiveUser activeUser = new ActiveUser();
        activeUser.setId(getUserSession());
        activeUser.setUserId(getUserId());
        return activeUser;
    }

}
