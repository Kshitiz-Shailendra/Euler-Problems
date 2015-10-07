package com.learning.algo;
/**
 * Dynamic Programming does it !!
 * @author Kshitiz
 *
 */
public class Q31CoinSums {
	
	public int coinCount(int coinVal[],int val){
		
		int length = coinVal.length,x=0,y=0;
		int [][]table = new int[val+1][length];
		
		for(int i=0;i<length ; i++){
			table[0][i]=1;
		}
		
		for(int i=1;i<val+1;i++){
			for(int j=0;j<length;j++){
				x = (i-coinVal[j]>=0)?table[i-coinVal[j]][j]:0;
				y = (j>=1)?table[i][j-1]:0;
				table [i][j] = x+y;
			}
		}
		
		return table[val][length-1];
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int []coinVal = {1, 2, 5, 10, 20, 50,100,200};
		Q31CoinSums coins = new Q31CoinSums();
		System.out.println(coins.coinCount(coinVal, 200));

		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));
		

	}

}
