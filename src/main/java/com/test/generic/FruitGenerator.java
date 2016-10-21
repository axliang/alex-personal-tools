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
package com.test.generic;

import java.util.Random;

/**
 * @Type FruitGenerator.java
 * @Desc   ȥʵ�ֽӿڵ�ʱ��Ҫָ����  ����
 * @author alex
 * @date 2016��10��21�� ����2:46:23
 * @version 
 */
public class FruitGenerator implements Generator<String> {

    private String[] fruits ={"apple","banana","orange"};
    
    @Override
    public String next() {
        // TODO Auto-generated method stub
        Random random = new Random();
        return fruits[random.nextInt(3)];
    }

}



/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016��10��21�� alex creat
 */