package leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
	public static void main(String []args){
		System.out.println(wordPattern("aaaa", "dog dog dog dog"));
	}
	
	public static boolean wordPattern(String pattern, String str){
		
		boolean follow = true;
		String [] patternHash = new String[26];
		Map<String, Integer> wordHash = new HashMap<String, Integer>();
		String [] strArray = str.split(" ");
		
		if(pattern.length()!=strArray.length){
			return false;
		}
		
		for(int i=0;i<pattern.length();i++){
			
			char token = pattern.charAt(i);
			String word = strArray[i];
			// token is new
			if(patternHash[token-'a']==null){
				// word should also be new
				if(wordHash.containsKey(word)){
					follow = false;
					break;
				}
				else{
					patternHash[token-'a']=word;
					wordHash.put(word, 1);
				}
				
			}
			else{
				// token already comes before
				//word should also exist and should be mapped to token
				if(!patternHash[token-'a'].equals(word)){
					follow=false;
					break;
				}
				
			}
			
		}
		
		return follow;
	}

}
