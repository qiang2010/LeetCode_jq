package qiang.dynamicPromming;

public class DungeonGame174 {
 
	public static void main(String[] args) {
		
		DungeonGame174 dg = new DungeonGame174();
		int [][]dungeon ={{10}};//{{1,-3,3},{0,-2,0},{-3,-3,-3}};// 
		System.out.println(dg.calculateMinimumHP2(dungeon));
	}
	
	
	public int calculateMinimumHP2(int[][] dungeon) { 

		if(dungeon == null || dungeon.length ==0 || dungeon[0].length == 0) return 0;
		int row = dungeon.length-1;
		int col = dungeon[0].length-1;
		int dp[][] = new int[row+1][col+1];
		dp[row][col] = dungeon[row][col] >= 0 ? 1: -dungeon[row][col]+1;
		
		for(int i=row-1; i>-1;i--){
			dp[i][col] = Math.max(1, dp[i+1][col]-dungeon[i][col]);
		}
		for(int j = col-1; j>-1;j--){
			dp[row][j] = Math.max(1,dp[row][j+1] - dungeon[row][j]);
		}
		for(int i = row-1;i>-1;i--){
			for(int j = col-1;j>-1;j--){
				dp[i][j] = Math.max(1,Math.min(dp[i][j+1], dp[i+1][j])-dungeon[i][j]);
			}
		}
		return dp[0][0];
		
	}
	
	public int calculateMinimumHP(int[][] dungeon) {
		if(dungeon == null || dungeon.length ==0 || dungeon[0].length == 0) return 0;
		int row = dungeon.length;
		int col = dungeon[0].length;
		int init[][] = new int[row][col];
		int cur[][]  = new int[row][col];
		if(dungeon[0][0] < 1){
			init[0][0] = Math.abs(dungeon[0][0]) +1;
			cur[0][0] = 1;
		}else{
			cur[0][0] =  dungeon[0][0]+1;
			init[0][0] = 1;
		}
			
		int dif  = 0;
		for(int i =1 ;i<col ;i++){
			dif = cur[0][i-1]+dungeon[0][i];
			init[0][i] = init[0][i-1];
			if(dif < 1){
				init[0][i] += Math.abs(dif)+1;
				cur [0][i]=1;
			}else{
				cur[0][i] = dif;
			}
		}
		for(int i =1;i<row;i++){
			dif = cur[i-1][0] + dungeon[i][0];
			init[i][0] = init[i-1][0];
			if(dif < 1){
				init[i][0] += Math.abs(dif)+1;
				cur[i][0] = 1;
			}else{
				cur[i][0] = dif;
			}
		}
		
		int topIni,leftIni,topCur,leftCur;
		for(int i =1 ;i<row ;i++){
			for(int j = 1 ; j <col;j++){
				dif = cur[i-1][j] + dungeon[i][j]; // 上面
				topIni = init[i-1][j];
				if(dif < 1){
					topIni += Math.abs(dif)+1;
					topCur = 1;
				}else{
					topCur =  dif;
				}
				dif = cur[i][j-1]+dungeon[i][j];
				leftIni = init[i][j-1];
				if(dif < 1){
					leftIni += Math.abs(dif)+1;
					leftCur = 1;
				}else{
					leftCur = dif;
				}
				if(topIni < leftIni){
					init[i][j] = topIni;
					cur[i][j] = topCur;
				}else{
					if(topIni > leftIni){
						init[i][j] = leftIni;
						cur[i][j] = leftCur;
					}else{
						// 相等的时候
						if(topCur > leftCur){
							init[i][j] = topIni;
							cur[i][j] = topCur;
						}else{
							init[i][j] = leftIni;
							cur[i][j] = leftCur;
						}
					}
					
					
				}
			}
		}
		return init[row-1][col-1];
	}
}
