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
 * @Type Container2.java
 * @Desc 
 * @author alex
 * @date 2016年10月21日 下午2:14:20
 * @version 
 */
public class Container2<K,V> {
    private K key;
    private V value;
    
    public Container2(K key, V value) {
        super();
        this.key = key;
        this.value = value;
    }
    
    
    public K getKey() {
        return key;
    }
    public void setKey(K key) {
        this.key = key;
    }
    public V getValue() {
        return value;
    }
    public void setValue(V value) {
        this.value = value;
    }
    
    
    
    public static void main(String[] args) {
        Container2<String, String> c1 = new Container2<String, String>("name", "findingsea");
        Container2<String, Integer> c2 = new Container2<String, Integer>("age", 24);
        Container2<Double, Double> c3 = new Container2<Double, Double>(1.1, 2.2);
        System.out.println(c1.getKey() + " : " + c1.getValue());
        System.out.println(c2.getKey() + " : " + c2.getValue());
        System.out.println(c3.getKey() + " : " + c3.getValue());
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