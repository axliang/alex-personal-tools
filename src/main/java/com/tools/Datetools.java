package com.tools;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Datetools {


		private static SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		public static SimpleDateFormat getDateformat() {
			return dateformat;
		}

		public static void setDateformat(SimpleDateFormat dateformat) {
			Datetools.dateformat = dateformat;
		}
		
		public String getDateTimeString(Date dates){
			return  dateformat.format(dates);
		}
	
	
}
