package com.learning.algo;

import java.util.ArrayList;
import java.util.List;

public class Q26ReciprocCycles {
	 
	private class OptionValue{
		int cycleLength;
		int num;
		public int getCycleLength() {
			return cycleLength;
		}
		public void setCycleLength(int cycleLength) {
			this.cycleLength = cycleLength;
		}
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		
		@Override
		public String toString() {
			return "OptionValue [cycleLength=" + cycleLength + ", num=" + num
					+ "]";
		}
		
		
	}
	
	public OptionValue maxCyclelength(int limit){ 
		OptionValue cycleLength, maxlength = new OptionValue();
		
		for(int i=2;i<=limit;i++){
			
			cycleLength = findCycleValue(i);
			maxlength = maxlength.getCycleLength()>cycleLength.getCycleLength()?maxlength:cycleLength;
			
		}
		return maxlength;
	}
	
	private  OptionValue findCycleValue(int denom){
		long num=1;
		
		int rem = 1;
		OptionValue cycleLength = new OptionValue();
		List<Integer> remList = new ArrayList<Integer>();
		do{
			num = num*10;
			if(num<denom){
				remList.add(0);
				continue;
			}
				
			else{
				rem = (int) (num % denom);
				num = rem;
				if(rem!=0&&remList.contains(rem)){
					
					int indx = remList.lastIndexOf(rem);
					cycleLength.setCycleLength(remList.size() - indx);
					cycleLength.setNum(denom);
					break;
				}else{
					remList.add(rem);
				}
			}
			
		}while(rem !=0);
		
		System.out.println("denom "+denom+" cycleLength "+cycleLength);
		return cycleLength;
	}
	
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		Q26ReciprocCycles cycles = new Q26ReciprocCycles();
		//System.out.println(cycles.findCycleValue(1000));
		System.out.println(cycles.maxCyclelength(10000).getNum());

		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));
		
		
	}

}
