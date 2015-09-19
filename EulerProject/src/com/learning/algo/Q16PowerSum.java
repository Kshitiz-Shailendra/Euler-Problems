/**
 * convert char to string : + ""
 */
package com.learning.algo;

import java.math.BigInteger;

public class Q16PowerSum {
	
	public long digitSum(int pow){
		
		long sum = 0;
		
		
		char [] bigArr = calcPower(pow).toCharArray();
		
		for(char el : bigArr){
			sum +=Long.parseLong(el+"");
		}
		
		
		
		return sum;
		
	}
	private String calcPower(int pow){
		BigInteger number2 = new BigInteger("2");
		BigInteger power2 =  number2.pow(pow);
		//System.out.println(power2);
		return power2.toString();
		
	}
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		Q16PowerSum sum = new Q16PowerSum();
		System.out.println(sum.digitSum(1000));
		
		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));
		
		
	}

}
