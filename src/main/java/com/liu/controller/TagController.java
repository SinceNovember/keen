package com.liu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.liu.entity.Page;
import com.liu.entity.Tag;
import com.liu.service.PageService;
import com.liu.service.TagService;

 /** 
 * @ClassName: TagController 
 * @author: lyd
 * @date: 2019年4月17日 下午2:20:40 
 * @describe:标签控制器
 */
@Controller
public class TagController {
	@Autowired
	private TagService tagService;
	@Autowired
	private PageService pageService;
	@RequestMapping("/tags")
	public ModelAndView tags()
	{
		ModelAndView modelAndView=new ModelAndView();
		List<Tag> tags=tagService.listTag();
		Integer tagCount=tags.size();
		Page page=pageService.getPage(5);//获取标签页得图片和签名
		modelAndView.addObject("tags", tags);
		modelAndView.addObject("tagCount", tagCount);
		modelAndView.addObject("page", page);
		modelAndView.setViewName("/home/tags");
		return modelAndView;			
	}
}
