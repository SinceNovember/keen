package com.liu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;import org.apache.lucene.queryparser.surround.query.SrndPrefixQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.liu.Utils.ResponseUtil;
import com.liu.model.Blog;
import com.liu.model.Comment;
import com.liu.service.BlogService;
import com.liu.service.CommentService;

import net.sf.json.JSONObject;

 /** 
 * @ClassName: CommentController 
 * @author: lyd
 * @date: 2017年10月10日 下午5:25:11 
 * @describe:评论博客Controller
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
	@Resource
	private CommentService commentService;
	@Resource
	private BlogService blogService;
	//评论信息保存
	@RequestMapping("/save")
	public String save(Comment comment,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception{
		System.out.println("评论。");
//		String sRand=(String)session.getAttribute("sRand");//获取验证码的值
		JSONObject jsonObject=new JSONObject();
		int resultTotal=0;
			String userIp=request.getRemoteAddr();//获取评论用户ip地址
			System.out.println("userIp"+userIp);
			comment.setUserIp(userIp);
			if(comment.getId()==null)
			{
				resultTotal=commentService.addComment(comment);
				Blog blog=blogService.findById(comment.getBlog().getId());
				blog.setReplyHit(blog.getReplyHit()+1);
				blogService.update(blog);
			}else
			{
				
			}
			if(resultTotal>0){
				jsonObject.put("success", true);
			}
			ResponseUtil.write(response, jsonObject);
			return null;
		
	}
}
