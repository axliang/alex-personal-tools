/*
 * Project: credit-combination-dispatcher
 * 
 * File Created at 2016�?9�?19�?
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package tools;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

public class RSAUtil {

    /**
     * 根据公钥对原文进行加�?
     * 
     * @param plainText �?要加密的原文
     * @param publicKey RSA公钥
     * @return 返回经过Base64编码的密�?
     * @throws Exception
     */
    public static String encrypt(String plainText, String publicKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        byte[] res = Base64.decodeBase64(publicKey);
        X509EncodedKeySpec KeySpec = new X509EncodedKeySpec(res);
        RSAPublicKey key = (RSAPublicKey) keyFactory.generatePublic(KeySpec);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] cipherData = cipher.doFinal(plainText.getBytes());
        return Base64.encodeBase64String(cipherData);
    }

    /**
     * 根据私钥对经过Base64编码的密文进行解�?
     *  
     * @param cipherText 经过Base64编码的密�?
     * @param privateKey RSR私钥
     * @return 返回解密后的原文
     * @throws Exception
     */
    public static String decrypt(String cipherText, String privateKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        byte[] res = Base64.decodeBase64(privateKey);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(res);
        RSAPrivateKey key = (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] plainData = cipher.doFinal(Base64.decodeBase64(cipherText));
        return new String(plainData, "UTF-8");
    }

    /**
     * 生成随机RSA公私钥串
     * 
     * @throws Exception
     */
    public static void generateRandomKeyPair() throws Exception {
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
        random.setSeed(System.currentTimeMillis());
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(4524, random);
        KeyPair pair = keyGen.generateKeyPair();
        Key pubKey = pair.getPublic();
        Key privKey = pair.getPrivate();
        System.out.println(Base64.encodeBase64String(pubKey.getEncoded()));
        System.out.println(Base64.encodeBase64String(privKey.getEncoded()));

    }
    
    public static void main(String[] args){
//        try {
//            RSAUtil.generateRandomKeyPair();
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        
     String publicKey ="MIICVzANBgkqhkiG9w0BAQEFAAOCAkQAMIICPwKCAjYLBnm1arKLtWAbd89d7XOunvJrxOYkUJwj35PC+P9MhU6Q/Rlz56LfoIX3+Fi358OXYItJYppPSEFMi4K2XWuCKqs3Xu+tYUFizIgQKA4su+8+hZXYnjRfjIYyofVl3uf0gaHy4hrbiIZP+j/h9LbmWbI14+V60CzCM/jaqAl+vr5nqrqqOgTpeQ6kQrCdhyb5pa3tev+GOe4mAnGmG6oYJ42vhxTjLeUCgtSU9Rl2nyIHcAhCmjqrG74D0CiHY9TkkM1INqvb8sgW7eSeHpoBgB/c+YiUEPnai1IJbUJY+L5BkAzGn1svVvfw8YcAjdaMwoZ+f0XNEdcRN4iFDAUjlJHcjFW2QKEUn9ZjsrvJ03HJKhsYA5wdTEwVpRgxHBSyLr4qm71iz6e0Wj9vtbFC23aWfOqGstf+kiEB+5Nia/dykN60uXDPqFgxwoGyS1gu/+8c5UMohrPcPKJX036FnBKGbsnm4xiLcGXKGwL6/wdDaj8kDEqZ4XNUaV+8yaCOBkRwljYNLnD9coyk7Hgf8iwEz2yP5CITmJG16t7E3Ja49TJVCgnHAZLaXff8NTNgEkDGhXxgwcvyyzwv6D3BgwEasdBQhjtf22u9ZLkKtIBmq2wAsdpIZG0V6JqIhV59nmrXXUYgOHr46hY9N1/dfUgBEEOR9LHPcyDqn/9Df58Zp8ejipLQZCVW93+OHRzSMEKcsS26Wyv5NPW0FDbVEmgKqAWdKw1wbMsWeXvBmmSEB7qfUQIDAQAB";   
     String privateKey = "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"; 
     String painTxt ="testNum";
     try{
         String  encodeString = RSAUtil.encrypt(painTxt, publicKey);
         String  decodeString = RSAUtil.decrypt(encodeString, privateKey);
         System.out.println(" painTxt:"+painTxt);
         System.out.println(" encode Result:"+encodeString);
         System.out.println("after decode painTxt:"+decodeString);
         
     } catch(Exception e){
         e.printStackTrace();
     }
    
     
        
        
    }
    
    
}

