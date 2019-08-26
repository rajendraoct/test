package com.aik.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormater 
{
  public static String getTodaysDate(Date date)
  {
	  SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yy");
	  
	  return format2.format(date);
  }
}
