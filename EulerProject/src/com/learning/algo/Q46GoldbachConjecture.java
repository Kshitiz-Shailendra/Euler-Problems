package com.learning.algo;

public class Q46GoldbachConjecture {
	
	boolean []prime;
	public Q46GoldbachConjecture() {
		prime = new boolean[1000000];
		int sqrt=(int)Math.sqrt(1000000);
		for(int i=2;i<=sqrt;i++){
			if(!prime[i]){
				for(int j=i*i;j<prime.length;j=j+i){
					prime[j]=true;
				}
			}
		}
	}
	
	private boolean isPrimeSieve(long num){
		return !prime[(int)num];
	}
	
	/*private boolean isPrimeBrute(long num){
		
		if(num<2)
			return false;
		if(num<=3)
			return true;
		if(num%2==0||num%3==0)
			return false;
		
		for(int i=5;i*i<=num;i=i+6)
			if(num%i==0||num%(i+2)==0)
				return false;
		
		return true;	
		
	}
	*/
	public long minGoldbachFalseNumber(){
		int diff=0;
		boolean flag = false;
		for(int x=33;;x=x+2){
			//System.out.println();
			//System.out.print(x+"  ");
			flag = false;
			//if(x<2000000){
				if(isPrimeSieve(x))
					continue;
			/*}else
				if(isPrimeBrute(x))
					continue;*/
			for(int y=1;(y*y<<1)<(x-2);y++){
				
				diff=x-2*y*y;
				//System.out.print("  diff "+diff);
				//if(diff<2000000){
					if(isPrimeSieve(diff)){
						flag = true;
						break;
					}
						
				/*}else{
					if(!isPrimeBrute(diff)){
						flag = true;
						break;
					}
				}*/
			}
			//System.out.print(flag);
			if(!flag)
				return x;
		}
		
		
	}
	
	public static void main(String[] args) {
	long start = System.currentTimeMillis();

	Q46GoldbachConjecture gold = new Q46GoldbachConjecture();
	System.out.println(gold.minGoldbachFalseNumber());

	long stop = System.currentTimeMillis();
	System.out.println("time " + (stop - start));	
	

	}

}
