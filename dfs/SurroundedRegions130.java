package qiang.dfs;

import java.util.LinkedList;

import qiang.leetcode.util.PrintUtil;

public class SurroundedRegions130 {

	
    public void solve(char[][] board) {
       
    	if(board == null) return ;
    	if(board.length==0) return ;
    	int row = board.length;
    	int col = board[0].length;
    	boolean [][]boardFlag = new boolean[row][col];		
    	for(int i = 0 ; i < row; i ++){
    		for(int j =0; j < col; j++){
    			if(board[i][j]=='x'){
    				boardFlag[i][j] = true;
    			}
    		}
    	}
    	
//    	for(int i = 0 ; i < row; i++){
//    		if(boardFlag[i][0]==false){
//    			dfs(boardFlag,i,0);
//    		}
//    		if(boardFlag[i][col-1]==false){
//    			dfs(boardFlag,i,col-1);
//    		}
//    	}
//      	for(int i = 0 ; i < col; i++){
//    		if(boardFlag[0][i]==false){
//    			dfs(boardFlag,0,i);
//    		}
//    		if(boardFlag[row-1][i]==false){
//    			dfs(boardFlag,row-1,i);
//    		}
//    	}
    	for(int i = 0 ; i < row; i++){
    		if(boardFlag[i][0]==false){
    			bfs(boardFlag,i,0);
    		}
    		if(boardFlag[i][col-1]==false){
    			bfs(boardFlag,i,col-1);
    		}
    	}
      	for(int i = 0 ; i < col; i++){
    		if(boardFlag[0][i]==false){
    			bfs(boardFlag,0,i);
    		}
    		if(boardFlag[row-1][i]==false){
    			bfs(boardFlag,row-1,i);
    		}
    	}
      
      	
    	for(int i = 0 ; i < row; i ++){
    		for(int j =0; j < col; j++){
    			if(!boardFlag[i][j]){
    				board[i][j] = 'X';
    			}
    		}
    	}
    	
    }	
	public void dfs(boolean[][]boardFlag,int i ,int j){
		
		if(i< 0 || i> boardFlag.length-1 || j <0 || j> boardFlag[0].length-1 || boardFlag[i][j]==true)
			return;
		boardFlag[i][j]= true;
		// 想四个方向深度检索。
		dfs(boardFlag, i-1, j);
		dfs(boardFlag, i+1, j);
		dfs(boardFlag, i, j-1);
		dfs(boardFlag, i, j+1);
	}
	class Point{
		int i ,j;
		Point(int i,int j){
			this.i = i;
			this.j = j;
		}
	}
	private void bfs(boolean [][]boardFlag,int i ,int j){
		LinkedList<Point> queue = new LinkedList<>();
		queue.addLast(new Point(i,j));
		boardFlag[i][j] = true;
		Point topPoint;
		int row = boardFlag.length;
		int col = boardFlag[0].length;
		int tempRow,tempCol;
		while(!queue.isEmpty()){
			topPoint = queue.getFirst();
			queue.removeFirst();
			tempRow = topPoint.i;
			tempCol = topPoint.j;
			if(tempRow-1>-1 && !boardFlag[tempRow-1][tempCol]){
				boardFlag[tempRow-1][tempCol] = true;
				queue.addLast(new Point(tempRow-1,tempCol));
			}
			if(tempRow+1< row && !boardFlag[tempRow+1][tempCol]){
				boardFlag[tempRow+1][tempCol] = true;
				queue.addLast(new Point(tempRow+1,tempCol));
			}
			if(tempCol-1>-1 && !boardFlag[tempRow][tempCol-1]){
				boardFlag[tempRow][tempCol-1] = true;
				queue.addLast(new Point(tempRow,tempCol-1));
			}
			if(tempCol+1<col && !boardFlag[tempRow][tempCol+1]){
				boardFlag[tempRow][tempCol+1] = true;
				queue.addLast(new Point(tempRow,tempCol+1));
			} 
		}
	}
	
	public static void main(String[] args) {
		char [][]board= {{'x','x','x'},
						 {'x','o','x'},
						 {'x','x','x'}};
		new SurroundedRegions130().solve(board);
		PrintUtil.printArray(board);
	}
}
