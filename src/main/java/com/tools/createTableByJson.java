package com.tools;


/**
 * Created by root on 14-10-12.
 */

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.util.Bytes;


public class createTableByJson{
    private static Configuration config;
     static {
        config = HBaseConfiguration.create();
        config.addResource("core-site.xml");
        config.addResource("hdfs-site.xml");
        config.addResource("yarn-site.xml");
        config.addResource("mapred-site.xml");
         try {
//             Configuration conf = HBaseConfiguration.create();	
//        	 GlobalIndexAdmin admin = new GlobalIndexAdmin(conf);
//        	 admin.addLOBForExistFamily(Bytes.toBytes("testTable"),Bytes.toBytes("f"),Bytes.toBytes("LOBP"));
//        	  admin.close();
        	  
        	  Configuration conf = HBaseConfiguration.create();	
        	  GlobalIndexAdmin admin = new GlobalIndexAdmin(conf);
        	  admin.addLOBForExistFamily(Bytes.toBytes("testTable"),Bytes.toBytes("f"),Bytes.toBytes("LOBP"));
        	  admin.close();
             
         } catch (MasterNotRunningException e) {
             e.printStackTrace();
         } catch (ZooKeeperConnectionException e) {
             e.printStackTrace();
         }
     }

  

    public static void main(String[] args){

    	System.out.println("  ---test  ");
            new createTableByJson().Method_create_Table();


    }

  




}
