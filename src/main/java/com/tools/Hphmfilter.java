package com.tools;


/**
 * 
 * @author alex.xi
 *
 */
public class Hphmfilter {

	
	/**
	 * ÅÐ¶ÏÊäÈëµÄºÅÅÆºÅÂëÊÇ·ñºÏ¹æ
	 * @param hphmin
	 * @return
	 */
	public static boolean  isLegal(String hphmin){
		if(hphmin.length()>7||hphmin.length()<=5)
			return false;
		else
			return true;
	}
	
	public static void main(String[] args){
		
		System.out.println("  :"+Hphmfilter.isLegal("FWRMU9J6EAD18650"));
	}
	
}
