package leetcode;

import java.util.Arrays;

public class ValidTriangleNumber {
	
	/*
	 * Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array 
	 * that can make triangles if we take them as side lengths of a triangle.

Example 1:

Input: [2,2,3,4]
Output: 3
Explanation:
Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3

Note:
	-- fuck this chicken shit
    The length of the given array won't exceed 1000.
    The integers in the given array are in the range of [0, 1000].

	 * 
	 */
	public static void main(String[] args){
		int nums[] = { 2,2,3,4};
		Arrays.sort(nums);
		
		/* 1ST SUBMISSION : 
		
		int count = 0;
		for(int i=0;i<nums.length-2;i++){
			for(int j=i+1;j<nums.length-1;j++){
				int k=nums.length-1;
				while(j<k){
					if(nums[i]+nums[j]>nums[k]){
						count+=k-j;
						break;
					}else{
						k--;
					}
				}
			}
		}
		System.out.println(count);
		
		*/
		
		/*
		 * BETTER SOLUTION
		 * 
		 */
		
		int count = 0;
		
		int right =0;
		int left = 0;
		
		for(int i=nums.length-1;i>=0;i--){
			
			left = 0;
			right = i-1;
			
			while(left<right){
				
				if(nums[left]+nums[right]>nums[i]){
					count+=right-left;
					right --;
				}else{
					left++;
					
				}
				
			}
			
		}
		
		System.out.println(count);
		
	}
}
