package com.learning.algo;

public class PrimeSummationQ10 {

	public long sumPrimes(long num){
		long sum=2;
		
		for(int i=3;i<=num;i++){
			
			if(isPrime(i)){
				sum = sum+i;
			}
		}
		
		return sum;
	}
	
	private boolean isPrime(long num){
		
		if(num==2)
			return true;
		
		if(num%2==0)
			return false;
		
		for(int i = 3; i<=Math.sqrt(num);i=i+2){
			if(num%i==0){
				return false;
			}
		}
		
		return true;
	}
	
	public long primeSieve(long num){
		long sum=0;
		
		boolean [] arr = new boolean[(int)num];
		int sqrt = (int) Math.sqrt(num);
		for(int i=2 ; i<= sqrt ; i++){
			if(!arr[i]){
				for(int j=i*i; j<num ;j=j+i){
					arr[j] = true;
				}
			}
		}
		for(int i=2;i<num;i++){
			if(!arr[i]){
				sum = sum +i;
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		PrimeSummationQ10 sum = new PrimeSummationQ10();
		System.out.println(sum.primeSieve(2000000));
		long stop = System.currentTimeMillis();
		System.out.println("time "+(stop-start));
	}

}
