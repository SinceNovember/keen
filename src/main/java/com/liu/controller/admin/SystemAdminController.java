package com.liu.controller.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liu.Utils.ResponseUtil;
import com.liu.model.Blog;
import com.liu.model.BlogType;
import com.liu.model.Blogger;
import com.liu.model.Link;
import com.liu.service.BlogService;
import com.liu.service.BlogTypeService;
import com.liu.service.BloggerService;
import com.liu.service.LinkService;

import net.sf.json.JSONObject;

 /** 
 * @ClassName: SystemAdminController 
 * @author: lyd
 * @date: 2017年10月10日 下午4:47:30 
 * @describe:重新刷新系统缓存
 */
@Controller
@RequestMapping("/admin/system")
public class SystemAdminController {
	@Resource
	private BloggerService bloggerService;
	@Resource
	private LinkService linkService;
	@Resource
	private BlogTypeService blogTypeService;
	@Resource
	private BlogService blogService;
	@RequestMapping("/refreshSystemCache")
	public String refreshSystemCache(HttpServletRequest request,HttpServletResponse response) throws Exception{
			ServletContext application=request.getSession().getServletContext();
			Blogger blogger=bloggerService.getBloggerData();
			blogger.setPassword(null);
			application.setAttribute("blogger", blogger);
			List<Link> linkList=linkService.getLinkData();
			application.setAttribute("linkList", linkList);
			List<BlogType> blogTypeList=blogTypeService.getBlogTypeData();
			application.setAttribute("blogTypeList", blogTypeList);
			List<Blog>blogTimeList=blogService.getBlogData();
			application.setAttribute("blogTimeList", blogTimeList);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("success", true);
			ResponseUtil.write(response, jsonObject);
			return null;
	}
}
