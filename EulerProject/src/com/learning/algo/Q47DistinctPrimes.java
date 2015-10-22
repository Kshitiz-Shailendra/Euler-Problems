package com.learning.algo;

public class Q47DistinctPrimes {
	
	private boolean primeCheck(long num , int numOfTimes){
		int count=0;
		if((num&1)==0){
			count++;
			while(num%2==0)
				num= num/2;
		}
		
		for(int i=3;i<=Math.sqrt(num);i=i+2){
			if(num%i==0){
				count++;
				while(num%i==0)
					num =num/i;
			}
			
		}
		if(num!=1)
			count++;//last left is always prime
		return count == numOfTimes;
	}
	public long distinctConsPrimeFactors(int limit){
		int count =0,num=0;
		boolean primeMet = false;
		outer:
		for(int i=440;!primeMet;){
			count=0;
			if(primeCheck(i, limit)){
				count++;
				int j=0;
				for(j=1;j<limit;j++){
					if(primeCheck(i+j, limit)){
						count++;
					}
				}
				
				if(count==limit){
					primeMet = true;
					num =i;
					break outer;
				}
				
				i++;
			}else{
				i++;
			}
		}
		
		
		return num;
	}
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Q47DistinctPrimes prime = new Q47DistinctPrimes();
		System.out.println(prime.distinctConsPrimeFactors(4));
		

		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));

	}

}
