package com.liu.controller.admin;

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
import com.liu.Utils.UploadUtil;
import com.liu.entity.Comment;
import com.liu.service.CommentService;
import com.liu.service.UserLogService;
import com.liu.service.UserService;

import net.sf.json.JSONObject;

 /** 
 * @ClassName: BackCommentController 
 * @author: lyd
 * @date: 2019年4月17日 下午2:42:40 
 * @describe:后台评论控制类
 */
@Controller
@RequestMapping("/admin")
public class BackCommentController {
	@Autowired
	private CommentService commentService;
	@Autowired 
	private UserService userService;
	@Autowired
	private UserLogService userLogService;
	ManageLog manageLog=BackArticleController.manageLog;
	/**
	 * 
	* @Title: list_comment  
	* @Description: 跳转评论页面
	 */
	@RequestMapping("/comment")
	public ModelAndView list_comment()
	{
		ModelAndView modelAndView=new ModelAndView();
		List<Comment> comments=commentService.listComment(0);
		modelAndView.addObject("comments", comments);
		modelAndView.addObject("commentCount", comments.size());
		modelAndView.setViewName("/admin/comment");
		return modelAndView;
		
	}
	/**
	 * 
	* @Title: delete_comment  
	* @Description: 删除评论
	 */
	@RequestMapping("/delete_comment")
	public String delete_comment(@RequestParam("cid")Integer cid,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		JSONObject jsonObject=new JSONObject();
		String originPath=commentService.getCommentByid(cid).getCommentAvatarPath();
		userLogService.insertLog(manageLog.insertLog("删除评论",commentService.getContentByCid(cid)));//添加日志
		if(commentService.deleteCommentByCid(cid)!=null)
		{
			UploadUtil.deleteImage(originPath, request);//删除原先的图片;
			jsonObject.put("success", true);
			jsonObject.put("msg", "评论删除成功");
		}
		else
		{
			jsonObject.put("success", false);
			jsonObject.put("msg", "评论删除失败");
		}
		ResponseUtil.write(response,jsonObject);
		return null;
	}
	/**
	 * 
	* @Title: jump_reply_comment  
	* @Description: 跳转到回复评论页面
	 */
	@RequestMapping("/jump_reply_comment")
	public ModelAndView jump_reply_comment(@RequestParam("cid")Integer cid)
	{
		ModelAndView modelAndView=new ModelAndView();
		Comment comment=commentService.getCommentByid(cid);
		modelAndView.addObject("comment", comment);
		modelAndView.setViewName("/admin/reply_comment");
		return modelAndView;
	}
	/**
	 * 
	* @Title: insert_reply  
	* @Description: 插入我得回复
	 */
	@RequestMapping("/insert_reply")
	@ResponseBody
	public String insert_reply(Comment comment,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		JSONObject jsonObject=new JSONObject();
		Date date=new Date();
		comment.setCommentCreateTime(date);
		comment.setCommentRole(1);
		comment.setCommentAuthorName(userService.getUser(1).getUserNickname());
		comment.setCommentLikeCount(0);
		comment.setCommentIp(request.getRemoteAddr());//设置为本地ip
		comment.setCommentAvatarPath("\\static\\pic\\comment\\default.jpg");

		if((commentService.insertComment(comment))!=null)		
			{
			userLogService.insertLog(manageLog.insertLog("回复评论",comment.getCommentContent()));//添加日志
			jsonObject.put("success", true);
			jsonObject.put("msg","回复成功");
			}
		else
			jsonObject.put("success", false);
		ResponseUtil.write(response,jsonObject);
		return null;
	}
	/**
	 * 
	* @Title: my_comment  
	* @Description: 跳转到我所有回复的页面
	 */
	@RequestMapping("/my_comment")
	public ModelAndView my_comment()
	{
		ModelAndView modelAndView=new ModelAndView();
		List<Comment> comments=commentService.listComment(1);//显示所有我回复得评论
		for(Comment comment:comments)
		{
			comment.setOriginalContent(commentService.getContentByCid(comment.getCommentPid()));
		}
		modelAndView.addObject("comments", comments);
		modelAndView.addObject("commentCount", comments.size());
		modelAndView.setViewName("/admin/my_comment");
		return modelAndView;
		
	}
	/**
	 * 
	* @Title: delete_my_comment  
	* @Description: 删除我得评论
	 */
	@RequestMapping("/delete_my_comment")
	public String delete_my_comment(@RequestParam("cid")Integer cid,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		JSONObject jsonObject=new JSONObject();
		userLogService.insertLog(manageLog.insertLog("删除我的回复",commentService.getContentByCid(cid)));
		if(commentService.deleteCommentByCid(cid)!=null)
		{
			jsonObject.put("success", true);
			jsonObject.put("msg", "评论删除成功");
		}
		else
		{
			jsonObject.put("success", false);
			jsonObject.put("msg", "评论删除失败");
		}
		ResponseUtil.write(response,jsonObject);
		return null;
	}
	/**
	 * 
	* @Title: jump_editor_comment  
	* @Description: 跳转到修改评论页面
	 */
	@RequestMapping("/jump_editor_comment")
	public ModelAndView jump_editor_comment(@RequestParam("cid")Integer cid)
	{
		ModelAndView modelAndView=new ModelAndView();
		System.out.println(cid);
		Comment comment=commentService.getCommentByid(cid);
		modelAndView.addObject("comment", comment);
		modelAndView.setViewName("/admin/editor_my_reply");
		return modelAndView;
	}
	/**
	 * 
	* @Title: editor_my_reply  
	* @Description: 修改我的回复
	 */
	@RequestMapping("/editor_my_reply")
	@ResponseBody
	public String editor_my_reply(Comment comment,HttpServletRequest request,HttpServletResponse response) throws Exception
	{

		JSONObject jsonObject=new JSONObject();
		if((commentService.updateMyContent(comment))!=null)		
			{
			userLogService.insertLog(manageLog.insertLog("修改我的回复",comment.getCommentContent()));
			jsonObject.put("success", true);
			jsonObject.put("msg","回复成功");
			}
		else
			jsonObject.put("success", false);
		ResponseUtil.write(response,jsonObject);
		return null;
	}
	

}
