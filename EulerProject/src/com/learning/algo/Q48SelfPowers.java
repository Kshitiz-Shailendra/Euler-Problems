package com.learning.algo;

import java.math.BigInteger;

public class Q48SelfPowers {
	
	public String selfPowers(){
		BigInteger sum = BigInteger.ZERO;
		for(int i=1;i<=1000;i++){
			sum = sum.add((new BigInteger(""+i)).pow(i));
		}
		
		String num = sum.toString();
		long length = num.length();
		
		return num.substring((int)(length-10));
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Q48SelfPowers selfpies = new Q48SelfPowers();
		System.out.println(selfpies.selfPowers());
		

		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));

	}

}
