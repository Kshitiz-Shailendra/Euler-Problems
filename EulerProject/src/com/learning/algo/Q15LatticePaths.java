package com.learning.algo;

public class Q15LatticePaths {

	
	public long calcNofLAtticePaths(int gridSize){
		
		long [][] grid  = new long[gridSize+1][gridSize+1];
		
		for(int i=0;i<gridSize;i++){
			grid[gridSize][i]=1;
			grid[i][gridSize]=1;
		}
		
		for(int i=gridSize-1 ; i>=0  ;i--){
			for(int j=gridSize-1 ; j>=0 ; j--){
				grid[i][j]=grid[i+1][j] + grid[i][j+1];
			}
		}
		
		return grid[0][0];
	}
	
	
	
	public static void main(String[] args) {
		Q15LatticePaths paths = new Q15LatticePaths();
		System.out.println(paths.calcNofLAtticePaths(20));

	}

}
