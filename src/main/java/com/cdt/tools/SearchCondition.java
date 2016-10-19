package com.cdt.tools;

import java.util.Date;

import com.cdt.commons.HbaseConstants;
import com.cdt.utils.StringUtils;

public class SearchCondition {

	private  static String temp="";
	
	
	
	public static void main (String[] args){
		
		String hphmtest="浙J?666?";
		String hphmtest2="浙J*";
		String result =SearchCondition.ParseHphmCondion(hphmtest);
		System.out.println("--result:"+result);
		String result2 =SearchCondition.ParseHphmCondion(hphmtest2);
		System.out.println("--result2:"+result2);
	}
	public static String ParseHphmCondion(String hphms){
		
		if(hphms != null){
			if(hphms.contains("*")){
				return "hphm like '%"+hphms.replace("*", "")+"%'";
			}else if(hphms.contains("?")){
				return "hphm like '"+hphms.replace("?", "_")+"'";
			}else {
			    return "hphm in ( '"+hphms+"')";
			}
		}else{
			return "hphm is not null";
		}
		
		
	}
	
	
	public String ParseHphm(String hphm){
		String tempstr="";
		if (StringUtils.isNotEmpty(hphm)){
			if(!"*".equals(hphm.trim())){
				if (hphm.indexOf("*") >= 0
						|| hphm.indexOf("?") >= 0) {
					 tempstr = hphm.toUpperCase();
					tempstr = tempstr.replaceAll("\\?", "_");
					tempstr = tempstr.replaceAll("\\*", "%");
//					table_veh_kkjds1.append(" and v.hphm like :hphm");
//					map.put("hphm", tempstr);
				} else {
					tempstr=hphm;
				}
			}
		}
		
		return hphm;
		
		
	}
	
	
	
	
	
	
	
	
	/**任务编号的长度，补足的用0补全*/
	public static final int RWBH_LENGTH=6;
	   public  static String getRwbhRowkey(String rwbh){
	    	String rwbhkey=rwbh;
	    	int size=rwbh.length();
	    	for(int j=0;j<RWBH_LENGTH-size;j++){
	    		rwbhkey="0"+rwbhkey;
	    	}
	    	return rwbhkey;
	    }
	
	
	
	
	
	public static  String getHphm(String hphm){
		if(StringUtils.isNull(hphm)){
			hphm="未识别";
		}
		temp=hphm;
		for(int i=0;i<15-hphm.length();i++){
			temp="-"+temp;
		}
		return temp;
	}
	
	
	public static String getHpzl(String hpzl){
		if(StringUtils.isNull(hpzl)){
			hpzl=HbaseConstants.MAX_HPZL;;//表示hpzl为null时的地址
		}
		temp=hpzl;
		for(int i=0;i<(HbaseConstants.MAX_HPZL.length()-hpzl.length());i++){
			temp="0"+temp;
		}
		return temp;
	}
	
	public static String getCdbh(String cdbh){
		if(StringUtils.isNull(cdbh)){
			cdbh=HbaseConstants.MAX_CDBH;;//表示cdbh为null时的地址
		}
		temp=cdbh;
		for(int i=0;i<(HbaseConstants.MAX_CDBH.length()-cdbh.length());i++){
			temp="0"+temp;
		}
		return temp;
	}
	
	public  static String getFxbh(String fxbh){
		if(StringUtils.isNull(fxbh)){
			fxbh=HbaseConstants.MAX_FXBH;;//表示fxbh为null时的地址
		}
		temp=fxbh;
		for(int i=0;i<(HbaseConstants.MAX_FXBH.length()-fxbh.length());i++){
			temp="0"+temp;
		}
		return temp;
	}
	
	//台州讨论结束，确认ddbh补全为18位，ddbh为空时采用9999的形式
	public  static  String getDdbh(String ddbh){
		if(StringUtils.isNull(ddbh)){
			ddbh=HbaseConstants.MAX_DDBH;;//表示ddbh为null时的地址
		}
		temp=ddbh;
		for(int i=0;i<(HbaseConstants.MAX_DDBH.length()-ddbh.length());i++){
			temp="0"+temp;
		}
		return temp;
	}
	
	//台州讨论结束，确认gcsj补全为13位，gcsj为空时是异常数据，不获取
	public static String getGcsj(Date gcsj){
		if(gcsj!=null){
			return HbaseConstants.MAX_TIME-gcsj.getTime()+"";
		}else{
			throw new IllegalArgumentException("获取的过车数据中过车时间不能为null，不进行转递！");
		}
	}
	

	// 补0  转化为标准格式 00001
	/***
	 * 进行计数
	 */
	public static String getCounts(String numb){
		int length=numb.length();
		for(int i=0;i<(8-length);i++){
			numb="0"+numb;
		}
		return numb;
	}
	
}
