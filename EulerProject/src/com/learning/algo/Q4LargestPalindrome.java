package com.learning.algo;

public class Q4LargestPalindrome {

	public int LargestPalindrome(){
		
		int largest =0;
		int palin = 0;
		for(int i=100;i<=999;i++){
			for(int j=100;j<=999;j++){
				palin = i*j;
				if(isPalindrome(palin)){
					largest = (largest<palin)?palin:largest;
				}
			}
		}
		return largest;
		
	}
	
	public boolean isPalindrome(int num){
		
		String reverseNum = (new StringBuilder(Integer.toString(num))).reverse().toString();
		System.out.println(num+" "+reverseNum);
		if(reverseNum.equals(Integer.toString(num))){
			return true;
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		
		Q4LargestPalindrome laQ4 = new Q4LargestPalindrome();
		System.out.println(laQ4.LargestPalindrome());
	}

}
