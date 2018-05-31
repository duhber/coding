package leetcode;

public class MaxChunksToMakeSorted {

	public static void main(String[] args) {
		/*
		 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1],
		 *  we split the array into some number of "chunks" (partitions), and individually sort each chunk. 
		 *   After concatenating them, the result equals the sorted array.
		 *   What is the most number of chunks we could have made?
		 * 
		 */
		
		int arr[] = {3,1,0,2,4};
		
		int chunkCount = 0;
		
		int chunkMax = -1;
		for(int i=0;i<arr.length;i++){
			
			if(arr[i]>chunkMax){
				chunkMax = arr[i];
			}
			
			if(chunkMax==i){
				chunkCount ++;
			}
		}
		
		System.out.println(chunkCount);
	}

}
