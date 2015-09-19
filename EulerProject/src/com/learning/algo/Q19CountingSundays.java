package com.learning.algo;

public class Q19CountingSundays {
	
	private int getDays(int month,int year){
		switch(month){
		case 4:case 6:case 9: case 11:
			return 30;
		case 2: return isLeapYear(year)?29:28;
		
		}
		
		return 31;
	}
	
	
	private boolean isLeapYear(int year) {
		
		if(year%400==0){
			return true;
		}else if(year%100==0){
			return false;
		}else if(year%4==0){
			return true;
		}
		
		return false;
	}

	public int getSundays(){
		int sundays = 0;
		
		int startYear = 1901;
		int endYear = 2000;
		int firstDay = 3;
		for(int i= startYear ; i<= endYear;i++){
			
			int days = getDays(1, i);
			int dif = days%7;
			firstDay = (dif+firstDay)%7;
			if(firstDay == 1){
				sundays++;
			}
			for(int m=2;m<=12;m++){
				firstDay = (dif+firstDay)%7;
				if(firstDay == 1){
					sundays++;
				}
				days = getDays(1, i);
				dif = days%7;
			}
		}
		
		
		return sundays;
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		Q19CountingSundays sunday = new Q19CountingSundays();
		System.out.println(sunday.getSundays());
		
		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));

	}

}
