package qiang.leetcode;

import javax.swing.text.html.MinimalHTMLWriter;

public class MaximalSquare221 {

	
	
    public static  int maximalSquare2(char[][] matrix) {
    	int ans=0;
    	if(matrix == null || matrix.length==0) return 0;
    	int size1 = matrix.length;
    	int size2 = matrix[0].length;
    	int dp[][] = new int[size1][size2];
    	// 初始化
    	for(int i=0; i< size1;i++){
    		//dp[i][0]= matrix[i][0]=='1'? 1:0;
    		if(matrix[i][0]=='1'){
    			dp[i][0]= 1;
    			ans = 1;
    		}
    	}
    	for(int j=0; j< size2;j++){
    		//dp[0][j]= matrix[0][j]=='1'? 1:0;
    		if(matrix[0][j]=='1'){
    			dp[0][j]= 1;
    			ans = 1;
    		}
    	}
    	// 
//    	int minSize = size1>size2? size2 : size1;
    	
    	for(int i=1; i<size1; i++){
    		for(int j=1;j<size2;j++){
    			if(matrix[i][j] == '0'){
    				dp[i][j] =0;
    			}else{
    				dp[i][j] = min3Num(dp[i-1][j-1],dp[i][j-1],dp[i-1][j])+1;
    				if(dp[i][j]>ans){
    					ans = dp[i][j];
    				}
    			}
    		}
    	}
    	
    	return ans*ans;
    }
	
	static int min3Num(int a, int b,int c){
		a = a>b? b:a;
		return  a>c? c:a;
	}
	/*
	 * (竟然是正方形。。。下面的方法肯定是错误的)
	 * 想法一，使用dp[i][j][m][n]分别记录左上角（i,j）和右下角(m,n)这两个点构建的矩形是否全是1，
	 * dp[i][j][m][n]又由其他小问题构成，实际上只要枚举矩形的长和宽以及一个点，就可以确定一个矩形。
	 * dp[i][j][m]-1[n-1] dp[i][n][m][n-1] dp[m][j][m][n-1]  dp[m-1][n-1][m][n] 
	 * 如果都为true,那么 dp[i][j][m][n]就为true，否则falase，同时更新max。
	 * 
	 */
    public static  int maximalREC(char[][] matrix) {
    	int ans=0;
    	if(matrix == null || matrix.length==0) return 0;
    	int size1 = matrix.length;
    	int size2 = matrix[0].length;
    	boolean dp[][][][] = new boolean[size1][size2][size1][size2];
    	// 初始化
    	for(int i=0; i< size1;i++){
    		for(int j=0; j<size2; j++){
    			dp[i][j][i][j] = matrix[i][j]=='1'? true:false;
    		}
    	}
    	// 
    	
    	for(int i=0; i<size1; i++){
    		for(int j=0;j<size2;j++){
    			for(int m = i+1;m<size1;m++){
    				for(int n = j+1; n<size2;n++){
    					if(dp[i][j][m-1][n-1] && dp[i][n][m-1][n]&&dp[m][n][m][n]&&dp[m][j][m][n-1]){
    						dp[i][j][m][n] =true;
    						int temp = (m-i+1)*(n-j+1);
    						if(temp > ans) {
    							ans = temp;
    							//System.out.println(ans);
    						}
    					}
    				}
    			}
    		}
    	}
    	
    	return ans;
    }
	
    public static  int maximalSquare(char[][] matrix) {
    	int ans=0;
    	if(matrix == null || matrix.length==0) return 0;
    	int size1 = matrix.length;
    	int size2 = matrix[0].length;
    	if(size2 == 0) return 1;
    	boolean dp[][][][] = new boolean[size1][size2][size1][size2];
    	// 初始化
    	for(int i=0; i< size1;i++){
    		for(int j=0; j<size2; j++){
    			dp[i][j][i][j] = matrix[i][j]=='1'? true:false;
    		}
    	}
    	// 
//    	int minSize = size1>size2? size2 : size1;
    	for(int i=0; i<size1; i++){
    		for(int j=0;j<size2;j++){
    			for(int m = 1;(m+i)<size1 && (m+j)<size2;m++){
    				//for(int n = j+1; n<size2;n++){
    					if(dp[i][j][m+i-1][j+m-1] && dp[i][j+m][m+i-1][j+m]&&dp[i+m][j+m][i+m][j+m]&&dp[m+i][j][m+i][j+m-1]){
    						dp[i][j][i+m][j+m] =true;
    						int temp =(m+1)*(m+1);
    						if(temp > ans) {
    							ans = temp;
    							//System.out.println(ans);
    						}
    				}
    			}
    		}
    	}
    	
    	return ans;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][]matrix = {
				{'1', '0', '1', '0', '0'},
				{'1' ,'0' ,'1', '1' ,'1'},
				{'1' ,'1' ,'1', '1' ,'1'},
				{'1', '0', '0', '1' ,'0'}
		};
		char [][] mm = new char[1][1];
		mm[0][0]='1';
		System.out.println(maximalSquare2(mm));
	}

}
