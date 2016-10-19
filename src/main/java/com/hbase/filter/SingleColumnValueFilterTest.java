package com.hbase.filter;



import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.SingleColumnValueExcludeFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.FilterList.Operator;
import org.apache.hadoop.hbase.util.Bytes;


/***
 *  rowfilter  的做法
 * @author alex.xi
 *
 */
public class SingleColumnValueFilterTest {

	private static String FAMALIY="v";
	private static Configuration config;
	
//	String tableName = "veh_passrec_sjscsj";
	String tableName = "veh_passrec_gcsj";
	
	public SingleColumnValueFilterTest(){
		config = HBaseConfiguration.create();
		config.addResource("core-site.xml");
		config.addResource("hdfs-site.xml");
		config.addResource("yarn-site.xml");
		config.addResource("mapred-site.xml");
		
	}
	
	public static void main(String[] args) {

	 new SingleColumnValueFilterTest().zdcTest();

  }
	
	
	/**
	 * 测试，新加的 zdc 列值，如果没有这一列，则该行数据过滤掉，如果有，这该行数据找出来。
	 * 要filter 和要用显示的值。 都要 scan 都要  addColumn。 如果要filter ,不显示的值，那你就exclude 吧
	 */
	private void zdcTest(){
		
		try {
			
			List<Filter> filterList=new ArrayList();
			SingleColumnValueFilter filter = new SingleColumnValueFilter(
					Bytes.toBytes(FAMALIY),
					Bytes.toBytes("zdc"),
					CompareFilter.CompareOp.EQUAL,
					new BinaryComparator(Bytes.toBytes("0")));
			
			//要使用作为条件的列，如果这一列本身就不存在，那么如果为true，这样的行将会被过滤掉，如果为false，这样的行会包含在结果集中
			filter.setFilterIfMissing(true);
			SingleColumnValueFilter filter2 = new SingleColumnValueFilter(
					Bytes.toBytes(FAMALIY),
					Bytes.toBytes("hpzl"),
					CompareFilter.CompareOp.EQUAL,
					new BinaryComparator(Bytes.toBytes("02")));
			filter2.setFilterIfMissing(true);
			
			filterList.add(filter);
			filterList.add(filter2);
			
			HTable table = new HTable(config, tableName);
			Scan scan = new Scan();
			
			FilterList  fiter=new FilterList(Operator.MUST_PASS_ALL,filterList); 
			scan.setFilter(fiter);
			scan.addColumn(Bytes.toBytes("v"), Bytes.toBytes("zdc"));
			scan.addColumn(Bytes.toBytes("v"), Bytes.toBytes("hpzl"));
			scan.addColumn(Bytes.toBytes("v"), Bytes.toBytes("ddbh"));
			ResultScanner rs = table.getScanner(scan);
			long count=0l;
			for(Result r:rs){
				count++;
				byte[] rowKey = r.getRow();
				byte[] val1 = r.getValue(Bytes.toBytes(FAMALIY), Bytes.toBytes("ddbh"));
				byte[] val2 = r.getValue(Bytes.toBytes(FAMALIY), Bytes.toBytes("cdbh"));
				byte[] val3 = r.getValue(Bytes.toBytes(FAMALIY), Bytes.toBytes("fk"));
				byte[] val4 = r.getValue(Bytes.toBytes(FAMALIY), Bytes.toBytes("gcsj"));
				byte[] val5 = r.getValue(Bytes.toBytes(FAMALIY), Bytes.toBytes("hphm"));
				byte[] val6 = r.getValue(Bytes.toBytes(FAMALIY), Bytes.toBytes("hpzl"));
				byte[] val7 = r.getValue(Bytes.toBytes(FAMALIY), Bytes.toBytes("sjscsj"));
				byte[] val8 = r.getValue(Bytes.toBytes(FAMALIY), Bytes.toBytes("fxms"));
				byte[] val9 = r.getValue(Bytes.toBytes(FAMALIY), Bytes.toBytes("zdc"));
//		
//				System.out.println("rowkey: "+Bytes.toString(rowKey));
				System.out.println("ddbh: "+Bytes.toString(val1));
//				System.out.println("cdbh: "+Bytes.toString(val2));
//				System.out.println("fk: "+Bytes.toString(val3));
//				System.out.println("gcsj: "+Bytes.toString(val4));
//				System.out.println("hphm: "+Bytes.toString(val5));
				System.out.println("hpzl: "+Bytes.toString(val6));
//				System.out.println("sjscsj: "+Bytes.toString(val7));
//				System.out.println("fxms: "+Bytes.toString(val8));
				System.out.println("zdc: "+Bytes.toString(val9));
			}
			rs.close();
			table.close();
			System.out.println("共: "+ count+"条结果，scan over");
			
			
		}catch(Exception e){
			
			
		}
		
		
		
		
	}
	
	
	
	
	
	
	/**
	 * 测试  语句 ：select t.* from veh_passrec t where not(hphm='浙A8555H' and hpzl='02')
	 * select t.* from veh_passrec t where  (hphm!='浙HV5285' or hpzl!='01') and (hphm!='浙HV5285' or hpzl!='02')
	 */
	private void SingleTest(){
		
		try{
			List<Filter> filterList=new ArrayList();
			List<Filter> filterList2=new ArrayList();
			SingleColumnValueFilter filter = new SingleColumnValueFilter(
					Bytes.toBytes(FAMALIY),
					Bytes.toBytes("hphm"),
					CompareFilter.CompareOp.NOT_EQUAL,
					new BinaryComparator(Bytes.toBytes("ABCDEF")));
					
			SingleColumnValueFilter filter2 = new SingleColumnValueFilter(
					Bytes.toBytes(FAMALIY),
					Bytes.toBytes("hpzl"),
					CompareFilter.CompareOp.NOT_EQUAL,
					new BinaryComparator(Bytes.toBytes("02")));
				
			SingleColumnValueFilter second_filter1 = new SingleColumnValueFilter(
					Bytes.toBytes(FAMALIY),
					Bytes.toBytes("hphm"),
					CompareFilter.CompareOp.NOT_EQUAL,
					new BinaryComparator(Bytes.toBytes("GHIJKL")));
					//when setting setFilterIfMissing(true), rows with "null" values are filtered
					
					
			SingleColumnValueFilter second_filter2 = new SingleColumnValueFilter(
					Bytes.toBytes(FAMALIY),
					Bytes.toBytes("hpzl"),
					CompareFilter.CompareOp.NOT_EQUAL,
					new BinaryComparator(Bytes.toBytes("04")));
					//when setting setFilterIfMissing(true), rows with "null" values are filtered
			
			
//					filter.setFilterIfMissing(true);
//					filter2.setFilterIfMissing(true);
//					second_filter1.setFilterIfMissing(true);
//					second_filter2.setFilterIfMissing(true);

					filterList.add(filter);
					filterList.add(filter2);
					filterList2.add(second_filter1);
					filterList2.add(second_filter2);
					
					FilterList  fiter=new FilterList(Operator.MUST_PASS_ONE,filterList); 
					FilterList  fiter2=new FilterList(Operator.MUST_PASS_ONE,filterList2);
					
					FilterList  fiter_union=new FilterList(Operator.MUST_PASS_ALL);
					fiter_union.addFilter(fiter);
					fiter_union.addFilter(fiter2);
					
			
			HTable table = new HTable(config, tableName);
			Scan scan = new Scan();
//			scan.setFilter(fiter_union);
			scan.setStartRow(Bytes.toBytes("8586860573999|2014-10-13 02:41:43|01|01|ABCDEF"));
			scan.setStopRow(Bytes.toBytes("8586860696999|2014-10-13 02:43:49|01|01|GHIJKL"));
			scan.addColumn(Bytes.toBytes("v"), Bytes.toBytes("gcsj"));
			scan.setMaxVersions();
			//specify maximum number of cells to avoid OutOfMemory error caused by huge amount of data in a single row
//			scan.setBatch(10000);
			ResultScanner rs = table.getScanner(scan);
			long count=0l;
			for(Result r:rs){
				count++;
				byte[] rowKey = r.getRow();
				byte[] val1 = r.getValue(Bytes.toBytes(FAMALIY), Bytes.toBytes("ddbh"));
				byte[] val2 = r.getValue(Bytes.toBytes(FAMALIY), Bytes.toBytes("cdbh"));
				byte[] val3 = r.getValue(Bytes.toBytes(FAMALIY), Bytes.toBytes("fk"));
				byte[] val4 = r.getValue(Bytes.toBytes(FAMALIY), Bytes.toBytes("gcsj"));
				byte[] val5 = r.getValue(Bytes.toBytes(FAMALIY), Bytes.toBytes("hphm"));
				byte[] val6 = r.getValue(Bytes.toBytes(FAMALIY), Bytes.toBytes("hpzl"));
				byte[] val7 = r.getValue(Bytes.toBytes(FAMALIY), Bytes.toBytes("sjscsj"));
				byte[] val8 = r.getValue(Bytes.toBytes(FAMALIY), Bytes.toBytes("fxms"));
		
				System.out.println("rowkey: "+Bytes.toString(rowKey));
				System.out.println("ddbh: "+Bytes.toString(val1));
				System.out.println("cdbh: "+Bytes.toString(val2));
				System.out.println("fk: "+Bytes.toString(val3));
				System.out.println("gcsj: "+Bytes.toString(val4));
				System.out.println("hphm: "+Bytes.toString(val5));
				System.out.println("hpzl: "+Bytes.toString(val6));
				System.out.println("sjscsj: "+Bytes.toString(val7));
				System.out.println("fxms: "+Bytes.toString(val8));
			}
			rs.close();
			table.close();
			System.out.println("共: "+ count+"条结果，scan over");
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	}
	
}




