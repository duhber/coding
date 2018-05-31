package leetcode;

public class CustomSortString {
	
	/*
	 * S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.

Return any permutation of T (as a string) that satisfies this property.

Example :
Input: 
S = "cba"
T = "abcd"
Output: "cbad"
Explanation: 
"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a". 
Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid out
	 * 
	 */
	
	public static void main(String[] args){
		
		String S="cba";
		String T="abcd";
		
		int charCount [] = new int[26];
		
		for(int i=0;i<T.length();i++){
			int index = T.charAt(i)-'a';
			charCount[index]++;
		}
		
		String result = "";
		
		for(int i=0;i<S.length();i++){
			char ch =  S.charAt(i);
			
			while(charCount[ch-'a']>0){
				result+=ch;
				charCount[ch-'a']--;
			}
		}
		
		for(int i=0;i<26;i++){
			while(charCount[i]>0){
				result+=(char)('a'+i);
				charCount[i]--;
			}
		}
		System.out.println(result);
		
	}

}
