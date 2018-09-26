package com.InterviewQuestions;

public class AddingEvens {
	// for this example I was passing in the string "1,2,3,4,5,6,7,8,9,10"
	public static void main(String[] args) {
		String array = args[0];
		
			String intStr[] = array.split(",");		
			int nums[] = new int[intStr.length];		

		int i = 0;			
		for ( String text : intStr) {
			nums[i] = Integer.parseInt(text);
			System.out.print(nums[i]);
			System.out.print(" ");
			i++;
		}
		Addition (nums);
	}

	public static void Addition (int[] nums){
		int sum = 0;
		for (int check : nums) {
			if ((check % 2) == 0) {
				sum += check;
			}
		}
		System.out.println(sum);
	}
}
