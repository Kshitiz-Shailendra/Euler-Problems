package com.learning.algo;

import java.math.BigInteger;

public class Q36DoubleBasePalindromes {
	
	
	public long palindromeSum(int limit){
		BigInteger base10 = BigInteger.TEN,base2 = new BigInteger("2");
		long sum = 0;
		for(int i=1;i<limit;i++){
			if(checkPalindrome(BigInteger.valueOf(i), base10))
				if(checkPalindrome(new BigInteger(Integer.toBinaryString(i)), base2))
					sum = sum + i;
		}
		
		return sum;
	}
	
	private boolean checkPalindrome(BigInteger num,BigInteger base){
		
		BigInteger temp = num,reverse=BigInteger.ZERO;
		while(temp.signum()>0){
			reverse = reverse.multiply(BigInteger.TEN).add(temp.mod(base));
			temp = temp.divide(BigInteger.TEN);
			
		}
		if(reverse.equals(num))
			return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		Q36DoubleBasePalindromes palins = new Q36DoubleBasePalindromes();
		
		//System.out.println(palins.checkPalindrome(new BigInteger("1001001001"), new BigInteger("10")));
		System.out.println(palins.palindromeSum(1000000));
		//System.out.println(Integer.toBinaryString(999999));
		//System.out.println();
		
		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));
		

	}

}
