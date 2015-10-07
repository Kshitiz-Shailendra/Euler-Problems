package com.learning.algo;


//Good analysis at MathBlog.dk by Kristian for this question 
public class Q38PandigitalMultiples {
	
	private boolean isPandigital(long num){
		int digits = 0, count = 0, tmp=0;

		  while (num > 0) {
		        tmp = digits;
		        digits = digits | 1 << (int)((num % 10) - 1);
		        if (tmp == digits) {
		            return false;
		        }
		 
		        count++;
		        num /= 10;
		    }

        return digits == (1 << count) - 1;
		
		
	}
	private long concatNum(long a,long b){
		long c = b;
		while(c>0){
			a = a*10;
			c = c/10; 
		}
		
		return a+b;
	}
	
	public long largestPanDigitalMultiple(){
		long max = 0,concat=0;
		
		for(int i=9182;i<9876;i++){
			concat = concatNum(i, 2*i);
			if(isPandigital(concat)){
				System.out.println(concat);
				max = max>concat?max:concat;
			}
		}
		
		return max;
	}
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Q38PandigitalMultiples multiples = new Q38PandigitalMultiples();
		System.out.println(multiples.largestPanDigitalMultiple());
		

		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));
	}

}
