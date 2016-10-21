/*
 * Project: alex-personal-tools
 * 
 * File Created at 2016年10月21日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Msg3rmation").  You shall not
 * disclose such Confidential Msg3rmation and shall use it only in
 * accordance with the terms of the license.
 */
package com.test.generic2;


class Msg3<T>{    // 指定上限，只能是数字类型  
    private T var ;     // 此类型由外部决定  
    public T getVar(){  
        return this.var ;     
    }  
    public void setVar(T var){  
        this.var = var ;  
    }  
    public String toString(){       // 覆写Object类中的toString()方法  
        return this.var.toString() ;      
    }  
};  

/**
 * @Type GenericsDemo29.java
 * @Desc 
 * @author alex
 * @date 2016年10月21日 下午5:35:05
 * @version 
 */
public class GenericsDemo29{  
    public static void main(String args[]){  
        Msg3<Integer> i1 = new Msg3<Integer>() ;  
        Msg3<String> i2 = new Msg3<String>() ;  
        i1.setVar(30) ;     // 设置内容  
        i2.setVar("李兴华") ;      // 设置内容  
        add(i1,i2) ;  
    }  
    public static <T> void add(Msg3<T> i1,Msg3<T> i2){  
        System.out.println(i1.getVar() + " " + i2.getVar()) ;  
    }  
};

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016年10月21日 alex creat
 */