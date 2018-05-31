package leetcode;

public class FindPeakElement {
	
	/*
	 * A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
Note:

Your solution should be in logarithmic complexity.

	 * 
	 * 
	 * 
	 */

	public static void main(String[] args){
		
		int [] nums = {-2147483648};
		
		int result = 0;
		int low = 0;
		int high = nums.length-1;
		int mid;
		System.out.println(Integer.MIN_VALUE);
		while(low<=high){
			mid = (low+high)/2;
			
			if((mid-1>=0?nums[mid-1]:Integer.MIN_VALUE)<nums[mid] && (mid+1<nums.length? nums[mid+1]:Integer.MIN_VALUE)<nums[mid] ){
				result = mid;
				break;
			}
			else if(nums[mid]<nums[mid+1]){
				low=mid+1;
			}else {
				high=mid-1;
			}
			
		}
		
		System.out.println(result);
	}
}
