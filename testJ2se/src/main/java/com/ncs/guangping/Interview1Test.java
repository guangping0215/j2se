package com.ncs.guangping;


public class Interview1Test {

	public static void main(String[] args) {
		String letter = "aaddbbccsDsssssssd";
		calMaxLetter(letter);
		
	}
	
	public static void calMaxLetter(String letter){
		 int[] sum = new int[52];
	        int max = 0;
	        int location = 0;
	        for (int i = 0; i < letter.length(); i++) {
	            char c = letter.charAt(i);
	            if (c >= 65 && c <= 90)//A~Z
	                sum[c - 65]++;
	            else if (c >= 97 && c <= 122)//a~z
	                sum[c - 71]++;
	            else
	                continue;
	        }
	        for (int i = 0; i < sum.length; i++)
		        if (sum[i] > max){
		        		max = sum[i];
		        		location = i;
		        }
	        
	        if(location<=26){
	        		System.out.println(Character.toChars(location+65));
	        }else{
		        System.out.println(Character.toChars(location+71));
	        }
	}
	
}