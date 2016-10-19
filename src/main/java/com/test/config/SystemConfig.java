/*
 * Project: credit-dsp-open
 * 
 * File Created at 2016å¹?9æœ?9æ—?
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
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


/**
 * 
 * @author alex
 *
 */
@Configuration
@PropertySource(value = "application.properties")
public class SystemConfig implements InitializingBean {

    private final static Logger logger = LoggerFactory.getLogger(SystemConfig.class);
    
    @Value("${so.path}")
    private String soPath;

    @Value("${external.url}")
    private String externalUrl;

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("Begin to load libdspopen.so from path : " + this.soPath);
        //        System.load(this.soPath);
    }
    
    public String getSoPath() {
        return soPath;
    }

    public void setSoPath(String soPath) {
        this.soPath = soPath;
    }

    public String getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016å¹?9æœ?9æ—? Lucifer creat
 */
