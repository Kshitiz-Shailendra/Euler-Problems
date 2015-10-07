package com.learning.algo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q42CodedTriangleNumbers {
	
	Set<Integer> triangleNumSet;
	
	public Q42CodedTriangleNumbers(){
		int j=0;
		triangleNumSet = new HashSet<Integer>();
		//here i chose 35 because the number score for words will rarely exceed 630 
		for(int i=1;i<35;i++){
			j=j+i;
			triangleNumSet.add(j);
		}
	}
	
	private String[] getArray(){
		String []arr = new String[2000];
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:/Users/Kshitiz/Desktop/programs/p042_words.txt"));
			String input = br.readLine();
			arr = input.replace("\"", "").split(",");
			//Arrays.sort(arr);
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
	
	public int countTriangleWords(){
		String []words = getArray();
		int count =0,score=0 ;
		
		for(int i=0;i<words.length;i++){
			score = numValue(words[i]);
			if(triangleNumSet.contains(score)){
				System.out.println(words[i]);
				count++;
			}
				
		}
		
		return count;
	}
			
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Q42CodedTriangleNumbers nums = new Q42CodedTriangleNumbers();
		
		System.out.println(nums.countTriangleWords());
		
		
		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));

	}

}
