package qiang.graph;

import java.util.LinkedList;
import java.util.List;

public class GraphValidTree261 {
	
	public static void main(String[] args) {
		
		GraphValidTree261 gg = new GraphValidTree261();
		int [][] edges = {{0, 1}, {1, 2}, {2, 3},{1,3}, {1, 4}};
		int n = 5;
		System.out.println(gg.validTree(n, edges));
	}
	public boolean validTree(int n, int[][] edges) { 
		if(edges == null)
			if( n > 0) return false;
			else return true;
		if(n<2) return true;
		LinkedList<Integer> less2 = new LinkedList<>();
		List<Integer>[] graph = new List[n];
		int [] degree = new int[n];
		for(int [] e:edges){
			degree[e[0]]++;
			degree[e[1]]++;
			this.addOneEdge(e[0], e[1], graph);
			this.addOneEdge(e[1], e[0], graph);
		}
		// 查看是否有 度 为 0的点。
		for(int i =0;i<n;i++){
			if(degree[i] == 0) return false;
			if(degree[i]==1)less2.add(i);
		}
		// 找到度为1的点集。 假设图中 只有  1-2  3-4 这两条边，那就有问题。
		int ls = less2.size();
		if(ls==2 && n ==2) return true;
		if(ls==n) return false;  
        // 这里使用dfs进行遍历。
		boolean []visited= new boolean[n];
		if(this.iscircle(visited, 0, graph,-1)){
			return false;
		}
		// 是否有多个分支
		for(boolean t:visited){
			if(!t) return false;
		}
		return true;
	}
	boolean iscircle(boolean visited[],int e, List<Integer>[] graph,int father){
		
		if(visited[e]) return true;
		visited[e] = true;
		List<Integer> edges = graph[e];
		for(int ed:edges){
			if(ed==father) continue;
			if(visited[ed]) return true;
			if(this.iscircle(visited, ed, graph,e))return true;
		}
		return false;
	}
	void addOneEdge(int b,int e,List<Integer>[]graph){
		if(graph[b] ==null){
			graph[b] = new LinkedList<Integer>();
		}
		graph[b].add(e);
	}
}
