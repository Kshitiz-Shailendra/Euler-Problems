package com.learning.algo;

public class Q43SubStringDivisbility {
	
	public long subStringDivisbilitySum(){
		long sum=0;
		
		for(long num = 1023456789;num<9876543210L;num++){
			if(isPandigital(num)&&isSpecialDivisible(num)){
				sum = sum + num;
				System.out.println(num);
			}
				
		}
		
		
		return sum;
		
	}
	
	private boolean isSpecialDivisible(long num){
		long []primes = {2,3,5,7,11,13,17};
		String numStr = Long.valueOf(num).toString();
		for(int i=1;i<8;i++){
			if(Long.valueOf(numStr.substring(i, i+3))%primes[i-1]!=0)
					return false;
		}
		
		return true;
	}
	
	private boolean isPandigital(long n){
		int min = 1023456789;
		int expected = 1023;
		if (n >= min)
	    {
	        int digits = 0;

	        for (; n > 0; n /= 10)
	        {
	            digits |= 1 << (n - ((n / 10) * 10));
	        }

	        return digits == expected;
	    }
	    return false;
		
		
	}
	public static void main(String[] args) {
		Q43SubStringDivisbility str =new Q43SubStringDivisbility();
		System.out.println(str.subStringDivisbilitySum());
		

	}

}
