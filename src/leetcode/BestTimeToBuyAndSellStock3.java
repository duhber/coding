package leetcode;

public class BestTimeToBuyAndSellStock3 {
	
	/*
	 * 
	 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

	 * 
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] prices = {1,2,4,2,5,7,2,4,9,0};
		
		int maxOneTx = 0;
		int maxTwoTx = 0; 
		int sum = 0;
		int seq=1;
		int minStock =0;
		for(int i=0;i<prices.length-1;i++){
			
			maxOneTx = Math.max(prices[i]-minStock, maxOneTx);
			minStock = Math.min(minStock, prices[i]);
			
			
			
		}
		
	}

}
