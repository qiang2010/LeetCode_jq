package qiang.dynamicPromming;

public class BestTimeToSellStock121 {

	
	
	 public int maxProfit(int[] prices) {
	    if(prices == null) return 0;
	    if(prices.length ==0) return 0;
	    int tempMin = prices[0];
	    int max = 0;
	    
	    for (int i = 1; i < prices.length; i++) {
			max = max < prices[i]-tempMin ? prices[i]-tempMin : max;
			tempMin = tempMin < prices[i] ? tempMin : prices[i];
		}
	    return max;
	 }
	 
	 
	 public static void main(String[] args) {
		int []nums = {1,2,100,4};
		System.out.println(new BestTimeToSellStock121().maxProfit(nums));
	}
}
