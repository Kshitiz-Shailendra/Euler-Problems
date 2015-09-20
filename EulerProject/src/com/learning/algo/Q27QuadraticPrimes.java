package com.learning.algo;

public class Q27QuadraticPrimes {
	
	public int multiplyPrimes(){
		int multiply = 1,n=0,maxn=0;
		
		for(int i=-1000;i<=1000;i++){
			for(int j=-1000;j<=1000;j++){
				n=0;
				if(j==2 && (i&1)!=0)
					continue;
				else{
					if(!checkPrime(j)){
						continue;
					}else{
						
						while(checkPrime(n*n + n*i + j))
							n++;
					}
				}
				
				if(n>maxn){
					maxn = n;
					System.out.println("i = "+i+" j = "+j);
					multiply = i*j;
				}
					
			}
		}
		
		
		return multiply;
	}
	
	
	private boolean checkPrime(long num){
		
		if(num<2)
			return false;
		if(num<4)
			return true;
		if(num%2==0)
			return false;
		
		for(int j=3; j<=Math.sqrt(num);j=j+2){
			if(num%j==0)
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		Q27QuadraticPrimes primes = new Q27QuadraticPrimes();
		//System.out.println(primes.checkPrime(163));
		System.out.println(primes.multiplyPrimes());
		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));

	}

}
