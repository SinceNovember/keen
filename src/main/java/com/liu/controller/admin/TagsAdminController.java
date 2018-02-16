package com.liu.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.liu.Utils.ResponseUtil;
import com.liu.model.Link;
import com.liu.model.PageBean;
import com.liu.service.BlogTypeService;
import com.liu.service.LinkService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

 /** 
 * @ClassName: LinkAdminController 
 * @author: lyd
 * @date: 2017年10月10日 下午4:45:17 
 * @describe:链接信息
 */
@Controller
@RequestMapping("/admin/link")
public class TagsAdminController {
	@Resource
	private LinkService linkService;
	@Resource
	private BlogTypeService blogTypeService;
	//显示所有标签
	@RequestMapping("/listLink")
	public String listLink(@RequestParam(value="page",required=false)String page
						   ,@RequestParam(value="rows",required=false)String rows,
						   HttpServletResponse response) throws Exception
	{
		PageBean pageBean=new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object>map=new HashMap<String, Object>();
		map.put("start", pageBean.getPage());
		map.put("pageSize", pageBean.getPageSize());
		List<Link> linkList=linkService.listLinkData(map);
		Long total=linkService.getTotal();
		JSONObject jsonObject=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(linkList);
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		ResponseUtil.write(response, jsonObject);
		return null;
	}
	//保存所有标签
	@RequestMapping("/save")
	public String saveLink(Link link,HttpServletResponse response,HttpServletRequest request) throws Exception
	{
		int resultTotal=0;
		if(link.getId()==null){
			resultTotal=linkService.addLink(link);
		}
		else{
			resultTotal=linkService.updateLink(link);
		}
		JSONObject jsonObject=new JSONObject();
		if(resultTotal>0){
			long allCategories=blogTypeService.getTotal();
			int tagsTotal=blogTypeService.getBlogTypeData().size();
			int linkTotal=linkService.getLinkData().size();
			int alltotals=tagsTotal+linkTotal;
			request.getSession().getServletContext().setAttribute("countsallcategories", allCategories);
			request.getSession().getServletContext().setAttribute("countsalltags", alltotals);
		jsonObject.put("success", true);
		}
		else
		{
			jsonObject.put("success", false);
		}
		ResponseUtil.write(response, jsonObject);
		return null;
	}
	//删除所有标签
	@RequestMapping("/delete")
	public String deleteLink(@RequestParam(value="ids",required=false)String ids,HttpServletResponse response,HttpServletRequest request)throws Exception
	{
		String[] idsStr=ids.split(",");
		for(int i=0;i<idsStr.length;i++){
			int id=Integer.parseInt(idsStr[i]);
			linkService.deleteLink(id);
		}
		long allCategories=blogTypeService.getTotal();
		int tagsTotal=blogTypeService.getBlogTypeData().size();
		int linkTotal=linkService.getLinkData().size();
		int alltotals=tagsTotal+linkTotal;
		request.getSession().getServletContext().setAttribute("countsallcategories", allCategories);
		request.getSession().getServletContext().setAttribute("countsalltags", alltotals);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("success", true);
		ResponseUtil.write(response, jsonObject);
		return null;
	}

}
