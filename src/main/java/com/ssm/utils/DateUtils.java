package com.ssm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
   
	private static SimpleDateFormat dateFormat;
	
	static {
		dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
	}
	
	public static String format(Date date) {
		return dateFormat.format(date);
	}
	
}
