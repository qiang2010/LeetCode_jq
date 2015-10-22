package qiang.dfs;

import java.util.LinkedList;
import java.util.List;

import qiang.leetcode.util.PrintUtil;

public class NQueens52 {
    
	public static void main(String[] args) {
		
		List<List<String>> ans = new NQueens52().solveNQueens(4);
		PrintUtil.print2DList(ans);	
	}
	
	public List<List<String>> solveNQueens(int n) {
    
		
		List<List<String>> ans = new LinkedList<List<String>>();
				
		dfs(ans, new int[n], n, 0);
		return ans;
    }
	void dfs(List<List<String>> ans,int []board,int n,int row){
		
		if(row == n){
			List<String> one = new LinkedList<>();
			StringBuilder sb;
			for(int i=0;i< n;i++){
				sb = new StringBuilder();
				for(int j=0;j<board[i];j++){
					sb.append('.');
				}
				sb.append('Q');
				for(int j = board[i]+1;j<n;j++){
					sb.append('.');
				}
				one.add(sb.toString());
			}
			ans.add(one);
			return;
		}
		for(int k=0;k<n;k++){
			if(isValid(board, row, k)){
				board[row] = k;
				dfs(ans, board, n, row+1);
			}
		}
			
	}
	
	
	/**
	 * row 表示将要处理的行，y表示放到row行的哪个列
	 * @param board
	 * @param row
	 * @param y
	 * @return
	 */
	boolean isValid(int []board,int row,int y){
		for(int i=0;i<row;i++){
			if(board[i]==y)return false;
			if(Math.abs(board[i]-y)==row-i)return false;
		}
		return true;
	}
	
}
