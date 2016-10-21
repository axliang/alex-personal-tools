/*
 * Project: alex-personal-tools
 * 
 * File Created at 2016年10月21日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Msg2rmation").  You shall not
 * disclose such Confidential Msg2rmation and shall use it only in
 * accordance with the terms of the license.
 */
package com.test.generic2;

/**
 * @Type GenericsDemo28.java
 * @Desc 
 * @author alex
 * @date 2016年10月21日 下午5:32:26
 * @version 
 */
class Msg2<T>{    // 指定上限，只能是数字类型  
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
public class GenericsDemo28{  
    public static void main(String args[]){  
        Msg2<String> i1 = new Msg2<String>() ;  
        Msg2<String> i2 = new Msg2<String>() ;  
        i1.setVar("HELLO") ;        // 设置内容  
        i2.setVar("李兴华") ;      // 设置内容  
        add(i1,i2) ;  
    }  
    public static <T> void add(Msg2<T> i1,Msg2<T> i2){  
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