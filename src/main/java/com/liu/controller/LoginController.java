package com.liu.controller;

import java.util.HashMap;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liu.Utils.ManageLog;
import com.liu.controller.admin.BackArticleController;
import com.liu.entity.Article;
import com.liu.entity.Comment;
import com.liu.entity.User;
import com.liu.entity.UserLog;
import com.liu.service.ArticleService;
import com.liu.service.CommentService;
import com.liu.service.UserLogService;

 /** 
 * @ClassName: LoginController 
 * @author: lyd
 * @date: 2019年4月17日 下午1:56:32 
 * @describe:登陆控制类
 */
@Controller
public class LoginController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CommentService commentServie;
	@Autowired
	private UserLogService userLogService;
	ManageLog manageLog=BackArticleController.manageLog;//用于统计日志
	public static String LoginIp="";
	@RequestMapping("/login")
	public String login(User user,HttpServletRequest request){
	Subject subject=SecurityUtils.getSubject();//获取shiro主体
	UsernamePasswordToken token=new UsernamePasswordToken(user.getUserName(),user.getUserPass());//将账号密码存入token
	try
	{
		subject.login(token);//尝试登陆
		HashMap<String, Object>map=new HashMap<String, Object>();
		map.put("start", 0);
		map.put("pageSize", 8);
		List<Comment> comments=commentServie.listRecentComment(map);//最近发布得评论
		List<Article> articles=articleService.listAdminArticle(map);//最新发布得文章
		List<UserLog> logs=userLogService.listLog(map);//最新的日志
		LoginIp=request.getRemoteAddr();
		userLogService.insertLog(manageLog.insertLog("登陆","用户登陆"));
		request.getSession().getServletContext().setAttribute("recentArticles",articles);
		request.getSession().getServletContext().setAttribute("comments", comments);
		request.getSession().getServletContext().setAttribute("commentCount", comments.size());
		request.getSession().getServletContext().setAttribute("logs", logs);
		return "redirect:/admin/main.jsp";
	}catch (Exception e) 
		{
		e.printStackTrace();
		request.setAttribute("errorInfo", "用户名密码错误");
		return "login";
		}
    }
}
