package com.test.mock;

import org.junit.Test;
import org.junit.runner.RunWith;

import cmcc.zyhy.shza.service.verify.UserAreaVerification;
import mockit.integration.junit4.JMockit;

/**
 * @Type TestUserAreaVerificationMock.java
 * @Desc 
 * @author alex
 * @date 2016�?10�?11�? 下午4:37:45
 * @version 
 */
@RunWith(JMockit.class)
public class TestUserAreaVerificationMock extends TestBaseMock{


    @Test
    public void verifyUserActiveNightAddr() {
        // 手机号码参数格式不正确，-1
        System.out.println(UserAreaVerification.verifyUserActiveNightAddr(
                "13333111111", "浙江省杭州市余杭区文�?西路2054"));
        //不合�?
        System.out.println(UserAreaVerification.verifyUserActiveNightAddr("13",
                "浙江省杭州市余杭区文�?西路2054"));
        //找不到号�?
        System.out.println(UserAreaVerification.verifyUserActiveNightAddr("13333111118",
                "浙江省杭州市余杭区文�?西路2054"));
        //地址返回false�?
        System.out.println(UserAreaVerification.verifyUserActiveNightAddr("13333111111",
                "浙江省杭州市余杭区文�?西路2055"));
        //home �? 空的
        System.out.println(UserAreaVerification.verifyUserActiveNightAddr("13333111117",
                "浙江省杭州市余杭区文�?西路2054"));
        
    }
    @Test
    public void verifyUserActiveMorningAddr() {
        // 手机号码参数格式不正确，-1
        System.out.println(UserAreaVerification.verifyUserActiveMorningAddr("13333111111",
                "浙江省杭州市余杭区文�?西路2054"));
        //不合�?
        System.out.println(UserAreaVerification.verifyUserActiveMorningAddr("13",
                "浙江省杭州市余杭区文�?西路2054"));
        //找不到号�?
        System.out.println(UserAreaVerification.verifyUserActiveMorningAddr("13333111118",
                "浙江省杭州市余杭区文�?西路2054"));
        
        //地址返回false�?
        System.out.println(UserAreaVerification.verifyUserActiveMorningAddr("13333111111",
                "浙江省杭州市余杭区文�?西路2055"));
        //home �? 空的
        System.out.println(UserAreaVerification.verifyUserActiveMorningAddr("13333111117",
                "浙江省杭州市余杭区文�?西路2054"));
    }
    @Test
    public void testVerifyUserActiveAfternoonAddr() {
        // 手机号码参数格式不正确，-1
        System.out.println(UserAreaVerification.verifyUserActiveAfternoonAddr("13333111111",
                "浙江省杭州市余杭区文�?西路2054"));
        
        //不合�?
        System.out.println(UserAreaVerification.verifyUserActiveAfternoonAddr("13",
                "浙江省杭州市余杭区文�?西路2054"));
        //找不到号�?
        System.out.println(UserAreaVerification.verifyUserActiveAfternoonAddr("13333111118",
                "浙江省杭州市余杭区文�?西路2054"));
        
        //地址返回false�?
        System.out.println(UserAreaVerification.verifyUserActiveAfternoonAddr("13333111111",
                "浙江省杭州市余杭区文�?西路2055"));
        //home �? 空的
        System.out.println(UserAreaVerification.verifyUserActiveAfternoonAddr("13333111117",
                "浙江省杭州市余杭区文�?西路2054"));
    }
    @Test
    public void testVerifyUserInfoAddr() {
        //合理
        System.out.println(UserAreaVerification.verifyUserInfoAddr("13333111111",
                "浙江省杭州市余杭区文�?西路2054"));
        //不合�?
        System.out.println(UserAreaVerification.verifyUserInfoAddr("13",
                "浙江省杭州市余杭区文�?西路2054"));
        //找不到号�?
        System.out.println(UserAreaVerification.verifyUserInfoAddr("13333111118",
                "浙江省杭州市余杭区文�?西路2054"));
        
        //地址返回false�?
        System.out.println(UserAreaVerification.verifyUserInfoAddr("13333111111",
                "浙江省杭州市余杭区文�?西路2055"));
        //home �? 空的
        System.out.println(UserAreaVerification.verifyUserInfoAddr("13333111117",
                "浙江省杭州市余杭区文�?西路2054"));
    }
    @Test
    public void testVerifyUserHomeAndCompanyAddr() {
        
        //合理
        System.out.println(UserAreaVerification.verifyUserInfoAddr("13333111111",
                "浙江省杭州市余杭区文�?西路2054"));
        //不合�?
        System.out.println(UserAreaVerification.verifyUserInfoAddr("13",
                "浙江省杭州市余杭区文�?西路2054"));
        //找不到号�?
        System.out.println(UserAreaVerification.verifyUserInfoAddr("13333111118",
                "浙江省杭州市余杭区文�?西路2054"));
        
        //地址返回false�?
        System.out.println(UserAreaVerification.verifyUserInfoAddr("13333111111",
                "浙江省杭州市余杭区文�?西路2055"));
        //home �? 空的
        System.out.println(UserAreaVerification.verifyUserInfoAddr("13333111117",
                "浙江省杭州市余杭区文�?西路2054"));
    }
    
    @Test
    public void testVerifyUserResidentAddr() {
        
        //合理
        System.out.println(UserAreaVerification.verifyUserResidentAddr("13333111111",
                "浙江省杭州市余杭区文�?西路2054"));
        //不合�?
        System.out.println(UserAreaVerification.verifyUserResidentAddr("13",
                "浙江省杭州市余杭区文�?西路2054"));
        //找不到号�?
        System.out.println(UserAreaVerification.verifyUserResidentAddr("13333111118",
                "浙江省杭州市余杭区文�?西路2054"));
        
        //地址返回false�?
        System.out.println(UserAreaVerification.verifyUserResidentAddr("13333111111",
                "浙江省杭州市余杭区文�?西路2055"));
        //home �? 空的
        System.out.println(UserAreaVerification.verifyUserResidentAddr("13333111117",
                "浙江省杭州市余杭区文�?西路2054"));
    }
    
    
    @Test
    public  void testVerifyUserContactCities() {
        // 手机号码参数格式不正确，-1
        System.out.println(UserAreaVerification.verifyUserContactCity(
                "13333111111", "浙江省杭州市余杭区文�?西路2054"));
        //不合�?
        System.out.println(UserAreaVerification.verifyUserContactCity("13",
                "浙江省杭州市余杭区文�?西路2054"));
        //找不到号�?
        System.out.println(UserAreaVerification.verifyUserContactCity("13333111118",
                "浙江省杭州市余杭区文�?西路2054"));
        
        //地址返回false�?
        System.out.println(UserAreaVerification.verifyUserContactCity("13333111111",
                "浙江省杭州市余杭区文�?西路2055"));
        //home �? 空的
        System.out.println(UserAreaVerification.verifyUserContactCity("13333111117",
                "浙江省杭州市余杭区文�?西路2054"));
    }

    @Test
    public  void testuserAddressesVerify() {
        System.out.println(UserAreaVerification.userAddressesVerify("13333111111", "浙江省杭州市余杭区文�?西路2054"));
        //不合�?
        System.out.println(UserAreaVerification.userAddressesVerify("13",
                "浙江省杭州市余杭区文�?西路2054"));
        //找不到号�?
        System.out.println(UserAreaVerification.userAddressesVerify("13333111118",
                "浙江省杭州市余杭区文�?西路2054"));
        
        //地址返回false�?
        System.out.println(UserAreaVerification.userAddressesVerify("13333111111",
                "浙江省杭州市余杭区文�?西路2055"));
        //home �? 空的
        System.out.println(UserAreaVerification.userAddressesVerify("13333111117",
                "浙江省杭州市余杭区文�?西路2054"));
    }

    @Test
    public  void testLeaveFrequencyQuery() {
        System.out.println(UserAreaVerification.leaveFrequencyQuery("13333111111"));
        
        //不合�?
        System.out.println(UserAreaVerification.leaveFrequencyQuery("13"));
        //找不到号�?
        System.out.println(UserAreaVerification.leaveFrequencyQuery("13333111118"));
        
        //地址返回false�?
        System.out.println(UserAreaVerification.leaveFrequencyQuery("13333111111"));
        //home �? 空的
        System.out.println(UserAreaVerification.leaveFrequencyQuery("13333111117"));
    }
    
    /**
     * 用户处境
     * 
     */
    @Test
    public  void testAreaInfoQuery() {
        //合理  2
        System.out.println(UserAreaVerification.areaInfoQuery("13333111111", "浙江省杭州市余杭区文�?西路2054", "0", "3", "0"));
  
        //不合�?
        System.out.println(UserAreaVerification.areaInfoQuery("13",
                "浙江省杭州市余杭区文�?西路2054", "0", "3", "0"));
        //找不到号�?
        System.out.println(UserAreaVerification.areaInfoQuery("13333111118",
                "浙江省杭州市余杭区文�?西路2054", "0", "3", "0"));
        
        //地址返回false�?
        System.out.println(UserAreaVerification.areaInfoQuery("13333111111",
                "浙江省杭州市余杭区文�?西路2055", "0", "3", "0"));
//        //home �? 空的
//        System.out.println(UserAreaVerification.areaInfoQuery("13333111117",
//                "浙江省杭州市余杭区文�?西路2054", "0", "3", "0"));
        
    
    }
    
    @Test
    public  void testInfoQueryBasedOnCert() {
        
        // 2
        System.out.println(UserAreaVerification.areaInfoQueryBasedOnCert("1", "330621198706189171", "浙江省杭州市余杭区文�?西路2054", "0", "1", "1", "1"));
        
        //不合�?  -1
        System.out.println(UserAreaVerification.areaInfoQueryBasedOnCert("1","330621198",
                "浙江省杭州市余杭区文�?西路2054", "0", "1", "1", "1"));
        //找不到号�? -2
        System.out.println(UserAreaVerification.areaInfoQueryBasedOnCert("1","330621198706189172",
                "浙江省杭州市余杭区文�?西路2054", "0", "1", "1", "1"));
        
        //地址返回false�?  -3
        System.out.println(UserAreaVerification.areaInfoQueryBasedOnCert("1","330621198706189173",
                "浙江省杭州市余杭区文�?西路2054", "0", "1", "1", "1"));
        //home �? 空的  -4
        System.out.println(UserAreaVerification.areaInfoQueryBasedOnCert("1","330621198706189171",
                "浙江省杭州市余杭区文�?西路2055", "0", "1", "1", "1"));
    }
    
    
    
    /**
     * 测试杭研模型，用户工作地�?验证
     * 
     */
    @Test
    public  void testVerifyUserWorkAddr() {
        //合理  5
        System.out.println(UserAreaVerification.verifyUserWorkAddr("13333111111",
                "浙江省杭州市余杭区文�?西路2054"));
        //不合�? -1
        System.out.println(UserAreaVerification.verifyUserWorkAddr("13",
                "浙江省杭州市余杭区文�?西路2054"));
        //找不到号�? -2
        System.out.println(UserAreaVerification.verifyUserWorkAddr("13333111118",
                "浙江省杭州市余杭区文�?西路2054"));
        
        //地址返回false�? -3
        System.out.println(UserAreaVerification.verifyUserWorkAddr("13333111111",
                "浙江省杭州市余杭区文�?西路2055"));
        //home �? 空的  -4
        System.out.println(UserAreaVerification.verifyUserWorkAddr("13333111117",
                "浙江省杭州市余杭区文�?西路2054"));

    }


}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016�?10�?11�? alex creat
 */