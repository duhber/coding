package leetcode;

public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAnagram("rat","tar"));

	}
	public static boolean isAnagram(String s, String t){
		boolean anagram = true;
		
		int [] hashS = new int[26];
		for(int i=0;i<s.length();i++){
			char token = s.charAt(i);
			hashS[token-'a']++;
		}
		for(int i=0;i<t.length();i++){
			char token = t.charAt(i);
			if(--hashS[token-'a']<0){
				anagram =  false;
				break;
			}
		}
		
		return anagram;
	}
}
