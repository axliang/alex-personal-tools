package com.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDate {
	
	
	
	public static String DatetoString(Date datetime,String format){
		   SimpleDateFormat sdf = new SimpleDateFormat( format );   
		   String l_result = sdf.format( format );   
		    
		    return l_result;
	}
 

}
