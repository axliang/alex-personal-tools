/*
 * Project: alex-personal-tools
 * 
 * File Created at 2016年10月21日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Msgrmation").  You shall not
 * disclose such Confidential Msgrmation and shall use it only in
 * accordance with the terms of the license.
 */
package com.test.generic2;

/**
 * @Type GenericsDemo27.java
 * @Desc 通过泛型方法返回泛型类的实例
 * @author alex
 * @date 2016年10月21日 下午5:08:11
 * @version 
 */
class Msg<T extends Number>{ // 指定上限，只能是数字类型  
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
public class GenericsDemo27{  
    public static void main(String args[]){  
        Msg<Integer> i = fun(30) ;  
        System.out.println(i.getVar()) ;  
        
        Msg<Double> m = fun(30.5d) ;  
        System.out.println(m.getVar()) ;  
        
        Msg<Float> m2 = fun(30.51f) ;  
        System.out.println(m2.getVar()) ;  
        
    }  
    public static <T extends Number> Msg<T> fun(T param){  
        Msg<T> temp = new Msg<T>() ;      // 根据传入的数据类型实例化Msg  
        temp.setVar(param) ;        // 将传递的内容设置到Msg对象的var属性之中  
        return temp ;   // 返回实例化对象  
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