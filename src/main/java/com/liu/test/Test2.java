package com.liu.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liu.Utils.ManageLog;
import com.liu.dao.VistorDao;
import com.liu.entity.Article;
import com.liu.entity.ArticleCategoryRef;
import com.liu.entity.ArticleTagRef;
import com.liu.entity.Comment;
import com.liu.entity.Page;
import com.liu.entity.User;
import com.liu.entity.UserLog;
import com.liu.entity.Vistor;
import com.liu.lucene.ArticleIndex;
import com.liu.service.ArticleCategoryRefService;
import com.liu.service.ArticleService;
import com.liu.service.ArticleTagRefService;
import com.liu.service.CategoryNodeService;
import com.liu.service.CategoryService;
import com.liu.service.CommentService;
import com.liu.service.PageService;
import com.liu.service.TagService;
import com.liu.service.UploadService;
import com.liu.service.UserLogService;
import com.liu.service.UserService;
import com.liu.service.VistorService;

@RunWith(SpringJUnit4ClassRunner.class)	
@ContextConfiguration(locations={"classpath:ApplicationContext.xml"})
public class Test2 {
	@Resource
	private ArticleService articleService;
	@Resource
	private CategoryService categoryService;
	@Resource
	private TagService tagService;
	@Resource
	private CategoryNodeService categoryNodeService;
	@Resource
	private ArticleCategoryRefService articleCategoryRefService;
	@Resource
	private ArticleTagRefService articleTagRefService;
	@Resource
	private UploadService uploadService;
	@Resource
	private CommentService commentService;
	@Resource
	private PageService pageService;
	@Resource
	private UserService userService;
	@Resource
	private UserLogService userLogService;
	@Resource
	private VistorService vistorService;
	ArticleIndex index=new ArticleIndex();
	@Test
	public void test() throws Exception{
//		Tag tag=new Tag();
//		tag.setTagId(57);
//		tag.setTagName("开发2311");
//		tag.setFontSize("45px");
//		tag.setFontColor("#ffffff");
//		Category category=new Category();
//		category.setCategoryId(18);
//		category.setCategoryName("112456");
//		category.setCategoryPid(1);
//		category.setCategoryOrder(2);
//		category.setCategoryDescription("没有");
//		System.out.println(categoryService.updateCategory(category));
//		Upload upload=new Upload();
//		upload.setPath("ad");
//		System.out.println(uploadService.insertPath(upload));
//		Article article=new Article();
//		article.setArticleTitle("111");
//		article.setMarkdownContent("adad");
//		article.setHtmlContent("qqwe");
//		article.setIssueType(1);
//		article.setArticleType(1);
//		article.setArticleCreateTime(new Date());
//		article.setArticleImagePath("adada");
//		articleService.insertArticle(article);
//		ArticleCategoryRef articleCategoryRef=new ArticleCategoryRef();
//		articleCategoryRef.setArticleId(1);
//		articleCategoryRef.setCategoryId(2);
//		articleCategoryRefService.insertCategoryByAid(articleCategoryRef);
//		Article article=new Article();
//		article.setArticleId(115);
//		article.setArticleTitle("1");
//		article.setMarkdownContent("123");
//		article.setHtmlContent("123");
//		article.setIssueType(0);
//		article.setArticleType(0);
//		article.setArticleImagePath("qqq");
//		article.setArticleUpdateTime(new Date());
		Map<String,Object>map=new HashMap<String, Object>();
		map.put("start", 1);
		map.put("pageSize", 5);
//		Article article=articleService.getArticleByAid(123);
//		Article article1=new Article();
//		article.setArticleId(123);
//		article.setArticleViewCount(article.getArticleViewCount()+1);
//		System.out.println(articleTagRefService.getArticleByTid(1));
		Comment comment=new Comment();
		comment.setCommentId(86);
		comment.setCommentContent("aaa");
//		comment.setCommentContent("测试啊");
		Page page=new Page();
		page.setPageFlag(1);
		page.setImagePath("123");
		page.setPageTag("111");
		User user=new User();
		user.setUserId(1);
		user.setMarkdownProfile("111");
//		user.setHeadPath("11");
//		System.out.println(userService.updateUser(user));
		String teString="123 234 345";
		String[] many=teString.split(" ");
		UserLog userLog=new UserLog();
		Date date=new Date();
		userLog.setTime(date);
		userLog.setDetail("111");
//		
		List<Article>articles=articleService.listArticle(map);

//		for(Article article:articles)
//		{
//			index.addIndex(article);
//		}
//		System.out.println("完成");
//		System.out.println(articleService.commentReduce(131));
//		System.out.println(commentService.listRecentComment(map));
//		System.out.println(userService.getUserByUsername("admin1"));
//		ManageLog manageLog=new ManageLog();
//		manageLog.insertLog("1", "111");
		Vistor vistor=new Vistor();
		vistor.setIp("111");
		vistor.setBrowser("aaa");
		vistor.setVisitTime(new Date());
		System.out.println(vistorService.deleteVistor(3));
	}
}
