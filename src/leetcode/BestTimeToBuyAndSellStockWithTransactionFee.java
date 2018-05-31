package leetcode;

public class BestTimeToBuyAndSellStockWithTransactionFee {

	public static void main(String[] args) {
		int stockPrice [] = {1, 3, 2, 8, 4, 9};
		int fee = 2;
		System.out.println(f(stockPrice, 0,0,0 ));
	}
	
	public static int f(int [] stockPrice, int profit, int buy, int day){
		int resWithBuy=0;
		int resWithSell=0;
		
		if(day==stockPrice.length){
			return profit;
		}
	
		if(buy==0){
			resWithBuy = Math.max(f(stockPrice, profit, buy,day+1), f(stockPrice, profit-stockPrice[day],stockPrice[day] ,day+1));
		}
		else{
			resWithSell = Math.max(f(stockPrice, profit, buy,day+1), f(stockPrice, profit+stockPrice[day]-2,0 ,day+1));
		}
		
		return Math.max(resWithSell, resWithBuy);
		
	}

}
