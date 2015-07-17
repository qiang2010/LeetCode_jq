package qiang.leetcode;

public class BestTimetoBuyandSellStockII122 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	/**
	 * Say you have an array for which the ith element is the price of a given stock on day i.
	 * @param prices
	 * @return
	 */
    public int maxProfit(int[] prices) {
     int ans = 0;
     for(int i =0; i < prices.length -1 ; i++){
    	 if(prices[i+1] > prices[i]){
    		 ans += prices[i+1] - prices[i];
    	 }
     }
     
     return ans;
    }
}
