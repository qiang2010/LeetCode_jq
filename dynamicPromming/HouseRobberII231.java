package qiang.dynamicPromming;

public class HouseRobberII231 {

	
    
	
	public int rob(int[] nums) {
        
		if(nums == null || nums.length ==0) return 0;
		if(nums.length == 1) return nums[0];
		if(nums.length == 2)return Math.max(nums[0], nums[1]);
		
		int dp[] = new int[nums.length];
		dp[0] =0;
		dp[1]= nums[0];
		for(int i =2;i < nums.length;i++){
			dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
		}
		int ans = dp[nums.length-1];
		dp[0] =0;
		dp[1]=nums[1];
		for(int i =2;i < nums.length;i++){
			dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
		}
		return Math.max(ans, dp[nums.length-1]);
	}
	
	public static void main(String[] args) {
		int []nums = {2,2,1};
		System.out.println(new HouseRobberII231().rob(nums));
	}
	
	
}
