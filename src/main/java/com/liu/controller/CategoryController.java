package com.liu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.liu.entity.Category;
import com.liu.entity.Page;
import com.liu.service.CategoryNodeService;
import com.liu.service.CategoryService;
import com.liu.service.PageService;

 /** 
 * @ClassName: CategoryController 
 * @author: lyd
 * @date: 2019年4月17日 下午1:49:21 
 * @describe:分类控制器
 */
@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CategoryNodeService categoryNodeService;
	@Autowired
	private PageService pageService;
	@RequestMapping("/categories")
	public ModelAndView categories()
	{
		ModelAndView modelAndView=new ModelAndView();
		List<Category> categories=categoryNodeService.getAllParent();//获取所有的父分类节点，其中包含其子节点
		for(Category category1:categories){//设置各分类的文章数
			category1.setArticleCount(categoryService.getCategoryArticleCount(category1.getCategoryId()));
			for(Category category2:category1.getChildrenCategory())
				category2.setArticleCount(categoryService.getCategoryArticleCount(category2.getCategoryId()));
		}
		Integer categoryCount=categoryService.listCategory().size();
		Page page=pageService.getPage(4);//显示分类页的页面图片和标签
		modelAndView.addObject("categories", categories);
		modelAndView.addObject("categoryCount", categoryCount);
		modelAndView.addObject("page", page);
		modelAndView.setViewName("/home/categories");
		return modelAndView;			
	}
}
