package qiang.leetcode;

public class MaximumSubarray53 {

	

    public int maxSubArray(int[] nums) {
        
    	if(nums == null || nums.length==0) return 0;
    	int size = nums.length; 
    	int []dp = new int[size];
    	dp[0] = nums[0];
    	
    	int max= dp[0];
    	for(int i=1;i<size; i++){
    		
    		if(dp[i-1] <0){
    			dp[i] = nums[i];
    		}else{
    			dp[i] = dp[i-1]+nums[i];
    		}
    		if(dp[i] > max ) max = dp[i];
    	}
    	return max;
    }	
	
    /**
     *  由于只需要max值，所以可以不用dp数组。减少空间使用。
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        
    	if(nums == null || nums.length==0) return 0;
    	int size = nums.length; 
    	
    	int dp = nums[0];
    	
    	int max= dp;
    	for(int i=1;i<size; i++){
    		
    		if(dp <0){
    			dp = nums[i];
    		}else{
    			dp = dp+nums[i];
    		}
    		if(dp > max ) max = dp ;
    	}
    	return max;
    }	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumSubarray53 ms = new MaximumSubarray53();
		int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(ms.maxSubArray(nums));
	}

}
