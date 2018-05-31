package leetcode;

public class MaximumProductSubarray {
	/*
	 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.

	 * 
	 */
	
	public static void main(String[] args){
		
		int [] nums = {1,-4,5,-2,-3};
		
		int negPrd = nums[0];
		int pozPrd = nums[0];
		int max = Integer.MIN_VALUE;
		for(int i=1;i<nums.length;i++){
			
			if(nums[i] <0){
				
				if(negPrd<0){
					pozPrd = negPrd*nums[i];
				}
				if(pozPrd>0){
					negPrd = nums[i]*pozPrd;
				}
			}
			
			else if(nums[i]>0){
				if(negPrd<0){
					negPrd = negPrd*nums[i];
				}
				if(pozPrd>0){
					pozPrd = nums[i]*pozPrd;
				}
				
			}
			
			max = Math.max(max, pozPrd);
			
			
		}
		
		System.out.println(max);
	}
	

}
