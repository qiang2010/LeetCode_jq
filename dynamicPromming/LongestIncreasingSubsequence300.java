package qiang.dynamicPromming;

public class LongestIncreasingSubsequence300 {

	public static void main(String[] args) {
		
		int []nums = {10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println(new LongestIncreasingSubsequence300().lengthOfLIS(nums));
	}
	  
	public int lengthOfLIS(int[] nums) {
		  
	       
		if(nums == null || nums.length == 0) return 0;
		int s = nums.length;
	    int dp[]    = new int[s];
	    dp[0] =1;
	    int max = 1;
	    
	    for(int i =1 ; i <s; i++){
	    	dp[i] = 1;
	    	for(int j = i-1; j > -1; j--){
	    		if(nums[i]>nums[j] && dp[i] < dp[j]+1){
	    			dp[i] = dp[j]+1;
	    		}
	    	}
	    }
	    for(int i =1 ; i <s; i++){
	    	if(dp[i] > max)max = dp[i];
	    }
	    return max;
	}
	
}
