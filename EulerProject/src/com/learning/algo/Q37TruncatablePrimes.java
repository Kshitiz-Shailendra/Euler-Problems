package com.learning.algo;

public class Q37TruncatablePrimes {
	
	boolean []primes;
	
	public Q37TruncatablePrimes() {
		primes = new boolean[2000000]; 
		primes[1]=true;
		int sqrt = (int)Math.sqrt(2000000);
		
		for(int i=2;i<=sqrt;i++){
			if(!primes[i]){
				for(int j=i*i;j<2000000;j=j+i){
					primes[j]=true;
				}
			}
		}
	}
	
	private boolean isPrimeThruSieve(long num){
		
		return !primes[(int) num];
	}
	
	

	private boolean isTrunctablePrime(long num){
		long temp=num;
		boolean flag = false;
		
		//right to left truncation
		while(temp>0){
			if(!isPrimeThruSieve(temp)){
				flag = true;
				break;
			}
			temp = temp/10;
		}
		if(flag)
			return false;
		temp = num;flag = false;
		
		//left to right truncation
		while(temp>0){
			temp = temp%(int)Math.pow(10, (int)Math.log10(temp));
			if(!isPrimeThruSieve(temp))
				return false;				
			
		}
				
		return true;
	}
	
	public long getTruncPrimeSum(){
		int count = 1;
		long sum = 0,num=11;
		
		while(count<=11){
			if(isTrunctablePrime(num)){
				System.out.println(count+" "+num);
				sum = sum+num;
				count++;num++;
			}else{
				num++;
			}
		}
		
		
		return sum;
	}
	
	public static void main(String[] args) {
	long start = System.currentTimeMillis();

	Q37TruncatablePrimes truncs = new Q37TruncatablePrimes();
	//System.out.println(truncs.isTrunctablePrime(739397));
	System.out.println("sum "+truncs.getTruncPrimeSum());
	long stop = System.currentTimeMillis();
	System.out.println("time " + (stop - start));	

	}

}
