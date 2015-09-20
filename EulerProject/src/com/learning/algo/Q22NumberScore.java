package com.learning.algo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;



public class Q22NumberScore {

	private String[] getArray(){
		String []arr = new String[5000];
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:/Users/Kshitiz/Desktop/programs/p022_names.txt"));
			String input = br.readLine();
			arr = input.replace("\"", "").split(",");
			Arrays.sort(arr);
			br.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return arr;
	}
	
	private int numValue(String name){
		
		int numSum = 0;
		for(int i=0;i<name.length();i++){
			numSum = numSum + ((int)name.charAt(i)-'A'+1);
		}
				
		return numSum;
	}
	public long numberScore(){
		
		long numScore = 0;
		String []arr = getArray();
		for(int i=0;i<arr.length;i++){
			numScore =numScore + (i+1)*numValue(arr[i].trim());
		}
		return numScore;
	}
	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		Q22NumberScore score = new Q22NumberScore();
		System.out.println(score.numberScore());

		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));

	}


	

}
