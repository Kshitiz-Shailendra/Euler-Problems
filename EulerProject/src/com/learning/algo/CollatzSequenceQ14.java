/**
 *concepts 
 *1.long arithmetic ops are faster than int 
 *2.faster way for finding even nos = (n&1==0) bitwise operations
 *
 */
package com.learning.algo;

public class CollatzSequenceQ14 {
	
	public long collatzSeq(long num){
		
		long count = 1; 
		while(num!=1){
						
			num = ((num & 1) == 0 ? num/2 : (3*num+1));
			
			count++;
		}
		return count;
	}
	
	public static void main(String args[]){
		
		long start = System.currentTimeMillis();
		CollatzSequenceQ14 seq = new CollatzSequenceQ14();
		long [] arr = {0,0};//{num,count}
		for(int i=1;(i<1000000) ; i++){
			
			if((i&1) != 0){
				long count = seq.collatzSeq(i);
				
				if(arr[1]<count){
					arr[1]=count;
					arr[0]=i;
				}
			}
			
		}
		
		
		System.out.println(arr[0]);
		long stop = System.currentTimeMillis();
		System.out.println("time --> "+(stop - start));
		
		
		
	}
}


