/*
 * Project: alex-hbase-test
 * 
 * File Created at 2016��9��12��
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.test.bulkload;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.HFileOutputFormat;
import org.apache.hadoop.hbase.mapreduce.LoadIncrementalHFiles;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

/**
 * @Type GeneratePutHFileAndBulkLoadToHBase.java
 * @Desc 
 * @author alex
 * @date 2016��9��12�� ����2:55:05
 * @version 
 */
public class GeneratePutHFileAndBulkLoadToHBase {
    
    public static class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>
    {

        private Text wordText=new Text();
        private IntWritable one=new IntWritable(1);
        @Override
        protected void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            // TODO Auto-generated method stub
            String line=value.toString();
            String[] wordArray=line.split(" ");
            for(String word:wordArray)
            {
                wordText.set(word);
                context.write(wordText, one);
            }
            
        }
    }
    
    public static class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable>
    {

        private IntWritable result=new IntWritable();
        protected void reduce(Text key, Iterable<IntWritable> valueList,
                Context context)
                throws IOException, InterruptedException {
            // TODO Auto-generated method stub
            int sum=0;
            for(IntWritable value:valueList)
            {
                sum+=value.get();
            }
            result.set(sum);
            context.write(key, result);
        }
        
    }
    
    public static class ConvertWordCountOutToHFileMapper extends Mapper<LongWritable, Text, ImmutableBytesWritable, Put>
    {

        @Override
        protected void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            // TODO Auto-generated method stub
            String wordCountStr=value.toString();
            String[] wordCountArray=wordCountStr.split("\t");
            String word=wordCountArray[0];
            int count=Integer.valueOf(wordCountArray[1]);
            
            //����HBase�е�RowKey
            byte[] rowKey=Bytes.toBytes(word);
            ImmutableBytesWritable rowKeyWritable=new ImmutableBytesWritable(rowKey);
            byte[] family=Bytes.toBytes("cf");
            byte[] qualifier=Bytes.toBytes("count");
            byte[] hbaseValue=Bytes.toBytes(count);
            // Put �����д��µĶ����ύ����ֻ��һ���У������ʹ�� KeyValue ��ʽ
            // KeyValue keyValue = new KeyValue(rowKey, family, qualifier, hbaseValue);
            Put put=new Put(rowKey);
            put.add(family, qualifier, hbaseValue);
            context.write(rowKeyWritable, put);
            
        }
        
    }
    
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Configuration hadoopConfiguration=new Configuration();
        String[] dfsArgs = new GenericOptionsParser(hadoopConfiguration, args).getRemainingArgs();
        
        //��һ��Job������ͨMR�������ָ����Ŀ¼
        Job job=new Job(hadoopConfiguration, "wordCountJob");
        job.setJarByClass(GeneratePutHFileAndBulkLoadToHBase.class);
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.setInputPaths(job, new Path(dfsArgs[0]));
        FileOutputFormat.setOutputPath(job, new Path(dfsArgs[1]));
        //�ύ��һ��Job
        int wordCountJobResult=job.waitForCompletion(true)?0:1;
        
        //�ڶ���Job�Ե�һ��Job�������Ϊ���룬ֻ��Ҫ��дMapper�࣬��Mapper���ж�һ��job��������з�������ת��ΪHBase��Ҫ��KeyValue�ķ�ʽ��
        Job convertWordCountJobOutputToHFileJob=new Job(hadoopConfiguration, "wordCount_bulkload");
        
        convertWordCountJobOutputToHFileJob.setJarByClass(GeneratePutHFileAndBulkLoadToHBase.class);
        convertWordCountJobOutputToHFileJob.setMapperClass(ConvertWordCountOutToHFileMapper.class);
        //ReducerClass ����ָ������ܻ����и��� MapOutputValueClass ��������ʹ�� KeyValueSortReducer ���� PutSortReducer
        //convertWordCountJobOutputToHFileJob.setReducerClass(KeyValueSortReducer.class);
        convertWordCountJobOutputToHFileJob.setMapOutputKeyClass(ImmutableBytesWritable.class);
        convertWordCountJobOutputToHFileJob.setMapOutputValueClass(Put.class);
        
        //�Ե�һ��Job�������Ϊ�ڶ���Job������
        FileInputFormat.addInputPath(convertWordCountJobOutputToHFileJob, new Path(dfsArgs[1]));
        FileOutputFormat.setOutputPath(convertWordCountJobOutputToHFileJob, new Path(dfsArgs[2]));
        //����HBase�����ö���
        Configuration hbaseConfiguration=HBaseConfiguration.create();
        //����Ŀ������
        HTable wordCountTable =new HTable(hbaseConfiguration, "word_count");
        HFileOutputFormat.configureIncrementalLoad(convertWordCountJobOutputToHFileJob,wordCountTable);
       
        //�ύ�ڶ���job
        int convertWordCountJobOutputToHFileJobResult=convertWordCountJobOutputToHFileJob.waitForCompletion(true)?0:1;
        
        //���ڶ���job����֮�󣬵���BulkLoad��ʽ����MR����������
        LoadIncrementalHFiles loader = new LoadIncrementalHFiles(hbaseConfiguration);
        //��һ������Ϊ�ڶ���Job�����Ŀ¼������HFile��Ŀ¼���ڶ�������ΪĿ���
        loader.doBulkLoad(new Path(dfsArgs[2]), wordCountTable);
        
        //������System.exit�����˳�
        System.exit(convertWordCountJobOutputToHFileJobResult);
        
    }

    
    
    
    

}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016��9��12�� alex creat
 */