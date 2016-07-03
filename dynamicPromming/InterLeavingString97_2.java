package qiang.dynamicPromming;

public class InterLeavingString97_2 {
   
	
	
	
	public static  boolean isInterleave(String s1, String s2, String s3) {
    
		// 输入的判断
		if(s1 == null && s2 ==null && s3 == null) return true;
		if(s3 == null){
			return false;
		}
		if(s1 == null && s2 !=null){
			return s3.equals(s2);
		}
		if(s1 != null && s2 == null){
			return s3.equals(s1);
		}
		
		int size1 = s1.length();
		int size2 = s2.length();
		int size3 = s3.length();
		if(size1 + size2 != size3)return false; // 长度不同肯定为false
		boolean dp[][]  = new boolean[size1+1][size2+1];
		// 初始化
		dp[0][0] =true;
		for(int i =1;i<size1+1;i++){
			dp[i][0] = dp[i-1][0] && (s1.charAt(i-1) == s3.charAt(i-1));
		}
		for(int i =1; i< size2+1;i++){
			dp[0][i] = dp[0][i-1] && (s2.charAt(i-1) == s3.charAt(i-1));
		}
		for(int i =1;i<size1+1;i++)
			for(int j =1;j < size2+1;j++){
				dp[i][j] = (dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1)) ||
						(dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
			}
		return dp[size1][size2];
    }
	
	
	
	
	public static void main(String[] args) {
		System.out.println(isInterleave("ab", "bc", "babc"));
		
		System.out.println(true ? false: false || true ? true : false);
		System.out.println(true ? true: false && false);
		
	}
}
