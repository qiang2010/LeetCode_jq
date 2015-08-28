package qiang.leetcode;

public class UniquePathII63 {

	
	
 
    public int uniquePathsWithObstacles(int[][]obstacleGrid) {
    	
    	if(obstacleGrid == null || obstacleGrid.length == 0) return 0;
		
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
    	
    	int dp[][] = new int[m][n];
    	int i =0;
    	for(i=0; i <m ; i++)
    		if(obstacleGrid[i][0] == 0)
    			dp[i][0] =1;
    		else{
    			dp[i][0]=0;
    			break;
    		}
    	for(; i <m ; i++)
    		dp[i][0]=0;
    	
    	for(i=0; i < n;i++)
    		if(obstacleGrid[0][i] == 0)
    			dp[0][i] = 1;
    		else {
    			dp[0][i]=0;
    			break;
    		}
    	for(;i<n;i++){
    		dp[0][i]=0;
    	}
    	
    	for( i =1; i < m ;i++){
    		for(int j=1; j< n; j++){
    			if(obstacleGrid[i][j]==0)
    				dp[i][j] = dp[i][j-1] + dp[i-1][j];
    			else dp[i][j]=0;
    		}
    	}
    	return dp[m-1][n-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniquePathII63 up = new UniquePathII63();
		//System.out.println(up.uniquePaths(4, 2));
		int [][] grid={{0,0,0},{0,0,0},{0,0,0}};
		System.out.println(up.uniquePathsWithObstacles(grid));
	}

}
