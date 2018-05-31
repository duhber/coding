package leetcode;

public class SomeProblem {
	
	public static void main(String [] args){
		String str="aabbsnckddddd";
		int [] arr=new int[26];
		String result="";
		for(int i=0;i<str.length();i++){
			int ch=str.charAt(i);
			if(++arr[ch-'a']==1){
				System.out.println((char)ch);
				result+=(char)ch;
			}
		}
		
		System.out.println(result);
	}

}
