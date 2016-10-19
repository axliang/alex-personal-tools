package com.tools;

import java.util.ArrayList;
import java.util.List;


/***
 * 数据公式
 * @author alex.xi
 *
 */
public class MathsUtils {
	
	
	
	/**
	 * 求平均值
	 * @param sample
	 * @return
	 */
	public  double calcAverage(List<Double> sample) {
		// TODO Auto-generated method stub
		double sum = 0;
		int cnt = 0;
		for (int i = 0; i < sample.size(); i++) {
			sum += sample.get(i);
			cnt++;
		}

		return (double) sum / cnt;
	}

	/**
	 * 求标准差
	 * @param array
	 * @param n
	 * @param average
	 * @return
	 */
	public double calcStandard(List<Double> array, int n, double average) {
		// TODO Auto-generated method stub
		double sum = 0;
		for (int i = 0; i < n; i++) {
			sum += ((double) array.get(i) - average)
					* ((double) array.get(i) - average);
		}
		return (double) Math.sqrt((sum / (n - 1)));
	}
	
	
//	变异系数又称“标准差率”，是衡量资料中各观测值变异程度的另一个统计量。
//	当进行两个或多个资料变异程度的比较时，如果度量单位与平均数相同，可以直接利用标准差来比较。
//	如果单位和（或）平均数不同时，比较其变异程度就不能采用标准差，而需采用标准差与平均数的比值（相对值）来比较。
//	标准差与平均数的比值称为变异系数，记为C.V。变异系数可以消除单位和（或）平均数不同对两个或多个资料变异程度比较的影响。   
//	标准变异系数是一组数据的变异指标与其平均指标之比，它是一个相对变异指标。   变异系数有全距系数、平均差系数和标准差系数等。
//	常用的是标准差系数，用CV(Coefficient of Variance)表示。   CV(Coefficient of Variance):标准差与均值的比率。   
//	用公式表示为：CV＝σ/μ   作用：反映单位均值上的离散程度，常用在两个总体均值不等的离散程度的比较上。
//	若两个总体的均值相等，则比较标准差系数与比较标准差是等价的。   变异系数又称离散系数
	
	public  double calcCV(ArrayList<Double> array) {
		double  Average= this.calcAverage(array);
		double  Standard= this.calcStandard(array,array.size(),Average);
		double CV=Standard/Average;
		return CV;
	}
	
	


	
	
	/**
	 * String speed 转为  Double 
	 * @param speeds
	 * @return
	 */
	public ArrayList<Double> TranformString(String[] speeds){
		
		ArrayList<Double> speed = new ArrayList(); // 得到某对卡口对的速度列表
		for (int i = 0; i < speeds.length; i++) {
			speed.add(Double.valueOf(speeds[i].trim()));
		}
		return speed;
	}
	
	
	static String vluaesSpeed2="43.19,	42.05,	39.95,	38.04,	35.51,	34.74,	33.29,	30.73,	30.73,	30.15,	29.59,	29.59,	29.05,	29.05,	29.05,	28.53,	28.53,	28.03,	28.03,	28.03,	28.03,	28.03,	28.03,	27.55,	27.55,	27.55,	26.19,	25.77,	25.77,	25.77,	25.36,	24.97,	24.58,	24.21,	21.02,	20.49,	18.80,	17.00,	16.82,	16.82,	16.82,	16.82,	16.82,	16.64,	16.64,	16.64,	16.47,	15.98,	15.82,	15.82,	15.67,	15.67,	15.51,	15.51,	15.36,	15.36,	15.22,	15.22,	15.07,	14.93,	14.93,	14.27,	14.02,	13.77,	13.66,	13.10,	12.29,	12.29,	12.29,	12.29,	12.20,	12.10,	12.10,	12.10,	12.01,	11.92,	11.92,	11.75,	11.75,	11.66,	11.58,	11.41,	9.57,	9.18,	9.13,	9.13,	9.03,	8.98,	8.93,	8.59,	8.59";

	static String vluaesSpeed="4.65,37.64,5.79,3.23,38.94,4.65,37.64,5.79,3.23,38.94";
	static String vluaesSpeed3="23.9,45.7,12.0,29.8,100.9";
	
	public static void main(String[] args) {
		
		GLBS_CDT   glbs_cdt=new GLBS_CDT();

		MathsUtils mathsutils=new MathsUtils();
		String[] speeds = vluaesSpeed2.split(",");
		
		ArrayList<Double>  speedsdouble =mathsutils.TranformString(speeds);
		
		System.out.println(vluaesSpeed2+" 的变异系数是  "+mathsutils.calcCV(speedsdouble));
		List<Double>  results2=glbs_cdt.filter(speedsdouble, 0.90);
		for(int i=0; i<results2.size();i++){
			if(i == 0){
				System.out.println();
				System.out.println(vluaesSpeed2+" 过滤后值是：");
			}
			System.out.print(results2.get(i)+"  ");
		}
//		
//		String[] speeds1 = vluaesSpeed.split(",");
//		ArrayList<Double>  speedsdouble1 =mathsutils.TranformString(speeds1);
//		System.out.println(vluaesSpeed+" 的变异系数是：    "+mathsutils.calcCV(speedsdouble1));
//		List<Double>  results1=glbs_cdt.filter(speedsdouble1, 0.90);
//		for(int i=0; i<results1.size();i++){
//			if(i == 0){
//				System.out.println();
//				System.out.println(vluaesSpeed+" 过滤后值是：");
//			}
//			System.out.print(results1.get(i)+"  ");
//		}
		

	}
	

}
