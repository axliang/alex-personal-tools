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
package com.test.HttpClient;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

import tools.RSAUtil;

/**
 * @Type HttpClientTest.java
 * @Desc 
 * @author alex
 * @date 2016年9月29日 上午11:21:31
 * @version 
 */
public class HttpClientTest {
    
    
    public static void main(String[] args) throws Exception {
        //        RSAUtil.generateRandomKeyPair();
        String publicKey = "MIICVzANBgkqhkiG9w0BAQEFAAOCAkQAMIICPwKCAjYLBnm1arKLtWAbd89d7XOunvJrxOYkUJwj35PC+P9MhU6Q/Rlz56LfoIX3+Fi358OXYItJYppPSEFMi4K2XWuCKqs3Xu+tYUFizIgQKA4su+8+hZXYnjRfjIYyofVl3uf0gaHy4hrbiIZP+j/h9LbmWbI14+V60CzCM/jaqAl+vr5nqrqqOgTpeQ6kQrCdhyb5pa3tev+GOe4mAnGmG6oYJ42vhxTjLeUCgtSU9Rl2nyIHcAhCmjqrG74D0CiHY9TkkM1INqvb8sgW7eSeHpoBgB/c+YiUEPnai1IJbUJY+L5BkAzGn1svVvfw8YcAjdaMwoZ+f0XNEdcRN4iFDAUjlJHcjFW2QKEUn9ZjsrvJ03HJKhsYA5wdTEwVpRgxHBSyLr4qm71iz6e0Wj9vtbFC23aWfOqGstf+kiEB+5Nia/dykN60uXDPqFgxwoGyS1gu/+8c5UMohrPcPKJX036FnBKGbsnm4xiLcGXKGwL6/wdDaj8kDEqZ4XNUaV+8yaCOBkRwljYNLnD9coyk7Hgf8iwEz2yP5CITmJG16t7E3Ja49TJVCgnHAZLaXff8NTNgEkDGhXxgwcvyyzwv6D3BgwEasdBQhjtf22u9ZLkKtIBmq2wAsdpIZG0V6JqIhV59nmrXXUYgOHr46hY9N1/dfUgBEEOR9LHPcyDqn/9Df58Zp8ejipLQZCVW93+OHRzSMEKcsS26Wyv5NPW0FDbVEmgKqAWdKw1wbMsWeXvBmmSEB7qfUQIDAQAB";
        String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAK1fFaVpAP4jo82nVsYLNx9SmEECSBaFfefeKTcLomX6rCW0Seg+CtsjLUh2+o49fnqHIlb6G6D9EzETjRd+aRaGThJ5KxA8kTAiPebEn/TNwR9cmC5dnhBNv3AxHF4CD2wNtpb5yrNbt/vmvT0q1SnB1k5fgTKF8a8YQIPusGgzAgMBAAECgYBNjMG++qgyBbkorZiX/75JaYWnVqDuSgoWpH5lG/Qpj6ZfOzTwCIiMm0CPMIFFDOa9YiMPKtMfAPULt8Yd4zKX3eAMzD8ejIYjU1P4Jx34N9Rh0a9G5g9fhQM4g4kfAvgWwQ08Yq94Hbe1AcvV9uEdJGGWzsgeemK2ABtnM9ihYQJBAO3jZh/Velj1QaOQUXWWQsyQcYRqMJ04HLY5Iipr93kA499ODbqb5dE9CKkOUhehYVmrkwbvE5Hsvc0h5R3o0ZECQQC6kjWL2phzbmINDc4UWBhIvawNvJU3w3lZBtiSsgUhNM0bhQBB1IIY5Ss0YmDCgJ84EcNnLmiH4Vg102Bf1PuDAkBgiun2P2fw1E/4NmioxPuFE5XOPF5QX+ZfGZ7BAqIjbHYOORofQoepPBDYsyQjzO26O4Rmyv3xOdfpeTkHw2XRAkEArakuYlFEmh1i8xeofNNLN1olblvc4Rz4NN/kcxd1IuWNDVKNXLk7p4SY5Je1zRYAHiaapc5Syjf87Y0lJc6PlQJBALyxmhdIoiaFOwbgmh+25AYhzP50DLl3Os9zYsq9IPtudk7IQQXhlZ/Kcg6vHlJp+0pRsDB8BRGxmULGbIVqr0I=";
        JSONObject json = new JSONObject();
        json.put("phoneNo", "13512345678");
        json.put("identifyCode", "201609230001");
        json.put("certNo", "111");
        json.put("custName", "张三");
        json.put("serviceCode", "VerifyCardPhone");
        String plainText = json.toJSONString();
        String cipherText = RSAUtil.encrypt(plainText, publicKey);
        System.out.println(cipherText);

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://127.0.0.1:8888/combineService");
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair("openId", "dasfagsdsds"));
            nvps.add(new BasicNameValuePair("param", cipherText));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        CloseableHttpResponse response = httpclient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        System.out.println(result);
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