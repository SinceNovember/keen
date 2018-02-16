package com.liu.Utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
	/**  
	* @Title: isEmpty  
	* @Description: 判断是否为空
	*/  
	public static boolean isEmpty(String str){
		if(str==null||"".equals(str.trim()))
		{
			return true;
			
		}else{
			return false;
		}
	}
	/**  
	* @Title: isNotEmpty  
	* @Description:判断是否部位空
	*/  
	public static boolean isNotEmpty(String str){
		if((str!=null)&&!("".equals(str.trim()))){
			return true;
		}
		else{
			return false;
		}
	}
	/**  
	* @Title: formatLike  
	* @Description:格式化模糊查询
	*/  
	public static String formatLike(String str){
		if(isNotEmpty(str)){
			return "%"+str+"%";
		}else
		{
			return null;
		}
	}
	public static List<String>filterWhite(List<String> list){
		List<String> resultList=new ArrayList<String>();
		for(String l:list)
		{
			if(isNotEmpty(l))
			{
				resultList.add(l);
			}
		}
		return resultList;
	}
}
