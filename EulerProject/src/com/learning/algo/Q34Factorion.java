package com.learning.algo;

public class Q34Factorion {

	public long factorionSum(){
		long sum=0;
		int count=0,factSum=0;
		int []factorialArr ={1,1,2,6,24,120,720,5040,40320,362880};
		
		for(int loop = 11;loop<100000;loop++){
			factSum=0;
			count = loop;
			while(count>0){
				factSum = factSum+factorialArr[count%10];
				count = count/10;
			}
			if(factSum == loop){
				System.out.println("num = "+loop);
				sum = sum+loop;
			}
				
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Q34Factorion fact = new Q34Factorion();
		System.out.println(fact.factorionSum());
		

		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));

	}

}
