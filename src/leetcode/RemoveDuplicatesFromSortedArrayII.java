package leetcode;

public class RemoveDuplicatesFromSortedArrayII {
	
	/*
	 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice 
	 * and return the new length.Do not allocate extra space for another array, you must do this by
	 *  modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

It doesn't matter what you leave beyond the returned length.

Example 2:

Given nums = [0,0,1,1,1,1,2,3,3],

Your function should return length = 7, with the first seven elements of nums 
being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

It doesn't matter what values are set beyond the returned length.

	 * 
	 * 
	 */
	public static void main(String[] args){
		
		int nums[] = {0,0,0};
	
		int i=0;
		int j=1;
		int count=1;
		while(j<nums.length){
			
			if(nums[i]==nums[j] && count<2){
				i++;
				count++;
			}
			else if(nums[i]!=nums[j]){
				i++;
				count=1;
			}
			else if(nums[i]==nums[j] && count==2){
				while(j<nums.length && nums[i]==nums[j]){
					j++;
				}
				if(j<nums.length)
					i++;
				count = 1;
			}
			
			if(i!=j && j<nums.length){
				int temp = nums[i];
				nums[i]=nums[j];
				nums[j]=temp;
			}
			j++;
		}
		
		for(int k=0;k<=i;k++){
			System.out.print(" "+nums[k]);
		}
		
	}

}
