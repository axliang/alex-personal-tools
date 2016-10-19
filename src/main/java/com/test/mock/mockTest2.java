/*
 * Project: alex-personal-tools
 * 
 * File Created at 2016年10月10日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.test.mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.easymock.EasyMock;
import org.junit.Test;

import cmcc.zyhy.hbase.manager.app.ShzaResultManager;
import cmcc.zyhy.hbase.persistentBase.ShzaResult;
/**
 * @Type mockTest.java
 * @Desc 
 * @author alex
 * @date 2016年10月10日 下午1:58:06
 * @version 
 */
public class mockTest2 {
    
//    private static final String  StringResult = "";
    
    
    @Test
    public  void ShzaResultManagerTest(){
        
        
        ShzaResultManager shzaResultManager = mock(ShzaResultManager.class);
       
        ShzaResult  shzaResult = new ShzaResult();
        shzaResult.setAuthentication("2");
        shzaResult.setName("test1");
        
        ShzaResult  shzaResult2 = new ShzaResult();
        shzaResult.setAuthentication("1");
        shzaResult.setName("test2");
        
        
        EasyMock.expect(System.getProperty("property")).andReturn("my property");//录制Mock对象的静态方法   
        when(shzaResultManager.getShzaResult("51FB059D661434C070AD2C6227B908C2")).thenReturn(shzaResult);
        when(shzaResultManager.getShzaResult("11111")).thenReturn(shzaResult2);
        
        System.out.println("------------------");
        
        ShzaResult  shzaResultTest = shzaResultManager.getShzaResult("51FB059D661434C070AD2C6227B908C2");
        System.out.println("------------------"+shzaResultTest.getAuthentication());
        
        
    }
    
    
    

}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016年10月10日 alex creat
 */