package com.liu.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.liu.Utils.ResolveToc;
import com.liu.entity.Article;
import com.liu.entity.PageBean;
import com.liu.entity.User;
import com.liu.service.ArticleService;
import com.liu.service.CategoryService;
import com.liu.service.PageService;
import com.liu.service.TagService;
import com.liu.service.UserService;


 /** 
 * @ClassName: InitArticleData 
 * @author: lyd
 * @date: 2019年4月17日 下午3:06:24 
 * @describe:监听器，用于启动服务器时显示主页得信息
 */
public class InitArticleData implements ServletContextListener,ApplicationContextAware{

	private static ApplicationContext applicationContext;
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		applicationContext=new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
		ServletContext application=sce.getServletContext();
		ArticleService articleService=(ArticleService) applicationContext.getBean("articleService");
		CategoryService categoryService=(CategoryService) applicationContext.getBean("categoryService");
		TagService tagService=(TagService) applicationContext.getBean("tagService");
		PageService pageService=(PageService) applicationContext.getBean("pageService");
		UserService userService=(UserService) applicationContext.getBean("userService");
		ResolveToc resolveToc=new ResolveToc();
		Integer pageSize=5;
		Map<String, Object> map=new HashMap<String, Object>();
		int articleCount=articleService.listArticle(map).size();//获取博客总数
		PageBean pageBean=new PageBean(1, pageSize);
		map.put("start", pageBean.getPage());
		map.put("pageSize", pageBean.getPageSize());
		List<Article> articles=articleService.listArticle(map);
		for(Article article:articles)
		{
			article.setSummary(resolveToc.summary(article.getHtmlContent()));
		}
		int totalPage=(int)Math.ceil(articleCount*1.0/pageSize);//获取总的页数
		Integer categoryCount=categoryService.listCategory().size();
		Integer tagCount=tagService.listTag().size();
		User user=userService.getUser(1);
		user.setTags(user.getPersonTag().split(" "));
		application.setAttribute("articles", articles);
		application.setAttribute("articleCount", articleCount);
		application.setAttribute("categoryCount", categoryCount);
		application.setAttribute("tagCount", tagCount);
		application.setAttribute("firsttotalPage", totalPage);
		application.setAttribute("firstnowPage", 1);
		application.setAttribute("page", pageService.getPage(1));
		application.setAttribute("inform", user);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
