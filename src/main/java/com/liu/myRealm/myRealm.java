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

import com.liu.model.Blogger;
import com.liu.service.BloggerService;

 /** 
 * @ClassName: myRealm 
 * @author: lyd
 * @date: 2017年10月10日 下午9:56:17 
 * @describe:Shiro自定义Realm
 */
public class myRealm  extends AuthorizingRealm{
	@Resource 
	private BloggerService bloggerService;

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
		Blogger blogger=bloggerService.getByUsername(username);
		if(blogger!=null)
		{
			SecurityUtils.getSubject().getSession().setAttribute("currentUser", blogger);
			AuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(blogger.getUsername(),blogger.getPassword(),"myRealm");
			return authenticationInfo;
		}
		return null;
	}
	
}
