package qiang.dynamicPromming;

public class BestTimeToBuyAndSellStockIV188_2 { 
	
	public static void main(String[] args) {
		
		int []prices={1,2,4};
		System.out.println(new BestTimeToBuyAndSellStockIV188_2().maxProfit(2, prices));
	}  
	
	public int maxProfit(int k, int[] prices) {
	     
		if(prices == null || prices.length == 0 || k==0) return 0;
		int day = prices.length;
		if(k > day){
			return maxProfit(prices);
		}
		int local[][] = new int[day][k+1];
		int global[][] = new int[day][k+1];
		int diff;
		for(int i =1;i<day;i++){
			diff = prices[i]-prices[i-1];
			for(int j = 1; j <k+1;j++){
				local[i][j] = Math.max(local[i-1][j]+diff, global[i-1][j-1]+Math.max(diff, 0));
				global[i][j] = Math.max(local[i][j], global[i-1][j]);
			}
		}
		return global[day-1][k];
	
	}
	  
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
