package qiang.dynamicPromming;

public class BurstBalloons312 {
	
	public static void main(String[] args) {
		int []nums={3,1,5,8};
		System.out.println(maxCoins(nums));
	}
    public static int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int dp[][] = new int[len+1][len+1];
        for(int j =1;j<len+1;j++){
            for( int i =j-1;i>-1;i--){
                int max = 0;
                for(int k = i; k< j;k++){
                    max = Math.max(max, dp[i][k] + dp[k+1][j]+ nums[k]*((i-1)==-1? 1:nums[i-1]) * ((j==len? 1:nums[j])) );
                }
                dp[i][j]= max;
            }
        }
        return dp[0][len];
    }
}
