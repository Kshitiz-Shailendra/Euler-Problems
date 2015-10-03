package com.learning.algo;

public class Q35CircularPrimes {
	
	private boolean [] sieve = new boolean[1000000];
	public Q35CircularPrimes() {
		//primeSieve till 1 million
		int sqrt=(int)Math.sqrt(1000000);
		for(int i=2;i<=sqrt;i++){
			if(!sieve[i]){
				for(int j=i*i;j<sieve.length;j=j+i){
					sieve[j]=true;
				}
			}
		}
	}
	
	public int circularPrimeCount(){
		//String num = "";
		int length =0,count=1,rotatedNum=0,temp=0;boolean flag=false;
		for(int i=3;i<1000000;i=i+2){
			temp =i;
			//num = Integer.toString(i);
			length = (int) Math.log10(i)+1;
			flag = false;
			if(/*!num.contains("0")&&*/isPrime(i)){
				if(length<2){
					//System.out.println(i);
					count++;
				}
					
				else{
					for(int j=0;j<length-1;j++){
						//rotatedNum = rotate(num);
						rotatedNum = rotateMathBased(temp);
						if(!isPrime(rotatedNum)){
							flag = true;
							break;
						}else{
							//num = Integer.toString(rotatedNum);
							temp = rotatedNum;
						}
							
					}
					
					if(!flag){
						//System.out.println(i);
						count++;
					}
						
				}
				
			}
				
		}
		
		return count;
	}
	
	private int rotate(String num){
		
			
		int value_0= num.charAt(0)-'0';
		String rotate = num.substring(1) + value_0;
				
		return Integer.parseInt(rotate);
	}
	
	private int rotateMathBased(int num){
		int digits = (int)Math.log10(num);
		return (num%10)*(int)(Math.pow(10, digits))+num/10;
	}
	
	private boolean isPrime(int num){
		return !sieve[num];
	}
		
	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		Q35CircularPrimes primes = new Q35CircularPrimes();
		//System.out.println(primes.rotate(Integer.valueOf(197).toString()));
		//System.out.println(primes.isPrime(10));
		System.out.println("count "+primes.circularPrimeCount());
		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));

	}

}
