package com.examples;

public class Pascal {

	public static void main(String[] args) {
		
		String n = args[0];
		int nthRow = Integer.parseInt(n);
		
    	for(int i =0;i<nthRow;i++) {
       		int number = 1;
       		for(int j=0;j<=i;j++) {
         		System.out.print(number + " ");
         		number = number * (i - j) / (j + 1);
        	}
        System.out.println();
    	}	

	}
}
