package com.cdt.tools;

import org.apache.log4j.Logger;

public class LogTools {
	
	
	   private Logger logger = Logger.getLogger(this.getClass().getName());
	   
	   
	   
	   public void PrintErrorTOlogger(Exception e){
			logger.error(e.getMessage(),e);
	   }
	   
	   public void PrintErrorTOlogger(Throwable throwable){
			logger.info("Exception:", throwable);
	   } 

}
