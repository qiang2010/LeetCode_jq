package qiang.bfs;

import java.util.LinkedList;

public class ShortestDistancefromAllBuildings317 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortestDistancefromAllBuildings317 dd = new ShortestDistancefromAllBuildings317();
		
		
		int [][]grid = {{1,0,2,0,1},
				{0,0,0,0,0},
		{0,0,1,0,0}};
		System.out.println(dd.shortestDistance(grid));
	}

	/**
	 * 首先实现第一种方法
	 * 1.求得所有的1到其他点的距离
	 * 2.求解0到1的距离之和最小值。
	 * @param grid
	 * @return
	 */
	public int shortestDistance(int[][] grid) {

		if(grid == null || grid.length == 0) return 0;
		int row = grid.length;
		int col = grid[0].length;
		int countOne = 0; // 统计1的数量
		for(int i =0;i< row;i++){
			for(int j = 0; j < col;j++){
				if(grid[i][j] == 1) countOne++;
			}
		}
		int dis[][][] = new int[countOne][row][col]; // 记录每个1到其他0的距离。
		int c = 0;
		for(int i =0;i< row;i++){
			for(int j = 0; j < col;j++){
				if(grid[i][j] == 1){
					bfsToGetDis(dis, grid, i, j, row, col, c);
					c++;
				}
			}
		}
		int min = Integer.MAX_VALUE;	
		for(int i =0;i< row;i++){
			for(int j = 0; j < col;j++){
				if(grid[i][j] == 0){
					int te = disFromAllOne(i,j,dis);
					min = Math.min(te, min);
				}
			}
		}
		return min;
	}
	
	
	int disFromAllOne(int x ,int y,int [][][]res){
		
		int ans = 0;
		for(int i =0 ;i<res.length;i++){
			if(res[i][x][y] == 0) return Integer.MAX_VALUE;
			else ans += res[i][x][y] ;
		}
		return ans;
	} 
    void bfsToGetDis(int[][][]dis,int [][]grid,int i,int j,int row,int col,int k){
    	int [][]dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    	boolean visited [][] = new boolean[row][col];
    	LinkedList<int[]> queue = new LinkedList<>();
    	queue.addLast(new int[]{i,j,0});
    	visited[i][j]=true;
    	int top[];
    	int tempX,tempY;
    	while(!queue.isEmpty()){
    		top = queue.getFirst();queue.removeFirst();
    		// 向四个方向走
    		for(int []oneD:dirs){
    			tempX = top[0] + oneD[0];
    			tempY = top[1] + oneD[1];
    			if(tempX > -1 && tempX < row && tempY > -1 && tempY < col && grid[tempX][tempY] == 0 &&visited[tempX][tempY] == false ){
    				dis[k][tempX][tempY] = top[2]+1;
    				visited[tempX][tempY] = true;
    				queue.addLast(new int[]{tempX,tempY,top[2]+1});
    			}
    		}
    	}
    }
}
