package com.cdt.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Datetools {


		private static SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		
		public static boolean BetweenMorning(String timestring){
			String time=timestring.substring(11);
			if(("00:00:00".compareTo(time)<=0)&& ("01:00:00".compareTo(time)>=0))
				return true;
			else return false;
			
		}
		
	
		
		public static Date GetDateFromLong(Long datelong){
			return new Date(datelong);
		}
		
		
		public static SimpleDateFormat getDateformat() {
			return dateformat;
		}

		public static void setDateformat(SimpleDateFormat dateformat) {
			Datetools.dateformat = dateformat;
		}
		
		public static String getDateTimeString(Date dates){
			return  dateformat.format(dates);
		}
	
		
		public static String getOracleDateString(String date){
			
			String  newdateString =date.substring(0, 19);
			return "to_date('"+newdateString+"', 'yyyy-mm-dd hh24:mi:ss')";
			
		}
		
		public static Date getDateFormString(String date){
			Date dates=null;
			try {
				String  newdateString =date.substring(0, 19);
				 dates = dateformat.parse(newdateString);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
			 return dates;
			}
		}
		
		//4294967295
		
		public static List<String> SplitTimes(String dateStart,String dateEnd,long  BatchTime){

			long startdate=Datetools.getDateFormString(dateStart).getTime();
			long enddate=Datetools.getDateFormString(dateEnd).getTime();
			ArrayList  resultlist=new  ArrayList();
			resultlist.add(dateStart);
			long flagtime=startdate+BatchTime;
//			System.out.println("start "+startdate+"  end:"+enddate+"  flagtime:"+flagtime);
			while(flagtime<enddate){
				resultlist.add(Datetools.getDateTimeString(new Date(flagtime)));
				flagtime=flagtime+BatchTime;
//				System.out.println("start "+startdate+"  end:"+enddate+"  flagtime:"+flagtime);
			}
			resultlist.add(dateEnd);
//			System.out.println("over  ");
			return resultlist;
		}
		
		
		/**
		 * 将时差转化为 时分秒
		 * @param timastamp
		 * @return
		 */
		public  static String FormatHMS(long timastamp){
			
			
			String hh=timastamp/1000/3600+"";
			if(hh.length()<2)
				hh="0"+hh;
			String mm=(timastamp/1000%3600/60)+"";// 余下的分钟数 取60 的模就是 分钟
			if(mm.length()<2)
				mm="0"+mm;
			String ss=(timastamp/1000%3600%60%60)+"";// 余下的秒数 取60 的模就是 分钟
			if(ss.length()<2)
				ss="0"+ss;
			String result=hh+":"+mm+":"+ss;
			return result;
		}
		
		
		public  static String FormatString(long timastamp){
            
            Date date = new Date(timastamp);
            return dateformat.format(date);
        }
        
		
		
		
		
		
		
		
	
		
		public static void main(String[]  args){
			
//			  System.out.println("flag:"+Datetools.BetweenMorning("2015-10-16 00:14:00"));	
//			  System.out.println("flag:"+Datetools.BetweenMorning("2015-10-16 01:14:00"));	
//			  System.out.println("flag:"+Datetools.BetweenMorning("2015-10-16 01:00:00"));
//			List  results=Datetools.SplitTimes("2015-01-01 17:46:13", "2015-03-01 17:46:13",  Long.valueOf(10*24*3600*1000));	
//			for(int i=0;i<results.size();i++){
//				System.out.println(i+" : "+results.get(i));
//			}
//			
//			Date date1=Datetools.getDateFormString("2015-10-16 01:14:23");
//			Date date2=Datetools.getDateFormString("2015-10-16 01:45:50");
//			
//			String result=Datetools.FormatHMS(date2.getTime()-date1.getTime());
//		    
//			System.out.println(System.currentTimeMillis());
			
		    //  1476572404986  20161011
		    //	1470862642567  20160810
		    //  1476379626107  2016-10-14 01:27:06
		    //  1470863839620  2016-10-14 01:27:06
		    
			System.out.println(Datetools.FormatString(Long.parseLong("1476764232141")));
			
			
//			Calendar caldate = Calendar.getInstance();
//            String date = dateformat.format(caldate.getTime());
//            System.out.println("date:"+date);
			
			
		}
}
