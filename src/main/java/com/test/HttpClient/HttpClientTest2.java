/*
 * Project: alex-personal-tools
 * 
 * File Created at 2016年10月21日
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

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Type HttpClientTest2.java
 * @Desc 
 * @author alex
 * @date 2016年10月21日 上午11:39:10
 * @version 
 */
public class HttpClientTest2 {
    
    /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(HttpClientTest2.class);
    
    /** The wsse header. */
    private static final String WSSE_HEADER = "X-WSSE";

    /** The content-type header. */
    private static final String CONTENT_TYPE = "Content-Type";

    /** The content-type content. */
    private static final String CONTENT_CONTENT = "application/json;charset=UTF-8";

    /** The host header. */
    private static final String HOST = "Host";

    /** The host content. */
    private static final String HOST_CONTENT = "aep.test.sdp.com";

    /** The authorization header. */
    private static final String AUTHORIZATION_HEADER = "Authorization";

    /** The authorization content. */
    private static final String AUTHORIZATION_CONTENT = "WSSE realm=\"SDP\", profile=\"UsernameToken\", type=\"Appkey\"";
    
    
    public void methond2() throws ClientProtocolException, IOException{
        
        HttpPost post = new HttpPost("http://127.0.0.1:8888/combineService");
        RequestConfig requestConfig =RequestConfig.custom()
                .setConnectionRequestTimeout(1000)
                .setConnectTimeout(3000)
                .setSocketTimeout(5000)
                .build();
        post.setConfig(requestConfig);
        post.setHeader(null);
        post.setEntity(null);
        

       
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = client.execute(post);
        
//        //初始化POST请求，  set Header  & set Entity
//        HttpClientTest2.initHttpPost(post, auth, params);
//        
//        //发送POST请求并获取响应
//        MobileReponse mobileReponse = MessageSenderUtil.sendMessage(client, post);
        
        
    }
    
    
//    public static void initHttpPost(HttpPost httpPost, Auth auth, JSONObject requestJson) {
//        addHttpHeaders(httpPost, auth);
//        addHttpEntity(httpPost, requestJson);
//    }
//    
//    
//    private static void addHttpHeaders(HttpUriRequest httpMethod, Auth auth) {
//        String wsseHeader = bulidWsseHeader(auth);
//        httpMethod.setHeader(new BasicHeader(WSSE_HEADER, wsseHeader));
//        logger.debug("The WSSE_HEADER is :\r\n\r\n" + wsseHeader + "\r\n\r\n");
//        httpMethod.setHeader(new BasicHeader(AUTHORIZATION_HEADER, AUTHORIZATION_CONTENT));
//        logger.debug("The AUTHORIZATION_HEADER is :\r\n\r\n" + AUTHORIZATION_CONTENT + "\r\n\r\n");
//        httpMethod.setHeader(new BasicHeader(CONTENT_TYPE, CONTENT_CONTENT));
//        logger.debug("The CONTENT_TYPE is :\r\n\r\n" + CONTENT_CONTENT + "\r\n\r\n");
//        httpMethod.setHeader(new BasicHeader(HOST, HOST_CONTENT));
//        logger.debug("The HOST is :\r\n\r\n" + HOST_CONTENT + "\r\n\r\n");
//    }
//    
//    private static void addHttpEntity(HttpPost httpPost, JSONObject requestJson) {
//        StringEntity s = new StringEntity(requestJson.toString(), "UTF-8");
//        s.setContentEncoding("UTF-8");
//        s.setContentType("application/json");
//        httpPost.setEntity(s);
//    }
//    
//    
//    /**
//     * Bulid wsse header.
//     * 
//     * @param auth the auth
//     * @return the string
//     */
//    private static String bulidWsseHeader(Auth auth) {
//        String appKey = auth.getAppKey();
//        String nonce = RandomNonceUtil.genRandomNonce();
//        String created = TimestampUtil.getLocalUtcTimestamp();
//        String source = (new StringBuilder(String.valueOf(nonce))).append(created)
//                .append(auth.getAppSecret()).toString();
//        String pwdDigest = null;
//        if (EncryptUtil.ENCRYPT_SHA1_TYPE.equals(auth.getEncryptType())) {
//            pwdDigest = EncryptUtil.encryptSha1Base64(source);
//        } else {
//            pwdDigest = EncryptUtil.encryptSha256Base64(source);
//        }
//        String header = "UsernameToken Username=" + "\"" + appKey + "\"" + ", PasswordDigest="
//                + "\"" + pwdDigest + "\"" + ", Nonce=" + "\"" + nonce + "\"" + ",Created=" + "\""
//                + created + "\"" + "";
//        return header;
//    }
//    
//    
//    
//    public static MobileReponse sendMessage(CloseableHttpClient client, HttpUriRequest httpMethod)
//            throws HttpException {
//        MobileReponse response = new MobileReponse();
//        try {
//            CloseableHttpResponse httpResponse = client.execute(httpMethod);
//            StatusLine statusLine = httpResponse.getStatusLine();
//            if (null != statusLine) {
//                response.setStatusCode(statusLine.getStatusCode());
//                response.setReasonPhrase(statusLine.getReasonPhrase());
//            }
//            HttpEntity httpEntity = httpResponse.getEntity();
//            if (httpEntity != null) {
//                String content = EntityUtils.toString(httpEntity, "UTF-8");
//                response.setRspContent(content);
//            }
//            response.parse();
//            EntityUtils.consume(httpEntity);
//        } catch (Exception e) {
//            throw new HttpException(e.getMessage(), e);
//        }
//        return response;
//    }
//    
    

}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016年10月21日 alex creat
 */