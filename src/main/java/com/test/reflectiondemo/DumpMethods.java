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
package com.test.reflectiondemo;


import java.lang.reflect.Method;
import java.util.Stack;

import junit.framework.TestCase;

/**
 * @Type DumpMethods.java
 * @Desc 
 * @author alex
 * @date 2016年10月24日 下午1:44:03
 * @version 
 */
public class DumpMethods extends TestCase {


    public static void main(String[] args) {
//        getDeclaredMethods("java.util.Stack");
//          new DumpMethods().invokeTest();
//          new DumpMethods().getClassTester();
          new DumpMethods().isInstanceTest();
        
    }

    private static void getDeclaredMethods(String className) {
        try {
            Class<?> c = Class.forName(className);
            Method m[] = c.getDeclaredMethods();
            for (int i = 0; i < m.length; i++) {
                System.out.println(m[i].toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getClassTester() {
        try {
            Class<?> stringClass = Class.forName("java.lang.String");
            Class<?> intClass = int.class;
            Class<?> integerClass = Integer.class;

            System.out.println(integerClass.getDeclaredMethods()[0].toString());
            
//            System.out.println(integerClass.getDeclaredMethods()[0].toString());
//            System.out.println(Stack.class.getDeclaredMethods()[0].toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void isInstanceTest() {
        Class<?> c = DumpMethods.class;
        boolean b = c.isInstance(new DumpMethods());
        System.out.println(b);
    }

    public void invokeTest(){
        Class<?> c = Person.class;
        try{
            Method setNameMethod = c.getMethod("setName", String.class);
            Method getNameMethod = c.getMethod("getName", null);
            Person p = (Person) c.newInstance();
            setNameMethod.invoke(p, "andy");
            String name = (String) getNameMethod.invoke(p, null);
            System.out.println(name);
        }catch(Exception e){
            System.out.println(e.toString());
        }
        
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