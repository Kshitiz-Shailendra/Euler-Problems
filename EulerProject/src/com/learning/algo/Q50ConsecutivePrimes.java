package com.learning.algo;

public class Q50ConsecutivePrimes {
	
	boolean []prime;
	public Q50ConsecutivePrimes(int limit) {
		prime = new boolean[limit];
		int sqrt=(int)Math.sqrt(limit);
		for(int i=2;i<=sqrt;i++){
			if(!prime[i]){
				for(int j=i*i;j<prime.length;j=j+i){
					prime[j]=true;
				}
			}
		}
	}
	private boolean isPrime(long num){
		if((int)num>prime.length)
			return false;
		
		return !prime[(int)num];
	}
	//heap space problem for larger numbers
	/*public long findConsecutivePrimeSum(int limit){
		int count=0,index=0;
		int []max={0,0};
		for(int i=2;i<limit;i++){
			if(!prime[i]){
				count++;
			}
		}
		int[][][] arr = new int[count+1][count+1][3];
		for(int i=2;i<prime.length;i++){
			if(!prime[i])
				arr[0][index++][0]=i;
		}
		arr[1][0][0]=2;
		System.out.println("");
		//arr[][][0] contains sum
		//arr[][][1] contains isPrime 1-true , 0-false
		//arr[][][2] contains number of Primes in between
		for(int i=1;i<arr.length;i++){
			for(int j=i;j<arr.length;j++){
				if(i==1){
					arr[i][j][0]=arr[i][j-1][0]+arr[0][j][0];
					if(arr[i][j][0]<limit && isPrime(arr[i][j][0])){
						arr[i][j][1]=1;
						arr[i][j][2]=j+1;
					}
				}else{
					arr[i][j][0]=arr[1][j][0]-arr[1][i-1][0];
					if(arr[i][j][0]<limit && isPrime(arr[i][j][0])){
						arr[i][j][1]=1;
						arr[i][j][2]=j-i+1;
					}
				}
			}
		}
		for(int i=1;i<arr.length;i++){
			for(int j=i;j<arr.length;j++){
				if(arr[i][j][1]==1 && max[1]<arr[i][j][2] ){
					max[0]=arr[i][j][0];
					max[1]=arr[i][j][2];
				}
			}
		}
		
		return max[0];
	}*/
	public long findConsecutivePrimeSum(int limit){
		int count=0,index=0,numOfPrimes=0,max=0;
		
		for(int i=2;i<limit;i++){
			if(!prime[i]){
				count++;
			}
		}
		int[][] arr = new int[2][count+1];
		for(int i=2;i<prime.length&&index<=count;i++){
			if(!prime[i])
				arr[0][index++]=i;
		}
		arr[1][0]=2;
		for(int i=1;i<arr[0].length;i++){
			arr[1][i]=arr[1][i-1]+arr[0][i];
		}
		for(int i=numOfPrimes;i<arr[0].length;i++){
			for(int j=i-(numOfPrimes+1);j>=0;j--){
				if(arr[1][i]-arr[1][j]>limit)
					break;
				
				if(isPrime(arr[1][i]-arr[1][j])){
					numOfPrimes = i-j;
					max =  arr[1][i]-arr[1][j];
				}
			}
		}
		
		return max;
	}
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Q50ConsecutivePrimes primes = new Q50ConsecutivePrimes(1000000);
		System.out.println(primes.findConsecutivePrimeSum(1000000));
		

		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));

	}

}
