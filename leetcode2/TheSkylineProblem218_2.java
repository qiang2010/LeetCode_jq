package qiang.leetcode2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TheSkylineProblem218_2 {

	class Edge{
		int x;
		int h;
		boolean isStart;
		Edge(int x,int h, boolean isStart){
			this.x = x;
			this.h = h;
			this.isStart = isStart;
		}
	}
    public List<int[]> getSkyline(int[][] buildings) {
    
    	List<int[]> ans = new ArrayList<>();
    	if(buildings == null || buildings.length == 0 || buildings[0].length == 0) return ans;
    	List<Edge> edges = new ArrayList<>();
    	
    	for(int[] oneT:buildings){
    		edges.add(new Edge(oneT[0], oneT[2], true));
    		edges.add(new Edge(oneT[1], oneT[2], false));
    	}
    	edges.sort(com);
        
    	PriorityQueue<Integer> heightHeap = new PriorityQueue<>(Collections.reverseOrder());
    	
    	for(Edge e:edges){
    		if(e.isStart){
    			
    			if(heightHeap.isEmpty() || e.h > heightHeap.peek()){
    				ans.add(new int[]{e.x,e.h});
    			}
    			heightHeap.add(e.h);    			
    		}else{
    			heightHeap.remove(e.h);
    			if(heightHeap.isEmpty()){
    				ans.add(new int[]{e.x,0});
    			}else{
    				if(e.h > heightHeap.peek()){
    					ans.add(new int[]{e.x,heightHeap.peek()});
    				}
    			}
    		}
    	}
    	return ans;
    
    }
    Comparator<Edge> com = new Comparator<Edge>() {

		@Override
		public int compare(Edge a, Edge b) {
			
			if(a.x != b.x){
				// 小到大
				return Integer.compare(a.x,b.x);
			}
			if(a.isStart && b.isStart){
				//高度较大的放前面,先处理较高的，那么较低的就不会被加入到解集合中。
				return Integer.compare(b.h, a.h);
			}
			
			if(!a.isStart && !b.isStart){
				// 小的在前，因为要先处理较低的，否则也会将其加入到解集合中。
				return Integer.compare(a.h, b.h);
			}
			// 一个是起始边，一个是终止边，起始边要在前面。
			return a.isStart? -1:1;
		}
    	
	};
	
}
