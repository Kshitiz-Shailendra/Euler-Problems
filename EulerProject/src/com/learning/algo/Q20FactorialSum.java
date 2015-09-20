package com.learning.algo;

import java.math.BigInteger;

public class Q20FactorialSum {

	private String getFactorial(int num){
		BigInteger factorial = BigInteger.ONE;
		
		for(int i=num ; i>0;i--){
			factorial = factorial.multiply(new BigInteger(Integer.valueOf(i).toString()));
		}
		System.out.println(factorial);
		return factorial.toString();
	}
	
	public long getFactSum(int num){
		long sum = 0;
		String bigNum = getFactorial(num);
		
		for(int i = 0 ; i<bigNum.length();i++){
			sum = sum + ((int)bigNum.charAt(i)-'0');
		}

		return sum;
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Q20FactorialSum factSum = new Q20FactorialSum();
		System.out.println(factSum.getFactSum(100));

		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));

	}

}
