package com.learning.algo;

public class Q6SumSquareDiff {

	
	public long sumSquareDiff(int num){
		
		long sq1= num*(num+1)*(2*num+1)/6;
		
		long sq2 = (long) Math.pow((num*(num+1)/2), 2);
		
		
		
		return sq2-sq1;
	}
	
	public static void main(String[] args) {
		
		Q6SumSquareDiff sq = new Q6SumSquareDiff();
		System.out.println(sq.sumSquareDiff(100));

	}

}
