package com.liu.controller.admin;

import java.util.Date;
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

import com.liu.Utils.ManageLog;
import com.liu.Utils.ResponseUtil;
import com.liu.Utils.UploadUtil;
import com.liu.entity.Article;
import com.liu.entity.Category;
import com.liu.entity.PageBean;
import com.liu.entity.Tag;
import com.liu.lucene.ArticleIndex;
import com.liu.service.ArticleCategoryRefService;
import com.liu.service.ArticleService;
import com.liu.service.ArticleTagRefService;
import com.liu.service.CategoryNodeService;
import com.liu.service.CategoryService;
import com.liu.service.CommentService;
import com.liu.service.TagService;
import com.liu.service.UserLogService;
import com.liu.service.UserService;

import net.sf.json.JSONObject;


 /** 
 * @ClassName: BackArticleController 
 * @author: lyd
 * @date: 2019年4月17日 下午2:21:27 
 * @describe:后台文章控制器
 */
@Controller
@RequestMapping("/admin")
public class BackArticleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CategoryNodeService categoryNodeService;
	@Autowired
	private TagService tagService;
	@Autowired
	private ArticleCategoryRefService articleCategoryRefService;
	@Autowired
	private ArticleTagRefService articleTagRefService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private  UserLogService userLogService;
	public static ManageLog manageLog=new ManageLog();//管理日志对象
	ArticleIndex articleIndex=new ArticleIndex();//博客索引，用于检索操作
	/**
	 * 
	* @Title: ListAll  
	* @Description: 分页显示文章
	 */
	@RequestMapping("/articles/{nowPage}")
	public ModelAndView ListAll(@PathVariable("nowPage")Integer nowPage)
	{
		ModelAndView modelAndView=new ModelAndView();
		Integer pageSize=10;//每页显示10篇文章
		Map<String, Object> map=new HashMap<String, Object>();
		int articleCount=articleService.countArticle();//获取日志总数
		PageBean pageBean=new PageBean(nowPage, pageSize);
		map.put("start", pageBean.getPage());
		map.put("pageSize", pageBean.getPageSize());
		List<Article> articles=articleService.listAdminArticle(map);
		int totalPage=(int)Math.ceil(articleCount*1.0/pageSize);//获取总的页数
		modelAndView.addObject("firsttotalPage", totalPage);
		modelAndView.addObject("firstnowPage", nowPage);
		modelAndView.addObject("articles", articles);
		modelAndView.addObject("type", "articles");//分类类型标志
		modelAndView.setViewName("/admin/all_article");
		return modelAndView;
	}
	/**
	 * 跳转到写文章
	* @Title: jump_write  
	* @Description: TODO
	 */
	@RequestMapping("/jump_write")
	public ModelAndView jump_write()
	{
		ModelAndView modelAndView=new ModelAndView();
		List<Category> categories=categoryNodeService.getAllParent();//获取所有分类
		List<Tag> tags=tagService.listTag();//获取所有标签
		modelAndView.addObject("categories", categories);
		modelAndView.addObject("tags", tags);
		modelAndView.setViewName("/admin/write_article");
		return modelAndView;

	}
	/**
	 * 
	* @Title: write  
	* @Description: 提交文章
	 */
	@RequestMapping("/write_article")
	public String write(Article article,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Date date=new Date();
		String lastPath="\\static\\bgpic\\";//封面缩略图存放位置
		JSONObject jsonObject=new JSONObject();
		if(article.getArticleImage().getOriginalFilename().length()!=0)
		{		
		String absolutePath=UploadUtil.UploadbgImage(article.getArticleImage(),lastPath, request);//上传文章封面图片
		article.setArticleImagePath(absolutePath);
		}else
		{
			article.setArticleImagePath("\\static\\bgpic\\default.jpg");//没有封面图片设置为默认图片
		}
		article.setArticleCommentCount(0);
		article.setArticleViewCount(0);
		article.setArticleCreateTime(date);
		if(articleService.insertArticle(article)!=null)
		{
		request.getSession().getServletContext().setAttribute("articleCount", articleService.countArticle());//更新添加博客后前台的显示数
		Integer articleId=articleService.getAidByTitle(article.getArticleTitle());
		articleIndex.addIndex(article);//提交文章加入到lunce索引中，用于查询
		
		if(article.getArticleTagId()!=null)
		{
			for(Integer tagId:article.getArticleTagId())
			{
			articleTagRefService.insertTagByAid(articleId, tagId);//添加选中的标签存放关联表
			}
		}
		if(article.getArticleCategoryId()!=null)
		{
			for(Integer categoryId:article.getArticleCategoryId())
			{
			articleCategoryRefService.insertCategoryByAid(articleId, categoryId);//添加选中得分类存放到关联表中
			}
		}
		userLogService.insertLog(manageLog.insertLog("添加博客", article.getArticleTitle()));//添加日志
		jsonObject.put("success", true);
		jsonObject.put("msg", "发表成功");
		}
		else
		{
			jsonObject.put("success", false);
			jsonObject.put("msg", "发表失败");
		}
		ResponseUtil.write(response, jsonObject);
		return null;
		
	}
	/**
	 * 
	* @Title: jump_editor_article  
	* @Description: 跳转到修改页面
	 */
	@RequestMapping("/jump_editor_article")
	public ModelAndView jump_editor_article(@RequestParam("aid")Integer aid)
	{
		ModelAndView modelAndView=new ModelAndView();
		Article article=articleService.getArticleByAid(aid);
		List<Category> categories=categoryNodeService.getAllParent();//显示所有分类
		List<Tag> tags=tagService.listTag();//显示所有标签
		modelAndView.addObject("categories", categories);
		modelAndView.addObject("tags", tags);
		modelAndView.addObject("article", article);
		modelAndView.addObject("articletags",articleTagRefService.getTagIdByAid(aid));
		modelAndView.addObject("articlecategories", articleCategoryRefService.getCategoryIdByAid(aid));
		modelAndView.setViewName("/admin/editor_article");
		return modelAndView;
		
	}
	/**
	 * 
	* @Title: editor_article  
	* @Description: 修改文章
	 */
	@RequestMapping("/editor_article")
	public String editor_article(Article article,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		JSONObject jsonObject=new JSONObject();
		Date date=new Date();
		String lastPath="\\static\\bgpic\\";//背景图位置
		Integer articleId=article.getArticleId();
		if(article.getArticleImage().getOriginalFilename().length()!=0)//如果修改了图片
		{		
		String originPath=articleService.getArticleByAid(article.getArticleId()).getArticleImagePath();//获取原图片路径
		String absolutePath=UploadUtil.UploadbgImage(article.getArticleImage(),lastPath, request);//上传封面图片
		UploadUtil.deleteImage(originPath, request);//删除原先的图片;
		article.setArticleImagePath(absolutePath);
		}
		article.setArticleUpdateTime(date);
		articleTagRefService.deleteByArticleId(articleId);//先删除标签关联表得数据
		articleCategoryRefService.deleteByArticleId(articleId);//先删除分类关联表得数据
		if(article.getArticleCategoryId()!=null)//插入分类
		{
			for(Integer tagId:article.getArticleTagId())
			{
			articleTagRefService.insertTagByAid(articleId, tagId);
			}
		}
		if(article.getArticleTagId()!=null)//插入标签到关联表
		{
			for(Integer categoryId:article.getArticleCategoryId())
			{
			articleCategoryRefService.insertCategoryByAid(articleId, categoryId);
			}

		}
		if(articleService.updateArticle(article)!=null)
		{
			userLogService.insertLog(manageLog.insertLog("修改博客", article.getArticleTitle()));//插入日志
			request.getSession().getServletContext().setAttribute("articleCount", articleService.countArticle());//更新添加博客后前台的显示数
			articleIndex.updateIndex(article);//修改提交，修改lucence索引
			jsonObject.put("success", true);
			jsonObject.put("msg", "修改成功");
		}
		else
		{
			jsonObject.put("success", false);
			jsonObject.put("msg", "修改失败");
		}
		ResponseUtil.write(response, jsonObject);
		return null;
		
	}
	/**
	 * 
	* @Title: delete_tag  
	* @Description: 删除文章
	 */
	@RequestMapping("/delete_article")
	public String delete_tag(@RequestParam("aid")Integer aid,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		JSONObject jsonObject=new JSONObject();
		userLogService.insertLog(manageLog.insertLog("删除博客", articleService.getArticleByAid(aid).getArticleTitle()));
		if((articleService.deleteArticle(aid))!=null)		
			{
			articleCategoryRefService.deleteByArticleId(aid);//删除分类关联表
			articleTagRefService.deleteByArticleId(aid);//删除标签关联表
			commentService.deleteCommentByAid(aid);
			request.getSession().getServletContext().setAttribute("articleCount", articleService.countArticle());//更新删除博客后前台的显示数
			articleIndex.deleteIndex(aid.toString());//删除文章后，删除指定得索引
			jsonObject.put("success", true);
			jsonObject.put("msg", "删除成功");
			}
		else
			{
			jsonObject.put("success", false);
			jsonObject.put("msg", "删除失败");
			}

		ResponseUtil.write(response,jsonObject);
		return null;
	}

}
