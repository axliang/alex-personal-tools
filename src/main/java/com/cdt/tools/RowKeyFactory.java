package com.cdt.tools;

import java.text.ParseException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.cdt.domain.VehPass;

public class RowKeyFactory {
	
	
	
	public static String DELIMITER="|";
	
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	
	public String GetRowKey(String type,VehPass vehPass){
		
		String result="";
			try {
				if("ddbhhphm".equals(type)){
					result=  this.getRowKeyByDdbhHphm(vehPass);
				}else if("ddbh".equals(type)){
					result=  this.getRowKeyByDdbh(vehPass);
				}else if("hphm".equals(type)){
					result= this.getRowKeyByHphm(vehPass);
				}else if("gcsj".equals(type)){
					result=  this.getRowKeyByGcsj(vehPass);
				}else if("sbbh".equals(type)){
					result=  this.getRowKeyBySbbh(vehPass);
				}else if("xlh".equals(type)){
					result=vehPass.getXlh();
				}else if("sjscsj".equals(type)){
					result=this.getRowKeyBySjscsj(vehPass);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
			return result;
	}

	
	
	//生成以ddbh+hphm为开头的rowKey
	public String getRowKeyByDdbhHphm(VehPass vehPass) throws ParseException{
		return SearchCondition.getDdbh(vehPass.getDdbh())+DELIMITER+SearchCondition.getHphm(vehPass.getHphm())+DELIMITER
			+SearchCondition.getHpzl(vehPass.getHpzl())+DELIMITER+SearchCondition.getGcsj(vehPass.getGcsj())
			+DELIMITER+SearchCondition.getFxbh(vehPass.getFxbh())+DELIMITER+SearchCondition.getCdbh(vehPass.getCdbh());
	}

	//生成以ddbh为开头的rowKey
	public String getRowKeyByDdbh(VehPass vehPass) throws ParseException{
		return SearchCondition.getDdbh(vehPass.getDdbh())+DELIMITER+SearchCondition.getGcsj(vehPass.getGcsj())
			+DELIMITER+SearchCondition.getHphm(vehPass.getHphm())+DELIMITER+SearchCondition.getHpzl(vehPass.getHpzl())
			+DELIMITER+SearchCondition.getFxbh(vehPass.getFxbh())+DELIMITER+SearchCondition.getCdbh(vehPass.getCdbh());
	}
	
	//生成以hphm为开头的rowKey
	public String getRowKeyByHphm(VehPass vehPass) throws ParseException{
		return SearchCondition.getHphm(vehPass.getHphm())+DELIMITER+SearchCondition.getHpzl(vehPass.getHpzl())+DELIMITER
			+SearchCondition.getGcsj(vehPass.getGcsj())+DELIMITER+SearchCondition.getDdbh(vehPass.getDdbh())
			+DELIMITER+SearchCondition.getFxbh(vehPass.getFxbh())+DELIMITER+SearchCondition.getCdbh(vehPass.getCdbh());
	}
	
	//生成以gcsj为开头的rowKey
	public String getRowKeyByGcsj(VehPass vehPass) throws ParseException{
		return SearchCondition.getGcsj(vehPass.getGcsj())+DELIMITER+SearchCondition.getHphm(vehPass.getHphm())+DELIMITER
			+SearchCondition.getHpzl(vehPass.getHpzl())+DELIMITER+SearchCondition.getDdbh(vehPass.getDdbh())+DELIMITER
			+SearchCondition.getFxbh(vehPass.getFxbh())+DELIMITER+SearchCondition.getCdbh(vehPass.getCdbh());
	}
	
	
	//生成以sbbh为开头的rowKey
	public String getRowKeyBySbbh(VehPass vehPass) throws ParseException{
		return SearchCondition.getDdbh(vehPass.getDdbh())+DELIMITER+SearchCondition.getFxbh(vehPass.getFxbh())+DELIMITER
			+SearchCondition.getCdbh(vehPass.getCdbh())+DELIMITER+SearchCondition.getGcsj(vehPass.getGcsj())+DELIMITER
			+SearchCondition.getHphm(vehPass.getHphm())+DELIMITER+SearchCondition.getHpzl(vehPass.getHpzl());
	}
	//生成以sjscsj为开头的rowKey
	public String getRowKeyBySjscsj(VehPass vehPass) throws ParseException{
		return  SearchCondition.getGcsj(vehPass.getSjscsj())+DELIMITER+ SearchCondition.getDdbh(vehPass.getDdbh())+DELIMITER
			+ SearchCondition.getFxbh(vehPass.getFxbh())+DELIMITER+ SearchCondition.getCdbh(vehPass.getCdbh())+DELIMITER+ SearchCondition.getHphm(vehPass.getHphm())+DELIMITER
			+ SearchCondition.getHpzl(vehPass.getHpzl());
	}
	

}
