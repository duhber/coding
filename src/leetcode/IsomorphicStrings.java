package leetcode;

public class IsomorphicStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isIsomorphic("paper", "title"));

	}
    public static  boolean isIsomorphic(String s, String t) {
        boolean isomorphic = true;
        int []hashS = new int[26];
        int []hashT = new int[26];
        
        if(s.length()!=t.length()){
        	isomorphic = false;
        }

        for(int i=0;i<s.length();i++){
        	char tokenS = s.charAt(i);
        	char tokenT = t.charAt(i);
        	
        	// old token
        	if(hashS[tokenS-'a']>0){
        		if(hashS[tokenS-'a']!=tokenT){
        			isomorphic = false;
        			break;
        		}
        	}
        	else{
        		if(hashT[tokenT-'a']>0){
        			isomorphic = false;
        			break;
        		}
        		else{
        			hashS[tokenS-'a']=tokenT;
        			hashT[tokenT-'a']++;
        		}
        	}
        	
        }
        
        
    	return isomorphic;
    }

}
