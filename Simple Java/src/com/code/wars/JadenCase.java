package com.code.wars;

public class JadenCase {

	public static void main(String[] args) {
	String phrase = args[0];
		toJadenCase(phrase);
	}
	public static String toJadenCase(String phrase) {
	
 if (phrase == null) System.out.println("Must return null when the arg is null");
 else if (phrase == "") System.out.println("Must return null when the arg is empty string");
 else {
	      char[] chars = phrase.toCharArray();
	      chars[0] = Character.toUpperCase(chars[0]);
	 
	      for(int x=1; x<chars.length; x++) {
	         if(chars[x-1] == ' '){
	            chars[x] = Character.toUpperCase(chars[x]);
	         } 
	      }
	 
	      String ans = new String(chars);
	 
	      System.out.println(ans);
	   }
return null;
	}
}


//Jaden Smith, the son of Will Smith, is the star of films such as The Karate Kid (2010) and After Earth (2013). 
//Jaden is also known for some of his philosophy that he delivers via Twitter. When writing on Twitter, 
//he is known for almost always capitalizing every word.


//Your task is to convert strings to how they would be written by Jaden Smith. 
//The strings are actual quotes from Jaden Smith, but they are not capitalized in the same way he originally typed them.