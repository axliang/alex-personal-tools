package com.cdt.tools;


import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class TestTime
{
	long foreTime;
	private Logger logger = Logger.getLogger(this.getClass().getName());
	/**
	 * ��ʾ����ִ��ʱ��
	 */
	public TestTime()
	{
		foreTime=System.currentTimeMillis();
	}

	/**
	 * ִ�г������õ�ʱ��
	 * @param str  ��ִ�г��������
	 */
	public void showTime(String str)
	{
		long currTime=System.currentTimeMillis();
		logger.log(Level.INFO, (str+"��"+(currTime-foreTime)/1000)+" �룬  ϵͳʱ�� ��"+(new Date()).toString());
		foreTime=currTime;
	}
	
}
