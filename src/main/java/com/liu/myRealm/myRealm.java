package com.liu.myRealm;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.liu.entity.User;
import com.liu.service.UserService;

 /** 
 * @ClassName: myRealm 
 * @author: lyd
 * @date: 2017年10月10日 下午9:56:17 
 * @describe:Shiro自定义Realm
 */
public class myRealm  extends AuthorizingRealm{
	@Resource 
	private UserService userService;

	@Override
//	授权查询回调函数
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
//	认证回调函数,进行登陆认证
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username=(String)token.getPrincipal();//获取用户名
		User user=userService.getUserByUsername(username);
		if(user!=null)
		{
			SecurityUtils.getSubject().getSession().setAttribute("user", user);
			AuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(user.getUserName(),user.getUserPass(),"myRealm");
			return authenticationInfo;
		}
		return null;
	}
	
}
