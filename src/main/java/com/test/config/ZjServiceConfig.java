/*
 * Project: DSP-SERVER
 * 
 * File Created at 2016骞?9鏈?19鏃?
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.test.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



/**
 * 
 * 
 * 
 * 
 * 
 * 
 */

/**
 * @Type ZjServiceConfig.java
 * @Desc 
 * @author alex
 * @date 2016年9月19日 下午3:15:27
 * @version 
 */
@Component("ZjServiceConfig")
public class ZjServiceConfig {
    
    private final static Logger logger = LoggerFactory.getLogger(ZjServiceConfig.class);
    @Value("${serviceCodes}")
    private String serviceCodes;
    @Value("${thread.size}")
    private String threadSize;
    @Value("${request.timeout}")
    private String requestTimeout;
    
    public ZjServiceConfig(){
        logger.info("---------------------------serviceCodes:"+serviceCodes);
        logger.info("---------------------------thread.size:"+threadSize);
        logger.info("---------------------------request.timeout:"+requestTimeout);
    }

    public String getRequestTimeout() {
        return requestTimeout;
    }

    public String getServiceCodes() {
        return serviceCodes.trim();
    }

    public void setServiceCodes(String serviceCodes) {
        this.serviceCodes = serviceCodes;
    }

    public String getThreadSize() {
        return threadSize;
    }

    public void setThreadSize(String threadSize) {
        this.threadSize = threadSize;
    }
    
    

}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016骞?9鏈?19鏃? alex creat
 */