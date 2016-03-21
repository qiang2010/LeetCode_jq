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
	
	
	/**
	 * 第二种方法
	 * @param nums
	 * @return
	 */
	public int rob2(int[] nums) {
		if(nums == null || nums.length==0)return 0 ;
		if(nums.length == 1)return nums[0];
		return Math.max(robRange(nums, 0, nums.length-2),robRange(nums, 1, nums.length-1));
	}
	/**
	 * 从begin 偷到 end
	 * @param nums
	 * @param begin
	 * @param end
	 * @return
	 */
	public int robRange(int []nums,int begin,int end){
		
		if(begin == end)return nums[begin];
		int dp0,dp1,curP;
		dp0 = nums[begin];
		dp1= Math.max(nums[begin], nums[begin+1]);
		for(int i =begin+2;i< end+1;i++){
			curP = Math.max(dp0+nums[i], dp1);
			dp0 = dp1;
			dp1 = curP;
		}
		return dp1;
	}
	
	
	
	public static void main(String[] args) {
		int []nums = {2,2,1};
		System.out.println(new HouseRobberII231().rob2(nums));
	}
	
	
}
