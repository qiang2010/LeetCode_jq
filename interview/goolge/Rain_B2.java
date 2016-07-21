package qiang.interview.goolge;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import qiang.util.FileUtil;

public class Rain_B2 {
	public static void main(String[] args) {
		
		Rain_B2 ss = new Rain_B2();
		ss.solutaion();
		
	}
	void solutaion(){
		String path = "E:\\googlejam\\";
		int aNun = 3;
		String sm = "B-small-practice.in";
		String big = "B-large-practice.in";
		int base= 1000000007 ;
		String test = "1.txt";
		int samllf = 2;
		FileUtil file  =null;
		FileUtil ansFile  =null;
		if(samllf == 0){
			file = new FileUtil(path+test);
			ansFile = new FileUtil(path+"test.out");
		}else if(samllf == 1){// small
			file = new FileUtil(path+sm);
			ansFile = new FileUtil(path+"samll.out");
		}else{
			if(samllf==2){ // big{
				 file = new FileUtil(path+big);
				ansFile = new FileUtil(path+"large.out");
			}
		}
		int size = Integer.parseInt(file.readLine());
		for(int i = 0 ;i< size;i++){
			String []li = file.readLine().split(" ");
			int R = Integer.parseInt(li[0]);
			int C = Integer.parseInt(li[1]);
			int [][] board = new int[R][C];
			for(int r =0;r<R;r++){
				String []cc = file.readLine().split(" ");
				for(int cccc =0;cccc<C;cccc++){
					board[r][cccc] = Integer.parseInt(cc[cccc]);
				}
			}
			int wa = trapRainWater(board);
				ansFile.writeLine("Case #"+(i+1)+": "+wa);	
			System.out.println("Case #"+(i+1)+": "+wa);
		}
//		in.close();
	}
	    /**
	     * @param heights: a matrix of integers
	     * @return: an integer
	     */
	    class Point{
	       int height;
	       int x, y;
	       Point(int height, int x, int y) {
	           this.height = height;
	           this.x = x;
	           this.y = y;
	       }
	    }

	    public int trapRainWater(int[][] heights) {
	        // write your code here
	        // modified dijkstra algorithm
	        // level: level of water each cell can hold
	        // height: height of cell
	        // initialization: border elements: height = level, inner: level = MAX
	        // minheap to store border cells. Then update level of inner cells
	        // by this logic: update_level = Math.max(cell_height, Math.min(neighout_level, old_level))
	        // time complexity: O(n^2*logN) // maintains min heap property
	        int row = heights.length;
	        if (row == 0) {
	            return 0;
	        }
	        int col = heights[0].length;
	        PriorityQueue<Point> minHeap = new PriorityQueue<Point>(10, new Comparator<Point>() {
	            public int compare(Point a, Point b) {
	                return a.height - b.height;
	            }
	        });
	        boolean visited[][] = new boolean[row][col];
	        for(int i =0; i < row;i++){
	        	 Point p = new Point(heights[i][0], i, 0);
                 minHeap.add(p);
                 visited[i][0] = true;
	        	 p = new Point(heights[i][col-1], i, col-1);
                 minHeap.add(p);
                 visited[i][col-1] = true;
	        }
	        for(int i =0; i < col;i++){
	        	 Point p = new Point(heights[0][i],  0,i);
                minHeap.add(p);
                visited[0][i] = true;
	        	 p = new Point(heights[row-1][i], row-1,i);
                minHeap.add(p);
                visited[row-1][i] = true;
	        }
	        int dx[] ={1,-1,0,0};
	        int dy[] ={0,0,1,-1};
	        int sum = 0;
	        while (!minHeap.isEmpty()) {
	            Point p = minHeap.poll();
	            for(int k = 0; k < 4;k++){
	            	int nx = p.x + dx[k];
	            	int ny = p.y + dy[k];
	            	if(nx<0 || ny<0 || nx > row-1 || ny > col-1) continue;
	            	if(visited[nx][ny]) continue;
	            	visited[nx][ny] = true;
	            	minHeap.add(new Point(Math.max(p.height, heights[nx][ny]), nx, ny));
	            	sum += Math.max(0,p.height-heights[nx][ny]);
	            }
	        }
	        return sum;
	    }
}
