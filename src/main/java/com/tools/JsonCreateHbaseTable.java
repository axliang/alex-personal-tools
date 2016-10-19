package com.tools;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.util.Bytes;

public class JsonCreateHbaseTable {
	
	GlobalIndexAdmin ga= new GlobalIndexAdmin();
	
	public void CreatTable(){
		
		Configuration conf = HBaseConfiguration.create();	
		GlobalIndexAdmin admin = new GlobalIndexAdmin(conf);
		admin.addLOBForExistFamily(Bytes.toBytes("testTable"),Bytes.toBytes("f"),Bytes.toBytes("LOBP"));
		 admin.close();
		 
		 conf.set("hbase.zookeeper.quorum", "transwarp-nv01,transwarp-nv02,transwarp-nv03");
		 conf.set("zookeeper.znode.parent", "/hyperbase1");
		 conf.set("hbase.zookeeper.property.clientPort", "2181");
		
		
	}
	
	

	
	
	
	

}
