package com.liu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.liu.Utils.PageUtil;
import com.liu.Utils.StringUtil;
import com.liu.model.Blog;
import com.liu.model.PageBean;
import com.liu.service.BlogService;

 /** 
 * @ClassName: IndexController 
 * @author: lyd
 * @date: 2017年10月10日 下午9:51:23 
 * @describe:索引信息Controller
 */
@Controller
@RequestMapping("/")
public class IndexController {
	@Resource
	private BlogService blogService;
	@RequestMapping("/index")
	public ModelAndView index(@RequestParam(value="paeg",required=false)String page
							  ,@RequestParam(value="typeId",required=false)String typeId
							  ,@RequestParam(value="releaseDateStr",required=false)String releaseDateStr
							  ,HttpServletRequest request)throws Exception
	{
		ModelAndView modelAndView=new ModelAndView();
		if(StringUtil.isEmpty(page)){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),10);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("start", pageBean.getPageSize());
		map.put("pageSize", pageBean.getPageSize());
		map.put("typeId", typeId);
		map.put("releaseDateStr", releaseDateStr);
		List<Blog> blogList=blogService.listBlog(map);
		for(Blog blog:blogList){
			List<String>imageList=blog.getImageList();
			String blogInfo=blog.getContent();
			Document document=Jsoup.parse(blogInfo);
			Elements jpgs=document.select("image[src$=.jpg]");
			for(int i=0;i<jpgs.size();i++)
			{
				Element jpg=jpgs.get(i);
				imageList.add(jpg.toString());
				if(i==2)
					break;
			}
		}
			StringBuffer param=new StringBuffer();
			if(StringUtil.isNotEmpty(typeId))
			{
				param.append("typeId="+typeId+"&");
			}
			if(StringUtil.isNotEmpty(releaseDateStr)){
				param.append("releaseDateStr="+releaseDateStr+"&");
			}
			modelAndView.addObject("pageCode", PageUtil.genPagination(
					request.getContextPath() + "/index.html", //还是请求该controller的index方法
					blogService.getTotal(map), 
					Integer.parseInt(page), 10,
					param.toString()));
			modelAndView.addObject("blogList", blogList);
			modelAndView.addObject("commonPage", "foreground/blog/blogList.jsp");
			modelAndView.addObject("title", "博客主页 - 刘宇东的博客");
			modelAndView.setViewName("mainTemp");
		return modelAndView;
	}
}
