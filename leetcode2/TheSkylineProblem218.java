package qiang.leetcode2;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class TheSkylineProblem218 {

 
	class Edge{
		int x;
		int h;
		boolean isStart;
		public Edge(int x,int h,boolean isStart){
			this.x = x;
			this.h = h;
			this.isStart = isStart;
		}
	}
	Comparator<Edge> com = new Comparator<Edge>(){
		
		@Override
		public int compare(Edge a,Edge b){
			
			if(a.x != b.x)return Integer.compare(a.x, b.x);
			if(a.isStart && b.isStart) return Integer.compare(b.h, a.h);
			if(!a.isStart && !b.isStart) return Integer.compare(a.h, b.h);
			return a.isStart ?-1:1;
		}
		
	};
    public List<int[]> getSkyline(int[][] buildings) { 
    	LinkedList<int[]> ans = new LinkedList<>();
    	if(buildings == null || buildings.length == 0 ) return ans;
    	LinkedList<Edge> edges = new LinkedList<>();
    	for(int i = 0 ;i<buildings.length;i++){
    		edges.add(new Edge(buildings[i][0],buildings[i][2],true));
    		edges.add(new Edge(buildings[i][1],buildings[i][2],false));
    	}
    	edges.sort(com);
    	PriorityQueue<Integer> heightMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
    	for(Edge e:edges){
    		
    		if(e.isStart){
    			if(heightMaxHeap.isEmpty() || e.h > heightMaxHeap.peek()){
    				ans.add(new int[]{e.x,e.h});
    			}
    			heightMaxHeap.add(e.h);
    		}else{
    			heightMaxHeap.remove(e.h);
    			if(heightMaxHeap.isEmpty()){
    				ans.add(new int[]{e.x,0});
    			}else{
    				if(e.h > heightMaxHeap.peek()){
    					ans.add(new int[]{e.x,heightMaxHeap.peek()});
    				}
    			}
    			
    		}
    	}
    	return ans;
    }
    
}
