package leetcode;

public class AddStrings {

	public static void main(String[] args){
		String num1 = "11";
		String num2 = "99";
		
		int len = Math.max(num1.length(), num2.length());
		
		int i=num1.length()-1;
		int j=num2.length()-1;
		
		int k = len-1;
		int carry=0;
		char res [] = new char[len];
		while(k>=0){
			
			int a = i>=0? num1.charAt(i)-'0':0;
			int b = j>=0?num2.charAt(j)-'0':0;
			
			int c = a+b+carry;
			int mod = c%10;
			carry = c/10;
			res[k]=(char)('0'+mod);
			
			j--;
			i--;
			k--;
		}
		
		String sum = carry>0?((char)('0'+carry)+String.valueOf(res)):String.valueOf(res);
		
		System.out.println(String.valueOf(sum));
		
	}
}
