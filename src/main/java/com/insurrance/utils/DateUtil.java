package com.insurrance.utils;

public class DateUtil {

	public static String getStartDate(int month, int year){
		return year + "-" + month + "-01";
	}
	
	public static String getExpiredDate(int month, int year){ 
		String expiredDate = "";
		if(month == 12){
			month = 1;
			year++;
		}else{
			month++;
		}
		expiredDate = year + "-" + month + "-01";
		return expiredDate;
	}
}
