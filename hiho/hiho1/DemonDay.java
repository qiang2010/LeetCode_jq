package qiang.hiho.hiho1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DemonDay {

	public static void main(String[] args) {
		DemonDay dd = new DemonDay();
		dd.process();
	}
	int row;
	int col;
	
	void process(){
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String []nm = in.readLine().split("\\s+");
			row = Integer.parseInt(nm[0]);
//			System.out.println(N);
			col = Integer.parseInt(nm[1]);
			String[] grid = new String[row];
			for(int i =0;i<row;i++){
				grid[i] = in.readLine();
//				System.out.println(grid[i]);
			}
			if(row == 1 && col == 1){
				System.out.println(grid[0].charAt(0)=='b' ?1:0);
				return;
			}
			int [][][]dp = new int[row][col][2];
			// 初始化第一行
			dp[0][0][0] = grid[0].charAt(0) =='b'? 1:0;
			dp[0][0][1] = Integer.MAX_VALUE;
			for(int j = 1;j < col;j++){
				dp[0][j][0] = dp[0][j-1][0] + (grid[0].charAt(j) =='b'? 1:0);
				dp[0][j][1] = Integer.MAX_VALUE;
			}
			if(!isNotVaidPos(1, 0)){
				dp[1][0][1] = gridInt(grid[1].charAt(0))+ ((isNotVaidPos(0,1) ||  (gridInt(grid[0].charAt(1)) == 1)) ? 0:1);
				dp[1][0][0] = Integer.MAX_VALUE;
			}
			for(int j = 2; j < row; j ++){
				dp[j][0][0] = Integer.MAX_VALUE;
				dp[j][0][1] = dp[j-1][0][1] + gridInt(grid[j].charAt(0));
			}
			for(int i = 1; i < row;i++){
				for(int j = 1 ;j< col;j++){
					dp[i][j][0] = Math.min(dp[i][j-1][0], dp[i][j-1][1]+((isNotVaidPos(i+1,j-1) ||  (gridInt(grid[i+1].charAt(j-1)) == 1)) ? 0:1)) + gridInt(grid[i].charAt(j));
					dp[i][j][1] = Math.min(dp[i-1][j][0] + ((isNotVaidPos(i-1,j+1) ||  (gridInt(grid[i-1].charAt(j+1)) == 1)) ? 0:1), dp[i-1][j][1]) +gridInt(grid[i].charAt(j));	
				}
			}
			System.out.println(Math.min(dp[row-1][col-1][0], dp[row-1][col-1][1]));
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	int gridInt(char c){
		return c == 'b' ? 1:0;
	}
	boolean isNotVaidPos(int i,int j){
		return i > row -1 || j > col-1;
	}
}
