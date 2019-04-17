package com.liu.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.liu.Utils.ManageLog;
import com.liu.Utils.ResponseUtil;
import com.liu.Utils.UploadUtil;
import com.liu.entity.Page;
import com.liu.service.PageService;
import com.liu.service.UserLogService;

import net.sf.json.JSONObject;

 /** 
 * @ClassName: BackPageController 
 * @author: lyd
 * @date: 2019年4月17日 下午2:49:18 
 * @describe:后台修改前台页面控制器
 */
@Controller
@RequestMapping("/admin")
public class BackPageController {
	@Autowired
	private PageService pageService;
	@Autowired
	private  UserLogService userLogService;
	ManageLog manageLog=BackArticleController.manageLog;//管理日志对象
	/**
	 * 跳转到修改页面
	* @Title: page_setup  
	* @Description: TODO
	 */
	@RequestMapping("/page_setup")
	public ModelAndView	page_setup()
	{
		ModelAndView modelAndView=new ModelAndView();
		Page index=pageService.getPage(1);//主页
		Page detail=pageService.getPage(2);//详细页
		Page archive=pageService.getPage(3);//归档页
		Page category=pageService.getPage(4);//分类页
		Page tag=pageService.getPage(5);//标签页
		Page about=pageService.getPage(6);//关于页
		modelAndView.addObject("pageIndex", index);
		modelAndView.addObject("pageDetail", detail);
		modelAndView.addObject("pageArchive", archive);
		modelAndView.addObject("pageCategory", category);
		modelAndView.addObject("pageTag", tag);
		modelAndView.addObject("pageAbout", about);
		modelAndView.setViewName("/admin/page_setup");
		return modelAndView;
	}
	/**
	 * 
	* @Title: update_page  
	* @Description: 修改网页图片和标签
	 */
	@RequestMapping("/update_page")
	public String	update_page(Page page,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		JSONObject jsonObject=new JSONObject();
		String absolutePath;
		String lastPath="static/images/";
		String originPath=pageService.getPage(page.getPageFlag()).getImagePath();//原来背景图的图片路径
		if(page.getPageImage().getOriginalFilename().length()!=0)
		{		
			absolutePath=UploadUtil.UploadbgImage(page.getPageImage(), lastPath, request);//上传图片
			UploadUtil.deleteImage(originPath, request);//删除原先的图片;
			page.setImagePath(absolutePath);
			userLogService.insertLog(manageLog.insertLog("修改","修改页面背景图" ));//插入日志
		}
		if(pageService.updatePage(page)!=null)
		{
			jsonObject.put("success", true);
			jsonObject.put("msg", "修改成功");
		}else
		{
			jsonObject.put("success", false);
			jsonObject.put("msg", "修改失败");
		}
		ResponseUtil.write(response, jsonObject);
		return null;
	}
}
