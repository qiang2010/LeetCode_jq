package qiang.leetcode2;

import java.util.HashSet;

public class ValidSudoku36 {
	
	
	
	public boolean isValidSudoku(char[][] board) {
		
		if(board == null ) return false;
		int size = board.length;
		
		for(int i = 0 ; i < size; i++){
			for(int j = 0 ; j < size; j++){
				if(board[i][j]=='.')continue;
				for(int k = 0 ; k < size; k++){
					if(board[k][j]!='.'&& k!=i && board[k][j]==board[i][j]){
						return false;
					}
					if(board[i][k]!='.'&& k!=j && board[i][k]==board[i][j]){
						return false;
					}
				}
			}
		}
		
		int m = 0 ,n =0;
		HashSet<Character> nu = new HashSet<Character>();
		for(m=0;m<9;m+=3){
			for(n=0;n<9;n+=3){
				nu.clear();
				for(int i=m; i < m+3;i++){
					for(int j = n;j < n+3;j++){
						if(board[i][j]!='.'){
							if(nu.contains(board[i][j]))
								return false;
							else{
								nu.add(board[i][j]);
							}
						}
					}
				}
			}
		}
		
		return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []boardString ={"..4...63.",
				".........",
				"5......9.",
				"...56....",
				"4.3.....1",
				"...7.....",
				"...5.....",
				".........",
				"........."};
		char [][]board = new char[9][9];
		for(int i =0 ; i < 9;i++){
			for(int j =0 ; j < 9 ; j ++){
				board[i][j] = boardString[i].charAt(j);
			}
		}
		ValidSudoku36 vs = new ValidSudoku36();
		System.out.println(vs.isValidSudoku(board));
	}

}
