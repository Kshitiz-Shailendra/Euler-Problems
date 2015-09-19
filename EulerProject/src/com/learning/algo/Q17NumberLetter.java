package com.learning.algo;

public class Q17NumberLetter {
	
	private String createNumberLetter(int num){
		
		StringBuilder numberLetter = new StringBuilder();
		StringBuilder specialNumberLetter = new StringBuilder();
		int count = 1;
		int originalNum = num;
		
		
		if(num==1000){
			
			return numberLetter.append("onethousand").toString();
		}
		
		while(num>0){
			int mod10 = num%10;
		
			switch(count){
				case 1: switch(mod10){
				
					case 1 : numberLetter.append("one");
						break;
					case 2 : numberLetter.append("two");
						break;
					case 3 : numberLetter.append("three");
						break;
					case 4 : numberLetter.append("four");
						break;
					case 5 : numberLetter.append("five");
						break;
					case 6 : numberLetter.append("six");
						break;
					case 7 : numberLetter.append("seven");
						break;
					case 8 : numberLetter.append("eight");
						break;
					case 9 : numberLetter.append("nine");
						break;
					
				
				}
					break;
				case 2:switch(mod10){
					case 1:
						int mod100 = originalNum%100;	
						//System.out.println(mod100);
						switch(mod100){
							case 10 : numberLetter = specialNumberLetter.append("ten");
								break;
							case 11 : numberLetter = specialNumberLetter.append("eleven");
								break;
							case 12 : numberLetter = specialNumberLetter.append("twelve");
								break;
							case 13 : numberLetter = specialNumberLetter.append("thirteen");
								break;
							case 14 : numberLetter = specialNumberLetter.append("fourteen");
								break;
							case 15 : numberLetter = specialNumberLetter.append("fifteen");
								break;
							case 16 : numberLetter = specialNumberLetter.append("sixteen");
								break;
							case 17 : numberLetter = specialNumberLetter.append("seventeen");
								break;
							case 18 : numberLetter = specialNumberLetter.append("eighteen");
								break;
							case 19 : numberLetter = specialNumberLetter.append("nineteen");
								break;
					
						}
						
						
						break;
					case 2 : numberLetter.insert(0,"twenty");
						break;
					case 3 : numberLetter.insert(0,"thirty");
						break;
					case 4 : numberLetter.insert(0,"forty");
						break;
					case 5 : numberLetter.insert(0,"fifty");
						break;
					case 6 : numberLetter.insert(0,"sixty");
						break;
					case 7 : numberLetter.insert(0,"seventy");
						break;
					case 8 : numberLetter.insert(0,"eighty");
						break;
					case 9 : numberLetter.insert(0,"ninety");
						break;
				
			
				}
				break;
					case 3:
						if(originalNum%100!=0){
							numberLetter.insert(0,"and");
						}
					switch(mod10){
				
					case 1 : numberLetter.insert(0,"onehundred");
						break;
					case 2 : numberLetter.insert(0,"twohundred");
						break;
					case 3 : numberLetter.insert(0,"threehundred");
						break;
					case 4 : numberLetter.insert(0,"fourhundred");
						break;
					case 5 : numberLetter.insert(0,"fivehundred");
						break;
					case 6 : numberLetter.insert(0,"sixhundred");
						break;
					case 7 : numberLetter.insert(0,"sevenhundred");
						break;
					case 8 : numberLetter.insert(0,"eighthundred");
						break;
					case 9 : numberLetter.insert(0,"ninehundred");
						break;
				}
		
			}
			num = num / 10;
			count++;
			
		}
		System.out.println(numberLetter);
		return numberLetter.toString();
		
	}
	
	public long countLetter(int boundary){
		
		long count = 0;
		
		for(int i = 1;i<=boundary;i++){
			count = count + createNumberLetter(i).length();
		}
		
		return count;
	}
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();

		Q17NumberLetter letter = new Q17NumberLetter();
		//System.out.println(letter.createNumberLetter(101));
		System.out.println(letter.countLetter(1000));
		long stop = System.currentTimeMillis();
		System.out.println("time " + (stop - start));

	}

}
