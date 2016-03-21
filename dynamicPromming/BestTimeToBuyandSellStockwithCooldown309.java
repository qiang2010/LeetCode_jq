package qiang.dynamicPromming;

public class BestTimeToBuyandSellStockwithCooldown309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []prices = {1, 2, 3, 0, 2,20};
		System.out.println(maxProfit(prices));
	}
	
	public static  int maxProfit(int[] prices) {
		
		if(prices == null || prices.length < 2) return 0;
		if(prices.length == 2){
			return prices[1]-prices[0]>0?prices[1]-prices[0]:0;
		}
		
		int buy1,newB;
		int sell0,sell1,newS=0;
		
		buy1= Math.max(-prices[0], -prices[1]);
		sell0 = 0;
		sell1 = Math.max(0, prices[1]-prices[0]);
		for(int i =2;i < prices.length;i++){
			newB = Math.max(buy1, sell0-prices[i]);
			newS = Math.max(sell1, buy1+prices[i]);
			buy1 = newB;
			sell0=sell1;
			sell1=newS;
		}
		return newS;
	}
 

}
