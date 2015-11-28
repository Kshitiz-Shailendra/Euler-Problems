package com.learning.algo;

public class Q44PentagonalNumbers {
	
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
	public long pentagonalSumDiff(){
		boolean found = false;
		long num =0,i=0,j=0,n1=0,n2=0;
		while(!found){
			i++;
			n1=i*(3*i-1)/2;
			for(j=i-1;j>0;j--){
				n2=j*(3*j-1)/2;
				if(isPentagonal(n1-n2)&&isPentagonal(n1+n2)){
					found = true;
					num = n1-n2;
					break;
				}
			}
		}
		
		
		return num;
	}
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Q44PentagonalNumbers diff = new Q44PentagonalNumbers();
		System.out.println(diff.pentagonalSumDiff());
		

		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));

	}

}
