package com.liu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	@RequestMapping("/about")
	public ModelAndView about()
	{
		ModelAndView modelAndView=new ModelAndView();
		String about=userService.getUser(1).getHtmlProfile();//获取个人简介，用于展示
		modelAndView.addObject("about", about);
		modelAndView.setViewName("/home/about");
		return modelAndView;
	}
}
