package com.learning.algo;
/**
 * getting upper bound : 355000  is the real deal.....
 * @author Kshitiz
 *
 */
public class Q30FifthPowers {
	
	
	public int powerSum(){
		int sum = 0;
		for(int i=2;i<355000 ;i++){
			if(isFifth(i))
				sum=sum+i;
		}
		
		return sum;
	}
	
	private boolean isFifth(int num){
		
		int chkNum = num,summedNum=0,mod=0; 
		
		while(chkNum>0){
			mod= chkNum%10;
			summedNum = summedNum+(int)Math.pow(mod, 5);
			chkNum = chkNum/10;
		}
		
		if(summedNum == num)
			return true;
			
		return false;
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		Q30FifthPowers powers = new Q30FifthPowers();
		System.out.println(powers.powerSum());

		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));

	}

}
