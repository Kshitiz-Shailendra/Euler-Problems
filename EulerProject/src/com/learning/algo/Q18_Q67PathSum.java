package com.learning.algo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q18_Q67PathSum {
	
	@SuppressWarnings("resource")
	public int[][] getArray(int num) {
		
		int arr[][] = new int[num][num];
		
		try{
			
			BufferedReader br = new BufferedReader(new FileReader("C:/Users/Kshitiz/Desktop/programs/triangle2.txt"));
			
			for(int i = 0 ; i<num ; i++){
				String [] str = br.readLine().trim().split(" ");
				for(int j = 0 ; j<str.length;j++){
					arr[i][j] = Integer.parseInt(str[j]); 
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
		return arr;
	}
	public int pathSum(int num){
		
		int [][] arr = getArray(num);
		int length = arr[0].length;
		for(int i=length-2;i>=0;i--){
			for(int j=0;j<=i;j++){
				arr[i][j] = arr[i][j]+((arr[i+1][j]>arr[i+1][j+1])?arr[i+1][j]:arr[i+1][j+1]);
			}
				
		}
		
		return arr[0][0];
	}
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();

		Q18_Q67PathSum sum = new Q18_Q67PathSum();
		System.out.println(sum.pathSum(100));

		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));
	}

}
