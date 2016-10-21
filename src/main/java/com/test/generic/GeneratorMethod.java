/*
 * Project: alex-personal-tools
 * 
 * File Created at 2016年10月21日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.test.generic;

/**
 * @Type GeneratorMethod.java
 * @Desc 
 * @author alex
 * @date 2016年10月21日 下午3:46:03
 * @version 
 */
public class GeneratorMethod {
    
    
    /**
     * 
     * @param t
     * @return
     */
    public static <T> T out(T t) {
        System.out.println(t);
        return t;
    }

    public static void main(String[] args) {
        out("findingsea");
        out(123);
        out(11.11);
        out(true);
    }

}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016年10月21日 alex creat
 */