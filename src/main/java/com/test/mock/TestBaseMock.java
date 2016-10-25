/*
 * Project: credit-verification-accessor-cs
 * 
 * File Created at 2016�?10�?12�?
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
packacom.test.mockock;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;

import com.alibaba.fastjson.JSONObject;

import cmcc.zyhy.hbase.manager.app.ShzaResultManager;
import cmcc.zyhy.hbase.manager.basic.UserIdcardManager;
import cmcc.zyhy.hbase.persistentBase.ShzaResult;
import cmcc.zyhy.hbase.persistentBase.UserIdcard;
import cmcc.zyhy.shza.util.BaiduMapGeoPoint;
import cmcc.zyhy.shza.util.HttpClinet;
import mockit.Mock;
import mockit.MockUp;

/**
 * @Type TesBaseMock.java
 * @Desc 
 * @author alex
 * @date 2016�?10�?12�? 下午1:40:28
 * @version 
 */
public class TestBaseMock {
    
 // mock对象
    protected MockUp<ShzaResultManager> mockUpShzaR;

    // mock对象
    protected MockUp<HttpClinet> mockUpHttpCli;
    
    // mock对象
    private MockUp<BaiduMapGeoPoint> mockUpBaiduMapGP;
    
    // mock对象
    private MockUp<UserIdcardManager> mockUpUserIdcardM;
    
    private HashMap<String, String> phoneMd5s = new HashMap<String, String>();
    
    private HashMap<String, String> idCardMd5s = new HashMap<String, String>();

    
    @Before
    public void init() {
        initParams();
        mockGetShzaResult();
        mockHttpClinet();
        mockUserIdcardManager();
        mockBaiduMapGeoPoint();
    }
    
    protected void initParams(){
        
        //手机号md5
        phoneMd5s.put("51FB059D661434C070AD2C6227B908C2", "13333111111");
        phoneMd5s.put("3421EEDD0A8DC3F87294450F178B7CB7", "13333111112");
        phoneMd5s.put("420D2CD7BD22436D0832EE3D92BF3C36", "13333111113");
        phoneMd5s.put("7783504A8D3B918B039202BF604D868F", "13333111114");
        phoneMd5s.put("726362F9555AABCE0671135575874B4B", "13333111115");
        phoneMd5s.put("05A48BCC29B945216561DEB2DBEFAB48", "13333111116");
        phoneMd5s.put("37BCAE8C3787FF7CAE026D065950AD20", "13333111117");
        phoneMd5s.put("14E5CF84D75DBFF8863F8D18BB58EDB9", "13333111119");
        phoneMd5s.put("2113CBF1A38373F82714F840FC5A2C9A", "13333111120");
        
          
        
        phoneMd5s.put("51fb059d661434c070ad2c6227b908c2", "13333111111");
        phoneMd5s.put("3421eedd0a8dc3f87294450f178b7cb7", "13333111112");
        phoneMd5s.put("420d2cd7bd22436d0832ee3d92bf3c36", "13333111113");
        phoneMd5s.put("7783504a8d3b918b039202bf604d868f", "13333111114");
        phoneMd5s.put("726362f9555aabce0671135575874b4b", "13333111115");
        phoneMd5s.put("05a48bcc29b945216561deb2dbefab48", "13333111116");
        phoneMd5s.put("37bcae8c3787ff7cae026d065950ad20", "13333111117");
        phoneMd5s.put("14e5cf84d75dbff8863f8d18bb58edb9", "13333111119");
        phoneMd5s.put("2113cbf1a38373f82714f840fc5a2c9a", "13333111120");

        
        //身份证md5
        idCardMd5s.put("d3fe3fc1382fc6579c520fdd14b4962d", "330621198706189171");
        idCardMd5s.put("25c37b304020b009fedfeac3fe7eb140", "330621198706189172");
        idCardMd5s.put("a2bcfa3e718e6ce2a9b251464988039f", "330621198706189173");
        idCardMd5s.put("0a8b6c16d615170cab9234958493f77f", "330621198706189174");
        idCardMd5s.put("662527c8e83638eeaa3f56ce540183c9", "330621198706189175");
        idCardMd5s.put("bf9b3507c2f0882e947762f1f7615f19", "330621198706189176");
        
        idCardMd5s.put("D3FE3FC1382FC6579C520FDD14B4962D", "330621198706189171");
        idCardMd5s.put("25C37B304020B009FEDFEAC3FE7EB140", "330621198706189172");
        idCardMd5s.put("A2BCFA3E718E6CE2A9B251464988039F", "330621198706189173");
        idCardMd5s.put("0A8B6C16D615170CAB9234958493F77F", "330621198706189174");
        idCardMd5s.put("662527C8E83638EEAA3F56CE540183C9", "330621198706189175");
        idCardMd5s.put("BF9B3507C2F0882E947762F1F7615F19", "330621198706189176");
    }

   

    
  
    
    
    /**
     * 初始�? mock测试数据
     */
    private void mockGetShzaResult() {
        //1. mock对象
        mockUpShzaR = new MockUp<ShzaResultManager>() {
            @Mock
            public ShzaResult getShzaResult(String rowkeyMd5) {
                String PhoneNum = phoneMd5s.get(rowkeyMd5);
                if(null == PhoneNum){
                    return null;
                }
                switch (PhoneNum) {
                    case ("13333111111"): {
                        ShzaResult shzaResult = new ShzaResult();
                        shzaResult.setAuthentication("2");
                        shzaResult.setName("test1");
                        shzaResult.setAfternoonCoordinateList("20160815:121.368942,31.237106;");
                        shzaResult.setNightCoordinateList("20160815:121.368942,31.237106;");
                        shzaResult.setMorningCoordinateList("20160815:121.368942,31.237106;");
                        shzaResult.setWorkCoordinateList("20160815:121.368942,31.237106;");
                        shzaResult.setResidentCoordinateList("20160815:121.368942,31.237106;");
                        shzaResult.setAddress("浙江省杭州市余杭区文�?西路2054");
                        shzaResult.setRecentContactCity("total:1800.00:1:0;");
                        shzaResult.setRecentExitCountry("201510:1:0;201511:1:0;201512:1:0;");
                        shzaResult.setRegistrationType("身份�?");
                        shzaResult.setIdNumber("D3FE3FC1382FC6579C520FDD14B4962D");
                        shzaResult.setRegistrationTime("2000-11-10 17:00:00");
                        shzaResult.setUserstatus("1");
                        return shzaResult;
                    }
                    case ("13333111112"): {
                        ShzaResult shzaResult2 = new ShzaResult();
                        shzaResult2.setAuthentication("1");
                        shzaResult2.setName("test2");
                        return shzaResult2;
                    }
                    case ("13333111113"): {
                        ShzaResult shzaResult3 = new ShzaResult();
                        shzaResult3.setAuthentication("0");
                        shzaResult3.setName("");
                        shzaResult3.setIdNumber("");
                        return shzaResult3;
                    }
                    case ("13333111114"): {
                        ShzaResult shzaResult4 = new ShzaResult();
                        shzaResult4.setAuthentication("1");
                        shzaResult4.setName("test4");
                        return shzaResult4;
                    }
                    case ("13333111115"): {
                        final ShzaResult shzaResult5 = new ShzaResult();
                        shzaResult5.setAuthentication("1");
                        shzaResult5.setName("test5");
                        return shzaResult5;
                    }
                    case ("13333111116"): {
                        final ShzaResult shzaResult6 = new ShzaResult();
                        shzaResult6.setAuthentication("7");
                        shzaResult6.setName("test6");
                        shzaResult6.setIdNumber("D3FE3FC1382FC6579C520FDD14B4962D");
                        return shzaResult6;
                    }
                    case ("13333111117"): {
                        final ShzaResult shzaResult6 = new ShzaResult();
                        shzaResult6.setAuthentication("7");
                        shzaResult6.setName("test6");
                        shzaResult6.setAfternoonCoordinateList("");
                        shzaResult6.setNightCoordinateList("");
                        shzaResult6.setMorningCoordinateList("");
                        shzaResult6.setWorkCoordinateList("");
                        shzaResult6.setResidentCoordinateList("");
                        shzaResult6.setAddress("");
                        shzaResult6.setRecentContactCity("");
                        shzaResult6.setRecentExitCountry("");
                        shzaResult6.setRegistrationType("");
                        return shzaResult6;
                    }
                    case ("13333111119"): {
                        ShzaResult shzaResult = new ShzaResult();
                        shzaResult.setAuthentication("2");
                        shzaResult.setName("test1");
                        shzaResult.setAfternoonCoordinateList("20160815:121.368942,31.237106;");
                        shzaResult.setNightCoordinateList("20160815:121.368942,31.237106;");
                        shzaResult.setMorningCoordinateList("20160815:121.368942,31.237106;");
                        shzaResult.setWorkCoordinateList("20160815:121.368942,31.237106;");
                        shzaResult.setResidentCoordinateList("20160815:121.368942,31.237106;");
                        shzaResult.setAddress("浙江省杭州市余杭区文�?西路2054");
                        shzaResult.setRecentContactCity("total:1800.00:1:0;");
                        shzaResult.setRecentExitCountry("201510:1:0;201511:1:0;201512:1:0;");
                        shzaResult.setRegistrationType("身份�?");
                        shzaResult.setIdNumber("D3FE3FC1382FC6579C520FDD14B4962D");
                        shzaResult.setRegistrationTime("2000-11-10 17:00:00");
                        shzaResult.setUserstatus("0");
                        return shzaResult;
                    }
                    case ("13333111120"): {
                        ShzaResult shzaResult = new ShzaResult();
                        shzaResult.setAuthentication("0");
                        shzaResult.setName("test1");
                        shzaResult.setAfternoonCoordinateList("20160815:121.368942,31.237106;");
                        shzaResult.setNightCoordinateList("20160815:121.368942,31.237106;");
                        shzaResult.setMorningCoordinateList("20160815:121.368942,31.237106;");
                        shzaResult.setWorkCoordinateList("20160815:121.368942,31.237106;");
                        shzaResult.setResidentCoordinateList("20160815:121.368942,31.237106;");
                        shzaResult.setAddress("浙江省杭州市余杭区文�?西路2054");
                        shzaResult.setRecentContactCity("total:1800.00:1:0;");
                        shzaResult.setRecentExitCountry("201510:1:0;201511:1:0;201512:1:0;");
                        shzaResult.setRegistrationType("身份�?");
                        shzaResult.setIdNumber("D3FE3FC1382FC6579C520FDD14B4962D");
                        return shzaResult;
                    }
                    default:
                        return null;
                }
            }
        };

    }
    /**
     * 初始�? mock测试数据
     */
    private void mockUserIdcardManager() {
        //1. mock对象
        mockUpUserIdcardM = new MockUp<UserIdcardManager>() {
            @Mock
            public  UserIdcard getUserIdcard(String rowkeyIdCard) {
                switch (rowkeyIdCard) {
                    case ("330621198706189171"): {
                        UserIdcard userIdcard = new UserIdcard();
                        userIdcard.setPhone("13333111111-20141020;13333111111-20141020");
                        return userIdcard;
                    }
                    case ("330621198706189173"): {
                        UserIdcard userIdcard = new UserIdcard();
                        userIdcard.setPhone("13333111121-20141020;13333111121-20141020");
                        return userIdcard;
                    }
                    default:
                        return null;
                }
            }
        };
        
    }

    /**
     * 初始�? mock测试数据
     */
    private void mockBaiduMapGeoPoint() {
        //1. mock对象
        mockUpBaiduMapGP = new MockUp<BaiduMapGeoPoint>() {
            @Mock
            public boolean lngLatCal(String address) {

                switch (address) {
                    case ("浙江省杭州市余杭区文�?西路2054"): {
                        return true;
                    }
                    default:
                        return false;
                }
            }
        };

    }
    

    /**
     * 初始�? mock测试数据
     */
    private void mockHttpClinet() {

       

        //1. mock对象
        mockUpHttpCli = new MockUp<HttpClinet>() {
            @Mock
            public String doPost(String url, String json) {
                //   String to object
                JSONObject jsonRef = JSONObject.parseObject(json);
                JSONObject paramStringObj = jsonRef.getJSONObject("paramString");

                if (null != paramStringObj.getJSONObject("IDField")) {

                    String idMd5 = (String) paramStringObj.getJSONObject("IDField").get("ID");
                    String idCard = idCardMd5s.get(idMd5);
                    switch (idCard) {
                        case ("330621198706189171"): {
                            JSONObject jsonResult = new JSONObject();
                            jsonResult.put("result", "0");
                            jsonResult.put("message", "test1");
                            jsonResult.put("value", "13333111119");
                            return jsonResult.toString();
                        }
                        case ("330621198706189172"): {
                            JSONObject jsonResult = new JSONObject();
                            jsonResult.put("result", "-1");
                            jsonResult.put("message", "test2");
                            return jsonResult.toString();
                        }
                        case ("330621198706189173"): {
                            JSONObject jsonResult = new JSONObject();
                            jsonResult.put("result", "-2");
                            jsonResult.put("message", "test3");
                            return jsonResult.toString();
                        }
                        case ("330621198706189174"): {
                            JSONObject jsonResult = new JSONObject();
                            jsonResult.put("result", "-3");
                            jsonResult.put("value", "-3");
                            jsonResult.put("message", "test4");
                            return jsonResult.toString();
                        }
                        case ("330621198706189175"): {
                            JSONObject jsonResult = new JSONObject();
                            jsonResult.put("result", "1");
                            jsonResult.put("value", "1");
                            jsonResult.put("message", "test4");
                            jsonResult.put("value", "13333111111");
                            return jsonResult.toString();
                        }
                        case ("330621198706189176"): {
                            JSONObject jsonResult = new JSONObject();
                            jsonResult.put("result", "1");
                            jsonResult.put("message", "test4");
                            jsonResult.put("value", "13333111321");
                            return jsonResult.toString();
                        }
                        default:
                            return null;
                    }
                }
                if (null != paramStringObj.getJSONObject("phoneNoField")) {

                    String phoneNoMd5 = (String) paramStringObj.getJSONObject("phoneNoField")
                            .get("phoneNo");
                    String phoneNo = phoneMd5s.get(phoneNoMd5);
                    switch (phoneNo) {
                        case ("13333111111"): {
                            JSONObject jsonResult = new JSONObject();
                            jsonResult.put("result", "0");
                            jsonResult.put("message", "test1");
                            return jsonResult.toString();
                        }
                        case ("13333111112"): {
                            JSONObject jsonResult = new JSONObject();
                            jsonResult.put("result", "-1");
                            jsonResult.put("message", "test2");
                            return jsonResult.toString();
                        }
                        case ("13333111113"): {
                            JSONObject jsonResult = new JSONObject();
                            jsonResult.put("result", "-2");
                            jsonResult.put("message", "test3");
                            return jsonResult.toString();
                        }
                        case ("13333111114"): {
                            JSONObject jsonResult = new JSONObject();
                            jsonResult.put("result", "-3");
                            jsonResult.put("value", "-3");
                            jsonResult.put("message", "test4");
                            return jsonResult.toString();
                        }
                        case ("13333111115"): {
                            JSONObject jsonResult = new JSONObject();
                            jsonResult.put("result", "-4");
                            jsonResult.put("value", "-4");
                            jsonResult.put("message", "test4");
                            return jsonResult.toString();
                        }
                        default:
                            return null;
                    }
                }
                return null;
            }
        };

    }
    
    
    @After
    public void tearDown() {
        //4. 还原对象，避免测试方法之间互相影响�?�对�?个实例来说没�?么影响，对静态方法影响较大�??
        mockUpShzaR.tearDown();
        mockUpHttpCli.tearDown();
        mockUpBaiduMapGP.tearDown();
        mockUpUserIdcardM.tearDown();
    }

    
    

}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016�?10�?12�? alex creat
 */