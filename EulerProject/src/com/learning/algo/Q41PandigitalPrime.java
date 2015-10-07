package com.learning.algo;
/**
 * only 7 and 4 digit pandigital nos can be non-prime because for others the sum of digits is 3 ie divisible by 3
 * @author Kshitiz
 *
 */
public class Q41PandigitalPrime {
	
	
	public int maxPandigitalPrime(){
		
		for(int i=7654321;i>7000000;i=i-2){
			if(isPandigital(i)&&isPrime(i))
				return i;
		}
		
		return 0;
	}
	
	private boolean isPandigital(int num){
		int digits=0,tmp=0,count=0;
		
		while(num>0){
			tmp = digits;
			digits = digits | 1<<(int)((num%10)-1);
			if(tmp == digits)
				return false;
			
			count++;
			num = num/10;
		}
		
		return digits == (1<<count) -1;
	}
	
	private boolean isPrime(int num){
		
		if(num<2)
			return false;
		if(num<=3)
			return true;
		if(num%2==0||num%3==0)
			return false;
		
		for(int i=5;i*i<=num;i=i+6)
			if(num%i==0||num%(i+2)==0)
				return false;
		
		return true;	
		
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Q41PandigitalPrime pans = new Q41PandigitalPrime();
		//System.out.println(pans.isPrime(29));
		System.out.println(pans.maxPandigitalPrime());

		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));

	}

}
