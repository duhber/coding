package leetcode;

public class MaximumSubarray {
	
	/*
	 *  Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

click to show more practice.
More practice:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

	 * 
	 */
	
	public static void main(String [] args){
		
		int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
		
		int sum[] = new int[nums.length];
		sum[0]=nums[0];
		
		int maxSum = sum[0];
		for(int i=1;i<nums.length;i++){
			
			if(sum[i-1]+nums[i] < nums[i]){
				sum[i]=nums[i];
			}
			else{
				sum[i]=sum[i-1]+nums[i];
			}
			
			maxSum = Math.max(sum[i], maxSum);
		}
		
		System.out.println(maxSum);
	}

}
