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

import java.util.Random;

/**
 * @Type CarGenerator.java
 * @Desc 然后定义一个生成器类来实现这个接口：
 * @author alex
 * @date 2016年10月21日 下午2:58:52
 * @version 
 */
public class CarGenerator implements Generator<String> {
    
    private static final String[] cars ={"BYD","TESLA","BENS","AUDI"};

    @Override
    public String next() {
        // TODO Auto-generated method stub
        Random random = new Random();
        return cars[random.nextInt(4)];
    }
    
    
    public static void main(String[] args){
        
        CarGenerator  carGenerator = new CarGenerator();
        for(int i =0;i<20;i++){
            System.out.println("---  "+carGenerator.next());
        }
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