package com.learning.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Q24LexPermutation {
	
	private long factorial(long num){
		long fact = 1;
		for(long i=num; i>0;i--){
			fact = fact*i;
		}
		return fact;
	}
	public String findNum(long nth){
		nth = nth-1;
		List<Integer> nums= new CopyOnWriteArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
		String permLex = "";
		int size = nums.size(); 
		for(int i=1;i<size;i++){
			long factNum = factorial(size-i);
			int j =(int) (nth/factNum); 
			permLex = permLex+nums.get(j);
			nth = nth%factNum;
			nums.remove(j);
			if(nth == 0){
				break;
			}
		}
		
		return permLex;
		
	}
	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		Q24LexPermutation perms = new Q24LexPermutation();
		
		System.out.println(perms.findNum(1000000));
		long stop = System.currentTimeMillis();
		
		System.out.println("time " + (stop - start));

	}

}
