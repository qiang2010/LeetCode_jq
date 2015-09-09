package qiang.dfs;

import qiang.tree.TreeAlg;

public class WordSearch79 {

	
    public boolean exist(char[][] board, String word) {
      
    	if(board == null || word == null) return false;
    	int row = board.length;
    	int col = board[0].length;
    	int wordSize = word.length();
    	boolean findFlag= false;
    	boolean pathBoard[][] = new boolean[row][col];
    	for(int i = 0; i < row; i++){
    		
    		for( int j = 0; j< col; j++){
    			
    			if(board[i][j] == word.charAt(0)){
    				//if(wordSize < (row-i) && wordSize < (col-j)) return false;
    				pathBoard[i][j] = true;
    				findFlag = find(pathBoard,board, row, col, i, j, word, wordSize, 0);
    				if(findFlag) return true;
    			}
    			pathBoard[i][j] = false;
    		}
    	}
    	return false;
    }	
    
    /**
     *  在深度搜索的时候要保证x y 和wordIndex在范围内。
     * @param board
     * @param x
     * @param y
     * @param word
     * @param wordIndex
     * @return
     */
    boolean find(boolean [][]pathBoard,char [][]board , int row,int col , int x, int y, String word,int size,int wordIndex){
    	
    	// 如果已经走出去了
    	if(x >row-1 || y > col-1  || x < 0 || y < 0) return false;
    	if(board[x][y] == word.charAt(wordIndex) && size == wordIndex+1  ){
    		return true;
    	}
    	
    	boolean left = false,right = false,top = false,bottom = false;
    	// 是否可以继续走，如果x y所在位置的字符和 word的相应字符相同表示，
    	//可以继续往下走。那么就往四个方向都走走,只要有一个方向走的通，就返回true，其他不用再走了。
    	if(board[x][y] == word.charAt(wordIndex)){
    		if(x+1<row && pathBoard[x+1][y]==false){
    			pathBoard[x+1][y] = true;
    			left  = find(pathBoard,board, row, col, x+1, y, word, size, wordIndex+1);
    			pathBoard[x+1][y] = false;
    		}
    		if(left) return true;
    		
    		if(y+1 < col && pathBoard[x][y+1]==false){
    			pathBoard[x][y+1] = true;
    			right  = find(pathBoard,board, row, col, x, y+1, word, size, wordIndex+1);
    			pathBoard[x][y+1] = false;
    		}
    		if(right) return true;
    		
    		if(x-1 > -1 && pathBoard[x-1][y]==false){
    			pathBoard[x-1][y] = true;
    			top  = find(pathBoard,board, row, col, x-1, y, word, size, wordIndex+1);
    			pathBoard[x-1][y] = false;
    		}
    		if(top) return true;
    		
    		if(y-1 >-1 && pathBoard[x][y-1]==false){
    			pathBoard[x][y-1] = true;
    			bottom  = find(pathBoard,board, row, col, x, y-1, word, size, wordIndex+1);
    			pathBoard[x][y-1] = false;
    		}
    		
    		return bottom;
    	}
    	return false;
    }
	public static void main(String[] args) {
		WordSearch79 ws = new WordSearch79();
		String[]listStrings = {"FYCENRD","KLNFINU","AAARAHR","NDKLPNE","ALANSAP","OOGOTPN","HPOLANO"};
		
		char [][]board = new char[listStrings.length][];
		int i =0;
		for(String temp:listStrings){
			board[i++] = temp.toCharArray();
		}
		
		System.out.println(ws.exist(board, "FRANCE"));
	}

}
