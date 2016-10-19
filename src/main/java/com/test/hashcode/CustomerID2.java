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
 * @Type CustomerID2.java
 * @Desc 
 * @author alex
 * @date 2016年10月13日 上午10:18:19
 * @version 
 */
public class CustomerID2 {
    
    private long crmID;
    private int nameSpace;

    public CustomerID2(long crmID, int nameSpace) {
      super();
      this.crmID = crmID;
      this.nameSpace = nameSpace;
    }

//    @Override
    public boolean equals(Object obj) {
      //null instanceof Object will always return false
      if (!(obj instanceof CustomerID2))
        return false;
      if (obj == this)
        return true;
      return  this.crmID == ((CustomerID2) obj).crmID &&
              this.nameSpace == ((CustomerID2) obj).nameSpace;
    }

    public int hashCode() {
      int result = 0;
      result = (int)(crmID/12) + nameSpace;
      return result;
    }

    public static void main(String[] args) {
      Map m = new HashMap();
      m.put(new CustomerID2(2345891234L,0),"Jeff Smith");
      System.out.println(m.get(new CustomerID2(2345891234L,0)));
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