package leetcode;

public class MinimumPathSum {
	
	/*
	 * 
	 * Given a m x n grid filled with non-negative numbers, 
	 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.


	 * 
	 */
	
	public static void main(String[] args) {
		
		int grid[][] = {{1,3,1}, {1,5,1},{4,2,1}};
		int m = grid.length;
		
		if(m>0){
			int n = grid[0].length;
			System.out.println(grid[0].length);
			
			
			for(int i=1;i<n;i++){
				grid[0][i]=grid[0][i-1]+grid[0][i];
			}
			
			for(int i=1;i<m;i++){
				
				for(int j=0;j<n;j++){
					grid[i][j] = Math.min(grid[i-1][j], j-1>=0?grid[i][j-1]:Integer.MAX_VALUE) + grid[i][j];
				}
				
			}
			
			System.out.println(grid[m-1][n-1]);
			
		}
		
	}

}
