package com.learning.algo;
/**
 * Although a poor solution
 * @author Kshitiz
 *
 */
public class Q28SpiralDiag {

	private int[][] createMatrix(int limit){
		int [][] spiralMat = new int[limit][limit];
		int count = limit*limit,i=0,j=limit-1,k=0;
		int row = 0,col = limit;
		while(count>0){
			for(j=col-1;j>=row;j--){
				spiralMat[row][j]=count;
				count--;
			}
			
			for(i=row+1 ; i<col;i++){
				spiralMat[i][row]=count;
				count--;
			}
			
			for(j=row+1;j<col;j++){
				spiralMat[col-1][j]=count;
				count--;
			}
			
			for(i=col-2;i>=row+1;i--){
				spiralMat[i][col-1]=count;
				count--;
			}
			
			row++;
			col--;
		}
		
		
		
		return spiralMat;
	}
	
	public long diagSum(int limit){
		long sum=-1;
		
		int [][] spiralMat = createMatrix(limit);
		
		for(int i=0;i<spiralMat.length;i++){
			sum = sum + spiralMat[i][i];
		}
		
		int k = spiralMat.length-1;
		for(int i=0;i<spiralMat.length;i++){
			if(k>=0){
				sum = sum+spiralMat[i][k];
				k--;
			}
		}
		
		
		return sum;
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Q28SpiralDiag diag = new Q28SpiralDiag();
		/*int limit = 5;
		int [][] diagMat = diag.createMatrix(limit);
		for(int i=0;i<limit;i++){
			for(int j=0;j<limit;j++){
				System.out.print(diagMat[i][j]+"\t");
			}
			System.out.println();
		}*/
		System.out.println(diag.diagSum(1001));
		//Your code goes here

		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));

	}

}
