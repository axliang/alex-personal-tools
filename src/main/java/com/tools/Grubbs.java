package com.tools;

import java.util.ArrayList;




//需要剔除异常数据，就是根据之前一组数据判断新来的数据是否为合理数据，在相差过大的时候予以剔除，找到了格拉布斯准则，具体内容和步骤参见链接http://www.docin.com/p-730815444.html，我觉得写的很好，里面的例子可以借鉴理解： 
//有一组数据8.2,5.4,14.0,7.3,4.7,9.0,6.5,10.1,7.7,6.0,我们要对里面的异常值（最大或最小）进行剔除。 
//1.首先进行排序：4.7,5.4,6.0,6.5,7.3,7.7,8.2,9.0,10.1,14.0 
//2.求平均值及标准差：平均值7.89，标准差：2.704 
//3.最大值及最小值为可疑值，偏离差分别为：14-7.89=6.11；7.89-4.7=3.19.（根据这两个值判断是否剔除最大值或最小值，文档中说只能判断一个，实际上两边都可以判断） 
//4.最小值的G1=（平均值-最小值）/标准差 
//最大值的Gn=（最大值-平均值）/标准差 
//5.确定检出水平alpha，一般为0.01或0.05，越大越宽松，根据实际条件进行确定，我这里使用0.05，根据后面的表格求出临界值，与G1，Gn作比较；若G1（Gn）大于临界值，则剔除，反之保留。

//http://www.docin.com/p-730815444.html






public class Grubbs {
	private ArrayList<Double> dataArrayList;
	private int length;
	private final double alpha = 0.05;

	// 传入一组数据，我们要做的是剔除最大或最小的异常值
	public Grubbs(ArrayList<Double> arrayList) {
		this.dataArrayList = arrayList;
		this.length = arrayList.size();
	}

	public ArrayList<Double> calc() {
		// 因为格拉布斯准则只能对大于等于3个数据进行判断，所以数据量小于3时，直接返回
		if (dataArrayList.size() < 3) {
			return dataArrayList;
		}
		// 首先对数据进行排序，我这里用了最基本的冒泡法
		dataArrayList = bubbleSort(dataArrayList, length);
		// 求出数据平均值和标准差
		double average = calcAverage(dataArrayList);
		double standard = calcStandard(dataArrayList, length, average);
		// 求助最小值和最大值G1，Gn
		double dubMin = average - dataArrayList.get(0);
		double dubMax = dataArrayList.get(length - 1) - average;
		double G1 = dubMin / standard;
		double Gn = dubMax / standard;
		// 做比较，是否剔除
		if (G1 > calcG(alpha, length)) {
			dataArrayList.remove(0);
			if (Gn > calcG(alpha, length)) {
				dataArrayList.remove(length - 2);
			}
		} else if (Gn > calcG(alpha, length)) {
			dataArrayList.remove(length - 1);
		}
		return dataArrayList;

	}

	// 冒泡排序
	private ArrayList<Double> bubbleSort(ArrayList<Double> arr, int n) {
		// TODO Auto-generated method stub
		double temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr.get(j) > arr.get(j + 1)) {
					temp = arr.get(j);
					arr.set(j, arr.get(j + 1));
					arr.set(j + 1, temp);
				}
			}
		}
		return arr;
	}

	// 求平均
	public double calcAverage(ArrayList<Double> sample) {
		// TODO Auto-generated method stub
		double sum = 0;
		int cnt = 0;
		for (int i = 0; i < sample.size(); i++) {
			sum += sample.get(i);
			cnt++;
		}

		return (double) sum / cnt;
	}

	// 求标准差
	private double calcStandard(ArrayList<Double> array, int n, double average) {
		// TODO Auto-generated method stub
		double sum = 0;
		for (int i = 0; i < n; i++) {
			sum += ((double) array.get(i) - average)
					* ((double) array.get(i) - average);
		}
		return (double) Math.sqrt((sum / (n - 1)));
	}

	// 算临界值的表，这里alpha为0.05
	private double calcG(double alpha, int n) {
		double[] N = { 1.1546847100299753, 1.4962499999999703,
				1.763678479497787, 1.9728167175443088, 2.1391059896012203,
				2.2743651271139984, 2.386809875078279, 2.4820832497170997,
				2.564121252001767, 2.6357330437346365, 2.698971864039854,
				2.755372404941574, 2.8061052912205966, 2.8520798130619083,
				2.894013795424427, 2.932482154393285, 2.9679513293748547,
				3.0008041587489247, 3.031358153993366, 3.0598791335206963,
				3.086591582831163, 3.1116865231590722, 3.135327688211162,
				3.157656337622164, 3.178795077984819, 3.198850919445483,
				3.2179177419513314, 3.2360783011390764, 3.2534058719727748,
				3.26996560491852, 3.2858156522011304, 3.301008108808857,
				3.31558980320037, 3.329602965279218, 3.3430857935316243,
				3.356072938839107, 3.368595919061223, 3.3806834758032323,
				3.3923618826659503, 3.403655212591846, 3.41458557057518,
				3.4251732969213213, 3.435437145364717, 3.4453944396432576,
				3.4550612115453876, 3.464452322969104, 3.4735815741386,
				3.482461799798589, 3.491104954935569, 3.4995221913492585,
				3.507723926208097, 3.5157199035634887, 3.5235192496631433,
				3.5311305227901078, 3.5385617582575746, 3.5458205091071684,
				3.5529138829882037, 3.5598485756350797 };

		return N[n - 3];
	}
}