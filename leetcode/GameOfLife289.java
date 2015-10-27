package qiang.leetcode;

public class GameOfLife289 {

	  
	
	public void gameOfLife(int[][] board) {
		
		if(board == null || board.length == 0 || board[0].length == 0) return;
		int row = board.length;
		int col = board[0].length;
		int c;
		for(int x =0;x<row;x++){
			for(int y =0;y<col;y++){
				c = countNumOfOne(x, y, board, row, col);
				if(board[x][y] ==1){
					if(c <2 || c > 3){
						board[x][y] = -1;
					}
				}else{
					if(c == 3){
						board[x][y] = 2;
					}
				}
			}
		}
		for(int x =0;x<row;x++){
			for(int y =0;y<col;y++){
				if(board[x][y] == -1  ){
					board[x][y] =0;
				}
				if(board[x][y] == 2){
					board[x][y] =1;
				}
			}
		}
	
	}
	int countNumOfOne(int x,int y,int[][] board,int row,int col){
		int ans = 0;
		int []xDis = {-1,0,1};
		int []yDis = {-1,0,1};
		int newX,newY;
		for(int i =0;i<3;i++){
			newX = x+xDis[i];
			for(int j =0;j < 3;j++){
				if(i ==1 && j==1)continue;
				newY = y+yDis[j];
				if(newX >-1 && newY >-1 && newX <row && newY <col){
					if(board[newX][newY] == 1 || board[newX][newY] == -1)
						ans++;
				}
			}
		}
		return ans;
	}
	
}
