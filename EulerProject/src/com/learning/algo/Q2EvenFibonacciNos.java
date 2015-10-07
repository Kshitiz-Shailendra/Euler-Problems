package com.learning.algo;

public class Q2EvenFibonacciNos {

	public int evenFibonacci(int num){
		int sum = 0,a=0,b=1,c=a+b;
		while(c<=num){
			a=b;
			b=c;
			c=a+b;
			if((c&1)==0){
				sum+=c;
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		
		Q2EvenFibonacciNos evenFib = new Q2EvenFibonacciNos();
		System.out.println(evenFib.evenFibonacci(4000000));
	}

}
