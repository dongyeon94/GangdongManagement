package com.toy.root.process;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateCalculrator {
	
	public String datePlusOneDay(String date) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");	
		Calendar calculrateDate = Calendar.getInstance();
		calculrateDate.setTime(dateFormat.parse(date));
		calculrateDate.add(Calendar.DATE, 1);
		String newdate = dateFormat.format(calculrateDate.getTime());
		return newdate;
	}
	public String datePlusOneMonth(String date) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");	
		Calendar calculrateDate = Calendar.getInstance();
		calculrateDate.setTime(dateFormat.parse(date));
		calculrateDate.add(Calendar.MONTH, 1);
		String newdate = dateFormat.format(calculrateDate.getTime());
		return newdate;
	}
}
