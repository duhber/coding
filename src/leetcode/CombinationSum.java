package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	/*
	 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), 
	 * find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]

Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]]
	 * 
	 * 
	 * 
	 */
	
	
	public  static void  main(String[] args){
		
		int [] candidates = {2,3,5};
		int target = 10;
		Arrays.sort(candidates);
		List<List<Integer>> results = new ArrayList<>();
		backtrack(results, candidates, target, 0, new ArrayList<Integer>());
		
		for(int i=0;i<results.size();i++){
			System.out.println();
			for(Integer val: results.get(i)){
				System.out.print("  "+val);
			}
		}
		
	}

	private static void backtrack(List<List<Integer>> results, int [] candidates, int rem, int index, List<Integer> combinations){
		if(rem==0){
			results.add(new ArrayList<Integer>(combinations));
		}
		else{
			for(int i=index;i<candidates.length;i++){
				if(rem-candidates[i]>=0){
					combinations.add(candidates[i]);
					backtrack(results,candidates, rem-candidates[i], i, combinations);
					combinations.remove(combinations.size()-1);
				}
			}
		}
	}

}
