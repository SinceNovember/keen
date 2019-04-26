package com.liu.listener;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.liu.entity.Vistor;
import com.liu.service.VistorService;
 /** 
 * @ClassName: AccessListener 
 * @author: lyd
 * @date: 2019年4月26日 下午11:22:30 
 * @describe:用于统计访问量监听器
 */
@WebListener
public class AccessListener implements ServletRequestListener,ApplicationContextAware{
	public static Integer VISTOR_NUMBER=0;
	private static Map<String,Object> vistorMap=new HashMap<String, Object>();
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		
	}

	public void requestInitialized(ServletRequestEvent sre) {
		VistorService vistorService=(VistorService) InitArticleData.applicationContext.getBean("vistorService");		
		HttpServletRequest request=(HttpServletRequest) sre.getServletRequest();
		String ip=request.getRemoteAddr();
		if(!vistorMap.containsKey(ip))
		{
			Vistor vistor=new Vistor();
			vistorMap.put(ip,true);
			String header = request.getHeader("user-agent");
			String browserVersion="";
			if(header == null || header.equals("")){
			   System.out.println("无");
			 }
	        if(header.indexOf("MSIE")>0){
	            browserVersion = "IE";
	        }else if(header.indexOf("Firefox")>0){
	            browserVersion = "Firefox";
	        }else if(header.indexOf("Chrome")>0){
	            browserVersion = "Chrome";
	        }else if(header.indexOf("Safari")>0){
	            browserVersion = "Safari";
	        }else if(header.indexOf("Camino")>0){
	            browserVersion = "Camino";
	        }else if(header.indexOf("Konqueror")>0){
	            browserVersion = "Konqueror";
	        }
			vistor.setIp(ip);
			vistor.setBrowser(browserVersion);
			vistor.setVisitTime(new Date());
			vistorService.insertVistor(vistor);
			VISTOR_NUMBER++;
		}
		
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		
	}






}
	