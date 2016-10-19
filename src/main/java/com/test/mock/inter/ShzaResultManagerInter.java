/*
 * Project: alex-personal-tools
 * 
 * File Created at 2016年10月10日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.test.mock.inter;

import cmcc.zyhy.hbase.persistentBase.ShzaResult;

/**
 * @Type ShzaResultManagerInter.java
 * @Desc 
 * @author alex
 * @date 2016年10月10日 下午2:38:56
 * @version 
 */
public interface ShzaResultManagerInter {

    
    public ShzaResult getShzaResult(String rowkey);
}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016年10月10日 alex creat
 */