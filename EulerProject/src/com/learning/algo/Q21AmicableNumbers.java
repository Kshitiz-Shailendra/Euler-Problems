package com.learning.algo;

import java.util.HashMap;
import java.util.Map;

public class Q21AmicableNumbers {
	
	private Map<Integer,Integer> amicableNumbers(int limit){
		
		int arr[] = new int[limit];
		Map<Integer,Integer>  amicableNumbers=  new HashMap<Integer, Integer>();
		for(int i=220;i<limit;i++)
			arr[i] = divisorSum(i);
		
		for(int i=220;i<limit;i++ ){
			int j= arr[i];
			/*
			  	j<i condition:
			  	1. Avoid an illegal index when 'j >= limit'
          		2. Avoid the insertion of the equivalent pair [j,i]
          		3. Avoid the insertion of perfect numbers such as [6,6]
			 */
			if(j<i && i==arr[j]){
				amicableNumbers.put(i, j);
			}
		}
		
		
		return amicableNumbers;
	}
	private int divisorSum(int num){
		int sum = 1;
		int loop = (int)Math.sqrt(num);
		for(int i=2;i<=loop;i++){
			if(num%i==0){
				//System.out.println(i);
				sum = sum+i;
				int rev = num/i;
				if(rev!=i)
					sum = sum+rev;
			}
		}
		return sum;
	}
	public int amicableSum(int limit){
		int sum = 0;
		Map<Integer,Integer> numbers = amicableNumbers(limit);
		
		for(Integer key : numbers.keySet()){
			System.out.println("numbers "+key + " "+numbers.get(key));
			sum = sum + key + numbers.get(key);
		}
		
		return sum;
	}
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Q21AmicableNumbers num = new Q21AmicableNumbers();
		System.out.println(num.amicableSum(10000));
		
		//Your code goes here

		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));

	}

}
