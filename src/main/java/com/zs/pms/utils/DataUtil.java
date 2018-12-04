package com.zs.pms.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtil {
	public static void showToday() {
		//日历类：获得当前时间，使用获得实例的方法来获得实例
		Calendar cal = Calendar.getInstance();
		//定义年月日时分秒
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH) + 1;
		int d = cal.get(Calendar.DATE);
		//int hh = cal.get(Calendar.HOUR);
		//改为24小时制
		int hh1 = cal.get(Calendar.HOUR_OF_DAY);
		int mm = cal.get(Calendar.MINUTE);
		int ss = cal.get(Calendar.SECOND);
		//输出时间
		System.out.println(y + "-" + m + "-" + d + " " + hh1 + ":" + mm + ":"
				+ ss);
		//减两个月的方法
//		cal.add(Calendar.MONTH,-2);
	}

	//获得String类型的初始化时间
	public static String getDateToStr(Date time,String pattern){
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(time);
	}
	
	//获得Date类型的初始化时间
	public static Date getStrToDate(String time,String pattern) throws ParseException{
		DateFormat df = new SimpleDateFormat(pattern);
		return df.parse(time);
	}
	
	/*public static void main(String[] args) {
		//初始化时间变量
//		Date date = new Date();
//		date.showTime();
		//输出String类型的Date时间信息
		System.out.println(DataUtil.getDateToStr(new Date(),"yy-MM-dd HH:mm:ss"));
		
	}*/
}
