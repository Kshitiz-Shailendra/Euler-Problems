package com.learning.algo;

import java.util.ArrayList;
import java.util.List;

public class Q23NonAbundantSum {
	
	private List<Integer> abundantNumbers(int limit){
		List<Integer> nums = new ArrayList<>();
		int []facts = new int[limit];
		
		for(int i=2;i<limit;i++){
			for(int j=i*2;j<limit;j=j+i){
				facts[j] +=i;
			}
		}
		for(int i=2; i<limit;i++){
			if(facts[i]>i){
				//System.out.println(i);
				nums.add(i);
				
			}
		}
		
		return nums;
	}
	
	private boolean[] abundantSums(int limit){
		boolean []sums = new boolean[limit+1];
		List<Integer> nums = abundantNumbers(limit);
		for(int i=0;i<nums.size();i++){
			for(int j=i;j<nums.size();j++){
				if(nums.get(i)+nums.get(j)<=limit){
					sums[nums.get(i)+nums.get(j)] = true;
				}else{
					break;
				}
			}
		}
		
		return sums;
	}
	
	private long nonAbundantSums(int limit){
		boolean [] abundantSums = abundantSums(limit);
		long nonAbundantSum = 0;
		for(int i=0;i<limit;i++){
			if(!abundantSums[i]){
				nonAbundantSum = nonAbundantSum+i;
			}
		}
		return nonAbundantSum;
	}
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		Q23NonAbundantSum abSum = new Q23NonAbundantSum();
		System.out.println(abSum.nonAbundantSums(28123));

		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));

	}

}
