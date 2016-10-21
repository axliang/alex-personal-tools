/*
 * Project: alex-personal-tools
 * 
 * File Created at 2016��10��21��
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
 * @Desc ͨ�����ͷ������ط������ʵ��
 * @author alex
 * @date 2016��10��21�� ����5:08:11
 * @version 
 */
class Msg<T extends Number>{ // ָ�����ޣ�ֻ������������  
    private T var ;     // ���������ⲿ����  
    public T getVar(){  
        return this.var ;     
    }  
    public void setVar(T var){  
        this.var = var ;  
    }  
    public String toString(){       // ��дObject���е�toString()����  
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
        Msg<T> temp = new Msg<T>() ;      // ���ݴ������������ʵ����Msg  
        temp.setVar(param) ;        // �����ݵ��������õ�Msg�����var����֮��  
        return temp ;   // ����ʵ��������  
    }  
};  

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016��10��21�� alex creat
 */