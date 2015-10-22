package qiang.bfs;

import java.util.LinkedList;

public class NumberOfIsland200 {

	
   class Node{
	   int i=-1 ,j=-1;
	   public Node(int i ,int j ){
		   this.j = j;
		   this.i = i;
	   }
   }
	
	public int numIslands(char[][] grid) {
        
		int ans = 0;
		if(grid == null || grid.length == 0) return ans; 
		int row = grid.length;
		int col = grid[0].length;
		for(int i = 0; i< row; i++ ){
			for( int j = 0 ; j <col; j++){
				if(grid[i][j]=='1'){
					ans++;
					bfs(grid, i, j);
				}
			}
			
		}
		return ans;
	}
	
	
	private void bfs(char [][]grid,int i,int j){
		int row = grid.length;
		int col = grid[0].length;
		if(i < 0 || i > row-1 || j < 0 || j > col-1) return ;
		if(grid[i][j]=='0'){
			return ;
		}
		
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(new Node(i,j));
		Node tempNode;
		int tempI,tempJ;
		while(!queue.isEmpty()){
			tempNode = queue.getFirst();
			queue.removeFirst();
			tempI = tempNode.i;
			tempJ = tempNode.j;
			if(tempI-1>-1 && grid[tempI-1][tempJ]=='1'){
				grid[tempI-1][tempJ]='0';
				queue.addLast(new Node(tempI-1,tempJ));
			}
			if(tempJ-1>-1 && grid[tempI][tempJ-1]=='1'){
				grid[tempI][tempJ-1]='0';
				queue.addLast(new Node(tempI,tempJ-1));
			}
			
			if(tempI+1< row && grid[tempI+1][tempJ]=='1'){
				grid[tempI+1][tempJ]='0';
				queue.addLast(new Node(tempI+1,tempJ));
			}
			if(tempJ+1 < col && grid[tempI][tempJ+1]=='1'){
				grid[tempI][tempJ+1]='0';
				queue.addLast(new Node(tempI,tempJ+1));
			}
		}
	}
	
	public static void main(String[] args) {
		
		char [][] grid = {{'1','1','1'},{'0','0','0'},{'0','0','0'}};
		
		System.out.println(new NumberOfIsland200().numIslands(grid));
		
	}
	
}
