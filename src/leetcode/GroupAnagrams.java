package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	
	/*
	 * Given an array of strings, group anagrams together.
	Example:
	
	Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
	Output:
	[
	  ["ate","eat","tea"],
	  ["nat","tan"],
	  ["bat"]
	]
	
	Note:
	
	    All inputs will be in lowercase.
	    The order of your output does not matter.
	 * 
	 * 
	 */
	
	public static void main(String[] args){
		
		String [] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		List<List<String>> result = new ArrayList<>();
		
		Map<String, List<String>> hash = new HashMap<>();
		
		int keys [] ;
		for(String str: strs){
			keys = new int[26];
			
			for(int i=0;i<str.length();i++){
				
				keys[str.charAt(i)-'a']++;
			}
			
			String key = "";
			
			for(int i=0;i<26;i++){
				if(keys[i]>0){
					key+=(char)('a'+i)+"-"+keys[i];
				}
			}
			
			if(hash.containsKey(key)){
				hash.get(key).add(str);
			}else{
				List<String> anagrams = new ArrayList<>();
				anagrams.add(str);
				hash.put(key, anagrams);
				
				result.add(anagrams);
			}
		}
		
		
		for(List<String> anagrams: result){
			
			System.out.println();
			
			for(String str:anagrams){
				System.out.print(" "+str);
			}
		}
		
	}

}
