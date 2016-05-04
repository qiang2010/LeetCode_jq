package qiang.bfs;

import java.util.LinkedList;

public class SmallestRectangleEnclosingBlackPixels302 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] image = {"0010",
				"0110",
				"0100"};
		SmallestRectangleEnclosingBlackPixels302 cc= new SmallestRectangleEnclosingBlackPixels302();
		System.out.println(cc.minArea(image, 0, 2));
	}

	
	class Point{
		int x,y;
		Point(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	int left=Integer.MAX_VALUE,right =0,top = Integer.MAX_VALUE,down=0;
	int minArea(String []image,int x,int y){
		if(image == null) return 0;
		LinkedList<Point> queue = new LinkedList<>();
		if(image[x].charAt(y) =='0')return 0;
		int row = image.length;
		int col = image[0].length();
		boolean [][]visited = new boolean[row][col];
		queue.addLast(new Point(x,y));
		Point topP;
		int [][]dirs = {{0,-1},{0,1},{-1,0},{1,0}};
		
		int newX,newY;
		while(!queue.isEmpty()){
			topP = queue.getFirst(); queue.removeFirst();
			updateMarg(topP);
			for(int i =0;i<4;i++){
				newX = topP.x + dirs[i][0];
				newY = topP.y + dirs[i][1];
				if(newX < 0 || newY <0 || newX > row-1 || newY > col-1 || visited[newX][newY] || image[newX].charAt(newY)=='0')continue;
				visited[newX][newY] = true;
				queue.addLast(new Point(newX,newY));
			}
		}
		return (down - top+1)*(right-left+1);
	}
	
	void updateMarg(Point p){
		left = left < p.x ? left:p.x;
		right = right < p.x ? p.x:right;
		top = top < p.y ? top:p.y;
		down = down < p.y? p.y:down;
	}
	
}
