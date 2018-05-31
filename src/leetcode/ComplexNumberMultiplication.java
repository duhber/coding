package leetcode;

public class ComplexNumberMultiplication {
	
	/*
	 * 
	 *  Given two strings representing two complex numbers.

	You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
	
	Example 1:
	
	Input: "1+1i", "1+1i"
	Output: "0+2i"
	Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
	
	Example 2:
	
	Input: "1+-1i", "1+-1i"
	Output: "0+-2i"
	Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
	
	Note:

    The input strings will not have extra blank.
    The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.

	 * 
	 */
	
	public static void main(String[] args){
		
		String a= "1+-1i";
		String b= "0+0i";
		
		String [] num1 = a.split("\\+");
		String [] num2 = b.split("\\+");
		
		int a1 = Integer.parseInt(num1[0]);
		
		int b1 = 0;
		if(num1[1].charAt(0)=='-'){
			
			b1 =-1*Integer.parseInt(num1[1].substring(1, num1[1].length()-1)); 
		}else{
			b1 =Integer.parseInt(num1[1].substring(0,  num1[1].length()-1));
		}
		
		
		
		int a2 = Integer.parseInt(num2[0]);
		int b2 = 0;
		
		if(num2[1].charAt(0)=='-'){
			b2 =-1*Integer.parseInt(num2[1].substring(1,  num2[1].length()-1)); 
		}else{
			b2 =Integer.parseInt(num2[1].substring(0,  num2[1].length()-1));
		}
		
		int a3 = (a1*a2 - b1*b2);
		int b3 = (a1*b2 + a2*b1);
		
		String result = a3+"+"+b3+"i";
		System.out.println(result);
		
	}

}
