package com.liu.controller.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.liu.Utils.ManageLog;
import com.liu.Utils.ResponseUtil;
import com.liu.entity.Category;
import com.liu.service.CategoryNodeService;
import com.liu.service.CategoryService;
import com.liu.service.UserLogService;
import com.liu.service.UserService;

import net.sf.json.JSONObject;

 /** 
 * @ClassName: BackCategoryController 
 * @author: lyd
 * @date: 2019年4月17日 下午2:31:03 
 * @describe:后台分类控制器
 */
@Controller
@RequestMapping("/admin")
public class BackCategoryController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CategoryNodeService categoryNodeService;
	@Autowired
	private UserLogService userLogService;
	ManageLog manageLog=BackArticleController.manageLog;
	/**
	 * 
	* @Title: jump_category  
	* @Description: 跳转分类页面
	 */
	@RequestMapping("/jump_category")
	public ModelAndView jump_category()
	{
		ModelAndView modelAndView=new ModelAndView();
		List<Category> categories=categoryNodeService.getAllParent();//获取所有分类
		for(Category category1:categories){//设置所有分类下得文章数
			category1.setArticleCount(categoryService.getCategoryArticleCount(category1.getCategoryId()));
			for(Category category2:category1.getChildrenCategory())
				category2.setArticleCount(categoryService.getCategoryArticleCount(category2.getCategoryId()));
		}
		modelAndView.addObject("categories", categories);
		modelAndView.setViewName("/admin/category");
		return modelAndView;
	}
	/**
	 * 跳转修改分类页面
	* @Title: jump_editor_category  
	* @Description: TODO
	 */
	@RequestMapping("/jump_editor_category")
	public ModelAndView jump_editor_category(@RequestParam("cid")Integer cid)
	{
		ModelAndView modelAndView=new ModelAndView();
		List<Category> list=new ArrayList<Category>();
		List<Category> parentCategories=categoryNodeService.getAllParent();//获取所以父亲结点
		Category category=categoryService.getCategoryByCid(cid);
		Category category2=new Category();//填充无父节点
		category2.setCategoryName("无父节点");
		category2.setCategoryId(0);
		if(category.getCategoryPid()==0)//如果分类为父节点
		{

			list.add(category2);//设置为无父亲节点
			if(categoryService.getCategoryByPid(category.getCategoryId()).size()==0)
			{
			list.addAll(parentCategories);//添加所有得分类父结点
			}
		}
		else
		{
			list.add(category.getParentCategory());//添加其父亲结点用于选择
			list.add(category2);//添加无父亲节点
			for(Category tempcategory:parentCategories)
			{
				if(tempcategory.getCategoryId()!=category.getCategoryPid())//添加所有其余父亲结点
					list.add(tempcategory);
			}
			
		}
		modelAndView.addObject("parentCategories", list);
		modelAndView.addObject("category",category);
		modelAndView.setViewName("/admin/editor_category");
		return modelAndView;
	}
	/**
	 * 
	* @Title: insert_category  
	* @Description: 插入分类
	 */
	@RequestMapping("/insert_category")
	public String insert_category(Category category,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		JSONObject jsonObject=new JSONObject();
		if((categoryService.insertCategory(category))!=null)		
		{
			request.getSession().getServletContext().setAttribute("categoryCount", categoryService.listCategory().size());//更新添加分类后前台的显示数
			userLogService.insertLog(manageLog.insertLog("添加分类", category.getCategoryName()));
			jsonObject.put("success", true);
			jsonObject.put("msg", "添加成功");
		}
		else
		{
			jsonObject.put("success", false);
			jsonObject.put("msg", "添加失败");
		}
		ResponseUtil.write(response,jsonObject);
		return null;
	}
	/**
	 * 修改分类
	* @Title: update_category  
	* @Description: TODO
	 */
	@RequestMapping("/update_category")
	@ResponseBody
	public String update_category(Category category,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		JSONObject jsonObject=new JSONObject();
		if((categoryService.updateCategory(category))!=null)		
			{
			userLogService.insertLog(manageLog.insertLog("修改分类", category.getCategoryName()));
			jsonObject.put("success", true);
			jsonObject.put("msg","修改成功");
			}
		else
			jsonObject.put("success", false);
		ResponseUtil.write(response,jsonObject);
		return null;
	}
	/**
	 * 删除分类
	* @Title: delete_tag  
	* @Description: TODO
	 */
	@RequestMapping("/delete_category")
	public String delete_tag(@RequestParam("cid")Integer cid,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		JSONObject jsonObject=new JSONObject();
		Category category=categoryService.getCategoryByCid(cid);
		if(category.getCategoryPid()==0&&(categoryService.findChildCategory(cid).size()!=0))//如果为父亲结点且分类下有文章
		{
			jsonObject.put("success", false);
			jsonObject.put("msg", "该分类下有其他分类,不可删除");
		}
		else
		{
			Integer articleCount=categoryService.getCategoryArticleCount(cid);
			if(articleCount==0)//如果文章数为0时
			{
			if(categoryService.deleteCategoryByCid(cid)!=null)
			{
				request.getSession().getServletContext().setAttribute("categoryCount", categoryService.listCategory().size());//更新删除分类后前台的显示数
				userLogService.insertLog(manageLog.insertLog("删除分类", category.getCategoryName()));//添加日志
				jsonObject.put("success", true);
				jsonObject.put("msg", "删除成功");
				jsonObject.put("categoryParent", categoryNodeService.getAllParent());
			}
			else
			{
				jsonObject.put("success", false);
				jsonObject.put("msg", "该分类下有文章不能删除");
			}
			}else
			{
				jsonObject.put("success", false);
				jsonObject.put("msg", "该分类下有文章不能删除");
			}
		}
		ResponseUtil.write(response,jsonObject);
		return null;
	}
}
