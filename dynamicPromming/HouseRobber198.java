package qiang.dynamicPromming;

public class HouseRobber198 {

	
    
	
	public int rob(int[] nums) {
        
		if(nums == null || nums.length ==0) return 0;
		if(nums.length == 1) return nums[0];
		int last0 = 0 ;
		int last1 = nums[0] ;
		int tempLast;
		for(int i =1; i < nums.length;i++){
			tempLast = Math.max(last1, last0);
			last1 = last0 + nums[i];
			last0 = tempLast;
		}
		return Math.max(last1, last0);
	}
	
	public int rob2(int[] nums) {
        
		if(nums == null || nums.length ==0) return 0;
		if(nums.length == 1) return nums[0];
		int []dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for(int i =2; i < nums.length;i++){
			dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
		}
		return dp[nums.length-1];
	}
	
	public int rob3(int[] nums) {
        
		if(nums == null || nums.length ==0) return 0;
		if(nums.length == 1) return nums[0];
		int dp0 = nums[0],dp1=Math.max(nums[0], nums[1]);
		int curP;
		for(int i =2; i < nums.length;i++){
			curP = Math.max(dp0+nums[i], dp1);
			dp0= dp1;
			dp1 = curP;
		}
		return dp1;
	}
	public int rob4(int[] nums) {
        
		if(nums == null || nums.length ==0) return 0;
		if(nums.length == 1) return nums[0];
		int dp0 =0,dp1=0;
		int curP;
		for(int i: nums){
			curP = Math.max(dp0+i, dp1);
			dp0= dp1;
			dp1 = curP;
		}
		return dp1;
	}
	
	public static void main(String[] args) {
		int []nums = {1};
		System.out.println(new HouseRobber198().rob(nums));
	}
	
	
}
