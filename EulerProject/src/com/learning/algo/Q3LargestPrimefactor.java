/**
 *concepts 
 *1.shorten the target condition (sqrt(num)) 
 *2.every number n can at most have one prime factor greater than n . If we,
 *	after dividing out some prime factor, calculate the square root of the remaining number we
 *	can use that square root as upper limit for factor.
 */

package com.learning.algo;

public class Q3LargestPrimefactor {

	public long findLargestPrimeFactor(long num){
		
		while(num%2==0){
			num = num/2;
		}
		
		for (long i = 3; i <=Math.sqrt(num); i=i+2) {
			
				while (num % i == 0) {
					num = num / i;
	            }
			
		}
		return num;
	}
	
	public static void main(String args[]){
		long start = System.nanoTime();
		Q3LargestPrimefactor large = new Q3LargestPrimefactor();
		System.out.println(large.findLargestPrimeFactor(600851475143L));
		long stop = System.nanoTime();
		
		System.out.println("time taken : "+(stop-start)/1000);
		
		
	}
}
 