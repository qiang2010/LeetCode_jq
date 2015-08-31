package qiang.leetcode;

public class EditDistance72 {

	
	
    public static int minDistance(String word1, String word2) {
     
    	int s1=0,s2=0;
    	if(word1==null && word2 != null) return word2.length();
    	if(word1!=null && word2 == null) return word1.length();
    	if(word1==null && word2 == null) return 0;
    	s1 = word1.length();
    	s2 = word2.length();
    	if(s1 == 0 ) return s2;
    	if(s2 == 0 ) return s1;
    	int [][]dp = new int[s1+1][s2+1];
    	for(int i =0; i < s2+1; i++){
    		dp[0][i] = i;
    	}
    	for(int i =0; i < s1+1; i++){
    		dp[i][0] = i;
    	}
    	
    	for(int i=1; i < s1+1; i++){
    		for(int j=1;j < s2+1; j++){
    			dp[i][j] = dp[i][j-1]+1;
    			if(dp[i][j] > dp[i-1][j]+1 ){
    				dp[i][j] = dp[i-1][j]+1;
     			}
    			int flag = 1;
    			if(word1.charAt(i-1) == word2.charAt(j-1)){
    				flag = 0;
    			}
    			if(dp[i][j] > dp[i-1][j-1]+flag){
    				dp[i][j] = dp[i-1][j-1]+flag;
    			}
    		}
    	
    	}
    	return dp[s1][s2];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(minDistance("pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopically"));
	}

}
