/*
 * Project: PersonalTools
 * 
 * File Created at 2016年9月22日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.cdt.tools;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;


/**
 * @Type Keys.java
 * @Desc 
 * @author alex
 * @date 2016年9月22日 上午10:22:13
 * @version 
 */
public class Keys {

    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";

    public static void main(String[] args) {
//        Map<String, Object> keyMap;
//        try {
//            keyMap = initKey();
//            String publicKey = getPublicKey(keyMap);
//            System.out.println(publicKey);
//            String privateKey = getPrivateKey(keyMap);
//            System.out.println(privateKey);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

//    public static String getPublicKey(Map<String, Object> keyMap) throws Exception {
//        Key key = (Key) keyMap.get(PUBLIC_KEY);
//        byte[] publicKey = key.getEncoded();
//        return encryptBASE64(key.getEncoded());
//    }
//
//    public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {
//        Key key = (Key) keyMap.get(PRIVATE_KEY);
//        byte[] privateKey = key.getEncoded();
//        return encryptBASE64(key.getEncoded());
//    }
//
//    public static byte[] decryptBASE64(String key) throws Exception {
//        return (new BASE64Decoder()).decodeBuffer(key);
//    }
//
//    public static String encryptBASE64(byte[] key) throws Exception {
//        return (new BASE64Encoder()).encodeBuffer(key);
//    }

    public static Map<String, Object> initKey() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Map<String, Object> keyMap = new HashMap<String, Object>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }
    
    
    
    

}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016年9月22日 alex creat
 */