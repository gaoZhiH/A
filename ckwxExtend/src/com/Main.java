package com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
	private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy年MM月dd日");
	public static void main(String[] args) {
		String t="2017年11月10日";
		/*
		Date date =new Date (t);
		System.out.println(date);*/
		//System.out.println(SIMPLE_DATE_FORMAT.format(t));
		//SIMPLE_DATE_FORMAT.format(new Date(t));
	Date d =null;
		 try {
		d	= SIMPLE_DATE_FORMAT.parse(t);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(d);
	}
}
