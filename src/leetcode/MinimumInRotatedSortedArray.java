package leetcode;

public class MinimumInRotatedSortedArray {
	
	/*
	 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * Find the minimum element.
	 * You may assume no duplicate exists in the array.
	 * 
	 * SOLUTION : 
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] nums = {1,4, 5, 6, 7, 8, 10,12};
		
		int low = 0;
		int high= nums.length-1;
		int mid;
		int result=nums[0];
		while(low<=high){
			mid = (low+high)/2;
			
			if((mid-1>=0?nums[mid-1]:Integer.MAX_VALUE)>nums[mid] && (mid+1<nums.length? nums[mid+1]:Integer.MAX_VALUE)>nums[mid] ){
				result = nums[mid];
				break;
			}
			else if(nums[mid]>nums[high]){
				low=mid+1;
			}else {
				high=mid-1;
			}
		}
		
		System.out.println(result);

	}

}
