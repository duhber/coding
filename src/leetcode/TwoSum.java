package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public static int[] twoSum(int [] nums, int target){
		int [] indices = new int[2];
		
		Map<Integer, Integer> hashDiff = new HashMap<>();
		for(int i=0;i<nums.length;i++){
			if(hashDiff.containsKey(nums[i])){
				indices[0]=hashDiff.get(nums[i]);
				indices[1]=i;
				break;
			}
			hashDiff.put(target-nums[i], i);
		}
		
		return indices;
	}
}
