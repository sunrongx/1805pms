package com.zs.pms.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static String getStrDate(Date date){
		//创建一个日期对象
		Calendar calendar = Calendar.getInstance();
		//设置传入的日期
		calendar.setTime(date);
		//获得年
		int y = calendar.get(Calendar.YEAR);
		//获得月
		int m = calendar.get(Calendar.MONTH)+1;
		//获得日期
		int d = calendar.get(Calendar.DAY_OF_MONTH);
		return y+"-"+m+"-"+d;
	}
}
