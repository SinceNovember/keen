package com.simple.monitor.service;

import com.simple.monitor.model.entity.ActiveUser;
import org.apache.shiro.subject.SimplePrincipalCollection;

import java.util.List;

public interface SessionService  {

    /**
     * 在线用户列表(根据Session)
     * @return
     */
    List<ActiveUser> listActiveUser(String nickname);

    /**
     * 用户是否在线
     * @param userId
     * @return
     */

    boolean isOnline(Integer userId);

    /**
     * 退出登陆
     */
    void logout(ActiveUser activeUser);

    /**
     * 强制其他用户退出登陆（包括删除Session)
     */
//    void forceLogout(Integer userId, String sessionId);

    void forceLogout(ActiveUser activeUser);


    /**
     * 通过用户ID获取Principal集合
     *
     * @param userId 用户ID
     * @return List<SimplePrincipalCollection>
     */
    List<SimplePrincipalCollection> getPrincipals(Integer userId);


}
