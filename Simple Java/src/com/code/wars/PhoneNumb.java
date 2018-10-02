package com.code.wars;
//Write a function that accepts an array of 10 integers (between 0 and 9), that returns a string of those numbers in 
//the form of a phone number.
public class PhoneNumb {
	public static void main(String[] args) {
		int numbers[] = {1,2,3,4,5,6,7,8,9,0};
		createPhoneNumber(numbers);
	}//I copy pasted phone.append, it took practically no time to write, but does not look very elegant
	public static String createPhoneNumber(int[] numbers) {
     	StringBuilder phone = new StringBuilder("(");
     	phone.append(numbers[0]);
		phone.append(numbers[1]);
		phone.append(numbers[2]);
		phone.append(") ");
		phone.append(numbers[3]);
		phone.append(numbers[4]);
		phone.append(numbers[5]);
		phone.append("-");
		phone.append(numbers[6]);
		phone.append(numbers[7]);
		phone.append(numbers[8]);
		phone.append(numbers[9]);
		System.out.println(phone);
		return phone.toString();
    }
}