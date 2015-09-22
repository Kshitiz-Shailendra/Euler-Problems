package com.learning.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q32PandigitalProduct {
	//first approach ... awfully slow
	/*public int panProduct(){
		int sum =0,product=0;
		boolean [] numArray = new boolean[10];
		for(int i=39;i<41;i++){
			
			for(int j=186;j<188;j++){
				Arrays.fill(numArray, false);
				product = i*j;
				
				
				while(i>0){
					numArray[i%10] = true;
					i=i/10;
				}
				while(j>0){
					numArray[j%10] = true;
					j=j/10;
				}
				while(product>0){
					numArray[product%10] = true;
					product=product/10;
				}
				boolean flag = false;
				for(int arr=1;arr<numArray.length;arr++){
					if(numArray[arr]!=true){
						flag = true;
					}
				}
				
				if(!flag)
				{sum = sum +i+j+product;
					System.out.println(sum);
				}	
					
			}	
		}
		
		return sum;
	}*/
	public int panProductSum(){
		int sum = 0,prod=0;
		Set<Integer> prodSet = new HashSet<Integer>();
		for(int i=1;i<100;i++){
			for(int j = 1;j<2000;j++){
				prod=i*j;
				long panNum = concatNum(concatNum(i,j),prod);
				if(panNum >= 1E8 && panNum <1E9 &&  isPandigital(panNum)){
					//System.out.println(panNum);
					//System.out.println("i= "+i+" j= "+j+" prod = "+prod);
					prodSet.add(prod);
				}
					
			}
		}
		for(Integer num : prodSet){
			sum = sum+num;
		}
		return sum;
	}
	//this is a gem of a code !!!!!
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
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Q32PandigitalProduct pan = new Q32PandigitalProduct();
		System.out.println(pan.panProductSum());
		//System.out.println(pan.isPandigital(281574396));

		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));

	}

}
