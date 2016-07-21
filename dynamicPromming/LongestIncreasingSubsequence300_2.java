package qiang.dynamicPromming;

import java.util.Arrays;

public class LongestIncreasingSubsequence300_2 {

	public static void main(String[] args) {
		
		int []nums = {10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println(new LongestIncreasingSubsequence300_2().lengthOfLIS(nums));
	}
	  
	/**
	 * 这里使用的是dp的方法，时间复杂度降低到 O(NlogN)
	 * 
	 * @param nums
	 * @return
	 */
	public int lengthOfLIS(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int s = nums.length;
	    int dp[]    = new int[s];
	    int ansLen = 0;
	    for(int n:nums){
	    	int index = Arrays.binarySearch(dp, 0,ansLen,n);
	    	if(index < 0){
	    		index = -(index+1);
	    	}
	    	dp[index] = n;
	    	if(index == ansLen){
	    		ansLen++;
	    	}
	    }
	    return ansLen;
	}
	
}
