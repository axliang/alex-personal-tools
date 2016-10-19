package com.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

VEH_CENTRE_AREAS
VehCentreAreasDao

VehCentreAreasBean


create table  stock_orc(F01 string,F02, string,F03 double,F04 double,F05 string,F06 double,F07  double ,F08 double,F11 string ,F13 double ,F99 date) ,partitioned by (F88, string) ,clustered, by, (F99), into, 8, buckets, ,stored, as, orc, ,location, '/tmp/orc1', >











public class DateUtil extends TimeUtil {     
	
	/**一天的毫秒数*/
	public static long dayMills=24*60*60*1000;
	
	/**一小时的毫秒数*/
	public static long hourMills=60*60*1000;
	
	/**一分钟的毫秒数*/
	public static long minuteMills=60*1000;
	  
	/**  
	* @Functionality: 构造函数  
	*/   
	public DateUtil() {}   
	     
//	----------------------日期计算---------------------------------------------------------------------------------   
	  
	/**  
	* 是否开始日期在结束日期之前(不包括相等)  
	* @param p_startDate  
	* @param p_endDate  
	* @return boolean 在结束日期前:ture;否则：false  
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static boolean isStartDateBeforeEndDate( Date p_startDate, Date p_endDate ) throws ParseException {   
	   long l_startTime = getMillisOfDate( p_startDate );   
	   long l_endTime = getMillisOfDate( p_endDate );   
	   return ( l_startTime - l_endTime > (long) 0 ) ? true : false;   
	}   
	  
	/**  
	* 获取2个字符日期的天数差  
	* @param p_startDate  
	* @param p_endDate  
	* @return 天数差  
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static long getDaysOfTowDiffDate( String p_startDate, String p_endDate ) throws ParseException {   
	     
	   Date l_startDate = toUtilDateFromStrDateByFormat( p_startDate,"yyyy-MM-dd");   
	   Date l_endDate = toUtilDateFromStrDateByFormat( p_endDate, "yyyy-MM-dd");   
	   long l_startTime = getMillisOfDate( l_startDate );   
	   long l_endTime = getMillisOfDate( l_endDate );   
	   long betweenDays = (long) ( ( l_endTime - l_startTime ) / ( 1000 * 60 * 60 * 24 ) );   
	   return betweenDays;   
	}   
	  
	/**  
	* 获取2个字符日期的周数差  
	* @param p_startDate  
	* @param p_endDate  
	* @return 周数差  
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static long getWeeksOfTowDiffDate( String p_startDate, String p_endDate ) throws ParseException {   
	   return getDaysOfTowDiffDate(p_startDate,p_endDate)/7;   
	}   
	  
	/**  
	* 获取2个字符日期的月数差  
	* @param p_startDate  
	* @param p_endDate  
	* @return 月数差  
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static long getMonthsOfTowDiffDate( String p_startDate, String p_endDate ) throws ParseException {   
	   return getDaysOfTowDiffDate(p_startDate,p_endDate)/30;   
	}   
	/**  
	* 获取2个字符日期的年数差  
	* @param p_startDate  
	* @param p_endDate  
	* @return 年数差  
	* @author zhuqx  
	* @Date:   2006-10-31  
	*/   
	public static long getYearsOfTowDiffDate( String p_startDate, String p_endDate ) throws ParseException {   
	   return getDaysOfTowDiffDate(p_startDate,p_endDate)/365;   
	}   
	  
	/**  
	* 在给定的日期基础上添加年，月，日、时，分，秒  
	* 例如要再2006－10－21（uitl日期）添加3个月，并且格式化为yyyy-MM-dd格式，  
	* 这里调用的方式为 addDate(2006－10－21,3,Calendar.MONTH,"yyyy-MM-dd")  
	* @param p_startDate 给定的日期  
	* @param p_count 时间的数量  
	* @param p_field 添加的域  
	* @param p_format 时间转化格式，例如：yyyy-MM-dd hh:mm:ss 或者yyyy-mm-dd等  
	* @return 添加后格式化的时间  
	* @Date:   2006-10-31  
	*/   
	public static String addDate(Date p_startDate,int p_count,int p_field,String p_format)throws ParseException {   
	     
	   //年，月，日、时，分，秒   
	   int l_year = getYearOfDate(p_startDate);   
	   int l_month = getMonthOfDate( p_startDate )-1;   
	   int l_day = getDayOfDate( p_startDate );   
	   int l_hour = getHourOfDate( p_startDate );   
	   int l_minute = getMinuteOfDate( p_startDate );   
	   int l_second = getSecondOfDate( p_startDate );   
	   Calendar l_calendar = new GregorianCalendar(l_year,l_month,l_day,l_hour,l_minute,l_second);   
	   l_calendar.add(p_field,p_count);   
	   return toStrDateFromUtilDateByFormat(l_calendar.getTime(),p_format);   
	}   
	  
		/**  
		* 判断给定日期是不是润年  
		* @param p_date 给定日期   
		* @return boolean 如果给定的年份为闰年，则返回 true；否则返回 false。  
		* @Date: 2006-10-31  
		*/   
	   public static boolean isLeapYear(Date p_date) {   
	     int l_year = getYearOfDate( p_date );   
	     GregorianCalendar l_calendar = new GregorianCalendar();   
	     return l_calendar.isLeapYear( l_year );   
	   }
	   
    /**
     * 获取距离中心多少时间的时间
     * @param d 中心时间点
     * @param calendar field
     * @param amount
     * @param f 格式字符串
     * @return
     */
    public static java.util.Date getDistanceDate(java.util.Date d,int clndrField,int amount){
    	Calendar c = Calendar.getInstance();
    	c.setTime(d);
    	c.add(clndrField, amount);
    	return c.getTime();
    }
    
    /**
     * 当去当天的起始日期：即为 当天的0时0分0秒
     * @param dataformate 日期的格式
     * */
    public static String getStartOfDay(String dataformate){
    	SimpleDateFormat sdf=new SimpleDateFormat(dataformate);
    	Calendar c=Calendar.getInstance();
    	c.setTime(new Date());
    	c.set(Calendar.HOUR_OF_DAY, 0);
    	c.set(Calendar.MINUTE, 0);
    	c.set(Calendar.SECOND, 0);
    	return sdf.format(c.getTime());
    }
    
	/**将毫秒时间间隔的形式输出，天，时，分，秒
	 * @param 时间，单位毫秒
	 * @return 输出的时间间隔*/
	public static String showDateInterval(long time){
		String result=" ";
		int day=(int)(time/dayMills);
		time=time%dayMills;
		int hour=(int)(time/hourMills);
		time=time%hourMills;
		int minute=(int)(time/minuteMills);
		time=time%minuteMills;
		int second=(int)(time/1000);
		result = result+day+" 天 "+hour+" 时 "+minute+" 分 "+second+" 秒";
		return result;
	}

	public static void main(String[] args) {
		try {
			//System.out.println(toStrDateFromUtilDateByFormat(toUtilDateFromStrDateByFormat("2010-03-31 14:11:12","yyyy-MM-dd hh:mm:ss"),"HH:mm:ss"));
			//System.out.println(DateUtil.toStrDateFromUtilDateByFormat(DateUtil.getDistanceDate(new Date(),Calendar.DAY_OF_MONTH, -7),ItsConstants.DATE_FRMT_TIME));
			//System.out.println(DateUtil.toSqlTimestampFromUtilDate(DateUtil.toUtilDateFromStrDateByFormat("2010-04-17 16:53:00", "yyyy-MM-dd HH:mm:ss")));
			System.out.println(DateUtil.getStartOfDay("yyyy-MM-dd HH:mm:ss"));
			System.out.println(DateUtil.getCurrentWeekday());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}