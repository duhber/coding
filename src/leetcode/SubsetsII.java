package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	/*
	 *  Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

	 * 
	 * 
	 * 
	 */

	public static void main(String [] args){
		
		int nums[] = {1,2,2,3};
		Arrays.sort(nums);
		List<List<Integer>> subsets = new ArrayList<>();
		backtract(subsets, new ArrayList<Integer>(), -1, nums);
		
		
	}
	
	private static void backtract(List<List<Integer>> subsets, List<Integer> subset, int index, int nums[]){
		subsets.add(new ArrayList<Integer>(subset));
		int prev=Integer.MIN_VALUE;
		for(int i=index+1;i<nums.length;i++){
			if(prev!=nums[i]){
				subset.add(nums[i]);
				backtract(subsets, subset, i, nums);
				subset.remove(subset.size()-1);
			}
			prev=nums[i];
		}
	}
	
	
}
