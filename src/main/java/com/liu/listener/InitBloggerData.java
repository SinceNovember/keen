package com.liu.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.liu.Utils.DateUtil;
import com.liu.model.Blog;
import com.liu.model.BlogType;
import com.liu.model.Blogger;
import com.liu.model.Link;
import com.liu.model.PageBean;
import com.liu.service.BlogService;
import com.liu.service.BlogTypeService;
import com.liu.service.BloggerService;
import com.liu.service.LinkService;

 /** 
 * @ClassName: InitBloggerData 
 * @author: lyd
 * @date: 2017年10月10日 下午12:32:35 
 * @describe:监听器，用于刚开始加载博客的信息
 */
@Component
public class InitBloggerData implements ServletContextListener,ApplicationContextAware{
	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		InitBloggerData.applicationContext=applicationContext;
		
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		 
	}

	public void contextInitialized(ServletContextEvent sce) {//初始化加载
	applicationContext=new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");//加载spring容器
	ServletContext application=sce.getServletContext();//获取Servlet上下文
	BlogService blogService=(BlogService) applicationContext.getBean("blogService");//获取bean
	BlogTypeService blogTypeService=(BlogTypeService) applicationContext.getBean("blogTypeService");
	LinkService linkService=(LinkService) applicationContext.getBean("linkService");
	BloggerService bloggerService=(BloggerService) applicationContext.getBean("bloggerService");
	int pageSize=5;//第一页的博客个数
	int blogcounts=blogService.getAllBlog().size();//获取博客总数
	Map<String,Object> map=new HashMap<String, Object>();
	int totalPage=(int)Math.ceil(blogcounts*1.0/pageSize);//获取总的页数
	map.put("start",0);
	map.put("pageSize", pageSize);
	List<Blog> allblog=blogService.getAllBlog();//获取所有博客
	List<Blog> blogByPage=blogService.listBlog(map);//根据Map获取相应页数得博客总数
	for(Blog blog:blogByPage){
		try {
			blog.setReleaseDateStr(DateUtil.formatString2(blog.getReleaseDate().toString()));//转换数据库日期
		} catch (Exception e) {
			System.out.println("日期转换失败！");
			e.printStackTrace();
		}
	}

	int blogTypeTotal=blogTypeService.getBlogTypeData().size();//博客类别总数
	int linkTotal=linkService.getLinkData().size();//获取标签个数
	int alltotals=blogTypeTotal+linkTotal;//标签个数等于分类加添加得标签
	int allBlogs=blogService.getAllBlog().size();//所有得博客
	long allCategories=blogTypeService.getTotal();//博客类别总数
	application.setAttribute("countsallblogs", allBlogs);//将对应得存放到ServletContext中，前三为个人信息中得日志等
	application.setAttribute("countsallcategories", allCategories);
	application.setAttribute("countsalltags", alltotals);
	application.setAttribute("blogList", blogByPage);
	application.setAttribute("firstnowPage", 1);
	application.setAttribute("firstblogcount", blogcounts);
	application.setAttribute("firsttotalPage", totalPage);
	Blogger blogger=bloggerService.getBloggerData();
	blogger.setPassword(null);
	application.setAttribute("blogger", blogger);
	List<Link> linkList=linkService.getLinkData();
	application.setAttribute("linkList", linkList);
	List<BlogType> blogTypeList=blogTypeService.getBlogTypeData();
	application.setAttribute("blogTypeList", blogTypeList);
	}
//	PageBean pageBean=new PageBean(1, 10);//第一页以及10个记录
//	Map<String, Object> map=new HashMap<String, Object>();
//	map.put("start", pageBean.getPage());
//	map.put("pageSize", pageBean.getPageSize());
//	List<Blog> blogList=blogService.listBlog(map);
//	try {
//		for(int i=0;i<blogList.size();i++)
//		{
//			List<String> list=new ArrayList<String>();
//			blogList.get(i).setReleaseDateStr(DateUtil.formatString(blogList.get(i).getReleaseDate().toString()));//博客时间 转化格式
//			String imageString=blogList.get(i).getContent();//获取博客正文
//			Document document=Jsoup.parse(imageString);//通过Jsoup解析正文
//			Elements element=document.select("img[src$=.jpg|。png]");//获取正文图片地址
//			for(int j=0;j<element.size();j++){//删选前三个图片
//				if(j==3)
//					break;
//				list.add(element.get(j).attr("src"));		
//				
//			}
//			blogList.get(i).setImageList(list);
//		}
//	} catch (Exception e) {
//		e.printStackTrace();
//	}


}
