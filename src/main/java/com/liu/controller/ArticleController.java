package com.liu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.liu.Utils.ResolveToc;
import com.liu.Utils.ResponseUtil;
import com.liu.entity.Article;
import com.liu.entity.Comment;
import com.liu.entity.Page;
import com.liu.entity.PageBean;
import com.liu.entity.Topic;
import com.liu.lucene.ArticleIndex;
import com.liu.service.ArticleService;
import com.liu.service.CommentService;
import com.liu.service.PageService;

 /** 
 * @ClassName: ArticleController 
 * @author: lyd
 * @date: 2019年4月17日 下午1:42:47 
 * @describe:文章控制器
 */
@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private PageService pageService;
	ResolveToc resolveToc=new ResolveToc();//创建获取文章简介类
	ArticleIndex articleIndex=new ArticleIndex();//创建文章索引类
	/**
	 * 
	* @Title: articleByPage  
	* @Description: 分页获取文章
	 */
	@RequestMapping("/page/{nowPage}")
	public ModelAndView articleByPage(@PathVariable("nowPage")Integer nowPage)
	{
		
		Integer pageSize=5;//每页5个文章
		ModelAndView modelAndView=new ModelAndView();
		Map<String, Object> map=new HashMap<String, Object>();
		int articleCount=articleService.listArticle(map).size();//获取博客总数
		PageBean pageBean=new PageBean(nowPage, pageSize);
		map.put("start", pageBean.getPage());
		map.put("pageSize", pageBean.getPageSize());
		List<Article> articles=articleService.listArticle(map);
		for(Article article:articles)
		{
			article.setSummary(resolveToc.summary(article.getHtmlContent()));//设置文章的简介
		}
		int totalPage=(int)Math.ceil(articleCount*1.0/pageSize);//获取总的页数
		Page page=pageService.getPage(1);//获取主页得标签和图片
		modelAndView.addObject("articles", articles);
		modelAndView.addObject("firsttotalPage", totalPage);
		modelAndView.addObject("firstnowPage", nowPage);
		modelAndView.addObject("page", page);
		modelAndView.setViewName("/home/index");
		return modelAndView;
		
	}
	/**
	 * 
	* @Title: articleByAid  
	* @Description: 获取文章得详细内容
	 */
	@RequestMapping("/{aid}")
	public ModelAndView articleByAid(@PathVariable("aid")Integer aid)
	{

		ModelAndView modelAndView=new ModelAndView();
		Article preArticle=articleService.getPreArticle(aid);//当前文章的上一篇
		Article nextArticle=articleService.getNextArticle(aid);//当前文章的下一篇
		Article article=articleService.getArticleByAid(aid);
		List<Topic> tocs=resolveToc.parse(article.getHtmlContent());//获取文章的目录
		Article article1=new Article();
		article1.setArticleId(aid);
		article1.setArticleViewCount(article.getArticleViewCount()+1);//访问量+1
		if(articleService.updateArticle(article1)!=null)
		{
			article.setArticleViewCount(article.getArticleViewCount()+1);
		}
		List<Comment> comments=commentService.getCommentByAid(aid);
		for(Comment comment:comments)
		{
			comment.setChildComment(commentService.getChildComment(comment.getCommentId()));//获取文章下的评论
		}
		Page page=pageService.getPage(2);//获取文章页得标签和图片
		modelAndView.addObject("article", article);
		modelAndView.addObject("tocs", tocs);
		modelAndView.addObject("preArticle", preArticle);
		modelAndView.addObject("nextArticle", nextArticle);
		modelAndView.addObject("comments", comments);
		modelAndView.addObject("commentCount", comments.size());
		modelAndView.addObject("page", page);
		modelAndView.setViewName("/home/detail");
		return modelAndView;
	}
	
	//检索全文
	/**  
	* @Title: search  
	* @Description: 检索文章
	*/  
	@RequestMapping("/search")
	public String search(@RequestParam(value="q",required=false)String q,HttpServletRequest request,HttpServletResponse response)throws Exception
	{
		if(q!="")
		{
		JSONObject jsonObject=new JSONObject();
		List<Article> articleIndexList=articleIndex.searchArticle(q,0);//对输入的内容进行检索
		jsonObject.put("articleIndexList", articleIndexList);
		ResponseUtil.write(response, jsonObject);
		}
		return null;
	}
}
