package com.tools;

import java.util.*;

//格拉布斯准则(高斯去噪)
public class GLBS
{
	static Map<Double, Double> map;
	List<Double> list;
	double mean;     // 均值
	double mean2;   // 平方均值
	int listNum;
	double variance;     // 标准差

	public GLBS(List<Double> list)
	{
		this.list=list;
		
		if(map==null)
		{
			initMap();
		}
		mean_variance();
	}

	/**
	 * 均值和方差
	 */
	private void mean_variance()
	{
		Collections.sort(list);
		listNum=list.size();
		if(listNum==0)
		{
			mean=0;
			return;
		}
		List<Double> newList=new ArrayList<Double>();
		for(Double d: list)
		{
			if(d>150)
			{
				listNum--;
				continue;
			}
			newList.add(d);
			mean+=d;
			mean2+=d*d;
		}
		list=newList;
		mean/=listNum;         // 均值
		mean2/=listNum;
		variance=Math.sqrt(mean2-mean*mean); // 标准差
	}

	private void initMap()
	{
		map=new HashMap<Double, Double>();
		double[][] crisis= {
				{0,0,0,1.148,1.425,1.602,1.729,1.828,1.909,1.977,2.036,2.088,2.134,2.175,2.213,2.247,2.279,2.309,2.335,
						2.361,2.385,2.408,2.429,2.448,2.467,2.486,2.502,2.519,2.534,2.549,2.583,2.577,2.591,2.604,
						2.616,2.628,2.639,2.65,2.661,2.671,2.682,2.692,2.7,2.71,2.719,2.727,2.736,2.744,2.753,2.76,
						2.768,2.775,2.783,2.79,2.798,2.804,2.811,2.818,2.824,2.831,2.837,2.842,2.849,2.854,2.86,2.866,
						2.871,2.877,2.883,2.888,2.893,2.897,2.903,2.908,2.912,2.917,2.922,2.927,2.931,2.935,2.94,2.945,
						2.949,2.953,2.957,2.961,2.966,2.97,2.973,2.977,2.981,2.984,2.989,2.993,2.996,3,3.003,3.006,
						3.011,3.014,3.017},
				{0,0,0,1.153,1.463,1.672,1.822,1.938,2.032,2.11,2.176,2.234,2.285,2.331,2.371,2.409,2.443,2.475,2.501,
						2.532,2.557,2.58,2.603,2.624,2.644,2.663,2.681,2.698,2.714,2.73,2.745,2.759,2.773,2.786,2.799,
						2.811,2.823,2.835,2.846,2.857,2.866,2.877,2.887,2.896,2.905,2.914,2.923,2.931,2.94,2.948,2.956,
						2.943,2.971,2.978,2.986,2.992,3,3.006,3.013,3.019,3.025,3.032,3.037,3.044,3.049,3.055,3.061,
						3.066,3.071,3.076,3.082,3.087,3.092,3.098,3.102,3.107,3.111,3.117,3.121,3.125,3.13,3.134,3.139,
						3.143,3.147,3.151,3.155,3.16,3.163,3.167,3.171,3.174,3.179,3.182,3.186,3.189,3.193,3.196,3.201,
						3.204,3.207},
				{0,0,0,1.155,1.481,1.715,1.887,2.02,2.126,2.215,2.29,2.355,2.412,2.462,2.507,2.549,2.585,2.62,2.651,
						2.681,2.709,2.733,2.758,2.781,2.802,2.822,2.841,2.859,2.876,2.893,2.908,2.924,2.938,2.952,
						2.965,2.979,2.991,3.003,3.014,3.025,3.036,3.046,3.057,3.067,3.075,3.085,3.094,3.103,3.111,3.12,
						3.128,3.136,3.143,3.151,3.158,3.166,3.172,3.18,3.186,3.193,3.199,3.205,3.212,3.218,3.224,3.23,
						3.235,3.241,3.246,3.252,3.257,3.262,3.267,3.272,3.278,3.282,3.287,3.291,3.297,3.301,3.305,
						3.309,3.315,3.319,3.323,3.327,3.331,3.335,3.339,3.343,3.347,3.35,3.355,3.358,3.362,3.365,3.369,
						3.372,3.377,3.38,3.383},
				{0,0,0,1.155,1.492,1.749,1.944,2.097,2.22,2.323,2.41,2.485,2.55,2.607,2.659,2.705,2.747,2.785,2.821,
						2.954,2.884,2.912,2.939,2.963,2.987,3.009,3.029,3.049,3.068,3.085,3.103,3.119,3.135,3.15,3.164,
						3.178,3.191,3.204,3.216,3.228,3.24,3.251,3.261,3.271,3.282,3.292,3.302,3.31,3.319,3.329,3.336,
						3.345,3.353,3.361,3.388,3.376,3.383,3.391,3.397,3.405,3.411,3.418,3.424,3.43,3.437,3.442,3.449,
						3.454,3.46,3.466,3.471,3.476,3.482,3.487,3.492,3.496,3.502,3.507,3.511,3.516,3.521,3.525,3.529,
						3.534,3.539,3.543,3.547,3.551,3.555,3.559,3.563,3.567,3.57,3.575,3.579,3.582,3.586,3.589,3.593,
						3.597,3.6}};
		for(int i=3; i<=100; i++)
		{
			add(i, 0.90, crisis[0][i]);
			add(i, 0.95, crisis[1][i]);
			add(i, 0.975, crisis[2][i]);
			add(i, 0.99, crisis[3][i]);
		}
		add(101, 0.90, 3.02);
		add(101, 0.95, 3.21);
		add(101, 0.975, 3.39);
		add(101, 0.99, 3.65);
	}

	private void add(int i, double d, double e)
	{
		map.put(i+d, e);
	}

	private double Subtract(int n, double a, double value)
	{
		if(n>100)
		{
			n=101;
		}
		return value-map.get(n+a);
	}

	/**
	 * @return 返回剔除了所有异常数据的list
	 */
	public List<Double> clipList()
	{
		do
		{
			if(listNum<3)
			{
				return list;
			}
		} while(clipOne());
		return list;
	}

	/**
	 * 至多剔除一个异常数据
	 * 
	 * @return
	 */
	private boolean clipOne()
	{
		double t1=Math.abs(list.get(0)-mean)/variance;
		double tn=Math.abs(list.get(listNum-1)-mean)/variance;
		double sub1=Subtract(listNum, 0.90, t1);
		double subn=Subtract(listNum, 0.90, tn);
		if(sub1>0||subn>0)
		{
			double remove;
			if(sub1>subn)
			{
				remove=list.get(0);
				mean=(listNum*mean-remove)/(listNum-1);     // 均值更新
				System.out.println(" 过滤了："+remove);
				list.remove(0);
				
			}
			else
			{
				remove=list.get(listNum-1);
				mean=(listNum*mean-remove)/(listNum-1);     // 均值更新
				System.out.println(" 过滤了："+remove);
				list.remove(listNum-1);
			}
			mean2=(listNum*mean2-remove*remove)/(listNum-1);
			variance=Math.sqrt(mean2-mean*mean);        // 方差更新
			listNum--;                              // 个数更新
			return true;
		}
		return false;
	}

	public double getMean()
	{
		return mean;
	}
	
	public static void main(String[] args) {
		List<Double> speedList=new ArrayList<Double>(){
			{
				add(23.9);
				add(45.7);
				add(12.0);
				add(29.8);
				add(100.9);
			}
		};
		
		String[] speeds = vluaesSpeed.split(",");
		ArrayList<Double>  speedsdouble =GLBS.TranformString(speeds);
		GLBS glbs=new GLBS(speedList);
		List<Double> newList=glbs.clipList();   //得到剔除异常数据后的列表;
		double mean=glbs.getMean();   //得到newList列表的均值;
	}
	
	
   public static ArrayList<Double> TranformString(String[] speeds){
		
		ArrayList<Double> speed = new ArrayList(); // 得到某对卡口对的速度列表
		for (int i = 0; i < speeds.length; i++) {
			speed.add(Double.valueOf(speeds[i].trim()));
		}
		return speed;
	}
	
	
	static String vluaesSpeed2="43.19,	42.05,	39.95,	38.04,	35.51,	34.74,	33.29,	30.73,	30.73,	30.15,	29.59,	29.59,	29.05,	29.05,	29.05,	28.53,	28.53,	28.03,	28.03,	28.03,	28.03,	28.03,	28.03,	27.55,	27.55,	27.55,	26.19,	25.77,	25.77,	25.77,	25.36,	24.97,	24.58,	24.21,	21.02,	20.49,	18.80,	17.00,	16.82,	16.82,	16.82,	16.82,	16.82,	16.64,	16.64,	16.64,	16.47,	15.98,	15.82,	15.82,	15.67,	15.67,	15.51,	15.51,	15.36,	15.36,	15.22,	15.22,	15.07,	14.93,	14.93,	14.27,	14.02,	13.77,	13.66,	13.10,	12.29,	12.29,	12.29,	12.29,	12.20,	12.10,	12.10,	12.10,	12.01,	11.92,	11.92,	11.75,	11.75,	11.66,	11.58,	11.41,	9.57,	9.18,	9.13,	9.13,	9.03,	8.98,	8.93,	8.59,	8.59";

	static String vluaesSpeed="4.65,37.64,5.79,3.23,38.94,4.65,37.64,5.79,3.23,38.94";
	
}
