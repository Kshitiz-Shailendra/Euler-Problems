package com.learning.algo;

public class Q33DigitCancellation {
	
	
	public void findRowsCols(int num){
		int [][]mat = getMatrix(),row = new int[2][10],col=new int[2][9];;
		int []digitArr = new int[2];
		int i=1;
		while(num>0){
			digitArr[i] = num%10;
			row[i] = mat[digitArr[i]-1];
			i--;
			num = num/10;
		}
		for(int j=0;j<2;j++){
			for(int k=0;k<9;k++){
				col[j][k] = mat[k][digitArr[j]];
			}
		}
	}
	
	
	public int[][] getMatrix(){
		int [][]mat = new int[9][10];
		int count = 10;
		for(int i=0;i<9;i++){
			for(int j=0;j<10;j++){
				mat[i][j] = count++;
			}
		}
		
		return mat;
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Q33DigitCancellation digit = new Q33DigitCancellation();
		
		/*int [][]mat = digit.getMatrix();
		for(int i=0;i<9;i++){
			for(int j=0;j<10;j++){
				System.out.print(mat[i][j]+"\t");
			}
			System.out.println();
		}*/
		digit.findRowsCols(23);
		

		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));

	}

}
