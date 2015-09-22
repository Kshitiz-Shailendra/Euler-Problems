package com.learning.algo;

public class SoItBeginsQ1 {
	
	public int summation(int num,int factor){
		
		int range = (num-1)/factor;
		
		return factor*range*(range+1)/2;
	}
	
	
	public static void main(String[] args) {
		
		SoItBeginsQ1 begins = new SoItBeginsQ1();
		
		int result = begins.summation(1000, 3)+begins.summation(1000, 5)-begins.summation(1000, 15);
		System.out.println(result);

	}

}
