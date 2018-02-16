package com.liu.Utils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.aspectj.apache.bcel.generic.ReturnaddressType;

public class DateUtil {
	/**  
	* @Title: formatDate  
	* @Description:格式化日期
	*/  
	public static String formatDate(Date date,String format){ //Date型格式化字符串
		String result="";
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		if(date!=null)
		{
		result=sdf.format(date);
		}
		return result;
	}
	public static String formatString(String str)throws Exception//SqlDate通过字符串进行格式化
	{
		if(str==null){
			return null;
		}
		SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		return sdf2.format(sdf1.parse(str));
	}
	public static String formatString1(String str)throws Exception
	{
		if(str==null){
			return null;
		}
		SimpleDateFormat sdf1=new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH);
		SimpleDateFormat sdf2=new SimpleDateFormat("MM-dd");
		return sdf2.format(sdf1.parse(str));
	}
	public static String formatString2(String str)throws Exception
	{
		if(str==null){
			return null;
		}
		SimpleDateFormat sdf1=new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH);
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
		return sdf2.format(sdf1.parse(str));
	}
	public static String formatString3(String str)throws Exception
	{
		if(str==null){
			return null;
		}
		SimpleDateFormat sdf1=new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH);
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy");
		return sdf2.format(sdf1.parse(str));
	}
	public static String getCurrentDateStr()throws Exception{ //格式化当前日期
		Date date=new Date();

		SimpleDateFormat sdf=new SimpleDateFormat("yyyMMddhhmmss");
		return sdf.format(date);
		
	}

	
}
