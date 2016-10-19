package com.cdt.tools;


import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class TestTime
{
	long foreTime;
	private Logger logger = Logger.getLogger(this.getClass().getName());
	/**
	 * 显示程序执行时间
	 */
	public TestTime()
	{
		foreTime=System.currentTimeMillis();
	}

	/**
	 * 执行程序所用的时间
	 * @param str  所执行程序的描述
	 */
	public void showTime(String str)
	{
		long currTime=System.currentTimeMillis();
		logger.log(Level.INFO, (str+"："+(currTime-foreTime)/1000)+" 秒，  系统时间 ："+(new Date()).toString());
		foreTime=currTime;
	}
	
}
