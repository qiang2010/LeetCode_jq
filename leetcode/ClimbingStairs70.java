package qiang.leetcode;

public class ClimbingStairs70 {

	
    public static int climbStairs(int n) {

    	if(n == 0) return 0;
    	if(n == 1) return 1;
    	if(n == 2) return 2;
    	int []dp = new int[n+1];
    	dp[0]=dp[1]=1;
    	dp[2] = 2;
    	for(int i=3; i < n+1;i++){
    		dp[i] = dp[i-1]+dp[i-2];
    	}
    	return dp[n];
    }
    /**
     * 减少空间使用
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {

    	if(n == 1) return 1;
    	if(n == 2) return 2;
    	int last = 1; 
    	int cur  = 2;
    	int next=1;
    	for(int i=3; i < n+1;i++){
    		next = cur + last;
    		last = cur;
    		cur = next;
    	}
    	return next;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs(13));
		System.out.println(climbStairs2(13));
	}
}
