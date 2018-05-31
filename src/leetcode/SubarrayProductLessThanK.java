package leetcode;

public class SubarrayProductLessThanK {
	
	/*
	 * Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

Example 1:

Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

Note:
0 < nums.length <= 50000.
0 < nums[i] < 1000.
0 <= k < 10^6.
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nums[] = {10, 5, 2, 6};
		int k = 3;
		
		int i=0;
		int j=0;
		
		int product = 1;
		int result = 0;
		
		while(j<nums.length){
			
			if(product*nums[j]<k){
				result +=j-i+1;
				product *=nums[j];
				j++;
			}else{
				if(i==j){
					product=1;
					j++;
				}
				else if(i<j)
					product = product/nums[i];
				i++;
			}
		}
		
		System.out.println(result);
 	}

}
