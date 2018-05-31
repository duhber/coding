package leetcode;

public class MaximumLengthOfRepeatedSubarray {

	/*
	 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:

Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: 
The repeated subarray with maximum length is [3, 2, 1].

Note:

    1 <= len(A), len(B) <= 1000
    0 <= A[i], B[i] < 100

	 * 
	 * 
	 */
	
	
	public static void main(String[] args) {
		int []A={1,2,3,2,1};
		int []B={3,2,1,4,7};
		
		int [][] dp = new int[B.length][A.length];
		int max = 0;
		
		
		
		
		for(int i=0;i<B.length;i++){
		
			for(int j=0;j<A.length;j++){
				
				if(i-1 >= 0 && j-1>=0 && B[i]==A[j]){
					dp[i][j] = dp[i-1][j-1]+1;
				}
				else if(B[i]==A[j]){
					dp[i][j]=1;
				}
				
				max= Math.max(dp[i][j], max);
			}
		}
		
		System.out.println(max);
		for(int i=0;i<B.length;i++){
			System.out.println();
			for(int j=0;j<A.length;j++){
				System.out.print(" "+dp[i][j]);
			}
		}
		
	}

}
