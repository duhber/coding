package leetcode;

public class DeleteOperationForTwoStrings {
	
	/*
	 *  Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, 
	 *  where in each step you can delete one character in either string.

	Example 1:
	
	Input: "sea", "eat"
	Output: 2
	Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
	
	Note:

    The length of given words won't exceed 500.
    Characters in given words can only be lower-case letters.

	 * 
	 */
	
	public static void main(String[] args){
		
		String word1 = "seat";
		String word2 = "eats";
		
		
		
		int n1 = word1.length();
		int n2 = word2.length();
		
		int dp [] [] = new int[n2+1][n1+1];
		
		dp[0][0] = 0;
		
		for(int i=1;i<=n1;i++){
			dp[0][i]=i;
		}
		
		for(int i=1;i<=n2;i++){
			dp[i][0]=i;
		}
		
		for(int i=1;i<=n2;i++){
			
			
			for(int j=1;j<=n1;j++){
				
				if(word2.charAt(i-1)==word1.charAt(j-1)){
					
					dp[i][j]=dp[i-1][j-1];
				}
				else{
					
					int temp = Math.min(dp[i-1][j], dp[i][j-1]);
					dp[i][j]=Math.min(temp+1, dp[i-1][j-1]+2);
				}
				
			}
		}
		
		System.out.println(dp[n2][n1]);
		
		for(int i=0;i<=n2;i++){
			System.out.println();
			for(int j=0;j<=n1;j++){
				System.out.print(dp[i][j]+"  ");
				
			}
		}
	}

}
