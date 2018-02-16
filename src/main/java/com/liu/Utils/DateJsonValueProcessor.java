package com.liu.Utils;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
  
import net.sf.json.JsonConfig;  
import net.sf.json.processors.JsonValueProcessor;  
  
 /** 
 * @ClassName: DateJsonValueProcessor 
 * @author: lyd
 * @date: 2017年10月10日 下午10:28:18 
 * @describe:Json Date处理
 */
public class DateJsonValueProcessor implements JsonValueProcessor {  
 public static final String Default_DATE_PATTERN ="yyyy-MM-dd";  
 private DateFormat dateFormat ;  
 public DateJsonValueProcessor(String datePattern){  
  try{  
   dateFormat  = new SimpleDateFormat(datePattern);  
     
  }catch(Exception e ){  
   dateFormat = new SimpleDateFormat(Default_DATE_PATTERN);  
     
  }  
    
 }  
 public Object processArrayValue(Object value, JsonConfig jsonConfig) {  
  return process(value);  
 }  
  
 public Object processObjectValue(String key, Object value,  
   JsonConfig jsonConfig) {  
  return process(value);  
 }  
 private Object process(Object value){  
  return dateFormat.format((Date)value);  
    
 }  
}  //
//import java.text.SimpleDateFormat;
//import net.sf.json.JsonConfig;
//import net.sf.json.processors.JsonValueProcessor;
//
//public class DateJsonValueProcessor implements JsonValueProcessor{
//	
//		private String format;
//		public DateJsonValueProcessor(String format){
//			format=this.format;
//		}
//		public Object processArrayValue(Object value,JsonConfig jsonConfig){
//			return null;
//		}
//		public Object processObjectValue(String key,Object value,JsonConfig jsonConfig){
//			if(value==null){
//				return "";
//			}
//			if(value instanceof java.sql.Timestamp)
//			{
//				String str=new SimpleDateFormat(format).format((java.sql.Timestamp)value);
//				return str;
//			}
//			if(value instanceof java.util.Date)
//			{
//				String str=new SimpleDateFormat(format).format((java.util.Date)value);
//				return str;
//			}
//			return value.toString();
//		}

