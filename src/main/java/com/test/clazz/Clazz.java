/*
 * Project: alex-personal-tools
 * 
 * File Created at 2016��10��24��
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.test.clazz;

import java.util.Date;

/**
 * @Type Clazz.java
 * @Desc 
 * �򵥵�˵����ȡĳһ��������Ӧ��Class�������ͨ����������;����
   1. Object��getClass����
   2. ʹ��.class�ķ�ʽ; ʹ�������ӡ�.class���ķ�ʽ���᷵��������Ӧ��Class�������磺
   3. ʹ��Class.forName����          
 * 
 * @author alex
 * @date 2016��10��24�� ����11:42:24
 * @version 
 */
public class Clazz {
    
    
 /**
  * java.lang.Class��һ���Ƚ�������࣬�����ڷ�װ��װ�뵽JVM�е��ࣨ������ͽӿڣ�����Ϣ��
  *  ��һ�����ӿڱ�װ���JVMʱ������һ����֮������java.lang.Class���󣬿���ͨ�����Class����Ա�װ�������ϸ��Ϣ���з��ʡ�
  */
   
    public void  test1(){
        Date date1 = new Date();
        Date date2 = new Date();
        Class c1 = date1.getClass();
        Class c2 = date2.getClass();
        System.out.println(c1.getName()); // java.util.Date
        System.out.println(c1 == c2); // true
    }
    
    public void  test2(){
        Class clazz = String.class;
        System.out.println(clazz.getName()); // java.lang.String
    }
    
    public void  test3(){
        try {
            Class clazz = Class.forName("com.test.clazz.Clazz");
            System.out.println(clazz.getName()); // java.lang.String
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    
    public static void main(String[]  args){
        
        Clazz  clazz = new Clazz();
//        clazz.test1();
//        clazz.test2();
        clazz.test3();
    }
    
    
    
    
    

}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016��10��24�� alex creat
 */