package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate2 {
	public static void main(String [] args){
		
	}
	public static boolean containsNearyByDuplicate(int[]nums,int k){
		boolean duplicate = false;
		
		Map<Integer, Integer> hashIndex = new HashMap<Integer, Integer>();
		for(int j=0;j<nums.length;j++){
			if(hashIndex.containsKey(nums[j])){
				int i = hashIndex.get(nums[j]);
				if(j-i<=k){
					duplicate = true;
					break;
				}
			}
			hashIndex.put(nums[j], j);
		}
		
		return duplicate;
	}
	
	// using sliding window and hash-set
	public static boolean method2(int[]nums,int k){
		boolean exist = false;
		
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0;i<nums.length;i++){
			if(i>k){
				set.remove(nums[i-k-1]);
			}
			if(!set.add(nums[i])){
				exist = true;
				break;
			}
		}
		return exist;
	}

}
