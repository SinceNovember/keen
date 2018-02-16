package com.liu.Utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;


 /** 
 * @ClassName: ResponseUtil 
 * @author: lyd
 * @date: 2017年10月10日 下午10:31:06 
 * @describe:进行传输数据到前台 主要用来传输Json格式
 */
public class ResponseUtil {
	public static void write(HttpServletResponse response,Object obj)throws Exception
	{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(obj.toString());
		out.flush();
		out.close();
	}
}
