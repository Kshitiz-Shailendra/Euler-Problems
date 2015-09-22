package com.learning.algo;

public class SmallestMultipleQ5 {

	private long lcm(long res,long b){
		
				
		return res*(b/gcd(res,b));
	}
	
	private long gcd(long res, long b) {
		
		long temp1 = res;
		System.out.print("gcd of ("+temp1 +", "+b);
		while(b>0){
			long temp = b;
			b = res%b;
			res=temp;
		}
		System.out.print(") -->"+res);
		System.out.println();
		return res;
	}

	/*private int gcd(){
		
		int res = 1;
		
		for(int i=2;i<=10;i++){
			res = gcd(res,i);
		}
		
		return res;
	}*/
	
	public long smallestLcm(){
		long res = 1;
		
		for(int i=2;i<=20;i++){
			//System.out.println("res  "+res);
			res = lcm(res,i);
		}
		
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmallestMultipleQ5 mul = new SmallestMultipleQ5();
		
		System.out.println(mul.smallestLcm());
	}

}
