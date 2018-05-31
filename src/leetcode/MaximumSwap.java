package leetcode;

public class MaximumSwap {
	
	/*
	 *  Given a non-negative integer, you could swap two digits at most once to get the maximum valued number.
	 *   Return the maximum valued number you could get.
	 *   Example 1:

Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.

Example 2:

Input: 9973
Output: 9973
Explanation: No swap.

Note:

	find index such that num[index] is the maximum number from i[0... n-1] to n-1. 
	
	if index is not equal to i and num[index]!=num[i] then swap. resulting number is the maximum number
	
	test cases: 10909091,1993,8386
	 
	 
    The given number is in the range [0, 108]

	 * 
	 * 
	 */
	
	public static void main(String[] args){
		int num=10909091; //1993//8386
		char[] digits = Integer.toString(num).toCharArray();
		
		int maxIndex[] = new int[digits.length];
		
		maxIndex[maxIndex.length-1] = maxIndex.length-1;
		for(int i=maxIndex.length-2;i>=0;i--){
			
			if(digits[i]>digits[maxIndex[i+1]]){
				maxIndex[i]=i;
			}else{
				maxIndex[i]=maxIndex[i+1];
			}
		}
		
		for(int i=0;i<maxIndex.length;i++){
			if(i!=maxIndex[i] && digits[i]!=digits[maxIndex[i]]){
				
				char temp = digits[i];
				digits[i]=digits[maxIndex[i]];
				digits[maxIndex[i]]=temp;
				break;
			}
			
		}
		int newNumber = Integer.valueOf(new String(digits));
		System.out.println(newNumber);
		
	}

}
