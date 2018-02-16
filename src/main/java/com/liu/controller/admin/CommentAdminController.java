package com.liu.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.liu.Utils.DateJsonValueProcessor;
import com.liu.Utils.ResponseUtil;
import com.liu.model.Comment;
import com.liu.model.PageBean;
import com.liu.service.CommentService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

 /** 
 * @ClassName: CommentAdminController 
 * @author: lyd
 * @date: 2017年10月10日 下午4:40:42 
 * @describe:评论信息
 */
@Controller
@RequestMapping("/admin/comment")
public class CommentAdminController {
	@Resource
	private CommentService commentService;
	//显示所有评论信息
	@RequestMapping("/listComment")
	public String listBlog(
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			@RequestParam(value = "state", required = false) String state,
			HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page),
				Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", pageBean.getStart());
		map.put("pageSize", pageBean.getPageSize());
		map.put("state", state);
		List<Comment> commentList = commentService.getCommentData(map);
		Long total = commentService.getTotal(map);
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(commentList, jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	//删除评论
	@RequestMapping("/deleteComment")
	public String deleteComment(@RequestParam(value="ids",required=false)String ids,HttpServletResponse response)throws Exception
	{
		String idsStr[]=ids.split(",");
		for(int i=0;i<idsStr.length;i++){
			System.out.println(Integer.parseInt(idsStr[i]));
			commentService.deleteComment(Integer.parseInt(idsStr[i]));
		}
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("success", true);
		ResponseUtil.write(response, jsonObject);
		return null;
	}
	//对评论进行审核
	@RequestMapping("/review")
	public String review(@RequestParam(value="ids",required=false)String ids,@RequestParam(value="state",required=false)Integer state
			,HttpServletResponse response)throws Exception
	{
		String[] idsStr=ids.split(",");
		JSONObject jsonObject=new JSONObject();
		for(int i=0;i<idsStr.length;i++){
			Comment comment=new Comment();
			comment.setId(Integer.parseInt(idsStr[i]));
			comment.setState(state);
			commentService.update(comment);
		}
		jsonObject.put("success", true);
		ResponseUtil.write(response, jsonObject);
		return null;
	}
}
