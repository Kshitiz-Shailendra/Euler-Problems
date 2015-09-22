package com.learning.algo;

public class PythagoreanTriplesQ9 {

	public long specialTriples(){
		long triplesProduct = 0;
		int i=0,j=0,k=0;
		
		outer:
		for(i=1;i<=1000;i++){
			j=i+1;
			k=j+1;
			
			while(k<=1000){
				while(k*k<i*i+j*j){
					k=k+1;
				}
				if(k*k==i*i+j*j && k<=1000){
					if(i+j+k==1000){
						System.out.println("i = "+i+" j = "+j+" k = "+k);
						triplesProduct = i*j*k;
						break outer;
					}
				}
				j=j+1;
			}
			
		}
		
		return triplesProduct;
	}
	
	public static void main(String[] args) {
		PythagoreanTriplesQ9 triples = new PythagoreanTriplesQ9();
		System.out.println(triples.specialTriples());

	}

}
