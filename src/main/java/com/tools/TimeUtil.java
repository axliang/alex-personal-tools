package com.tools;

package com.cdt.framework.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public abstract class TimeUtil {   
	  
	/**
	    * 鏃ユ湡鍜屾椂闂寸殑鏍煎紡
	    */
	    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd hh:mm:ss";
	  
//	---褰撳墠鏃ユ湡鐨勫勾锛屾湀锛屾棩锛屾椂锛屽垎锛岀   
	public static Calendar now   = Calendar.getInstance();   
	int    year = now.get( Calendar.YEAR );   
	int    date = now.get( Calendar.DAY_OF_MONTH );   
	int    month = now.get( Calendar.MONTH ) + 1;   
	int    hour = now.get( Calendar.HOUR );   
	int    min   = now.get( Calendar.MINUTE );   
	int    sec   = now.get( Calendar.SECOND );   
	  
//	-------------------------------鏃ユ湡绫诲瀷杞崲---------------------------------------------------------------------------   
	/**  
	* 瀛楃鍨嬫棩鏈熻浆鍖杣til.Date鍨嬫棩鏈�  
	* @Param:p_strDate 瀛楃鍨嬫棩鏈�   
	* @param p_format 鏍煎紡:"yyyy-MM-dd" / "yyyy-MM-dd hh:mm:ss"  
	* @Return:java.util.Date util.Date鍨嬫棩鏈�  
	* @Throws: ParseException  
	* @Author: zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static java.util.Date toUtilDateFromStrDateByFormat( String p_strDate, String p_format )   
	    throws ParseException {   
	   java.util.Date l_date = null;   
	   java.text.DateFormat df = new java.text.SimpleDateFormat( p_format );   
	   if ( p_strDate != null && ( !"".equals( p_strDate ) ) && p_format != null && ( !"".equals( p_format ) ) ) {   
	    l_date = df.parse( p_strDate );   
	   }   
	   return l_date;   
	}   
	  
	  
	  
	/**  
	* 瀛楃鍨嬫棩鏈熻浆鍖栨垚sql.Date鍨嬫棩鏈�  
	* @param p_strDate    瀛楃鍨嬫棩鏈�  
	* @return java.sql.Date sql.Date鍨嬫棩鏈�  
	* @throws ParseException   
	* @Author: zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static java.sql.Date toSqlDateFromStrDate( String p_strDate ) throws ParseException {   
	   java.sql.Date returnDate = null;   
	   java.text.DateFormat sdf = new java.text.SimpleDateFormat();   
	   if ( p_strDate != null && ( !"".equals( p_strDate ) ) ) {   
	    returnDate = new java.sql.Date( sdf.parse( p_strDate ).getTime() );   
	   }   
	   return returnDate;   
	}   
	     
	/**   
	* util.Date鍨嬫棩鏈熻浆鍖栨寚瀹氭牸寮忕殑瀛楃涓插瀷鏃ユ湡  
	* @param   p_date    Date   
	* @param   p_format String   
	* 鏍煎紡1:"yyyy-MM-dd"   
	* 鏍煎紡2:"yyyy-MM-dd hh:mm:ss EE"   
	* 鏍煎紡3:"yyyy骞碝M鏈坉d鏃� hh:mm:ss EE"   
	* 璇存槑: 骞�-鏈�-鏃� 鏃�:鍒�:绉� 鏄熸湡 娉ㄦ剰MM/mm澶у皬鍐�  
	* @return String   
	* @Author: zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static String toStrDateFromUtilDateByFormat( java.util.Date p_utilDate, String p_format ) throws ParseException {   
	   String l_result = "";   
	   if ( p_utilDate != null ) {   
	    SimpleDateFormat sdf = new SimpleDateFormat( p_format );   
	    l_result = sdf.format( p_utilDate );   
	   }   
	   return l_result;   
	}   
	  
	/**  
	* util.Date鍨嬫棩鏈熻浆鍖栬浆鍖栨垚Calendar鏃ユ湡  
	* @param p_utilDate Date  
	* @return Calendar  
	* @Author: zhuqx  
	* @Date: 2006-10-31  
	*/   
	public static Calendar toCalendarFromUtilDate(java.util.Date p_utilDate) {   
	   Calendar c = Calendar.getInstance();   
	   c.setTime(p_utilDate);   
	   return c;   
	}   
	  
	/**  
	* util.Date鍨嬫棩鏈熻浆鍖杝ql.Date(骞存湀鏃�)鍨嬫棩鏈�  
	* @Param: p_utilDate util.Date鍨嬫棩鏈�  
	* @Return: java.sql.Date sql.Date鍨嬫棩鏈�  
	* @Author: zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static java.sql.Date toSqlDateFromUtilDate( java.util.Date p_utilDate ) {   
	   java.sql.Date returnDate = null;   
	   if ( p_utilDate != null ) {   
	    returnDate = new java.sql.Date( p_utilDate.getTime() );   
	   }   
	   return returnDate;   
	}   
	  
	/**  
	* util.Date鍨嬫棩鏈熻浆鍖杝ql.Time(鏃跺垎绉�)鍨嬫棩鏈�  
	* @Param: p_utilDate util.Date鍨嬫棩鏈�  
	* @Return: java.sql.Time sql.Time鍨嬫棩鏈�  
	* @Author: zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static java.sql.Time toSqlTimeFromUtilDate( java.util.Date p_utilDate ) {   
	   java.sql.Time returnDate = null;   
	   if ( p_utilDate != null ) {   
	    returnDate = new java.sql.Time( p_utilDate.getTime() );   
	   }   
	   return returnDate;   
	}   
	  
	/**  
	* util.Date鍨嬫棩鏈熻浆鍖杝ql.Date(鏃跺垎绉�)鍨嬫棩鏈�  
	* @Param: p_utilDate util.Date鍨嬫棩鏈�  
	* @Return: java.sql.Timestamp sql.Timestamp鍨嬫棩鏈�  
	* @Author: zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static java.sql.Timestamp toSqlTimestampFromUtilDate( java.util.Date p_utilDate ) {   
	   java.sql.Timestamp returnDate = null;   
	   if ( p_utilDate != null ) {   
	    returnDate = new java.sql.Timestamp( p_utilDate.getTime() );   
	   }   
	   return returnDate;   
	}   
	  
	/**  
	* sql.Date鍨嬫棩鏈熻浆鍖杣til.Date鍨嬫棩鏈�  
	* @Param: sqlDate sql.Date鍨嬫棩鏈�  
	* @Return: java.util.Date util.Date鍨嬫棩鏈�  
	* @Author: zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static java.util.Date toUtilDateFromSqlDate( java.sql.Date p_sqlDate ) {   
	   java.util.Date returnDate = null;   
	   if ( p_sqlDate != null ) {   
	    returnDate = new java.util.Date( p_sqlDate.getTime() );   
	   }   
	   return returnDate;   
	}
	
	public static String toStrDateTimeFromCalendarByFormat(Calendar calendar){
		int year =calendar.get(Calendar.YEAR);    
		  
		int month=calendar.get(Calendar.MONTH)+1;    
		  
		int day =calendar.get(Calendar.DAY_OF_MONTH);    
		  
		int hour =calendar.get(Calendar.HOUR_OF_DAY);    
		  
		int minute =calendar.get(Calendar.MINUTE);    
		  
		int seconds =calendar.get(Calendar.SECOND);  
		
		String _yystr = "", _mmstr = "", _ddstr = "", _hourstr = "", _minstr = "",_secondstr = "";
		_yystr = ""+year;
		_mmstr = "" + month;
		if (month < 10) {
            _mmstr = "0" + month;
        }
		_ddstr = ""+day;
		if (day < 10) {
            _ddstr = "0" + day;
        }
		_hourstr = ""+hour;
		if(hour<10){
			_hourstr = "0" + hour;
		}
		_minstr = ""+minute;
		if(minute<10){
			_minstr = "0" + minute;
		}
		_secondstr = ""+seconds;
		if(seconds<10){
			_secondstr = "0" + seconds;
		}
		String time = _yystr+"-"+_mmstr+"-"+_ddstr+" "+_hourstr+":"+_minstr+":"+_secondstr;
		
		return time;
	}
	
	public static String toStrDateFromCalendarByFormat(Calendar calendar){
		int year =calendar.get(Calendar.YEAR);    
		  
		int month=calendar.get(Calendar.MONTH)+1;    
		  
		int day =calendar.get(Calendar.DAY_OF_MONTH);   
		
		String _yystr = "", _mmstr = "", _ddstr = "";
		_yystr = ""+year;
		_mmstr = "" + month;
		if (month < 10) {
            _mmstr = "0" + month;
        }
		_ddstr = ""+day;
		if (day < 10) {
            _ddstr = "0" + day;
        }
		
		String daystr = _yystr+"-"+_mmstr+"-"+_ddstr;
		
		return daystr;
	}
	  
//	-----------------鑾峰彇鎸囧畾鏃ユ湡鐨勫勾浠斤紝鏈堜唤锛屾棩浠斤紝灏忔椂锛屽垎锛岀锛屾绉�----------------------------   
	/**   
	* 鑾峰彇鎸囧畾鏃ユ湡鐨勫勾浠�   
	* @param p_date util.Date鏃ユ湡   
	* @return int   骞翠唤   
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static int getYearOfDate( java.util.Date p_date ) {   
	   java.util.Calendar c = java.util.Calendar.getInstance();   
	   c.setTime( p_date );   
	   return c.get( java.util.Calendar.YEAR );   
	}   
	     
	/**   
	* 鑾峰彇鎸囧畾鏃ユ湡鐨勬湀浠�   
	* @param p_date util.Date鏃ユ湡   
	* @return int   鏈堜唤   
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static int getMonthOfDate( java.util.Date p_date ) {   
	   java.util.Calendar c = java.util.Calendar.getInstance();   
	   c.setTime( p_date );   
	   return c.get( java.util.Calendar.MONTH ) + 1;   
	}   
	  
	/**   
	* 鑾峰彇鎸囧畾鏃ユ湡鐨勬棩浠�   
	* @param p_date util.Date鏃ユ湡   
	* @return int   鏃ヤ唤   
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static int getDayOfDate( java.util.Date p_date ) {   
	   java.util.Calendar c = java.util.Calendar.getInstance();   
	   c.setTime( p_date );   
	   return c.get( java.util.Calendar.DAY_OF_MONTH );   
	}   
	  
	/**   
	* 鑾峰彇鎸囧畾鏃ユ湡鐨勫皬鏃�   
	* @param p_date util.Date鏃ユ湡   
	* @return int   鏃ヤ唤   
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static int getHourOfDate( java.util.Date p_date ) {   
	   java.util.Calendar c = java.util.Calendar.getInstance();   
	   c.setTime( p_date );   
	   return c.get( java.util.Calendar.HOUR_OF_DAY );   
	}   
	     
	/**   
	* 鑾峰彇鎸囧畾鏃ユ湡鐨勫垎閽�   
	* @param p_date util.Date鏃ユ湡   
	* @return int   鍒嗛挓   
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static int getMinuteOfDate( java.util.Date p_date ) {   
	   java.util.Calendar c = java.util.Calendar.getInstance();   
	   c.setTime( p_date );   
	   return c.get( java.util.Calendar.MINUTE );   
	}   
	     
	/**   
	* 鑾峰彇鎸囧畾鏃ユ湡鐨勭閽�   
	* @param p_date util.Date鏃ユ湡   
	* @return int   绉掗挓   
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static int getSecondOfDate( java.util.Date p_date ) {   
	   java.util.Calendar c = java.util.Calendar.getInstance();   
	   c.setTime( p_date );   
	   return c.get( java.util.Calendar.SECOND );   
	}   
	     
	/**   
	* 鑾峰彇鎸囧畾鏃ユ湡鐨勬绉�     
	* @param p_date util.Date鏃ユ湡   
	* @return long   姣     
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static long getMillisOfDate( java.util.Date p_date ) {   
	   java.util.Calendar c = java.util.Calendar.getInstance();   
	   c.setTime( p_date );   
	   return c.getTimeInMillis();   
	}   
	  
//	-----------------鑾峰彇褰撳墠/绯荤粺鏃ユ湡(鎸囧畾鏃ユ湡鏍煎紡)-----------------------------------------------------------------------------------   
	/**  
	* 鑾峰彇鎸囧畾鏃ユ湡鏍煎紡褰撳墠鏃ユ湡鐨勫瓧绗﹀瀷鏃ユ湡  
	* @param p_format 鏃ユ湡鏍煎紡  
	* 鏍煎紡1:"yyyy-MM-dd"   
	* 鏍煎紡2:"yyyy-MM-dd hh:mm:ss EE"   
	* 鏍煎紡3:"yyyy骞碝M鏈坉d鏃� hh:mm:ss EE"   
	* 璇存槑: 骞�-鏈�-鏃� 鏃�:鍒�:绉� 鏄熸湡 娉ㄦ剰MM/mm澶у皬鍐�  
	* @return String 褰撳墠鏃堕棿瀛楃涓�  
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static String getNowOfDateByFormat( String p_format ) {   
	   Date d = new Date();   
	   SimpleDateFormat sdf = new SimpleDateFormat( p_format );   
	   String dateStr = sdf.format( d );   
	   return dateStr;   
	}   
	  
	/**  
	* 鑾峰彇鎸囧畾鏃ユ湡鏍煎紡绯荤粺鏃ユ湡鐨勫瓧绗﹀瀷鏃ユ湡  
	* @param p_format 鏃ユ湡鏍煎紡  
	* 鏍煎紡1:"yyyy-MM-dd"   
	* 鏍煎紡2:"yyyy-MM-dd hh:mm:ss EE"   
	* 鏍煎紡3:"yyyy骞碝M鏈坉d鏃� hh:mm:ss EE"   
	* 璇存槑: 骞�-鏈�-鏃� 鏃�:鍒�:绉� 鏄熸湡 娉ㄦ剰MM/mm澶у皬鍐�  
	* @return String 绯荤粺鏃堕棿瀛楃涓�  
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static String getSystemOfDateByFormat( String p_format ) {   
	   long time = System.currentTimeMillis();   
	   Date d2 = new Date();   
	   Date d = new Date( time );   
	   SimpleDateFormat sdf = new SimpleDateFormat( p_format );   
	   String dateStr = sdf.format( d );   
	   return dateStr;   
	}   
	  
	/**  
	* 鑾峰彇瀛楃鏃ユ湡涓�涓湀鐨勫ぉ鏁�  
	* @param p_date  
	* @return 澶╂暟  
	* @author zhuqx  
	*/   
	public static long getDayOfMonth( Date p_date ) throws ParseException {   
	   int year = getYearOfDate(p_date);   
	   int month = getMonthOfDate( p_date )-1;   
	   int day = getDayOfDate( p_date );   
	   int hour = getHourOfDate( p_date );   
	   int minute = getMinuteOfDate( p_date );   
	   int second = getSecondOfDate( p_date );   
	   Calendar l_calendar = new GregorianCalendar(year,month,day,hour,minute,second);   
	   return l_calendar.getActualMaximum( l_calendar.DAY_OF_MONTH );   
	}   
	  
//	 -----------------鑾峰彇鎸囧畾鏈堜唤鐨勭涓�澶�,鏈�鍚庝竴澶� ---------------------------------------------------------------------------   	
	/**   
	* 鑾峰彇鎸囧畾鏈堜唤鐨勭涓�澶�   
	* @param p_strDate 鎸囧畾鏈堜唤  
	* @param p_formate 鏃ユ湡鏍煎紡  
	* @return String 鏃堕棿瀛楃涓�  
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static String getDateOfMonthBegin( String p_strDate, String p_format ) throws ParseException {   
	   java.util.Date date = toUtilDateFromStrDateByFormat( p_strDate,p_format );   
	   return toStrDateFromUtilDateByFormat( date,"yyyy-MM" ) + "-01";   
	}   
	     
	/**   
	* 鑾峰彇鎸囧畾鏈堜唤鐨勬渶鍚庝竴澶�   
	* @param p_strDate 鎸囧畾鏈堜唤  
	* @param p_formate 鏃ユ湡鏍煎紡  
	* @return String 鏃堕棿瀛楃涓�  
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static String getDateOfMonthEnd( String p_strDate, String p_format ) throws ParseException {   
	   java.util.Date date = toUtilDateFromStrDateByFormat( getDateOfMonthBegin( p_strDate,p_format ),p_format );   
	   Calendar calendar = Calendar.getInstance();   
	   calendar.setTime( date );   
	   calendar.add( Calendar.MONTH,1 );   
	   calendar.add( Calendar.DAY_OF_YEAR,-1 );   
	   return toStrDateFromUtilDateByFormat( calendar.getTime(),p_format );   
	}   
	
	/**
	 * 鑾峰彇鎸囧畾骞翠唤鐨勭涓�澶�   
	 * @param p_strDate  鎸囧畾骞翠唤
	 * @param p_format
	 * @return
	 * @throws ParseException
	 */
	public static String getDateOfYearBegin( String p_strDate, String p_format ) throws ParseException {   
		   java.util.Date date = toUtilDateFromStrDateByFormat( p_strDate,p_format );   
		   return toStrDateFromUtilDateByFormat(date,"yyyy") + "-01-01";   
	}
	
	/**   
	* 鑾峰彇鎸囧畾骞翠唤鐨勬渶鍚庝竴澶�   
	* @param p_strDate 鎸囧畾鏈堜唤  
	* @param p_formate 鏃ユ湡鏍煎紡  
	* @return String 鏃堕棿瀛楃涓�  
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static String getDateOfYearEnd( String p_strDate, String p_format ) throws ParseException {   
	   java.util.Date date = toUtilDateFromStrDateByFormat( getDateOfYearBegin( p_strDate,p_format ),p_format );   
	   Calendar calendar = Calendar.getInstance();   
	   calendar.setTime( date );   
	   calendar.add( Calendar.YEAR,1 );   
	   calendar.add( Calendar.DAY_OF_YEAR,-1 );   
	   return toStrDateFromUtilDateByFormat( calendar.getTime(),p_format );   
	} 
	
	/**
	 * 鑾峰彇褰撳墠骞翠唤鍙婁箣鍓�5骞� 骞翠唤鍒楄〃
	 * @param n 褰撳墠骞翠唤鍚戝墠骞翠唤鏁�
	 * @return
	 */
	public static List getYearList(int n){
		Calendar calendar = Calendar.getInstance();
		List yearList = new ArrayList();
		int nowYear = calendar.get(Calendar.YEAR);
		for(int i=0;i<n+1;i++){
			yearList.add(nowYear-i);
		}
		return yearList;
	}
	
//	/**
//	 * 鑾峰彇鏈堜唤鍒楄〃
//	 * @return
//	 */
//	public static List getMonthList(){
//		List monthList = new ArrayList();
//		for(int i=0;i<12;i++){
//			monthList.add(ToolUtil.appendZero(i+1+"",2));
//		}
//		return monthList;
//	}
//	/**
//	 * 鑾峰彇灏忔椂鍒楄〃
//	 * @return
//	 */
//	public static List getHourList(){
//		List hourList = new ArrayList();
//		for(int i=-1;i<23;i++){
//			hourList.add(ToolUtil.appendZero(i+1+"",2));
//		}
//		return hourList;
//	}
//	
	//**********************************************00 2010-05-30鍔犲叆***********************************************************
	
    //鐢ㄦ潵鍏ㄥ眬鎺у埗 涓婁竴鍛紝鏈懆锛屼笅涓�鍛ㄧ殑鍛ㄦ暟鍙樺寲     
    private static int weeks = 0;     
    private static int MaxDate;//涓�鏈堟渶澶уぉ鏁�     
    private static int MaxYear;//涓�骞存渶澶уぉ鏁�  
	 /**    
        * 寰楀埌浜屼釜鏃ユ湡闂寸殑闂撮殧澶╂暟    
        */     
    public static String getTwoDay(String sj1, String sj2) {     
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");     
        long day = 0;     
        try {     
         java.util.Date date = myFormatter.parse(sj1);     
         java.util.Date mydate = myFormatter.parse(sj2);     
         day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);     
        } catch (Exception e) {     
         return "";     
        }     
        return day + "";     
    }     
     
     
    /**    
        * 鏍规嵁涓�涓棩鏈燂紝杩斿洖鏄槦鏈熷嚑鐨勫瓧绗︿覆          
        */     
    public static String getWeek(String sdate) {     
        // 鍐嶈浆鎹负鏃堕棿     
        Date date = TimeUtil.strToDate(sdate);     
        Calendar c = Calendar.getInstance();     
        c.setTime(date);     
        return new SimpleDateFormat("EEEE").format(c.getTime());     
    }     
     
    /**    
        * 灏嗙煭鏃堕棿鏍煎紡瀛楃涓茶浆鎹负鏃堕棿 yyyy-MM-dd 
        */     
    public static Date strToDate(String strDate) {     
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");     
        ParsePosition pos = new ParsePosition(0);     
        Date strtodate = formatter.parse(strDate, pos);     
        return strtodate;     
    }     
     
    /**    
        * 涓や釜鏃堕棿涔嬮棿鐨勫ぉ鏁� 
        */     
    public static long getDays(String date1, String date2) {     
        if (date1 == null || date1.equals(""))     
         return 0;     
        if (date2 == null || date2.equals(""))     
         return 0;     
        // 杞崲涓烘爣鍑嗘椂闂�     
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");     
        java.util.Date date = null;     
        java.util.Date mydate = null;     
        try {     
         date = myFormatter.parse(date1);     
         mydate = myFormatter.parse(date2);     
        } catch (Exception e) {     
        }     
        long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);     
        return day;     
    }     
     
     
     
         
    // 璁＄畻褰撴湀鏈�鍚庝竴澶�,杩斿洖瀛楃涓�     
    public static String getDefaultDay(){       
       String str = "";     
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");         
     
       Calendar lastDate = Calendar.getInstance();     
       lastDate.set(Calendar.DATE,1);//璁句负褰撳墠鏈堢殑1鍙�     
       lastDate.add(Calendar.MONTH,1);//鍔犱竴涓湀锛屽彉涓轰笅鏈堢殑1鍙�     
       lastDate.add(Calendar.DATE,-1);//鍑忓幓涓�澶╋紝鍙樹负褰撴湀鏈�鍚庝竴澶�     
            
       str=sdf.format(lastDate.getTime());     
       return str;       
    }     
         
    // 涓婃湀绗竴澶�     
    public static String getPreviousMonthFirst(){       
       String str = "";     
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");         
     
       Calendar lastDate = Calendar.getInstance();     
       lastDate.set(Calendar.DATE,1);//璁句负褰撳墠鏈堢殑1鍙�     
       lastDate.add(Calendar.MONTH,-1);//鍑忎竴涓湀锛屽彉涓轰笅鏈堢殑1鍙�     
        str=sdf.format(lastDate.getTime());     
       return str;       
    }     
         
    //鑾峰彇褰撴湀绗竴澶�     
    public static String getFirstDayOfMonth(){       
       String str = "";     
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");         
     
       Calendar lastDate = Calendar.getInstance();     
       lastDate.set(Calendar.DATE,1);//璁句负褰撳墠鏈堢殑1鍙�     
       str=sdf.format(lastDate.getTime());     
       return str;       
    }    
         
         
    //鑾峰彇褰撳ぉ鏃堕棿      
    public static String getNowTime(String dateformat){     
        Date   now   =   new   Date();        
        SimpleDateFormat   dateFormat   =   new   SimpleDateFormat(dateformat);//鍙互鏂逛究鍦颁慨鏀规棩鏈熸牸寮�        
        String hehe = dateFormat.format(now);        
        return hehe;     
    }     
         
    // 鑾峰緱褰撳墠鏃ユ湡涓庢湰鍛ㄦ棩鐩稿樊鐨勫ぉ鏁�     
    private static int getMondayPlus() {     
        Calendar cd = Calendar.getInstance();     
        // 鑾峰緱浠婂ぉ鏄竴鍛ㄧ殑绗嚑澶╋紝鏄熸湡鏃ユ槸绗竴澶╋紝鏄熸湡浜屾槸绗簩澶�......     
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK)-1;         //鍥犱负鎸変腑鍥界ぜ鎷滀竴浣滀负绗竴澶╂墍浠ヨ繖閲屽噺1  
        System.out.println("鐩稿樊澶╂暟:"+dayOfWeek);     
        if (dayOfWeek == 1) {     
            return 0;     
        } else {     
            return 1 - dayOfWeek;     
        }     
    }     
         
    //鑾峰緱鏈懆涓�鐨勬棩鏈�     
    public static String getMondayOFWeek(){
         int mondayPlus = getMondayPlus();     
         GregorianCalendar currentDate = new GregorianCalendar();     
         currentDate.add(GregorianCalendar.DATE, mondayPlus);     
         Date monday = currentDate.getTime();     
              
         DateFormat df = DateFormat.getDateInstance();     
         String preMonday = df.format(monday);     
         return preMonday;     
    }     
         
    //鑾峰緱鐩稿簲鍛ㄧ殑鍛ㄥ叚鐨勬棩鏈�     
    public static String getSaturday() {     
        int mondayPlus = getMondayPlus();     
        GregorianCalendar currentDate = new GregorianCalendar();     
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * 0 + 6);     
        Date monday = currentDate.getTime();     
        DateFormat df = DateFormat.getDateInstance();     
        String preMonday = df.format(monday);     
        return preMonday;     
    }          
         
    // 鑾峰緱鏈懆鏄熸湡鏃ョ殑鏃ユ湡       
    public static String getCurrentWeekday() {
        int mondayPlus = getMondayPlus();     
        GregorianCalendar currentDate = new GregorianCalendar();     
        currentDate.add(GregorianCalendar.DATE, mondayPlus+6);     
        Date monday = currentDate.getTime();     
             
        DateFormat df = DateFormat.getDateInstance();     
        String preMonday = df.format(monday);     
        return preMonday;     
    } 
         
    // 鑾峰緱涓婂懆鏄熸湡鏃ョ殑鏃ユ湡     
    public static String getPreviousWeekSunday() {  
        int mondayPlus = getMondayPlus();     
        GregorianCalendar currentDate = new GregorianCalendar();     
        currentDate.add(GregorianCalendar.DATE, mondayPlus+weeks);     
        Date monday = currentDate.getTime();     
        DateFormat df = DateFormat.getDateInstance();     
        String preMonday = df.format(monday);     
        return preMonday;     
    }     
     
    // 鑾峰緱涓婂懆鏄熸湡涓�鐨勬棩鏈�     
    public static String getPreviousWeekday() {  
        int mondayPlus = getMondayPlus();     
        GregorianCalendar currentDate = new GregorianCalendar();     
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks);     
        Date monday = currentDate.getTime();     
        DateFormat df = DateFormat.getDateInstance();     
        String preMonday = df.format(monday);     
        return preMonday;     
    }     
         
    // 鑾峰緱涓嬪懆鏄熸湡涓�鐨勬棩鏈�     
    public static String getNextMonday() {     
        int mondayPlus = getMondayPlus();     
        GregorianCalendar currentDate = new GregorianCalendar();     
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7);     
        Date monday = currentDate.getTime();     
        DateFormat df = DateFormat.getDateInstance();     
        String preMonday = df.format(monday);     
        return preMonday;     
    }
	//*******************************************************************************************************************
	public static void main(String[] args) {
		try {
			System.out.println(DateUtil.getPreviousWeekday());
			System.out.println(DateUtil.getDefaultDay());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}