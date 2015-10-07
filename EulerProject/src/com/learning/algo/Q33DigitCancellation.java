package com.learning.algo;

public class Q33DigitCancellation {
	
	
	public int findRowsCols(){
		
		int []product  = {1,1};
		int gcd = 0;
		for(int loop = 12; loop<100;loop++){
				
			for(int j=loop+1;j<100;j++){
				gcd = gcd(j,loop);
				if(loop%10!=0 && loop%11!=0 && (loop*j) % 100!=0 && !revEqual(loop,j) && gcd>1 ){
					
					int i2 = 1,count2 =j,count1=loop;
					int []digitArr = new int[2],digitArr2 = new int[2],reducedFrac=new int[2],wrongReducedFrac = new int[2];
					while(count2>0){
						digitArr[i2] = count1%10;
						digitArr2[i2] = count2%10;
						count1 = count1/10; 
						count2 = count2/10;
						i2--;
					}
					reducedFrac[0]=loop/gcd;
					reducedFrac[1]=j/gcd;
					if(digitArr[0]!=digitArr2[0] && digitArr[0]!=digitArr2[1] && digitArr[1]!=digitArr2[0] && digitArr[1]!=digitArr2[1])
						continue;
					
					if(digitArr[0]==digitArr2[0]){
						wrongReducedFrac[0] = digitArr[1];
						wrongReducedFrac[1] = digitArr2[1];
					}else if(digitArr[0]==digitArr2[1]){
						wrongReducedFrac[0] = digitArr[1];
						wrongReducedFrac[1] = digitArr2[0];
					}else if(digitArr[1]==digitArr2[0]){
						wrongReducedFrac[0] = digitArr[0];
						wrongReducedFrac[1] = digitArr2[1];
					}else{
						wrongReducedFrac[0] = digitArr[0];
						wrongReducedFrac[1] = digitArr2[0];
					}
					
					
					int gcd2 = gcd(wrongReducedFrac[1],wrongReducedFrac[0]);
					wrongReducedFrac[0] = wrongReducedFrac[0]/gcd2;
					wrongReducedFrac[1] = wrongReducedFrac[1]/gcd2;	
					
					
					if(reducedFrac[0]==wrongReducedFrac[0]&&reducedFrac[1]==wrongReducedFrac[1]){
						product[0] = product[0]*reducedFrac[0];
						product[1] = product[1]*reducedFrac[1];
						System.out.println("loop= "+loop+" j= "+j);
					}
						
					//System.out.println("loop= "+loop+" j= "+j);
				}
			}
			
			
			
			
			
		}
		return product[1]/product[0];
	}
	
	
	private boolean revEqual(int loop, int j) {
		int c=0;
		while(j>0){
			c =c*10+ j%10;
			j=j/10;
		}
		return loop==c;
	}


	private int gcd(int a, int b) {
		int gcd=0;
		while(b>0){
			gcd = a%b;
			a=b;
			b=gcd;
		}
		
		return a;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Q33DigitCancellation digit = new Q33DigitCancellation();
		
		
		System.out.println(digit.findRowsCols());
		

		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));

	}

}
