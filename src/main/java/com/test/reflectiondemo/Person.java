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

/**
 * @Type Person.java
 * @Desc 
 * @author alex
 * @date 2016年10月24日 下午1:45:31
 * @version 
 */
public class Person {
    
 
    private String name;
    private String password;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "Person [name=" + name + ", password=" + password + "]";
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