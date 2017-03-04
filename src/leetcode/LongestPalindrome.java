package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hello World");	
		String s = "abccccdd";
		System.out.println(fasterMethod(s));

	}
    public static int longestPalindrome(String s) {//24ms
        int result = 0;
        Map<Character, Integer> hash = new HashMap<Character, Integer>();
        for(char token:s.toCharArray()){
        	int count=1;
        	if(hash.containsKey(token)){
        		count=hash.get(token)+1;
        		
        	}
        	hash.put(token, count);
        }
        
        for(Map.Entry<Character, Integer> entry : hash.entrySet()){
        	int val = entry.getValue();
        	result += (val%2==0?val:val-1);
        }
        
        if(result<s.length()){
        	result++;
        }
        
        return result;
    }
    
    public static int fasterMethod(String s){//10ms
    	int result =0;
    	int []hash = new int[256];
    	
    	for(int i=0;i<s.length();i++){
    		char token = s.charAt(i);
    		hash[token]++;
    		if(hash[token]==2){
    			result+=2;
    			hash[token]=0;
    		}
    	}
    	
        if(result<s.length()){
        	result++;
        }
    	
    	
    	return result;
    }

}
