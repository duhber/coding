package leetcode;

public class NumberOfSubarraysWithBoundedMaximum {
	
	/*
	 * 
	 * We are given an array A of positive integers, and two positive integers L and R (L <= R).

Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that subarray is at least L and at most R.

Example :
Input: 
A = [2, 1, 4, 3]
L = 2
R = 3
Output: 3
Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].

	 * 
	 * 
	 * SOLUTION : 
	 * 
	 * Suppose dp[i] denotes the max number of valid sub-array ending with A[i]. We use following example to illustrate the idea:

A = [2, 1, 4, 2, 3], L = 2, R = 3

    if A[i] < L

For example, i = 1. We can only append A[i] to a valid sub-array ending with A[i-1] to create new sub-array. So we have dp[i] = dp[i-1] (for i > 0)

    if A[i] > R:

For example, i = 2. No valid sub-array ending with A[i] exist. So we have dp[i] = 0.
We also record the position of the invalid number 4 here as prev.

    if L <= A[i] <= R

For example, i = 4. In this case any sub-array starts after the previous invalid number to A[i] (A[prev+1…i], A[prev+2…i]) is a new valid sub-array. So dp[i] += i - prev

Finally the sum of the dp array is the solution. Meanwhile, notice dp[i] only relies on dp[i-1] (and also prev), we can reduce the space complexity to O(1)
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int A[] = {2, 1,4,3};
		
		int L=2;
		int R=3;
		
		int count = 0;
		int res = 0;
		int prev=-1;
		
		
		for(int i=0;i<A.length;i++){
			
			if(A[i]>=L  && A[i]<=R){
				count = i-prev;
				res+=count;
			}
			else if(A[i]<L){
				res+=count;
			}
			else{
				prev=i;
				count=0;
			}
		}
		System.out.println(res);
	}

}
