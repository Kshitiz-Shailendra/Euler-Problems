package com.learning.algo;

public class Q40ChampernowneConstant {
	
	public int multiplyConstants(){
		int multiply = 1,start=0;
		int	[]arr = {1,10,100,1000,10000,100000,1000000};
		StringBuilder champerStrBuilder = new StringBuilder(Integer.toString(start));
		while(start<1000001){
			start++;
			champerStrBuilder.append(start);
		}
		String champerStr = champerStrBuilder.toString();
		for(int i=0;i<arr.length;i++){
			multiply = multiply*(champerStr.charAt(arr[i]) -'0');
		}
		
		return multiply;
	}
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Q40ChampernowneConstant cnst = new Q40ChampernowneConstant();
		System.out.println(cnst.multiplyConstants());

		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));
		

	}

}
