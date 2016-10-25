/*
 * Project: alex-personal-tools
 * 
 * File Created at 2016年10月24日
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
 * 简单的说，获取某一个类所对应的Class对象可以通过如下三种途径：
   1. Object的getClass方法
   2. 使用.class的方式; 使用类名加“.class”的方式即会返回与该类对应的Class对象。例如：
   3. 使用Class.forName方法          
 * 
 * @author alex
 * @date 2016年10月24日 上午11:42:24
 * @version 
 */
public class Clazz {
    
    
 /**
  * java.lang.Class是一个比较特殊的类，它用于封装被装入到JVM中的类（包括类和接口）的信息。
  *  当一个类或接口被装入的JVM时便会产生一个与之关联的java.lang.Class对象，可以通过这个Class对象对被装入类的详细信息进行访问。
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
 * 2016年10月24日 alex creat
 */