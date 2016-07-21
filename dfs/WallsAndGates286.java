package qiang.dfs;

public class WallsAndGates286 {
	
	
	
	public void wallsAndGates(int[][] rooms) {
		
		if(rooms == null) return;
		for(int i =0;i< rooms.length;i++)
			for(int j =0;j< rooms[0].length;j++){
				if(rooms[i][j] == 0)
					dfs(rooms, i, j, 0);
			}
		
	}
	void dfs(int [][]rooms,int i ,int j,int d){
		if(i < 0 || j < 0 || i > rooms.length-1 || j > rooms[0].length-1 || rooms[i][j] < d)
			return;
		dfs(rooms, i+1, j, d+1);
		dfs(rooms, i-1, j, d+1);
		dfs(rooms, i, j+1, d+1);
		dfs(rooms, i, j-1, d+1);
	}
}
