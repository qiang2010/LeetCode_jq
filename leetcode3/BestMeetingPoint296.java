package qiang.leetcode3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestMeetingPoint296 {

	
	  public int minTotalDistance(int[][] grid) {
		  if(grid == null)return 0;
		  int r = grid.length;
		  if(r == 0) return 0;
		  int c = grid[0].length;
		  ArrayList<Integer>  xList = new ArrayList<>();
		  ArrayList<Integer>  yList = new ArrayList<>();
		  for(int i =0;i<r;i++)
			  for(int j = 0;j<c;j++){
				  if(grid[i][j] == 1){
					  xList.add(i);
					  yList.add(j);
				  }
			  }
		  // 可以不对x方向排序
		  Collections.sort(yList);
		  return minXY(xList)+minXY(yList);
	  }
	  int minXY(List<Integer> li){
		  int re =0 ;
		  int i = 0,j = li.size()-1;
		  while(i <j){
			  re+= li.get(j--)-li.get(i--);
		  }
		  return re;
	  }
}
