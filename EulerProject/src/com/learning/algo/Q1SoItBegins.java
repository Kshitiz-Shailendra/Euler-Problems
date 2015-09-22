package com.learning.algo;

public class Q1SoItBegins {
	
	public int summation(int num,int factor){
		
		int range = (num-1)/factor;
		
		return factor*range*(range+1)/2;
	}
	
	
	public static void main(String[] args) {
		
		Q1SoItBegins begins = new Q1SoItBegins();
		
		int result = begins.summation(1000, 3)+begins.summation(1000, 5)-begins.summation(1000, 15);
		System.out.println(result);

	}

}
