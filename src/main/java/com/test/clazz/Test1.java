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

import com.test.reflectiondemo.Person;

/**
 * @Type test1.java
 * @Desc   Class 的使用
 * @author alex
 * @date 2016年10月24日 上午11:56:18
 * @version 
 */
public class Test1 {
    
    public  <T> T getBean(Class<T> clazz){
        T bean = null ;
        try {
            bean = clazz.newInstance();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bean;
    }
    
    
//    public  <? extends Number> String getBean(Class<?> clazz){
//        T bean = null ;
//        try {
//            bean=clazz.newInstance();
//        } catch (InstantiationException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return bean;
//    }
    
    public static void main(String[] args){
        Test1 test = new Test1();
        Integer  inter =  test.getBean(Integer.class);
//        Float  floatt =  test.getBean(Float.class);
//        Double  doubll =  test.getBean(Double.class);
//        String  str =  test.getBean(String.class);
        
//        System.out.println(inter.getClass().getName());
//        System.out.println(floatt.getClass().getName());
//        System.out.println(doubll.getClass().getName());
        try {
            Class<?> c = Integer.class;
            Integer p = (Integer) c.newInstance();
            
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
//        System.out.println(str.getClass().getName());
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