package com.liu.Utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;


 /** 
 * @ClassName: UploadUtil 
 * @author: lyd
 * @date: 2019年4月17日 下午3:17:33 
 * @describe:上传图片工具
 */
public class UploadUtil {
	/**
	 * 
	* @Title: Upload  
	* @Description: 上传图片到指定位置
	 */
	public static void Upload(MultipartFile myfiles,String uploadPath,String fileName)
	{
		  File uploadRootDir = new File(uploadPath);
	        if(!uploadRootDir.exists())
	             uploadRootDir.mkdirs();
	        File targetFile = new File(uploadPath+fileName);
	           if(fileName!=null&&fileName.length()>0){
	               try {
//	                 将源文件转移到目标文件，使用transferTo方法
	            	   myfiles.transferTo(targetFile);
	               } catch (IOException e) {
	                   e.printStackTrace();
	               }
	           }
	}
	/**
	 * 
	* @Title: UploadbgImage  
	* @Description: 上传文章和评论头像图片
	 */
	public static String UploadbgImage(MultipartFile myfiles,String lastPath,HttpServletRequest request)
	{
		   String servletPath = request.getSession().getServletContext().getRealPath("/");//项目路径
	        String uploadPath=servletPath+lastPath;//封面存放位置
	        String OriginName = myfiles.getOriginalFilename();
	        long startTime=System.currentTimeMillis();  
	        String suffix = OriginName.substring(OriginName.lastIndexOf(".") + 1);
	        String fileName=startTime+"."+suffix;
			UploadUtil.Upload(myfiles, uploadPath,fileName);
			String absolutePath=lastPath+fileName;
			return absolutePath;
	}
	/**
	 * 
	* @Title: deleteImage  
	* @Description: 删除指定路径的图片
	 */
	public static void deleteImage(String imagePath,HttpServletRequest request)
	{
		String servletPath=request.getSession().getServletContext().getRealPath("/");//项目路径
		String filePath=servletPath+imagePath;
		File file=new File(filePath);
		if(file.exists())
		{
			file.delete();

		}
		
	}
	/**
	 * 
	* @Title: UploadPageImage  
	* @Description: 用于上传页面的背景图
	 */
	public static String UploadPageImage(MultipartFile myfiles,Integer pageFlag,HttpServletRequest request)
	{
		String servletPath=request.getSession().getServletContext().getRealPath("/");
		String fileName="";
		String filePath = "static/images/";
		if(pageFlag==1)
		{
			fileName="index.jpg";
		}else if(pageFlag==2)
		{
			fileName="detail.jpg";
		}else if(pageFlag==3)
		{
			fileName="archive.jpg";
		}else if(pageFlag==4)
		{
			fileName="category.jpg";
		}else if(pageFlag==5)
		{
			fileName="tag.jpg";
		}else 
		{
			fileName="about.jpg";
		}
		filePath+=fileName;
		UploadUtil.Upload(myfiles, servletPath,filePath);
		return filePath;
	}
}
