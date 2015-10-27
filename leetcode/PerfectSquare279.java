package qiang.leetcode;

public class PerfectSquare279 {
	
	public static void main(String[] args) {
		
		System.out.println(new PerfectSquare279().numSquares(13));
		System.out.println(new PerfectSquare279().numSquares2(13));
	}
	
	
	/**
	 * 这里使用动态规划的方法来解决。
	 * 
	 * @param n
	 * @return
	 */
	public int numSquares2(int n) {
		
		if(n < 2) return 1;
		int sq = (int)Math.sqrt(n);
		if(sq*sq == n) return 1;
		
		int dp[] = new int[n+1];
		dp[0] = 0;
		dp[1] =1;
		for(int i =2; i < n+1;i++){
			int min = Integer.MAX_VALUE;
			int j =1;
			while(i-j*j>-1){
				min = Math.min(min, dp[i-j*j]+1);
				j++;
			}
			dp[i] = min;
		}
		return dp[n];
	}
        
		
	
	
	public int numSquares(int n) {
	        
	 
		if(n < 2) return 1;
		int sq = (int)Math.sqrt(n);
		if(sq*sq == n) return 1;
		dfs(0, n, sq);
		return min;
	}
	int min = Integer.MAX_VALUE;
	void dfs(int curDeep,int left,int curSquare){
		if(curDeep > min){
			return;
		}
		if(left == 0){
			if(curDeep < min){
				min = curDeep;
			}
			return;
		}
		if(left < 0) return;
		if(curSquare == 0) return;
		int c = left / (curSquare*curSquare);
		for(int i = c; i>=0;i--)
			dfs(curDeep+i, left-i*curSquare*curSquare, curSquare-1);
	}
}
