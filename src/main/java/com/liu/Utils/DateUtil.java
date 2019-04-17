package com.liu.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String dateformatstring(Date date)
	{
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String newDate=sdf.format(date);
		return newDate;
	}
}
