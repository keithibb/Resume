package com.InterviewQuestions;

import java.util.Scanner;

public class OnlyLetters {

	public static void main(String[] args) {
		String str = args[0];
//		Method that I thought of during interview
		char[] chars = str.toCharArray();
		StringBuilder onlyAlpha= new StringBuilder();
	      for(int x=0; x<chars.length; x++) {
			if((chars[x] >= 'a' && chars[x] <= 'z') || (chars[x] >= 'A' && chars[x] <= 'Z')) {
				onlyAlpha.append(chars[x]);
		    }
		}
	      System.out.println(onlyAlpha);
//		More eloquent way I thought of after the interview
//		str = str.replaceAll("[^A-Za-z]", "");
//		System.out.println(str);
	}
}