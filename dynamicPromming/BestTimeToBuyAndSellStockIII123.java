package qiang.dynamicPromming;

public class BestTimeToBuyAndSellStockIII123 {

	
	
	/**
	 *  可以进行最多两次交易，一次或者两次
	 *  
	 *  使用两个数组，leftProfit[i]记录从0开始到i的最大收益,rightProfit[j]记录从j到size-1的收益，
	 *  然后，leftProfit[i]+right[i] 最大的就是最大的收益了。
	 *  
	 *  rightProfit的计算：
	 *  
	 *  开始的时候我只是想到了使用最小值，始终都要在O(N^2)的时间才能解决。 没有想到可以利用从i到size-1的最大值。
	 *  
	 *  假设我们获得了从i到size-1的最大值，以及最大收益，当i--的时候，就相当于添加了一个数j=i-1，
	 *  只要用i到size-1的最大值减去prices[i-1]，然后和i到size-1的最大收益比较，就能得到从i-1到size-1的最大收益了。

	 * @param prices
	 * @return
	 */
	
    public int maxProfit(int[] prices) {
       
    	if(prices == null) return 0;
    	if(prices.length ==0) return 0;
    	int len = prices.length;
    	int []leftProfit = new int[len];
    	int []rightProfit = new int[len];
    	int minLeft = prices[0];
    	int maxLeftProfit= 0,maxRightProfit=0;
    	int maxRight = prices[len-1];
    	leftProfit[0] = rightProfit[0] = 0;
    	for(int i =1; i < len; i++){
    		leftProfit[i] = prices[i] - minLeft;
    		int k =(leftProfit[i] > maxLeftProfit) ? (maxLeftProfit= leftProfit[i]):(leftProfit[i]= maxLeftProfit);
    		minLeft = minLeft > prices[i]? prices[i]:minLeft;
    		
    		rightProfit[len-i-1] =maxRight -  prices[len-i-1];
    		k = rightProfit[len-i-1] >  maxRightProfit ? (maxRightProfit = rightProfit[len-i-1]):(rightProfit[len-i-1]= maxRightProfit);
    		maxRight = maxRight < prices[len-i-1] ? prices[len-i-1]:maxRight;
	
    	}
    	
    	// 可以由后向前
    	
    	int ansMax = 0;
    	for(int i =0; i < len; i++){
    		ansMax = ansMax > (leftProfit[i]+rightProfit[i]) ? ansMax: (leftProfit[i]+rightProfit[i]); 
    	}
    	
    	return ansMax;
    }	
	
	
	public static void main(String[] args) {

		int []prices = {6,1,3,2,4,7};
		System.out.println(new BestTimeToBuyAndSellStockIII123().maxProfit(prices));	
	}

}
