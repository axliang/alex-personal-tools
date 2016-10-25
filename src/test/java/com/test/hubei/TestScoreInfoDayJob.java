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
import com.cmcc.hy.bigdata.weijifen.jobs.hubei.score.AcctPhoneMapper;
import com.cmcc.hy.bigdata.weijifen.jobs.hubei.score.ScoreInfoDayMapper;
import com.cmcc.hy.bigdata.weijifen.jobs.hubei.score.ScoreInfoDayReducer;
import com.cmcc.hy.bigdata.weijifen.model.ScoreInfo;


/**
 * @Type TestScoreInfoDayJob.java
 * @Desc 
 * @author alex
 * @date 2016Âπ?8Êú?25Êó? ‰∏ãÂçà3:05:21
 * @version 
 */
public class TestScoreInfoDayJob {

    private MultipleInputsMapReduceDriver<Text, ScoreInfo, ImmutableBytesWritable, Mutation> mapDriver;
    private AcctPhoneMapper mapper1 = new AcctPhoneMapper();
    private ScoreInfoDayMapper mapper2 = new ScoreInfoDayMapper();
    private ScoreInfoDayReducer reducer = new ScoreInfoDayReducer();

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

        conf.set("scoreInfo.column", "3,5,6");
        conf.set("scoreInfo.column.filterRule", "\\d+,.+,.+");
        conf.set("scoreInfo.column.mapping", "entt_id,score_type,score_balance");
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

        BytesWritable scoreKey1 = new BytesWritable(Bytes.toBytes("1"));
        Text scoreText1 = new Text("-\t-\t-\t7100000269704\t-\tconsumScore\t-10\t-");

        BytesWritable scoreKey2 = new BytesWritable(Bytes.toBytes("1"));
        Text scoreText2 = new Text("-\t-\t-\t7100000269704\t-\tconsumScore2\t30\t-");

        Pair<BytesWritable, Text> scoreInput1 = new Pair<BytesWritable, Text>(scoreKey1,
                scoreText1);
        Pair<BytesWritable, Text> scoreInput2 = new Pair<BytesWritable, Text>(scoreKey2,
                scoreText2);
        mapDriver.addInput(mapper2, scoreInput1);
        mapDriver.addInput(mapper2, scoreInput2);

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
                            HBaseTableSchema.toBytes(HBaseTableSchema.QL_POINTS))) {
                Assert.assertArrayEquals(Bytes.toBytes("20"), CellUtil.cloneValue(actualCell));
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
 * 2016Âπ?8Êú?25Êó? alex creat
 */
