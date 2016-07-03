package qiang.leetcode4;

public class DesignTicTacToe348 {

	
	int []rows;
	int []cols ;
	int diag ;
	int rev_diag;
	int N ;
	public DesignTicTacToe348(int n){
		
		rows = new int[n];
		cols = new int[n];
		diag = 0;
		rev_diag = 0;
		N = n;
	}
	
	int move(int row,int col,int player){
		int add = player == 1? 1:-1;
		rows[row] +=add;
		cols[col] += add;
		if(row == col){
			diag += add;
		}
		if(row + col ==  N -1){
			this.rev_diag+=add;
		}
		if(Math.abs(rows[row]) == N || Math.abs(cols[col])== N || Math.abs(diag) == N || Math.abs(rev_diag)==N){
			return player;
		}
		return 0;
	}
	
}
