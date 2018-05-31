package leetcode;

public class NextGreaterElementIII {
	
	/*
	 * Given a positive 32-bit integer n, you need to find the smallest 32-bit integer
	 *  which has exactly the same digits existing in the integer n and is greater in value than n. 
	 *  If no such positive 32-bit integer exists, you need to return -1.

	Example 1:
	
	Input: 12
	Output: 21
	
	 
	
	Example 2:
	
	Input: 21
	Output: -1

	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x =1;
		int n=1999999999;
		
		/*int prev=-1;
		
		int current = 0;
		int tens = 1;
		
		int number = -1;
		
		int right =0;
		while(n>0){
			
			current = n%10;
			n=n/10;
			if(prev>current){
				number= tens*10*n + tens*prev+ (right-(tens/10)*prev+(tens/10)*current);
				break;
				
			}
			prev = current;
			right=tens*current+right;
			tens=tens*10;
		} */
		
		
		char[] digits = String.valueOf(n).toCharArray();
		
		int i= digits.length-2;
		
		System.out.println(Integer.MAX_VALUE);
		
		while(i>=0){
			
			int digit = digits[i]-'0';
			int prev = digits[i+1]-'0';
			
			if(prev>digit){
				
				//digits[i]=(char)('0'+prev);
				//digits[i+1]=(char)('0'+digit);
				int j=digits.length-1;
				
				while(j>=i+1){
					
					int token = digits[j]-'0';
					if(token>digit){
						digits[i]=digits[j];
						digits[j]=(char)('0'+digit);
						break;
					}
					j--;
				}
				
				int low = i+1;
				int high=digits.length-1;
				
				
				while(low<high){
					
					char temp = digits[low];
					digits[low]=digits[high];
					digits[high]=temp;
					low++;
					high--;
				}
				
				break;
				
			}
			i--;
		}
		int number = -1;
		if(i>=0){
			long result=0;
			for(int j=0;j<digits.length;j++){
				
				result=result*10+(digits[j]-'0');
			}
			
			if(result<=Integer.MAX_VALUE){
				number=(int) (result);
			}
		}
		
		System.out.println(number);
	}

}
