package com.examples;

public class Fibonacci {
public static void main(String[] args) {

	int x = 0;
	int y = 1;
System.out.print("0 ");	
	for (int i = 1 ; i <= 25 ; i++ ) {
		int z = x;
		x += y;
		y = z;
		System.out.print(x + " ");
	}
}
}