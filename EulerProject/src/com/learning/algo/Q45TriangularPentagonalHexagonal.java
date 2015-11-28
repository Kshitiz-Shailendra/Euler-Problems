package com.learning.algo;
/**
 * better way is to ignore triangular aspect and generate pentagonal numbers and 
 * check for hexagonality... hexagonal numbers are implicitly triangular.
 * @author Kshitiz
 *
 */
public class Q45TriangularPentagonalHexagonal {
	
	private boolean isPerfectSquare(long num){
		if(num<0)
			return false;
		long sqrt = (long)Math.sqrt(num);
		
		return sqrt*sqrt==num;
	}
	
	private boolean isPentagonal(long num){
		if(isPerfectSquare(24*num + 1) && (int)Math.sqrt(24*num+1)%6 == 5)return true;
		return false;
	}
	
	private boolean isHexagonal(long num){
		if(isPerfectSquare(8*num + 1) && (int)Math.sqrt(8*num+1)%4 == 3)return true;
		return false;
	}
	
	public long nextThatNumber(){
		long startNum = 40755;
		for(int i=286;;i++){
			startNum = startNum+i;
			if(isPentagonal(startNum)&&isHexagonal(startNum))
				return startNum;
		}
	}
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Q45TriangularPentagonalHexagonal hexPent = new Q45TriangularPentagonalHexagonal();
		System.out.println(hexPent.nextThatNumber());
		

		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));

	}

}
