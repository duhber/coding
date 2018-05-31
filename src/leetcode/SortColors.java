package leetcode;

public class SortColors {
	
	/*
	 * 
	 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent,
	 *  with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
	 */
	
	public static void main(String[] args){
		int [] nums = {2,0,2,1,1,0};
		
		int zeros = 0;
		int twos = nums.length-1;
		
		while(zeros<twos){
			
			while(zeros<nums.length && nums[zeros]==0)
				zeros++;
			while(twos>=0 && nums[twos]==2){
				twos--;
			}
			
			if(zeros>=twos){
				break;
			}
			
			
			
		}
		
	}

}
