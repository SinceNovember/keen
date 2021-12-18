package com.simple.monitor.service.impl;

import com.google.common.collect.Lists;
import com.simple.chat.utils.ChannelUtils;
import com.simple.common.utils.AddressUtil;
import com.simple.common.utils.HttpContextUtils;
import com.simple.common.utils.StringUtils;
import com.simple.monitor.model.entity.ActiveUser;
import com.simple.monitor.service.SessionService;
import com.simple.system.model.entity.User;
import com.simple.system.service.UserService;
import com.simple.system.service.UserTokenService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static com.simple.monitor.model.entity.ActiveUser.OFFLINE;
import static com.simple.monitor.model.entity.ActiveUser.ONLINE;

/**
 * 会话管理Service
 */
@Service
public class SessionServiceImpl implements SessionService {

    @Resource
    private  SessionDAO sessionDAO;

    @Resource
    private UserService userService;

    @Resource
    private UserTokenService userTokenService;

    /**
     * 获取当前所有在线用户
     * @param nickname
     * @return
     */
    @Override
    public List<ActiveUser> listActiveUser(String nickname) {
        String currentSessionId = (String)SecurityUtils.getSubject().getSession().getId();

        List<ActiveUser> list = new ArrayList<>();
        try{
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        sessions.stream().filter(session -> session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY) != null)
            .forEach(session -> {
                SimplePrincipalCollection principalCollection = (SimplePrincipalCollection) session
                        .getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
                User user = (User)principalCollection.getPrimaryPrincipal();
                ActiveUser activeUser = new ActiveUser();
                activeUser.setNickname(user.getNickname());
                activeUser.setUserId(user.getUserId());
                activeUser.setId(session.getId().toString());
                activeUser.setHost(session.getHost());
                activeUser.setStartTime(session.getStartTimestamp());
                activeUser.setLastAccessTime(session.getLastAccessTime());
                long timeout = session.getTimeout();
                activeUser.setStatus(timeout == 0L ? OFFLINE : ONLINE);
                String address = AddressUtil.getCityInfo(activeUser.getHost());
                activeUser.setLocation(address);
                activeUser.setTimeout(timeout);
                activeUser.setUser(userService.getUserDetailById(activeUser.getUserId()));
                if (Objects.equals(currentSessionId, activeUser.getId())) {
                    activeUser.setCurrent(true);
                }
                if (StringUtils.isBlank(nickname)
                        || StringUtils.equalsIgnoreCase(activeUser.getNickname(), nickname)) {
                    list.add(activeUser);
                }
            });
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 判断用户是否在线
     * @param userId
     * @return
     */
    @Override
    public boolean isOnline(Integer userId) {
        return sessionDAO.getActiveSessions().stream().anyMatch(session -> {
            SimplePrincipalCollection principalCollection = (SimplePrincipalCollection) session
                    .getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            User user = (User)principalCollection.getPrimaryPrincipal();
            return Objects.equals(userId, user.getUserId());
        });
    }

    /**
     * 正常退出
     */
    public void logout(ActiveUser activeUser) {
        userTokenService.clearToken(activeUser, HttpContextUtils.getRequestParam("X-Token"));
        SecurityUtils.getSubject().logout();
        ChannelUtils.removeAndNotify(activeUser.getUserId().toString());
    }

    /**
     * 强制退出用户
     */
    @Override
    public void forceLogout(ActiveUser activeUser) {
        Session session = sessionDAO.readSession(activeUser.getId());
        session.setTimeout(0);
        session.stop();
        sessionDAO.delete(session);
        userTokenService.clearToken(activeUser, null);
    }

    @Override
    public List<SimplePrincipalCollection> getPrincipals(Integer userId) {
        List<SimplePrincipalCollection> collections = Lists.newArrayList();
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        sessions.forEach(session -> {
            SimplePrincipalCollection simplePrincipalCollection = (SimplePrincipalCollection) session
                    .getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            if (simplePrincipalCollection != null) {
                User user = (User) simplePrincipalCollection.getPrimaryPrincipal();
                if (userId.equals(user.getUserId())) {
                    collections.add(simplePrincipalCollection);
                }
            }
        });
        return collections;
    }

}
