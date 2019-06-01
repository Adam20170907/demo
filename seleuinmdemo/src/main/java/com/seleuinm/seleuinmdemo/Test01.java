package com.seleuinm.seleuinmdemo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test01 {

	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(ft.format(date));
		Calendar calendar  = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE, 1);
		date = calendar.getTime();
		System.out.println("明天 = "+ft.format(date));
	}

}
