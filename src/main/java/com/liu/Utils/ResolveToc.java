package com.liu.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.liu.entity.Topic;

 /** 
 * @ClassName: ResolveToc 
 * @author: lyd
 * @date: 2019年4月8日 下午6:05:47 
 * @describe:解析工具
 */
public class ResolveToc {
	/**
	 * 
	* @Title: parse  
	* @Description:解析标签
	 */
	public List<Topic> parse(String html)
	{
		int i=1;
		List<Topic> tocs=new ArrayList<Topic>();
		Document doc=Jsoup.parse(html);
		Elements tocEles=doc.select("h1");//选择标签下所有得h1标签得元素
		for(Element tocEle:tocEles)
		{

			Topic topic=new Topic();
			topic.setTocName(tocEle.text());
			topic.setTocId(tocEle.attr("id"));
			topic.setTocIndex(i++);
			tocs.add(topic);
		}
		return tocs;	
	}
	/**
	 * 
	* @Title: summary  
	* @Description:解析文章简介
	 */
	public String summary(String html)
	{
		String str;
		String newhtml=html.replaceAll("<ol>\\s{2,}","<ol>");
		String[] ss=newhtml.split("\\s{2,}");
		if(ss.length<2)
			str=html;
		else
			str=ss[0]+ss[1];
		return str;
	}
}
