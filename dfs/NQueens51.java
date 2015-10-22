package qiang.dfs;


public class NQueens51 {
    
	public static void main(String[] args) {
		
		System.out.println( new NQueens51().totalNQueens(1));
	}
	
	int count =0;
	public int totalNQueens(int n) {
    
		dfs( new int[n], n, 0);
		return count;
    }
	void dfs(int []board,int n,int row){
		
		if(row == n){
			count++;
			return;
		}
		for(int k=0;k<n;k++){
			if(isValid(board, row, k)){
				board[row] = k;
				dfs(board, n, row+1);
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
