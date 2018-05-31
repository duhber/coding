package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ReorganizeString {
	
	/*
	 * 
	 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other 
	 * are not the same.If possible, output any possible result.  If not possible, return the empty string.

	Example 1:
	
	Input: S = "aab"
	Output: "aba"
	
	Example 2:
	
	Input: S = "aaab"
	Output: ""
	
	Note:
	
	S will consist of lowercase letters and have length in range [1, 500].

	 */

	public static void main(String[] args) {
		
		String S="aacab";
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o2[1]-o1[1];
			}
		});
		int ch[] = new int[26];
		
		for(int i=0;i<S.length();i++){
			ch[S.charAt(i)-'a']++;
		}
		
		
		for(int i=0;i<26;i++){
			if(ch[i]>0){
				int chFreq [] = new int[2];
				chFreq [0]=i;
				chFreq [1]=ch[i];
				pq.add(chFreq);
			}
		}
		
		StringBuilder res = new StringBuilder();
		int index = 0;
		boolean isValid = true;
		while(!pq.isEmpty()){
			int[] first = pq.poll();
			char token =(char) ('a'+first[0]);
			
			if(index==0 || res.charAt(index-1)!=token){
				res.append(token);
				
				if(--first[1]>0){
					pq.add(first);
				}
			}else{
				
				int [] second = pq.poll();
				
				if(second==null){
					isValid = false;
					break;
				}
				token =(char) ('a'+second[0]);
				res.append(token);
				if(--second[1]>0){
					pq.add(second);
				}
				pq.add(first);
			}
			index++;
		}
		
		if(isValid){
			System.out.println(res.toString());
		}else{
			System.out.println("");
		}
	}
}
