package leetcode;

public class ContainerWithMostWater {
	/*
	 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate 
	 * (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
	 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.

	
	Note: You may not slant the container and n is at least 2. 
	
	/*
	 * HINT : USING TWO POINTERS
	 * 
	 */
	
	 
	/*
	 *  SOLUTIONS : 
	 *  Start by evaluating the widest container, using the first and the last line. 
	 *  All other possible containers are less wide, so to hold more water, they need to be higher. 
	 *  Thus, after evaluating that widest container, skip lines at both ends that don’t support a higher height. 
	 *  Then evaluate that new container we arrived at. Repeat until there are no more possible containers left.
	 * 
	 */
	
	public static void main(String [] args){
		
		int height[] = {1,2,3,4};
		
		int i=0;
		int j=height.length -1;
		
		int maxArea = -1;
		
		while(i<j){
			
			int h = Math.min(height[i], height[j]);
			maxArea = Math.max(h*(j-i), maxArea);
			while(height[i]<=h && i<j) i++;
			while(height[j]<=h && i<j) j--;
		}
		System.out.println(maxArea);
	}

}
