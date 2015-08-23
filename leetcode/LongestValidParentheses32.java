package qiang.leetcode;

public class LongestValidParentheses32 {
    
	
	
	public int longestValidParentheses(String s) {
    
		if( s == null || "".equals(s)) return 0;
		int ans=0;
		int size = s.length();
		int dp[] = new int[size];
		int edge;
		for(int k = size-2; k > -1; k--){
			if( s.charAt(k) == '('){
				edge = k + dp[k+1]+1;
				if(edge < size && s.charAt(edge)==')'){
					dp[k] = dp[k+1]+2;
					//比如对于这种情况()()
					if(edge+1<size){
						dp[k]+=dp[edge+1];
					}
				}
				if(dp[k] > ans){
					ans = dp[k];
				}
			}
		}
		
		return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestValidParentheses32 lp  = new LongestValidParentheses32();
		System.out.println(lp.longestValidParentheses("()()(()"));
	}

}
