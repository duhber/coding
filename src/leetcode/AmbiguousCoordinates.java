package leetcode;

import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates {
	
	/*
	 * We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)".  
	 * Then, we removed all commas, decimal points, and spaces, and ended up with the string S.  
	 * Return a list of strings representing all possibilities for what our original coordinates could have been.

Our original representation never had extraneous zeroes, so we never started with numbers like "00", "0.0", "0.00", "1.0", "001", "00.01", or any other number that can be represented with less digits.  Also, a decimal point within a number never occurs without at least one digit occuring before it, so we never started with numbers like ".1".

The final answer list can be returned in any order.  Also note that all coordinates in the final answer have exactly one space between them (occurring after the comma.)

Example 1:
Input: "(123)"
Output: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]

Example 2:
Input: "(00011)"
Output:  ["(0.001, 1)", "(0, 0.011)"]
Explanation: 
0.0, 00, 0001 or 00.01 are not allowed.

Example 3:
Input: "(0123)"
Output: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]

Example 4:
Input: "(100)"
Output: [(10, 0)]
Explanation: 
1.0 is not allowed.

	 * 
	 */
	
	public static void main(String[] args){
		String S = "(0123)";
		
		int len = S.length()-2;
		List<String> result = new ArrayList<>();
		for(int i=2;i<=len;i++){
			String x = S.substring(1, i);
			String y = S.substring(i, len+1);
			
			//System.out.println(String.format("%s %s", x,y));
			
			List<String> xList=helper(x);
			List<String> yList = helper(y);
			
			if(!xList.isEmpty() && !yList.isEmpty()){
				
				for(String x1: xList){
					for(String y1: yList){
						
						result.add("("+x1+", "+y1+")");
						
					}
				}
				
			}
		}
		
		for(String res: result){
			System.out.println(res);
		}
		
	}
	
	private static List<String> helper(String number){
		List<String> list = new ArrayList<>();
		
		int len = number.length();
		if(number.charAt(0)=='0'&& number.charAt(len-1)=='0' && len>1){
			
			
		}else if(number.charAt(len-1)=='0'){
			list.add(number);
		}else if(number.charAt(0)=='0'){
			list.add("0."+number.substring(1));
		}else{
			for(int i=1;i<len;i++){
				list.add(number.substring(0, i)+"."+number.substring(i));
			}
			list.add(number);
		}
		
		return list;
				
	}

}
