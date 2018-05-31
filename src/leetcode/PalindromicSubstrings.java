package leetcode;

public class PalindromicSubstrings {
	
	/*
	 * 
	 *  Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

Manacher's algorithm. more efficient solution
	 */

	public static void main(String[] args){
		
		String s = "aaca";
		int n=s.length();
		int dp [][] = new int[n][n];
		
		int i,j;
		int count=0;
		for(int len=0;len<n;len++){
			for(i=0,j=i+len;j-i<n && i<n && j<n;i++,j=len+i){
				if(len==0){
					dp[i][j] = 1;
					count++;
				}
				else {
					
					boolean isPrevPalin = (len==1)?true:(dp[i+1][j-1]==1);
					if(isPrevPalin && s.charAt(i)==s.charAt(j)){
						dp[i][j]=1;
						count++;
					}
				}
			}
		}
		
		System.out.println(count);
		
		
		
	}
}
