package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
	
	/*
	 * 
	 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
	 */
	
	
	public static void main(String[] args){
		
		String[] numPad = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		String digits = "23";
		List<String> result = new ArrayList<>();
		backtrack(result, new char[digits.length()], digits, 0, numPad);
		
		for(String str: result){
			System.out.println(str);
		}
		
	}
	
	private static void backtrack(List<String> result, char[] word, String digits, int index, String[]numPad){
		
		if(index==digits.length()){
			result.add(new String(word));
		}else {
			String str = numPad[digits.charAt(index)-'0'];
			for(int i=0;i<str.length();i++){
				word[index]=str.charAt(i);
				backtrack(result,word,digits,index+1,numPad);
			}
		}
	}

}
