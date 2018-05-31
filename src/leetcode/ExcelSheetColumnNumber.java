package leetcode;

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {

		/*
		 * 
		 * Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...

Example 1:

Input: "A"
Output: 1

Example 2:

Input: "AB"
Output: 28

Example 3:

Input: "ZY"
Output: 701


		 */
		
		
		
		String s = "ZY";
		
		int res = 0;
		
		for(int i=0, j=s.length()-1;i<s.length() && j>=0;i++,j--){
			res +=(int)Math.pow(26, j)*((int)s.charAt(i)-'A' + 1);
			
		}
		
		System.out.println(res);
		
		
	}

}
