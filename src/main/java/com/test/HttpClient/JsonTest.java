/*
 * Project: alex-personal-tools
 * 
 * File Created at 2016年10月14日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.test.HttpClient;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.alibaba.fastjson.JSONObject;

/**
 * @Type JsonTest.java
 * @Desc 
 * @author alex
 * @date 2016年10月14日 上午10:23:43
 * @version 
 */
public class JsonTest {
    
    
    public static void main(String[] args){
        
        String add_url = "http://127.0.0.1:8080/test/doThis";  
        URL url = new URL(add_url);  
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();  
        connection.setDoInput(true);  
        connection.setDoOutput(true);  
        connection.setRequestMethod("POST");  
        connection.setUseCaches(false);  
        connection.setInstanceFollowRedirects(true);  
        connection.setRequestProperty("Content-Type","application/json");  
        connection.connect();  
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());  
        JSONObject obj = new JSONObject();  
           
        obj.put("code", -1002);       
        obj.put("message", "msg");  
        out.writeBytes(obj.toString());  
        out.flush();  
        out.close();
        
        
    }
    


}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016年10月14日 alex creat
 */