package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * 
 * 
 * 

Find all possible combinations of k numbers that add up to a number n, 
given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

 * 
 * 
 */


public class CombinationSum3 {
	
	public static void main(String[] args) {
		
		int k=3;
		int n=7;
		List<List<Integer>> results = new ArrayList<>();
		for(int i=1;i<=9;i++){
			
			find(results, i,new ArrayList<Integer>(Arrays.asList(i)), k, n-i );
		}
		
		for(int i=0;i<results.size();i++){
			System.out.println();
			for(Integer val: results.get(i)){
				System.out.print("   "+val);
			}
		}
		
	}
	
	private static void  find(List<List<Integer>> results, int i, List<Integer> result, int k, int rem ){
		if(k==result.size() && rem==0){
			results.add(new ArrayList<Integer>(result));
		}
		else if(i<rem && result.size()<k){
			for(int j=i+1;j<=9;j++){
				int len = result.size();
				System.out.println(len);
				result.add(j);
				find(results, j, result, k, rem-j );
				result.remove(len);
			}
		}
	}

}
