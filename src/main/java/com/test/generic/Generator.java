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
 * @Type Generator.java
 * @Desc  在泛型接口中，生成器是一个很好的理解，看如下的生成器接口定义
 * @author alex
 * @date 2016年10月21日 下午2:40:24
 * @version 
 */
public interface Generator<T> {
    
    public abstract T next();

}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016年10月21日 alex creat
 */