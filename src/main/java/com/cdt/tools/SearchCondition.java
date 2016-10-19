package com.cdt.tools;

import java.util.Date;

import com.cdt.commons.HbaseConstants;
import com.cdt.utils.StringUtils;

public class SearchCondition {

	private  static String temp="";
	
	
	
	public static void main (String[] args){
		
		String hphmtest="��J?666?";
		String hphmtest2="��J*";
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
	
	
	
	
	
	
	
	
	/**�����ŵĳ��ȣ��������0��ȫ*/
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
			hphm="δʶ��";
		}
		temp=hphm;
		for(int i=0;i<15-hphm.length();i++){
			temp="-"+temp;
		}
		return temp;
	}
	
	
	public static String getHpzl(String hpzl){
		if(StringUtils.isNull(hpzl)){
			hpzl=HbaseConstants.MAX_HPZL;;//��ʾhpzlΪnullʱ�ĵ�ַ
		}
		temp=hpzl;
		for(int i=0;i<(HbaseConstants.MAX_HPZL.length()-hpzl.length());i++){
			temp="0"+temp;
		}
		return temp;
	}
	
	public static String getCdbh(String cdbh){
		if(StringUtils.isNull(cdbh)){
			cdbh=HbaseConstants.MAX_CDBH;;//��ʾcdbhΪnullʱ�ĵ�ַ
		}
		temp=cdbh;
		for(int i=0;i<(HbaseConstants.MAX_CDBH.length()-cdbh.length());i++){
			temp="0"+temp;
		}
		return temp;
	}
	
	public  static String getFxbh(String fxbh){
		if(StringUtils.isNull(fxbh)){
			fxbh=HbaseConstants.MAX_FXBH;;//��ʾfxbhΪnullʱ�ĵ�ַ
		}
		temp=fxbh;
		for(int i=0;i<(HbaseConstants.MAX_FXBH.length()-fxbh.length());i++){
			temp="0"+temp;
		}
		return temp;
	}
	
	//̨�����۽�����ȷ��ddbh��ȫΪ18λ��ddbhΪ��ʱ����9999����ʽ
	public  static  String getDdbh(String ddbh){
		if(StringUtils.isNull(ddbh)){
			ddbh=HbaseConstants.MAX_DDBH;;//��ʾddbhΪnullʱ�ĵ�ַ
		}
		temp=ddbh;
		for(int i=0;i<(HbaseConstants.MAX_DDBH.length()-ddbh.length());i++){
			temp="0"+temp;
		}
		return temp;
	}
	
	//̨�����۽�����ȷ��gcsj��ȫΪ13λ��gcsjΪ��ʱ���쳣���ݣ�����ȡ
	public static String getGcsj(Date gcsj){
		if(gcsj!=null){
			return HbaseConstants.MAX_TIME-gcsj.getTime()+"";
		}else{
			throw new IllegalArgumentException("��ȡ�Ĺ��������й���ʱ�䲻��Ϊnull��������ת�ݣ�");
		}
	}
	

	// ��0  ת��Ϊ��׼��ʽ 00001
	/***
	 * ���м���
	 */
	public static String getCounts(String numb){
		int length=numb.length();
		for(int i=0;i<(8-length);i++){
			numb="0"+numb;
		}
		return numb;
	}
	
}
