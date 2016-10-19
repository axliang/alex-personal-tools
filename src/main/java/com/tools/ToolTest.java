package com.tools;


import java.io.DataInput;
import java.io.IOException;

import org.apache.hadoop.hbase.util.Bytes;



public class ToolTest {
	
//	static String inputdata="XH	HPZL	HPHM	CLPP1	CLXH	CLPP2	GCJK	ZZG	ZZCMC	CLSBDH	FDJH	CLLX	CSYS	SYXZ	SFZMHM	SFZMMC	SYR	SYQ	CCDJRQ	DJRQ	YXQZ	QZBFQZ	FZJG	GLBM	FPRQ	FZRQ	FDJRQ	FHGZRQ	BXZZRQ	BPCS	BZCS	BDJCS	DJZSBH	ZDJZSHS	DABH	XZQH	ZT	DYBJ	JBR	CLLY	LSH	FDJXH	RLZL	PL	GL	ZXXS	CWKC	CWKK	CWKG	HXNBCD	HXNBKD	HXNBGD	GBTHPS	ZS	ZJ	QLJ	HLJ	LTGG	LTS	ZZL	ZBZL	HDZZL	HDZK	ZQYZL	QPZK	HPZK	HBDBQK	CCRQ	HDFS	LLPZ1	PZBH1	LLPZ2	PZBH2	XSDW	XSJG	XSRQ	JKPZ	JKPZHM	HGZBH	NSZM	NSZMBH	GXRQ	XGZL	QMBH	HMBH	BZ	JYW	ZSXZQH	ZSXXDZ	YZBM1	LXDH	ZZZ	ZZXZQH	ZZXXDZ	YZBM2	ZDYZT	YXH	CYRY	DPHGZBH	SQDM	CLYT	YTSX	DZYX	XSZBH	SJHM	JYHGBZBH	DWBH	SYQSRQ	YQJYQZBFQZ	YQJYQZ2	FDJGS	SFYZHGN	ZZJGLX	WXMBC	NCDQSY";
	
	static String tableindex="XLH	GLXLH	HPHM	HPZL	SYXZ	CLLX	SFGPS	SFJLY	SYR	LXDH	LXDZ	SFZMHM	AQY	AQYDH	AQYDZ	AQYSFZ	YYQD	YYZD	LCS	WFWCLS	WFYCLS	SGWCLS	SGYCLS	SFHMD	SFGP	CJR	CJDW	CJIP	CJSJ	BZ1	BZ2	BZ3";
	
	static String ownersql="BZ3	XLH	XZ	MC	DM	LXR	SJHM	GDDH	ZYYW	LXDZ	ZGDW	CJR	CJDW	CJIP	CJSJ	SZSF	WFZS	SGZS	WCLS	JDCZS	JSRZS	SFGP	BZ1	BZ2";
	
	static String  veh_viorecsql ="XLH	HPHM	HPZL	CSYS	CWKC	WFSJ	HDLQSJ	HDCXSJ	CDBH	FXBH	CLLX	WFXW	WFXW2	WFNR	WFNR2	SCZT	ZHCZSJ	WFDD	DDBH	CLBH	SBBH	ZMS	SJSS	SJLY	TPZT	SJSCSJ	TPSCSJ	HPYS	BKXH	CLTP1	CLTP2	CLTP3	CLTP4	CLTP5	CLTP6	CLTP7	DCXS	XCXS	CLSD	ZJCCFS	JDZT	CJR	JDR	JDRQ	JDJG	DZRY	TZDH	ZDXH	TSCZR	TSCZIP	CLSYR	ZSXXDZ	YZBM	SJHM	DHHM	DZYJ	JSZH	FZJG	DSR	TZRQ	TZR	WFJFS	FKJE	ZNJ	CLJG	WFBH	CLSJ	YYFS	JDS	CFR	DSRSFZ	DSRDZ	DSRXZQH	DSRDABH	DSRDH	DSRQTLXFS	JKFS	JSJQ	SPJE	SPR	SPSJ	CLPP	HCBZ	ZCBZ	CLFS	BZ	BYZD1	BYZD2	BYZD3	CJSJHM	XJJH	XJXM	XZQH";
	
	static String  veh_passrec_gcsj="xlh	 sbbh	fxbh	hphm	hpzl	clbh	gcsj gcsjToStr	clsd	cwkc	hpys	cllx	hdlqssj	hdcxsj	cltp1	cltp2	cltp3	cltp4	cltp5	cltp6	cltp7	wfxw	dcxs	xcxs	wfbj	sjscsj sjscsjToStr	cdbh	ddbh	ddms	ptjdbh	sczt	xsfx	fxms	clpp	zjccfs	csys	byzd1	byzd2	byzd3";
    static String veh_passrec_gcsj2="xlh,sbbh,fxbh,hphm,hpzl,clbh,gcsj,gcsjToStr,clsd,cwkc,hpys,cllx,hdlqssj,hdcxsj,cltp1,cltp2,cltp3,cltp4,cltp5,cltp6,cltp7,wfxw,dcxs,xcxs,wfbj,sjscsj,sjscsjToStr,cdbh,ddbh,ddms,ptjdbh,sczt,xsfx,fxms,clpp,zjccfs,csys,byzd1,byzd2,byzd3";
	
	
	static String  veh_viorec="	XLH	HPHM	HPZL	CSYS	CWKC	WFSJ	HDLQSJ	HDCXSJ	CDBH	FXBH	CLLX	WFXW	WFXW2	WFNR	WFNR2	SCZT	ZHCZSJ	WFDD	DDBH	CLBH	SBBH	ZMS	SJSS	SJLY	TPZT	SJSCSJ	TPSCSJ	HPYS	BKXH	CLTP1	CLTP2	CLTP3	CLTP4	CLTP5	CLTP6	CLTP7	DCXS	XCXS	CLSD	ZJCCFS	JDZT	CJR	JDR	JDRQ	JDJG	DZRY	TZDH	ZDXH	TSCZR	TSCZIP	CLSYR	ZSXXDZ	YZBM	SJHM	DHHM	DZYJ	JSZH	FZJG	DSR	TZRQ	TZR	WFJFS	FKJE	ZNJ	CLJG	WFBH	CLSJ	YYFS	JDS	CFR	DSRSFZ	DSRDZ	DSRXZQH	DSRDABH	DSRDH	DSRQTLXFS	JKFS	JSJQ	SPJE	SPR	SPSJ	CLPP	HCBZ	ZCBZ	CLFS	BZ	BYZD1	BYZD2	BYZD3	CJSJHM	XJJH	XJXM	XZQH	WFSJ2	WFDD2	DDBH2";

	static String veh_gcsj="rwbh,hphm,hpzl,gcsj,ddbh ,ddmc ,fxbh ,fxmc ,gcjlxh,cdbh,fk";
	static String  veh_viorec2="XLH,HPHM,HPZL,WFSJ,CLLX,WFXW,WFNR,SCZT,WFDD,DDBH,SJSS,SJLY,TPZT,SJSCSJ,HPYS,CLTP1,CLTP2,DCXS,XCXS,CLSD,ZJCCFS,CSYS,WFSJ2,WFDD2,DDBH2";

	static String veh_dm_follow="rwbh,hphm,hpzl,ddbh,fxbh,gcsj,hphm2,hpzl2,gcsj2,gcjlxh,gcjlxh2";
	
	static String    cloumns="v_hphm    ,	v_hpzl    ,	v_cllx    ,	v_srjkdbh ,	v_srjkdmc ,	v_srsj    ,	v_srtp    ,	v_scjkdbh ,	v_scjkdmc ,	v_scsj    ,	v_sctp    ,	v_qjbh    ,	v_qjmc    ,	v_qjjl    ,	v_pjsd    ,	v_sfcs    ,	v_wfxw    ,	v_xsz     ,	v_jdcwftp ,	v_srgcxh  ,	v_scgcxh  ,	v_csys    ,	v_hpys    ,	v_code    ,	v_message ";
	
	static String    SystemLoadString="driverName,jdbc_url,Dm_Veh_Clash_Result,Dm_Veh_Clash_Result_Detail,Dm_Veh_Follow_Result,Dm_Veh_Follow_Result_Detail";

	static String  roadPlace="jkdbh	mc	sm	dwdm	gxsj	jd	wd	cjtp	js	bz	jllx	jfbh	jkdlx	jkdjb	flag	jkdzt	pyjx	dym1	dym2	dym3	dym4	dym5	ddlx	xzqh	jstz	dwlx	jrqgjcbk	fxctq	ssxm";
	
	static String  roadPlace2="jkdbh	mc	sm	dwdm	jd	wd ";
	
	
	
	static String  hz_gps_itmes  ="CPHM,TIME,LATITUDE,LONGITUDE,TERMINAL_ID,SERIAL_NUMBER,ALARM_ID,STATUS,SPEED,ORIENTATION,LATITUDE_DECODE,LONGITUDE_DECODE,UPDATE_TIME";
	
	
	
	static String  tpi_area="xlh,qyid,txsj,yddj,tpi,vkt,gxsj,ydlcbl,speed,ydlccd,tpi2,tpi3,tpi4,vkt2";
	
	
	static  String tpi_city="xlh,csid,txsj,yddj,tpi,vkt,gxsj,ydlcbl,speed,ydlccd,tpi2,tpi3,tpi4";


	static String tpi_road="xlh,dlid,txsj,yddj,tpi,vkt,gxsj,ydlcbl,speed,ydlccd,tpi2,tpi3,tpi4";
	
	static String tpi_section="xlh,ldid,txsj,yddj,tpi,vkt,gxsj,ydlcbl,speed,ydlccd,tpi2,tpi3,tpi4";


	static String tpi_shortpath="xlh,ljid,txsj,yddj,tpi,vkt,vf,ljcd,llzs,pjsd,vktjsfs,gxsj,tpi2,dldj,kind,vkt2";
	
	
	static String t_web_reportflow="id,schoolid,studentid,item,status,order";
	static String t_web_sysconfig="id,school_id,item,itemvalue,iteminfo";
	
	
	
	static String t_web_expense="id,schoolid,school,college,collegecode,speciality,specialitycode,item ,expense,cycle ";
	static String t_student_expense="id,schoolid,,userid,school,college,collegecode,speciality,specialitycode,itemid,item,expense,cycle,status";
	static String t_map_student_expense="id,schoolid,userid,itemid,status";
	static String t_web_material="id,schoolId,college,collegeCode,speciality,specialityCode,item,itemDetail,receiveTime,receiveAddr";

	
    static String hy_wjf_userinfo="OP_TIME,USER_ID,CUST_ID,ACCT_ID,AGE_ID,SEX_ID,EDUCATION_ID,OCCUPATION_ID,CUSTSTATUS_ID,CUSTTYPE_ID,IMSI,SIM,VIP_MARK,ENTERPRISE_ID,PRODUCT_NO,CITY_ID,COUNTY_ID,CHANNEL_ID,CHANNELTYPE_ID,USER_OPENTIME,BIG_BRAND_ID,BRAND_ID,USERSTATUS_ID,PLAN_ID,USER_ONLINE_ID,USER_OFFLINE_ID,DAY_NEW_MARK,DAY_OFF_MARK,HLR_CODE,USER_PROPERTY,ORDER_NO,STS_DATE,VALID_DATE,expire_date";
    static String hy_wjf_position="cause,cellId,eventId,imei,imsi,lac,lacCell,lacCoordinate,msisdn,timestamp";
//    static String hy_wjf_score="SCORE_BALANCE_ID ,REGION_ID ,SCORE_CYCLE ,ENTT_ID,ENTT_TYPE ,SCORE_TYPE ,SCORE_BALANCE ,EXTEND_BALANCE ,NEW_SCORE ,RD_SCORE ,CREATE_TYPE ,CREATE_TIME ,CUR_MON_NEW_SCORE ,STAT_MONTH ,STAT_DATE";
    static String hy_wjf_score="Score_Cycle ,Entt_Id ,Score_Type ,Score_Balance  ,Stat_Month ,Stat_Date";

    // verify table
    
   // \s\n    ->,
    static String hy_verify_creditModel="name,idNumber,address,registrationTime,phoneBrand,phoneModel,phoneSystem,authentication,userstatus,homeCoordinate,workCoordinate,morningCoordinate,afternoonCoordinate,nightCoordinate,contactCity,contactPerson,contactRisk,internetBehavior,registrationType,feeOweLevel,starLevel,blacklistType,groupType";
    static String hy_verify_tempInfo="workAndHomeCoordinate,residentAddressConfidence,workAddressConfidence,workCoordinateList,residentCoordinateList,morningCoordinateList,afternoonCoordinateList,nightCoordinateList,recentContactCity,cityCalculatedDate,recentContactPerson,contactorCalculatedDate,recentContactRisk,recent5warnStatistic,recentCallStatistics,recentMsgStatistics,recentGPRSStatistics,recentTotalFeeStatistics,recentExitCountry,recentTerminal,recentDomesticRoamCall,offlineConsumeList,businessTravelList,recentAbnormalBehavior,recentRelationshipsRisk";

    

    //
    





	
	
//  key,rwbh,hphm,hpzl,gcsj,ddbh,ddmc,fxbh,fxmc,gcjlxh,cdbh,fk
	
	
	
	
	//鏇挎崲鎹㈣绗�  \r\n
	
	static String fakeitmes="rwbh,	rowKey,	fk,	gcjlxh,	gcjlxh2,	hphm,	hpzl,	gcsj,	gcsj2,	sjsj,	sjsj2,	ddbh,	ddmc,	ddbh2,	ddmc2,	fxbh,	fxbh2,	fxms,	fxms2,xssd";
	static String fakerowkey="rwbh,hphm,hpzl,ddbh,fxbh,gcsj,ddbh2,fxbh2,gcsj2";
	
	static String inceptorjars="/usr/lib/hive/lib/commons-cli-1.2.jar,	/usr/lib/hive/lib/commons-codec-1.6.jar,	/usr/lib/hive/lib/commons-collections-3.2.1.jar,	/usr/lib/hive/lib/commons-configuration-1.6.jar,	/usr/lib/hive/lib/commons-logging-1.1.1.jar,	/usr/lib/hive/lib/guava-11.0.2.jar,	/usr/lib/hive/lib/httpclient-4.2.5.jar,	/usr/lib/hive/lib/httpcore-4.2.5.jar,	/usr/lib/hive/lib/libfb303-0.9.0.jar,	/usr/lib/hive/lib/libthrift-0.9.0.jar,	/usr/lib/hive/lib/log4j-1.2.16.jar,	/usr/lib/hive/lib/slf4j-api-1.6.1.jar,	/usr/lib/hive/lib/slf4j-log4j12-1.6.1.jar,	/usr/lib/hive/lib/hive-common-0.12.0-transwarp-tdh40.jar,	/usr/lib/hive/lib/hive-jdbc-0.12.0-transwarp-tdh40.jar,	/usr/lib/hive/lib/hive-metastore-0.12.0-transwarp-tdh40.jar,	/usr/lib/hive/lib/hive-serde-0.12.0-transwarp-tdh40.jar,	/usr/lib/hive/lib/hive-service-0.12.0-transwarp-tdh40.jar,	/usr/lib/hadoop/hadoop-annotations-2.5.2-transwarp.jar,	/usr/lib/hadoop/hadoop-auth-2.5.2-transwarp.jar,	/usr/lib/hadoop/hadoop-common-2.5.2-transwarp.jar,	/usr/lib/hadoop-hdfs/hadoop-hdfs-2.5.2-transwarp.jar";

	
	public static void main(String[] args){
		
//		String[] resutlt=roadPlace2.split("\\s+");
//		String[] resutlt=hy_wjf_position.split(",");
		String[] resutlt=hy_verify_tempInfo.split(",");
		
	
//		String[] resutltveh_gcsj=SystemLoadString.split(",");
		ToolTest tootest= new ToolTest();
		tootest.printExternTable(resutlt,"tempInfo");
//		tootest.PrintMapXmls(resutlt);
//		tootest.printMapXmlsinsertsql(resutlt);
//		tootest.printValuse(resutlt);
//		tootest.printMapXmlsinsertValues(resutlt);
//		tootest.printMapXmlsUpdate(resutlt);
//		tootest.PrintPrivate(resutlt);
//		tootest.PrintInitNull(resutlt);
//		tootest.PrintInitObj(resutlt);
//		tootest.PrintreadFields(resutlt);
//		tootest.writeUTF(resutlt);
//		tootest.psBeans(resutlt);
//		tootest.printlnquestionMark(resutlt.length);
//		tootest.PrintInceptorCPs(resutlt);
//		tootest.PrintSysLoad(resutltveh_gcsj);
//		tootest.PrintPuts(resutlt);
//		tootest.GetValue(resutlt);
//		tootest.PrintInceptorTables(resutlt);
//		tootest.SetBeans(resutlt);
//		tootest.SetBeans2_allBigChar(resutlt);
		
		
		
		
//		for(int i=0;i<resutlt.length;i++){
////			System.out.print(""+resutlt[i]+" string ,");
//			System.out.println("private String "+resutlt[i].trim()+" = \""+"\";");
//			
//		}
		
//		StringBuffer sqls=new StringBuffer();
//		for(int i=0;i<resutlt.length;i++){
////    		System.out.println("callstmt.setString("+(i+1)+", veh_viorec_bean."+resutlt[i].trim()+"());");
//			sqls.append("? ,");
//		}
//		System.out.println(sqls);
		
		
//		vehViorec
//		+ veh_areaspeed.getXLH() + "','" 
		
//		StringBuffer rowkey=new StringBuffer();
//		StringBuffer reslult=new StringBuffer();
//		StringBuffer reslultV=new StringBuffer();

//		for(int i=0;i<resutltveh_gcsj.length;i++){
////			System.out.println(" + vehViorec.get"+resutlt[i].trim()+"() +\"',"+"'\"");
////			System.out.println("private String "+resutlt[i].trim()+" = \""+"\";");
//			
////			System.out.println("p1.add(Bytes.toBytes(familyName1), Bytes.toBytes(\""+resutlt[i].trim()+"\"),Bytes.toBytes(DM_VEHCLASH_Beans.get"+resutlt[i].trim()+"()));");
////			
//			if(i!=resutltveh_gcsj.length-1){
//				rowkey.append(resutltveh_gcsj[i].trim()+" :string,");
//				reslult.append(resutltveh_gcsj[i].trim()+" string,");
//				reslultV.append("v:"+resutltveh_gcsj[i].trim()+",");
//			}
//			else {
//				rowkey.append(resutltveh_gcsj[i].trim()+" :string");
//				reslult.append(resutltveh_gcsj[i].trim()+" string");
//				reslultV.append("v:"+resutltveh_gcsj[i].trim());
//			}
//		}
//		System.out.println("reslult:  "+rowkey);
//		System.out.println("reslult:  "+reslult);
//		System.out.println("reslultV: "+reslultV);

		
	}
	
	
	public void PrintInceptorTables(String[] inParams){
		
		StringBuffer rowkey=new StringBuffer();
		StringBuffer reslult=new StringBuffer();
		StringBuffer reslultV=new StringBuffer();

		for(int i=0;i<inParams.length;i++){
//			System.out.println(" + vehViorec.get"+resutlt[i].trim()+"() +\"',"+"'\"");
//			System.out.println("private String "+resutlt[i].trim()+" = \""+"\";");
			
//			System.out.println("p1.add(Bytes.toBytes(familyName1), Bytes.toBytes(\""+resutlt[i].trim()+"\"),Bytes.toBytes(DM_VEHCLASH_Beans.get"+resutlt[i].trim()+"()));");
//			
			if(i!=inParams.length-1){
				rowkey.append(inParams[i].trim()+" :string,");
				reslult.append(inParams[i].trim()+" string,");
				reslultV.append("v:"+inParams[i].trim()+",");
			}
			else {
				rowkey.append(inParams[i].trim()+" :string");
				reslult.append(inParams[i].trim()+" string");
				reslultV.append("v:"+inParams[i].trim());
			}
		}
		System.out.println("reslult:  "+rowkey);
		System.out.println("reslult:  "+reslult);
		System.out.println("reslultV: "+reslultV);
		
	}
	
	
	
	
	public void PrintSysLoad(String[] inParams){
		
		StringBuffer sqls1= new StringBuffer();
		StringBuffer sqls2= new StringBuffer();
		for(int j=0;j<inParams.length;j++){
			
//			  String   driverName=p.getProperty("driverName");
//			  hashmap.put("oracle.username", oracle_username);
	
			sqls1.append("String   "+inParams[j]+"=p.getProperty(\""+inParams[j]+"\");\n");
			sqls2.append("hashmap.put(\""+inParams[j]+"\", "+inParams[j]+");\n");
		
		}
		System.out.println(" "+sqls1);
		System.out.println(" "+sqls2);
		
		
	}
	public void PrintGetValues(String[] inParams){
		
		StringBuffer sqls1= new StringBuffer();
		StringBuffer sqls2= new StringBuffer();
		for(int j=0;j<inParams.length;j++){
			
//			  String   driverName=p.getProperty("driverName");
//			  hashmap.put("oracle.username", oracle_username);
			
			sqls1.append("String   "+inParams[j]+"=p.getProperty(\""+inParams[j]+"\");\n");
			sqls2.append("hashmap.put(\""+inParams[j]+"\", "+inParams[j]+");\n");
			
		}
		System.out.println(" "+sqls1);
		System.out.println(" "+sqls2);
		
		
	}
	
	public void PrintStringBlank(){
		
		
	}
	
	
	public void PrintPrivate(String[] inParams){
		for(int i=0;i<inParams.length;i++){
//			if(i==3)
//			System.out.println("private String "+inParams[i].trim().replace("_", "")+" = \""+"\";");
			System.out.println("private String "+inParams[i].trim().replace("_", "")+";");
		}
	}
	public void PrintInitNull(String[] inParams){
	    for(int i=0;i<inParams.length;i++){
	        System.out.println("this."+inParams[i].trim().replace("_", "")+" = null"+";");
	    }
	}
	public void PrintInitObj(String[] inParams){
	    for(int i=0;i<inParams.length;i++){
	        System.out.println("this."+inParams[i].trim().replace("_", "")+" = obj."+inParams[i].trim().replace("_", "")+";");
	    }
	}
	public void PrintreadFields(String[] inParams){
	    for(int i=0;i<inParams.length;i++){
	        System.out.println("this."+inParams[i].trim().replace("_", "")+" = in.readUTF();");
	    }
	}
	
//	 out.writeUTF(getStr(phoneRoamChargeKb));
	public void writeUTF(String[] inParams){
	    for(int i=0;i<inParams.length;i++){
	        System.out.println("out.writeUTF(getStr("+inParams[i].trim().replace("_", "")+"));");
	    }
	}
	

	
	
	public void PrintPuts(String[] inParams){
		for(int i=0;i<inParams.length;i++){
			String Char=inParams[i].toUpperCase().trim().substring(0, 1);
			String subString=inParams[i].trim().substring(1, inParams[i].trim().length());
			System.out.println("p1.add(Bytes.toBytes(familyName1), Bytes.toBytes(\""+inParams[i].trim()+"\"),Bytes.toBytes(dm_vehfake_bean.get"+Char+subString+"()));");
		}
	}
	
	public void count(int i){
		System.out.println(i);
		
	}
	
	
	
	
	
//	byte[] val1 = r.getValue(Bytes.toBytes("v"), Bytes.toBytes("kkbh"));
	
	public void GetValue(String[] inParams){
		
		for(int i=0;i<inParams.length;i++){
//			String Char=inParams[i].toUpperCase().trim().substring(0, 1);
//			String subString=inParams[i].trim().substring(1, inParams[i].trim().length());
//			System.out.println("p1.add(Bytes.toBytes(familyName1), Bytes.toBytes(\""+inParams[i].trim()+"\"),Bytes.toBytes(dm_vehfake_bean.get"+Char+subString+"()));");
//			System.out.println("byte[] "+inParams[i]+"bytes = r.getValue(Bytes.toBytes(\"v\"), Bytes.toBytes(\""+inParams[i]+"\"));");
//			System.out.println("  rowkey is:"+Bytes.toString(val8));
			System.out.println("	System.out.println(\" "+inParams[i]+" is:\"+Bytes.toString("+inParams[i]+"bytes));");
		}
	}
	
	
	//	dm_vehclash_bean.setDdbh(res.getString("ddbh"));
	public void psBeans(String[] inParams){
		
		for(int i=0;i<inParams.length;i++){
			String Char=inParams[i].toUpperCase().trim().substring(0, 1);
			String subString=inParams[i].trim().substring(1, inParams[i].trim().length());
//			System.out.println("vehpass.set"+Char+subString+"(res.getString(\""+inParams[i].trim()+"\"));");
//			vehpass.setCllx(Bytes.toString(xlhbytes));
			System.out.println("ps.setString("+(i+1)+",bean.get"+Char+subString+"());");
		}
	}
	public void SetBeans(String[] inParams){
		
		for(int i=0;i<inParams.length;i++){
			String Char=inParams[i].toUpperCase().trim().substring(0, 1);
			String subString=inParams[i].trim().substring(1, inParams[i].trim().length());
//			System.out.println("vehpass.set"+Char+subString+"(res.getString(\""+inParams[i].trim()+"\"));");
//			vehpass.setCllx(Bytes.toString(xlhbytes));
			System.out.println("vehpass.set"+Char+subString+"(Bytes.toString("+inParams[i].trim()+"bytes));");
		}
	}
	public void SetBeans2_allBigChar(String[] inParams){
		
		for(int i=0;i<inParams.length;i++){
			String items=inParams[i].toUpperCase().trim();
			System.out.println("case "+(i)+":{\ngpsbean.set"+items+"(obj);\n break;\n}");
		}
	}
	
	public void PrintInceptorCPs(String[] inParams){
		for(int i=0;i<inParams.length;i++){
			System.out.println("cp "+inParams[i]+" /tmp/xll/inceptorjars");
		}
	}
	
	
	public void PrintMapXmls(String[] inParams){
		for(int i=0;i<inParams.length;i++){
			//	   <result column="phone_no_1" property="phoneNo1" jdbcType="VARCHAR" />
			System.out.println("  <result column=\""+inParams[i]+"\" property=\""+inParams[i]+"\" jdbcType=\"VARCHAR\" />");
		}
	}
	
	public void printMapXmlsItems(String[] inParams){
		for(int i=0;i<inParams.length;i++){
			System.out.println("  <if test=\""+inParams[i]+" != null\">\n   "+inParams[i]+",\n </if>");
		}
	}
	
	
	public void printValuse(String[] inParams){
		
		for(int i=0;i<inParams.length;i++){
			System.out.println(inParams[i]+",\n");
		}
		
		for(int i=0;i<inParams.length;i++){
			System.out.println("  #{item."+inParams[i]+",jdbcType=VARCHAR}\n");
		}
	}
	public void printMapXmlsinsertsql(String[] inParams){
		
		
//	 	<if test="schoolid != null">
//	 		school_id,
// 		</if>
		
		for(int i=0;i<inParams.length;i++){
			System.out.println("  <if test=\""+inParams[i]+" != null\">\n   "+inParams[i]+",\n </if>");
		}
//		#{phoneNo1,jdbcType=VARCHAR},
		for(int i=0;i<inParams.length;i++){
			System.out.println("  <if test=\""+inParams[i]+" != null\">\n   #{"+inParams[i]+",jdbcType=VARCHAR},\n </if>");
		}
	}
	
	public void printMapXmlsinsertValues(String[] inParams){
		
//		#{phoneNo1,jdbcType=VARCHAR},
		for(int i=0;i<inParams.length;i++){
			System.out.println("  <if test=\""+inParams[i]+" != null\">\n   #{"+inParams[i]+",jdbcType=VARCHAR},\n </if>");
		}
	}
	
	public void printMapXmlsUpdate(String[] inParams){
		
//		school_id=#{schoolId},
		for(int i=0;i<inParams.length;i++){
			System.out.println("  <if test=\""+inParams[i]+" != null\">\n    "+inParams[i] +"=#{"+inParams[i]+"},\n </if>");
		}
	}
	
	
	
	public void printlnquestionMark(int size){
		
		StringBuffer sb=new StringBuffer("");
		for(int i=0;i<size;i++){
			sb.append("?,");
		}
		System.out.println(sb);
	}
	
	
	public void printExternTable(String[] items,String famaliName){
		
		StringBuffer sb=new StringBuffer("");
		StringBuffer sb2=new StringBuffer("");
		for(int i=0;i<items.length;i++){
			sb.append(items[i]+" string,");
			sb2.append(famaliName+":"+items[i]+",");
		}
		System.out.println(sb.toString());
		System.out.println(sb2.toString());
	}
	
	
	
	

}
