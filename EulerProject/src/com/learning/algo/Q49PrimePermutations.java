package com.learning.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

public class Q49PrimePermutations {
	boolean [] prime;int countPrime;
	Set<Integer> numPermuted;
	public Q49PrimePermutations() {
		numPermuted = new HashSet<Integer>();
		prime = new boolean[10000];
		int sqrt=(int)Math.sqrt(10000);
		for(int i=2;i<=sqrt;i++){
			countPrime++;
			if(!prime[i]){
				for(int j=i*i;j<prime.length;j=j+i){
					prime[j]=true;
				}
			}
		}
	}
	
	private boolean isPrime(int num){
		if(num<0)
			return false;
		return !prime[num];		
	}
	private long concat(long a,long b){
		long temp = b;
		while(temp>0){
			a=a*10;
			temp = temp/10;
		}
		
		return a+b;
	}
	public List<Integer> permute(String str){
		List<Integer> permutations = new ArrayList<Integer>();
		permute("",str,permutations);
		return permutations;
	}
	public void permute(String prefix, String str,List<Integer> permutations) {
	    if (str.length() == 0){
	    	int num = Integer.valueOf(prefix);
	    	numPermuted.add(num);
	    	permutations.add(num);
	    }
	      
	    else
	      for (int i = 0; i < str.length(); i++) {
	        
	          String newString = str.substring(0, i) + str.substring(i + 1);
	          permute(prefix + str.charAt(i), newString,permutations);
	        
	        
	      }
	  }
	public long findPermSequence(){
		
		long result = 0;
		//int first =0,second=0,temp=0;
		outer:
		for(int i=9999;i>1490;i=i-2){
			if(isPrime(i)/* && !numPermuted.contains(i)*/){
				List<Integer> perms = permute(Integer.toString(i));
				perms.sort(null);
				for(int j=0;j<perms.size();j++){
					for(int k=j+1;k<perms.size();k++){
						int first = perms.get(j),second = perms.get(k); 
						/*if(first>second){
							int temp = first;
							second = first;
							first = temp;
									
						}*/
						if(first != second && isPrime(first) && isPrime(second)){
							int third = second + (second-first);
							if(third<10000 &&  isPrime(third) && perms.contains(third)){
								result = concat(concat(first,second),third);
								break outer;
							}
						}
						
						
					}
				}
					
				
			}
		}
		return result;
	}
	public Set<Integer> getHashSet(){
		return numPermuted;
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Q49PrimePermutations perms = new Q49PrimePermutations();
		System.out.println(perms.findPermSequence());
		//List<Integer> nums = perms.permute("1489");
		//Set<Integer> nums = perms.getHashSet();
		/*for(Integer num : nums){
			System.out.println(num);
		}*/

		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));

	}

}
