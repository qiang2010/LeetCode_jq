package qiang.leetcode;

public class UniquePath62 {

	
	
	/**
	 *  对uniquePath的改进，只是使用一个一维数组。
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths2(int m, int n) {
	    	
	    	if(m < 2  || n < 2 ) return 1;
	    	
	    	int dp[] = new int[n];
	    	for(int i=0; i <n ; i++)
	    		dp[i] =1;
	    	
	    	for(int i =1; i < m ;i++){
	    		for(int j=1; j< n; j++){
	    			dp[j] +=dp[j-1];
	    		}
	    	}
	    	return dp[n-1];
	    }
	
    public int uniquePaths(int m, int n) {
    	
    	if(m < 2  || n < 2 ) return 1;
    	
    	int dp[][] = new int[m][n];
    	for(int i=0; i <m ; i++)
    		dp[i][0] =1;
    	for(int i=0; i < n;i++)
    		dp[0][i] = 1;
    	
    	for(int i =1; i < m ;i++){
    		for(int j=1; j< n; j++){
    			dp[i][j] = dp[i][j-1] + dp[i-1][j];
    		}
    	}
    	return dp[m-1][n-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniquePath62 up = new UniquePath62();
		System.out.println(up.uniquePaths(4, 2));
		System.out.println(up.uniquePaths2(4, 2));
	}

}
