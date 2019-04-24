package com.liu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.liu.entity.Article;
import com.liu.entity.Comment;
import com.liu.service.CommentService;
import com.liu.service.UserService;
  /** 
 * @ClassName: AboutController 
 * @author: lyd
 * @date: 2019年4月17日 下午1:32:20 
 * @describe:跳转关于页面控制器
 */
@Controller
public class AboutController {
	@Autowired
	private UserService userService;
	@Autowired
	private CommentService commentService;
	@RequestMapping("/about")
	public ModelAndView about()
	{
		ModelAndView modelAndView=new ModelAndView();
		String about=userService.getUser(1).getHtmlProfile();//获取个人简介，用于展示
		Article article=new Article();
		article.setArticleId(0);
		List<Comment> comments=commentService.getCommentByAid(0);
		for(Comment comment:comments)
		{
			comment.setChildComment(commentService.getChildComment(comment.getCommentId()));//获取文章下的评论
		}
		modelAndView.addObject("article",article);
		modelAndView.addObject("comments", comments);
		modelAndView.addObject("about", about);
		modelAndView.setViewName("/home/about");
		return modelAndView;
	}
}
