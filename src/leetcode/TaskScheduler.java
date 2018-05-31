package leetcode;

public class TaskScheduler {

	
	/*
	 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters 
	 * represent different tasks.Tasks could be done without original order. Each task could be done in one interval. 
	 * For each interval, CPU could finish one task or just be idle.

		However, there is a non-negative cooling interval n that means between two same tasks, 
		there must be at least n intervals that CPU are doing different tasks or just be idle.
		
		You need to return the least number of intervals the CPU will take to finish all the given tasks.
		
		Example 1:
		
		Input: tasks = ["A","A","A","B","B","B"], n = 2
		Output: 8
		Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.

	 * 
	 * 
	 */
	public static void main(String[] args) {
		
		char tasks [] = {'A','A','A','B','B','B'};
		
		int taskCount [] = new int[26];
		int n=2;
		
		int output = 0;
		int currentTask = 0;
		int cooldown = 0;
		
		for(int i=0;i<tasks.length;i++){
			taskCount['A'-tasks[i]]++;
			
		}
		for(int i=0;i<taskCount.length;i++){
			
			
		}
		
		
	}

}
