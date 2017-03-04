package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AllAnagramsInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(findAnagrams("cbaebabacd","abc"));
		

	}
	private static List<Integer> findAnagrams(String s, String p){
		int len  = p.length();
		List<Integer> result = new ArrayList<Integer>();
		
		int start = 0;
		
		Map<Character,Integer> hashP = new HashMap<Character,Integer>();
		Map<Character,Integer> hashS = new HashMap<Character,Integer>();
		
		for(int i=0;i<len;i++){
			
			char token = p.charAt(i);
			int val = 1;
			if(hashP.containsKey(token)){
				val = hashP.get(token)+1;
			}
			hashP.put(token, val);
		}
		for(int i=0;i<s.length();i++){
			char token = s.charAt(i);
			if(hashP.containsKey(token)){
				int val = 1;
				if(hashS.containsKey(token)){
					val = hashS.get(token)+1;
				}
				hashS.put(token, val);
				if(i==start+len-1){
					
					if(isAnagram(hashS, hashP)){
						result.add(start);
					}
					int startTokenValue = hashS.get(s.charAt(start));
					if(startTokenValue > 1){
						hashS.put(s.charAt(start), startTokenValue-1);
					}
					else{
						hashS.remove(s.charAt(start));
					}
					start = start+1;
				}
			}
			else{
				hashS.clear();
				start=i+1;
			}
			
		}
		
		return result;
	}
	
	private static boolean isAnagram(Map<Character, Integer> hashS, Map<Character, Integer> hashP){
		boolean anagram = true;
		if(hashS.size()!=hashP.size()){
			anagram = false;
		}
		else{
			for(Entry<Character, Integer> entry : hashS.entrySet()){
				char key = entry.getKey();
				int valS = entry.getValue();
				int valP = hashP.get(key);
				
				if(valS!=valP){
					anagram=false;
					break;
				}
			}
		}
		
		return anagram;
		
	}

}
