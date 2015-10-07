package com.learning.algo;

public class Q39RightTriangles {
	
	public int[] rightTrianglesSum(int limit){
		int []triaglsarr = new int[limit+1];
		int i,j,k;i=j=k=0;
		for(i=1;i<=limit;i++){
			j=i+1;
			k=j+1;
			while(k<=limit){
				while(k*k<i*i+j*j){
					k=k+1;
				}
				if((i+j+k)<=limit && k*k==i*i+j*j && k<=limit){
					triaglsarr[i+j+k]++;
				}
				
				j=j+1;
			}
		}
		
		return triaglsarr;
	}
	public int maxRightTriangles(int limit){
		int []max ={0,0};//index,value
		int []arr = rightTrianglesSum(limit);
		
		for(int i=1;i<1001;i++){
			if(max[1]<arr[i]){
				max[0]=i;
				max[1]=arr[i];
			}
			//System.out.println("index "+i+" has "+arr[i]+" combinations");
		}
		return max[0];
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Q39RightTriangles rights = new Q39RightTriangles();
		System.out.println(rights.maxRightTriangles(1000));
		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));
	}

}
