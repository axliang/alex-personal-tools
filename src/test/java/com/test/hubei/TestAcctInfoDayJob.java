package com.test.hubei;

import java.util.Arrays;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellScanner;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.KeyValueSerialization;
import org.apache.hadoop.hbase.mapreduce.MutationSerialization;
import org.apache.hadoop.hbase.mapreduce.ResultSerialization;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MultipleInputsMapReduceDriver;
import org.apache.hadoop.mrunit.types.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cmcc.hy.bigdata.weijifen.constants.HBaseTableSchema;
import com.cmcc.hy.bigdata.weijifen.jobs.hubei.acct.AcctInfoDayMapper;
import com.cmcc.hy.bigdata.weijifen.jobs.hubei.acct.AcctInfoDayReducer;
import com.cmcc.hy.bigdata.weijifen.jobs.hubei.acct.AcctPhoneMapper;
import com.cmcc.hy.bigdata.weijifen.model.AcctInfo;

/**
 * @Type TestAcctInfoDayJob.java
 * @Desc 
 * @author alex
 * @date 2016Âπ?9Êú?8Êó? ‰∏ãÂçà5:06:10
 * @version 
 */
public class TestAcctInfoDayJob {
    
    private MultipleInputsMapReduceDriver<Text, AcctInfo, ImmutableBytesWritable, Mutation> mapDriver;
    private AcctPhoneMapper mapper1 = new AcctPhoneMapper();
    private AcctInfoDayMapper mapper2 = new AcctInfoDayMapper();
    private AcctInfoDayReducer reducer = new AcctInfoDayReducer();

    @Before
    public void init() {

        mapDriver = MultipleInputsMapReduceDriver.newMultipleInputMapReduceDriver();
        mapDriver.addMapper(mapper1);
        mapDriver.addMapper(mapper2);
        mapDriver.setReducer(reducer);
        Configuration conf = mapDriver.getConfiguration();
        conf.set("columnSeparator", ",");
        conf.set("ruleSeparator", ",");
        conf.set("mappingSeparator", ",");
        conf.set("acctPhoneMap.column", "0,1");
        conf.set("acctPhoneMap.column.filterRule",
                "\\d+,^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$");
        conf.set("acctPhoneMap.column.mapping", "acct_id,phone_no");
        
        conf.set("acctInfo.column", "1,2,3");
        conf.set("acctInfo.column.filterRule", "\\d+,.+,.+");
        conf.set("acctInfo.column.mapping", "acct_id,acct_book_item_id,acct_balance");
        conf.set("log.level", "i");

        conf.setStrings("io.serializations", conf.get("io.serializations"),
                MutationSerialization.class.getName(), ResultSerialization.class.getName(),
                KeyValueSerialization.class.getName());

    }

    @Test
    public void test() throws Exception {

        BytesWritable acctPhoneKey1 = new BytesWritable(Bytes.toBytes("1"));
        Text acctPhoneText1 = new Text("7100000269704\t13986365629");
        Pair<BytesWritable, Text> acctPhoneinput1 = new Pair<BytesWritable, Text>(acctPhoneKey1,
                acctPhoneText1);
        mapDriver.addInput(mapper1, acctPhoneinput1);

        BytesWritable acctKey1 = new BytesWritable(Bytes.toBytes("1"));
        Text acctText1 = new Text("-\t7100000269704\tconsumScore\t10000");

        BytesWritable acctKey2 = new BytesWritable(Bytes.toBytes("2"));
        Text acctText2 = new Text("-\t7100000269704\tconsumScore2\t30");

        Pair<BytesWritable, Text> acctInput1 = new Pair<BytesWritable, Text>(acctKey1,
                acctText1);
        Pair<BytesWritable, Text> acctInput2 = new Pair<BytesWritable, Text>(acctKey2,
                acctText2);
        mapDriver.addInput(mapper2, acctInput1);
        mapDriver.addInput(mapper2, acctInput2);

        // mapDriver.runTest();
        List<Pair<ImmutableBytesWritable, Mutation>> result = mapDriver.run();

        byte[] expectedRowkey = Bytes.toBytes("13986365629");
        ImmutableBytesWritable expectedKey = new ImmutableBytesWritable(expectedRowkey);

        Assert.assertEquals(1, result.size());
        Pair<ImmutableBytesWritable, Mutation> resultPair = result.get(0);
        Assert.assertEquals(expectedKey, resultPair.getFirst());

        Mutation actualPut = resultPair.getSecond();
        CellScanner cs = actualPut.cellScanner();
        while (cs.advance()) {
            Cell actualCell = cs.current();
            if (Arrays.equals(CellUtil.cloneFamily(actualCell),
                    HBaseTableSchema.toBytes(HBaseTableSchema.CF_BASICINFO))
                    && Arrays.equals(CellUtil.cloneQualifier(actualCell),
                            HBaseTableSchema.toBytes(HBaseTableSchema.QL_BALANCE))) {
                Assert.assertArrayEquals(Bytes.toBytes("10030"), CellUtil.cloneValue(actualCell));
            } else {
                Assert.fail("Not expected qualifier");
            }

        }
    }
    
    
    

}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016Âπ?9Êú?8Êó? alex creat
 */