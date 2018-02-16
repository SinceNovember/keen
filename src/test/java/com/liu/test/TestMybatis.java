package com.liu.test;


	import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

	import org.apache.log4j.Logger;
	import org.junit.Before;
	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.springframework.context.ApplicationContext;
	import org.springframework.context.support.ClassPathXmlApplicationContext;
	import org.springframework.test.context.ContextConfiguration;
	import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

	import com.alibaba.fastjson.JSON;
import com.liu.model.Blog;
import com.liu.model.BlogType;
import com.liu.model.Blogger;
import com.liu.model.Comment;
import com.liu.model.Link;
import com.liu.service.BlogServiceImpl;
import com.liu.service.BlogTypeServiceImpl;
import com.liu.service.BloggerServiceImpl;
import com.liu.service.CommentServiceImpl;
import com.liu.service.LinkServiceImpl;
import com.liu.service.UserService;
import com.liu.service.UserServiceImpl;


	@RunWith(SpringJUnit4ClassRunner.class)		//琛ㄧず缁ф壙浜哠pringJUnit4ClassRunner绫�
	@ContextConfiguration(locations = {"classpath:ApplicationContext.xml"})
	public class TestMybatis {
//		private static Logger logger = Logger.getLogger(TestMyBatis.class);
//		private ApplicationContext ac = null;
		@Resource
		private UserServiceImpl userServiceImpl;
		@Resource
		private BlogServiceImpl blogServiceImpl;
		@Resource
		private BloggerServiceImpl BloggerServiceImpl;
		@Resource
		private BlogTypeServiceImpl blogTypeServiceImpl;
		@Resource
		private CommentServiceImpl commentServiceImpl;
		@Resource
		private LinkServiceImpl linkServiceImpl;
//		@Before
//		public void before() {
//			ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//			userService = (IUserService) ac.getBean("userService");
//		}

		@Test
		public void test1() {
			Date date=blogServiceImpl.findById(54).getReleaseDate();
			System.out.println(date);
			System.out.println(blogServiceImpl.getNextBlog(date).getId());
//			List<Blog> list=blogServiceImpl.listBlogByTypeId(16);
//			System.out.println(list.size());
//			Map<String, Object> map=new HashMap<String, Object>();
//			map.put("start1", 1);
//			map.put("pageSize", 5);
//			System.out.println(blogServiceImpl.listByPage(map).size());
			//bloggerSerivce
//			User user=new User();
//			user.setId(2);
//			user.setUserName("ooo");
//			user.setPassword("asd");
//			user.setAge(15);
//			userService.insert(user);
//			System.out.println("插入成功");
//			User user = userService.getUserById(1);
//			System.out.println("user:"+user);
//			 System.out.println(user.getUserName());
//			 logger.info("鍊硷細"+user.getUserName());
//			logger.info(JSON.toJSONString(user));
//			System.out.println("sss");
//			System.out.println("all:"+userServiceImpl.getAllUser());
//			Map<String, Object>map=new HashMap<String, Object>();
//			map.put("title", "1");
//			map.put("typeId", 1);
//			map.put("releaseDateStr", "2017年09月");
//			map.put("start", 0);
//			map.put("pageSize", 1);
//			System.out.println(blogServiceImpl.listBlog(map).size());
//			blog.setBlogType(blogType);
//			map.put("test", blog);
//			System.out.println(blogServiceImpl.getBlogData().get(0).getBlogCount());
//			Map map=new HashMap<String, Object>();
//			map.put("title", 1);
//			map.put("start", 0);
//			map.put("pageSize", 5);
//			System.out.println(blogServiceImpl.listBlog(map).get(0).getBlogType().getTypeName());
//			System.out.println(blogServiceImpl.getTotal(map));
//			Blog blog=new Blog();
//			BlogType blogType=new BlogType();
//			blogType.setId(1);
//			blog.setTitle("212");
//			blog.setBlogType(blogType);
//			blog.setId(1);
//			System.out.println(blogServiceImpl.update(blog));
//			System.out.println(blogServiceImpl.getNextBlog(2).getTitle());
//			Blog blog=new Blog();
//			BlogType blogType=new BlogType();
//			blogType.setId(1);
//			blog.setId(4);
//			blog.setTitle("21256");
//			blog.setSummary("qqs");
//			blog.setContent("sadasd");
//			blog.setKeyWord("ss");
//			blog.setBlogType(blogType);
//			System.out.println(blogServiceImpl.addBlog(blog));
//			System.out.println(blogServiceImpl.deleteBlog(4));
//			System.out.println(blogServiceImpl.getBlogByTypeId(1));
			//bloggerService
//			Blogger blogger=new Blogger();
//			blogger.setPassword("6666");
//			blogger.setSign("ada");
//			blogger.setProfile("adadass");
//			blogger.setImagename("Dadaada");
//			blogger.setNickname("adddwww");
//			System.out.println(BloggerServiceImpl.updateBlogger(blogger));
			//blogtype
//			Map<String,Object> map=new HashMap<String, Object>();
//			map.put("start", 1);
//			map.put("pageSize", 1);
//			System.out.println(blogTypeServiceImpl.getBlogTypeData().size());
//			System.out.println(blogTypeServiceImpl.listByPage(map).get(0).getId());
//			System.out.println(blogTypeServiceImpl.getById(1).getId());
//			System.out.println(blogTypeServiceImpl.getTotal());
//			BlogType blogType=new BlogType();			
//			blogType.setOrderNum(5);
//			blogType.setTypeName("4");
//			System.out.println(blogTypeServiceImpl.addBlogType(blogType));
//			BlogType blogType=new BlogType();			
//			blogType.setOrderNum(555);
//			blogType.setTypeName("4");
//			blogType.setId(6);
//			System.out.println(blogTypeServiceImpl.updateBlogType(blogType));
//			System.out.println(blogTypeServiceImpl.deleteBlogType(7));
			//comment
//			Map<String,Object>map=new HashMap<String, Object>();
//			map.put("blogId",1);
//			map.put("state", 1);
//			map.put("start", 0);
//			map.put("pageSize", 2);
//			System.out.println(commentServiceImpl.getCommentData(map).size());
//			Map<String,Object>map=new HashMap<String, Object>();
//			map.put("state", 1);
//			System.out.println(commentServiceImpl.getTotal(map));
//			Comment comment=new Comment();
//			Blog blog=new Blog();
//			blog.setId(1);
//			comment.setUserIp("ada");
////			comment.setContent("dddd");
//			comment.setBlog(blog);
//			comment.setState(3);
//			comment.setId(5);
//			System.out.println(commentServiceImpl.deleteCommentByBlogId(2));
			//Link

//			System.out.println(linkServiceImpl.getLinkData());
//			Map map=new HashMap<String, Object>();
//			map.put("start", 0);
//			map.put("pageSize",1);
//			System.out.println(linkServiceImpl.listLinkData(map));
//			Link link=new Link();
//			link.setLinkname("ss");
//			link.setId(2);
//			System.out.println(linkServiceImpl.deleteLink(2));
		}
	}


