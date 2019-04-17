package com.liu.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.liu.Utils.ResponseUtil;
import com.liu.Utils.UploadUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/upload")
public class BackUploadController {

	/**
	 * 
	* @Title: upload  
	* @Description: 存放editor.md编辑的图片
	 */
	@RequestMapping("/article_image")
	public String upload(@RequestParam(value = "editormd-image-file", required = false) MultipartFile myfiles,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		JSONObject jsonObject=new JSONObject();
		String servletPath = request.getSession().getServletContext().getRealPath("/");//项目路径
	    String uploadPath = servletPath+"static\\pic\\";//图片存放位置
	    String OriginName = myfiles.getOriginalFilename();
	    long startTime=System.currentTimeMillis();  //获取运行时间，用于设为图片得名称
	    String suffix = OriginName.substring(OriginName.lastIndexOf(".") + 1);//获取图片后缀名
	    String fileName=startTime+"."+suffix;//图片名称
	    UploadUtil.Upload(myfiles, uploadPath,fileName);//上传图片
        jsonObject.put("success", 1);
        jsonObject.put("message", "上传成功");
        jsonObject.put("url","/Blog/static/pic/"+fileName);
        ResponseUtil.write(response, jsonObject);
		return null;
		
	}
}
