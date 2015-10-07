package com.learning.algo;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
/**
 * Easier doing HashSet way
 * @author Kshitiz
 *
 */
public class Q29DigitPowers {
	
	public int uniquePowers(int limit){
		Set<BigInteger>  powerSet = new HashSet<BigInteger>();
		
		for(int i=2;i<=limit;i++){
			BigInteger num = new BigInteger(Integer.valueOf(i).toString());
			for(int j=2;j<=limit;j++){
				powerSet.add(num.pow(j));
			}
		}
		return powerSet.size();
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Q29DigitPowers powers = new Q29DigitPowers();
		System.out.println(powers.uniquePowers(100));
	
		
		
		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));

	}

}
