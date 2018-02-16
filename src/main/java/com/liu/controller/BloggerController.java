package com.liu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liu.model.Blogger;
import com.liu.service.BloggerService;

 /** 
 * @ClassName: BloggerController 
 * @author: lyd
 * @date: 2017年10月10日 下午5:21:48 
 * @describe:通过shiro进行登陆验证
 */
@Controller
@RequestMapping("/blogger")
public class BloggerController {
	@Resource
	private BloggerService bloggerService;
	@RequestMapping("/login")
	public String login(Blogger blogger,HttpServletRequest request){
	Subject subject=SecurityUtils.getSubject();//获取主体
	UsernamePasswordToken token=new UsernamePasswordToken(blogger.getUsername(), blogger.getPassword());//将账号密码存入token
	try
	{
		subject.login(token);//尝试登陆
		return "redirect:/admin/main.jsp";
	}catch (Exception e) 
		{
		e.printStackTrace();
		request.setAttribute("blogger", blogger);
		request.setAttribute("errorInfo", "用户名密码错误");
		return "login";
		}
    }
	
 }
