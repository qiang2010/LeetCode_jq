package qiang.leetcode;

public class MinimumPathSum64 {
    
	
	
	public int minPathSum(int[][] grid) {
		if(grid == null || grid.length == 0 ) return Integer.MAX_VALUE;
		
		int m = grid.length;
		int n = grid[0].length;
		
		// 初始化
		int [][]dp = new int[m][n];
		
		dp[0][0]= grid[0][0];
		for(int i = 1 ; i < m; i++){
			dp[i][0] = dp[i-1][0] + grid[i][0];
		} 
		for(int i=1;i<n;i++){
			dp[0][i] = dp[0][i-1] + grid[0][i];
		}
		
		int temp;
		for(int i =1; i<m; i++){
			for(int j =1; j<n; j++){
				if(dp[i][j-1] > dp[i-1][j])
					temp = dp[i-1][j];
				else temp = dp[i][j-1];
				dp[i][j]= temp + grid[i][j];
			}
		}
		return dp[m-1][n-1];
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumPathSum64 mp = new MinimumPathSum64();
		int [][] grid ={{1,1,1},{1,1,1},{1,1,1}};
		System.out.println(mp.minPathSum(grid));
	}

}
