package com.simple.system.oauth2;

import com.simple.system.model.dto.MenuDTO;
import com.simple.system.model.entity.User;
import com.simple.system.model.enums.UserStatus;
import com.simple.system.service.MenuPermissionRelateService;
import com.simple.system.service.MenuService;
import com.simple.system.service.UserService;
import com.simple.system.service.UserTokenService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.simple.common.utils.StringUtils.getPath;


/**
 * Shiro认证器
 */
@Component
public class OAuth2Realm extends AuthorizingRealm{

    @Resource
    private UserService userService;

    @Resource
    private UserTokenService userTokenService;

    @Resource
    private MenuService menuService;

    @Resource
    private MenuPermissionRelateService menuPermissionRelateService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }
    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String accessToken = (String)token.getPrincipal();

        Integer userId = userTokenService.verityUserToken(accessToken);
        User user = userService.getById(userId);
        if (user == null) {
            throw new DisabledAccountException("账号已被删除，请联系管理员");
        }
        if (user.getStatus() == UserStatus.LOCK) {
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }

        HttpServletRequest request = null;

        if (token instanceof OAuth2Token) {
            request = (HttpServletRequest)((OAuth2Token) token).getRequest();
        }

        MenuDTO menu = menuService.getButtonByPathAndRequestMethod(getPath(request.getRequestURI()), request.getMethod());
        if (menu != null && !menuPermissionRelateService.hasMenuPermission(user, menu)) {
            throw new AuthorizationException("当前用户无此操作权限");
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, accessToken, getName());
        //如果没有创建关系，保存session-token的关系
        userTokenService.createTokenSessionRelate(accessToken, SecurityUtils.getSubject().getSession().getId().toString());
        return info;
    }
}
