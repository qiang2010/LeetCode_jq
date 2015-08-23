package qiang.leetcode;

public class ValidSudoku36 {
	
	
	
	public boolean isValidSudoku(char[][] board) {
		
		if(board == null ) return false;
		int size = board.length;
		
		for(int i = 0 ; i < size; i++){
			for(int j = 0 ; j < size; j++){
				
				for(int k = 0 ; k < size; k++){
					if(board[i][j]=='.')break;
					if(board[k][j]!='.'&& k!=i && board[k][i]==board[i][j]){
						return false;
					}
					if(board[i][k]!='.'&& k!=j && board[i][k]==board[i][j]){
						return false;
					}
				}
			}
		}
		
		int m = 0 ,n =0; 
		
		
		return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
