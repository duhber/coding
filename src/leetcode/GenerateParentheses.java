package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses {
	
	/*
	 *  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

	 */
	
	public static void main(String[] args){
		
		List<String> results = new ArrayList<>();
		
		int n=3;
		genParentheses(results, 0, 0, n, new char[2*n], 0);
		
		for(int i=0;i<results.size();i++){
			System.out.println(results.get(i));
		}
		
	}

	private static void genParentheses(List<String> results, int open, int close, int n, char[]str, int index ){
		
		if(open==close && index==2*n){
			results.add(new String(str));
		}else if(index < 2*n && open<=n && close <n){
			index++;
			//System.out.println(String.format("open %d , close %d, index %d", open,close, index));
			if(open>close){
				str[index-1]=')';
				genParentheses(results, open, close+1, n, str, index);
			}
			str[index-1]='(';
			genParentheses(results, open+1, close, n, str, index);
		}
		
	}
}
