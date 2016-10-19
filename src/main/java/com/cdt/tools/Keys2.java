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

import java.security.KeyPair;
import java.security.KeyPairGenerator;

import javax.crypto.Cipher;

/**
 * @Type Keys2.java
 * @Desc 
 * @author alex
 * @date 2016年9月22日 上午10:28:57
 * @version 
 */
public class Keys2 {

    
    public  void Test3() throws Exception  
    {  
       
       //生成密钥对  
       KeyPairGenerator keyGen =KeyPairGenerator.getInstance("RSA");  
       keyGen.initialize(1024);  
        KeyPair key= keyGen.generateKeyPair();  
      
        // 原文  
        byte[]plainText = "shaofa".getBytes();  
      
        //加密工具  
        Cipher c1 =Cipher.getInstance("RSA");  
       c1.init(Cipher.ENCRYPT_MODE,key.getPrivate());  
        byte[]cipherText = c1.doFinal(plainText);  
      
       c1.init(Cipher.DECRYPT_MODE,key.getPublic());  
        byte[]output = c1.doFinal(cipherText);  
      
    }  
    
    
    
    public static void main(String[] args) throws Exception{
        new Keys2().Test3();
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