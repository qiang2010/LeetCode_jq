package qiang.dynamicPromming;

public class DistinctSubsequences115 {
	
	/**
	 * t in s
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public int numDistinct(String s, String t) {
	        
		if(t == null || s == null) return 0;
		int sSize = s.length();
		int tSize = t.length();
		if(sSize<tSize) return 0;
		int dp[][] = new int[sSize][tSize];
		
		if(s.charAt(0)==t.charAt(0)){
			dp[0][0] = 1;
		}
		
		for(int i =1; i < sSize; i++){
			dp[i][0] =dp[i-1][0]; 
			if(s.charAt(i)==t.charAt(0))
				dp[i][0] += 1;
		}
		
		for(int i=1;i<sSize; i++){
			for(int j = 1; j<tSize &&j <= i; j++ ){
				if(s.charAt(i)==t.charAt(j)){
					dp[i][j] =dp[i-1][j]+dp[i-1][j-1]; 
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[sSize-1][tSize-1];
	}
	
	public static void main(String[] args) {
		
		System.out.println(new DistinctSubsequences115().numDistinct("", "rabbit"));
		
		
	}
	
	
}
