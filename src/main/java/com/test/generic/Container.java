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
 * @Type Container.java
 * @Desc 
 * @author alex
 * @date 2016年10月21日 下午2:11:47
 * @version 
 */
public class Container {

    private String key;
    private String value;

    public Container(String k, String v) {
        key = k;
        value = v;
    }
    
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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