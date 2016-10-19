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

import org.junit.Test;
import org.junit.runner.RunWith;

import cmcc.zyhy.hbase.manager.app.ShzaResultManager;
import cmcc.zyhy.hbase.persistentBase.ShzaResult;
import mockit.Expectations;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
/**
 * @Type mockTest.java
 * @Desc 
 * @author alex
 * @date 2016年10月10日 下午1:58:06
 * @version 
 */

@RunWith(JMockit.class)
public class mockTest {
    
    
    @Mocked
    ShzaResultManager  shzaResultManager;
    
    @Test
    public  void ShzaResultManagerTest(){
        
        
        final ShzaResult  shzaResult = new ShzaResult();
        shzaResult.setAuthentication("2");
        shzaResult.setName("test1");
        
        final ShzaResult  shzaResult2 = new ShzaResult();
        shzaResult2.setAuthentication("1");
        shzaResult2.setName("test2");
        // 设置mock期望
        new Expectations(){{
            ShzaResultManager.getShzaResult("51FB059D661434C070AD2C6227B908C2");
            result = shzaResult;
        }};
        new Expectations(){{
            ShzaResultManager.getShzaResult("11111");
            result = shzaResult2;
        }};
        ShzaResult  shzaResultTest = ShzaResultManager.getShzaResult("51FB059D661434C070AD2C6227B908C2");
        System.out.println(shzaResultTest.getAuthentication());
        
        
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