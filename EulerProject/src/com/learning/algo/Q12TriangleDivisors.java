package com.learning.algo;


public class Q12TriangleDivisors {
	
	public long triangleDiv(long num){
		
		long i=0;
		
		for(long j=1;;j++){
			i=i+j;
			System.out.println(j+" ");
			if(numDivisors(i)>num){
				return i;
			}
		}
	}
	
	public long numDivisors(long num){
		
		System.out.print("num "+num);
		long numDivisors = 0;
		for(int i=1;i<=Math.sqrt(num);i++){
			if(num%i==0)
				numDivisors++;
		}
		
		System.out.println(" numDivisors "+numDivisors*2);
		System.out.println();
		return numDivisors*2;
	}
	
	public static void main(String[] args) {
		Q12TriangleDivisors div = new Q12TriangleDivisors();
		//System.out.println(div.triangleDiv(500));
		System.out.println(div.numDivisors(4573800));
	}

}
