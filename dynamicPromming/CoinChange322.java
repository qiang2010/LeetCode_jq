package qiang.dynamicPromming;

import java.util.Arrays;

public class CoinChange322 {
    
	public static void main(String[] args) {
		
		int []coins = {2, 5,10,1};
		int amount = 27;
		System.out.println(coinChange2(coins, amount));
		
	}
	
	public static  int coinChange(int[] coins, int amount) {
        
		if(coins == null || coins.length == 0)return -1;
		
		if(amount == 0)return 0;
    
		Arrays.sort(coins);
		
		int []dp = new int[amount+1];
		dp[0] = 0;
		dp[1] = -1;
	
		int tempMin;
		for(int i =1;i<amount+1;i++){
			tempMin = Integer.MAX_VALUE;
			for(int j = 0 ; j < coins.length;j++){
				
				if(i >= coins[j] && dp[i-coins[j]]>-1){
					if(dp[i-coins[j]] < tempMin){
						tempMin = dp[i-coins[j]];
					}
				}
			}
			if(tempMin != Integer.MAX_VALUE){
				dp[i] = tempMin+1;
			}else{
				dp[i] = -1;
			}
		}
		return dp[amount];
	}
    /**
     * 使用动态规划的方法
     * dp[i] 表示的是当钱的数量是i的时候的少分割数量
     * */
    public static  int coinChange2(int[] coins, int amount) {
        
        if(coins == null) return 0;
        if(amount <= 0 ) return 0;
        int dp[] = new int[amount+1];
        dp[0] =0;
        for(int i = 1;i< amount+1; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int c:coins){
                if(i-c< 0 || dp[i-c] == Integer.MAX_VALUE)continue;
                dp[i] = Math.min(dp[i],dp[i-c]+1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE? -1: dp[amount];
    }
	
}
