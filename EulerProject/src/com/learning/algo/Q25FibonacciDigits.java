package com.learning.algo;

import java.math.BigInteger;

public class Q25FibonacciDigits {
	final double g = (Math.sqrt(5) + 1) / 2;
	public long fibonacciIndex(int limit){
		long index = 3;
		
		BigInteger a = new BigInteger("1");
		BigInteger b = new BigInteger("1");
		BigInteger c = a.add(b);
		do{
			a=b;
			b=c;
			c=a.add(b);
			index++;
		}while(c.toString().length()<limit);
		
		System.out.println(c.toString());
		return index;
	}
	//better approach
	public double binetFormulaApproach(int limit){
		int i = 1;
		double temp = 1;
		while(temp < limit-1){
			i++;
			temp = i * Math.log10(g) + Math.log10(1/Math.sqrt(5));			
		}
		System.out.println(i);
		return temp;
	}
	public static void main(String[] args) {
	long start = System.currentTimeMillis();
	Q25FibonacciDigits digits = new Q25FibonacciDigits();
	System.out.println(digits.binetFormulaApproach(1000));
	//Your code goes here

	long stop = System.currentTimeMillis();
	System.out.println("time " + (stop - start));

	}

}
