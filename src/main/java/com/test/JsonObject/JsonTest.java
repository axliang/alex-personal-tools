/*
 * Project: alex-personal-tools
 * 
 * File Created at 2016年9月29日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.test.JsonObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSONObject;

/**
 * @Type JsonTest.java
 * @Desc 
 * @author alex
 * @date 2016年9月29日 上午10:55:56
 * @version 
 */
public class JsonTest {
    
    
    public static void main(String[] args){
       
        //  object to String 
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("phoneNo", "10767113709");
        jsonObject.put("idCard", "331023");
        jsonObject.put("userName", "alex.xi");
        String jsonStr = jsonObject.toJSONString();
        
        System.out.println("jsonStr:"+jsonStr);
        
        
        //   String to object
        JSONObject jsonRef = JSONObject.parseObject(jsonStr);
        
        System.out.println("jsonRef:"+jsonRef.toString());
        System.out.println("jsonRef toJSONString:"+jsonRef.toJSONString());
        for(Entry<String, Object> entry : jsonRef.entrySet()){
            System.out.println(" key:"+entry.getKey());
            System.out.println(" value:"+entry.getValue());
        }
        
        // json to Map
        Map<String, Object> tmp = new HashMap<String, Object>();
        tmp.putAll(jsonRef);
        
        
        
    }
    

}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016年9月29日 alex creat
 */