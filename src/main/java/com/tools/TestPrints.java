package com.tools;

import java.math.BigDecimal;
import java.util.Random;

public class TestPrints {
	
	
	
//	7.5f,7.6f,7.7f,7.5f,7.6f,7.5f,7.4f,7.5f,7.6f,7.7f,7.5f,7.6f,7.5f,7.4f,7.5f,7.6f,7.7f,7.5f,7.6f,7.5f,7.4f,7.5f,7.6f,7.7f,7.5f,7.6f,7.5f,7.4f,7.5f,7.6f,7.7f,7.5f,7.6f,7.5f,7.4f,7.5f,7.6f,7.7f,7.5f,7.6f,7.5f,7.4f,7.5f,7.6f,7.7f,7.5f,7.6f,7.5f,7.4f,7.5f,7.6f,7.7f,7.5f,7.6f,7.5f,7.4f,7.5f,7.6f,7.7f,7.5f,7.6f,7.5f,7.4f,7.5f,7.6f,7.7f,7.5f,7.6f,7.5f,7.4f,7.5f,7.6f,7.7f,7.5f,7.6f,7.5f,7.4f,7.5f,7.6f,7.7f,7.5f,7.6f,7.5f,7.4f,7.5f,7.6f,7.7f,7.5f,7.6f,7.5f,7.4f,7.5f,7.6f,7.7f,7.5f,7.6f,7.5f,7.4f,7.5f,7.6f,7.7f,7.5f,7.6f,7.5f,7.4f,7.5f,7.6f,7.7f,7.5f,7.6f,7.5f,7.4f,7.5f,7.6f,7.7f,7.5f,7.6f,7.5f,7.4f,7.5f,7.6f,7.7f,7.5f,7.6f,7.5f,7.4f,7.5f,7.6f,7.7f,7.5f,7.6f,7.5f,7.4f,7.5f,7.6f,7.7f,7.5f,7.6f,7.5f,7.4f,7.5f,7.6f,7.7f,7.5f,7.6f,7.5f,7.4f,7.5f,7.6f,7.7f,7.5f,7.6f,7.5f,7.4f,
	
//	String[] mid_result="7.8f,7.6f,7.5f,7.4f";
	
	public static void main(String[] args){
		
		Random r = new Random();
		
		
		for(int j=0;j<70;j++){
			
			if(j>=30&&j<=45){
				float d3 = (float) (r.nextFloat() * 0.3 + 7.7);
				BigDecimal   b  =   new BigDecimal(d3);  
				d3 =  b.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();  
				System.out.print(","+ d3+"f");
			}else if(Math.abs(j-40)>5&&Math.abs(j-40)<15){
				float d3 = (float) (r.nextFloat() * 0.2 + 7.5);
				BigDecimal   b  =   new BigDecimal(d3);  
				d3 =  b.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
				System.out.print(","+ d3+"f");
			}else{
				float d3 = (float) (r.nextFloat() * 0.1 + 7.5);
				BigDecimal   b  =   new BigDecimal(d3);  
				d3 =  b.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
				System.out.print(","+ d3+"f");
			}
			
			
			
		}
		
		
		
	}

}
