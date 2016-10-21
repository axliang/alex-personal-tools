/*
 * Project: alex-personal-tools
 * 
 * File Created at 2016��10��21��
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.test.generic2;


/**
 * <T>  ���ͱ�ʶ
 *  T  ��������
 *  T  �����������
 * @author alex
 *
 */
class Demo{  
    public <T> T fun(T t){            // ���Խ����������͵�����  
        return t ;                  // ֱ�ӰѲ�������  
    }  
};  

/**
 * @Type GenericsDemo26.java
 * @Desc 2.1���巺�ͷ���
 * @author alex
 * @date 2016��10��21�� ����5:02:41
 * @version 
 */
public class GenericsDemo26{  
    public static void main(String args[]){  
        Demo d = new Demo() ;   // ʵ����Demo����  
        String str = d.fun("���˻�") ; //  �����ַ���  
        int i = d.fun(30) ;     // �������֣��Զ�װ��  
        System.out.println(str) ;   // �������  
        System.out.println(i) ;     // �������  
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