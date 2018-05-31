package leetcode;

public class BestTimeToBuyAndSellStock {

	/*
	 * Say you have an array for which the ith element is the price of a given stock on day i.

	If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
	 design an algorithm to find the maximum profit.
	
	Example 1:
	
	Input: [7, 1, 5, 3, 6, 4]
	Output: 5
	
	max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
	
	Example 2:
	
	Input: [7, 6, 4, 3, 1]
	Output: 0
	
	In this case, no transaction is done, i.e. max profit = 0.

	 * 
	 * 
	 */
	public static void main(String[] args) {
		int profit = 0;
		
		int[] prices = {2,4,1};
		
		int minIndex = 0;
		int maxIndex = 0;
		
		for(int i=1;i<prices.length;i++){
			minIndex = (prices[minIndex] > prices[i])?i:minIndex;
			maxIndex = (prices[maxIndex] > prices[i]) && minIndex<maxIndex?maxIndex:i;
			
			
			profit = profit< prices[maxIndex]-prices[minIndex]?prices[maxIndex]-prices[minIndex]:profit; 
			
		}
	
		
		System.out.println(profit);

	}

}
