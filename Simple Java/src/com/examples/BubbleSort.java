package com.examples;

import java.util.Arrays;

public class BubbleSort {
public static void main(String[] args) {
	int x =0;
	int arr[] = {1,0,5,6,3,2,3,7,9,8,4}; 
	System.out.println(Arrays.toString(arr));
	for (int i: arr) {
	for (int j = 1; j < 11; j++) {
if (arr[j-1] > arr[j]) {
	x = arr[j-1];
arr[j-1] = arr[j];
arr[j] = x;

}	
	}

}
	System.out.println(Arrays.toString(arr));
}
}