package com.learning.algo;

public class Q7Prime10001 {

	
	public long prime(int n){
		
		long prime = 1;
		int count = 0;
		while(count!=n){
			for(long i=prime+1;;i++){
				if(checkPrime(i)){
					count++;
					prime = i; 
					break;
				}
			}
			//System.out.println(prime+" "+count);
		}
		
		
		return prime;
	}
	
	private boolean checkPrime(long i) {
		
		if(i<2)
			return false;
		if(i<4)
			return true;
		if(i%2==0)
			return false;
		
		for(int j = 3; j<=Math.sqrt(i);j=j+2){
			if(i%j==0)
				return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		Q7Prime10001 prime = new Q7Prime10001();
		System.out.println(prime.prime(10001));

	}

}
