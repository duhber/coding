package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumSizeSubarraySum {
	
	/*
	 *  Given an array of n positive integers and a positive integer s, 
	 *  find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

click to show more practice.
More practice:

If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).

	 * 
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int s =11;
		int [] nums = {1,2,3,4,5};
		
		Map<Integer, Integer>  sumIndexMap = new HashMap<Integer,Integer>();
		sumIndexMap.put(0, -1);
		
		int minLen = Integer.MAX_VALUE;
		int sumJ = 0;
		for(int j=0;j<nums.length;j++){
			
			sumJ+=nums[j];
			int sumIMinusOne = sumJ-s;
			
			if(sumIndexMap.containsKey(sumIMinusOne)){
				int i = sumIndexMap.get(sumIMinusOne);
				minLen = Math.min(minLen, j-i);
			}
			
			sumIndexMap.put(sumJ,j);
		}
		
		System.out.println(minLen);
	}

}
