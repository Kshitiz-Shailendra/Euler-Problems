package com.learning.algo;

public class EvenFibonacciNosQ2 {

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
		
		EvenFibonacciNosQ2 evenFib = new EvenFibonacciNosQ2();
		System.out.println(evenFib.evenFibonacci(4000000));
	}

}
