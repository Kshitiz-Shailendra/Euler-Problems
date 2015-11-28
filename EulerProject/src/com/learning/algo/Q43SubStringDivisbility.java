package com.learning.algo;

import java.util.HashSet;
import java.util.Set;
//copied mathsblog.dk
public class Q43SubStringDivisbility {
	
	//extremely slow 
	 /*public Set<String> permutationFinder(String str) {
	        Set<String> perm = new HashSet<String>();
	        //Handling error scenarios
	        if (str == null) {
	            return null;
	        } else if (str.length() == 0) {
	            perm.add("");
	            return perm;
	        }
	        char initial = str.charAt(0); // first character
	        String rem = str.substring(1); // Full string without first character
	        Set<String> words = permutationFinder(rem);
	        for (String strNew : words) {
	            for (int i = 0;i<=strNew.length();i++){
	                perm.add(charInsert(strNew, initial, i));
	            }
	        }
	        return perm;
	    }
	 
	    public String charInsert(String str, char c, int j) {
	        String begin = str.substring(0, j);
	        String end = str.substring(j);
	        return begin + c + end;
	    }
	    
	    
	    public long subStringDivisbilitySum(){
		long sum=0;
		
		for(long num = 1023456789;num<9876543210L;num++){
			if(isPandigital(num)&&isSpecialDivisible(num)){
				sum = sum + num;
				System.out.println(num);
			}
				
		}
		Set<String> permSet = permutationFinder("0123456789");
		
		for(String num:permSet){
			if(isPandigital(num)&&isSpecialDivisible(num)){
				sum = sum +Long.valueOf(num);
			}
		}
		
		return sum;
		
	}
	
	private boolean isSpecialDivisible(String numStr){
		long []primes = {2,3,5,7,11,13,17};
		//String numStr = Long.valueOf(num).toString();
		for(int i=1;i<8;i++){
			if(Long.valueOf(numStr.substring(i, i+3))%primes[i-1]!=0)
					return false;
		}
		
		return true;
	}
	
	private boolean isPandigital(String num){
		int min = 1023456789;
		int expected = 1023;
		long n = Long.valueOf(num);
		if (n >= min)
	    {
	        int digits = 0;

	        for (; n > 0; n /= 10)
	        {
	            digits |= 1 << (n - ((n / 10) * 10));
	        }

	        return digits == expected;
	    }
	    return false;
		
		
	}*/
	int [] perm = {1,0,2,3,4,5,6,7,8,9};
	public long divisibilitySum(){
		long sum = 0;
		int [] divisors = {1,2,3,5,7,11,13,17};
		int count = 1,numPerm = 3265920;
		while (count < numPerm) {
		    int N = perm.length;
		    int i = N - 1;
		    while (perm[i - 1] >= perm[i]) {
		       i = i - 1;
		    }
		 
		    int j = N;
		    while (perm[j - 1] <= perm[i - 1]) {
		        j = j - 1;
		    }
		 
		    // swap values at position i-1 and j-1
		    swap(i - 1, j - 1);
		 
		    i++;
		    j = N;
		    while (i < j) {
		        swap(i - 1, j - 1);
		        i++;
		        j--;
		    }
		    boolean divisible = true;
		    for (int k = 1; k < divisors.length; k++) {
		        int num = 100 * perm[k] + 10 * perm[k + 1] + perm[k + 2];
		        if (num % divisors[k] != 0) {
		            divisible = false;
		            break;
		        }
		    }
		    if (divisible) {
		        long num = 0;
		        for(int k = 0; k < perm.length; k++){
		            num = 10*num + perm[k];
		        }
		        sum += num;
		    }
		    count++;
		}
		
		return sum;
	}
	
	private void swap(int i, int j) {
		int temp = perm[i];
		perm[i]=perm[j];
		perm[j]=temp;
		
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		Q43SubStringDivisbility str =new Q43SubStringDivisbility();
		
		System.out.println(str.divisibilitySum());

		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));
		
		//System.out.println(str.subStringDivisbilitySum());
		
		

	}

}
