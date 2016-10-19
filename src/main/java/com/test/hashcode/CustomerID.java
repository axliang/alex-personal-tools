/*
 * Project: alex-personal-tools
 * 
 * File Created at 2016年10月13日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.test.hashcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Type CustomerID.java
 * @Desc 
 * @author alex
 * @date 2016年10月13日 上午10:08:27
 * @version 
 */
public class CustomerID {

    private long crmID;
    private int nameSpace;

    public CustomerID(long crmID, int nameSpace) {
      super();
      this.crmID = crmID;
      this.nameSpace = nameSpace;
    }

    @Override
    public boolean equals(Object obj) {
      //null instanceof Object will always return false
      if (!(obj instanceof CustomerID))
        return false;
      if (obj == this)
        return true;
      return  this.crmID == ((CustomerID) obj).crmID &&
              this.nameSpace == ((CustomerID) obj).nameSpace;
    }
    
    /****
     * put 的时候 按照 key.hashcode, 和数组 Node size ，进行 &,放到对应的位置
     * 
     * 取数 的时候，map.get(key.hashcode),判断hashcode 相等，判断 key.equls 和key 相等
     * 
     * @param args
     */
    
    public static void main(String[] args) {
      Map m = new HashMap();
      m.put(new CustomerID(2345891234L,0),"Jeff Smith");
      System.out.println(m.get(new CustomerID(2345891234L,0)));
    }
}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016年10月13日 alex creat
 */