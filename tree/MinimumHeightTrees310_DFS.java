package qiang.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumHeightTrees310_DFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumHeightTrees310_DFS mi = new MinimumHeightTrees310_DFS();
		int n = 2;
		int [][]edges ={{0, 1}};
		System.out.println(mi.findMinHeightTrees(n, edges));
	}
	class Node{
		int val;
		int minDep;
		Node(int val){
			this.val= val;
			minDep = -1;
		}
		Node(int val,int min){
			this.val= val;
			minDep = min;
		}
	}
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
	        
		// 构建图。
		Map<Integer,List<Node>> graph = new HashMap<>();
		for(int[] edge:edges){
			addOneEdge(edge[0],edge[1],graph);
			addOneEdge(edge[1],edge[0],graph);
		}
		boolean []visited = new boolean[n];
		int min = Integer.MAX_VALUE;
		Comparator<Node> com = new Comparator<Node>(){
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.minDep> o2.minDep) return 1;
				return -1;
			}
		};
		PriorityQueue<Node> ans = new PriorityQueue<>(com);
		for(int i =0; i < n;i++){
			visited[i] = true;
			int cur = dfs(i,visited,graph);
			if(cur <= min){
				ans.add(new Node(i,cur));
				min = cur;
			}
			visited[i]= false;
		}
		List<Integer> an = new ArrayList<>();
		Node t = ans.poll();
		an.add(t.val);
		min = t.minDep;
		while(!ans.isEmpty()){
			t = ans.poll();
			if(t.minDep == min){
				an.add(t.val);
			}else{
				return an;
			}
		}
		return an;
	}
	int dfs(int curNode,boolean []visited,Map<Integer,List<Node>> graph){
		
		int max = Integer.MIN_VALUE; // 对每个地点要求其最大的深度。
		List<Node> edges = graph.get(curNode);
		if(edges == null) return 0; // 没有邻边
		for(Node n:edges){
			if(visited[n.val])continue;
			visited[n.val] = true;
			if(n.minDep < 0){
				int m = dfs(n.val,visited,graph)+1;
				n.minDep = m;
			}
			max = Math.max(n.minDep, max);
			visited[n.val]= false;
		}
		return max == Integer.MAX_VALUE ? 0: max; 
	}
	void addOneEdge(int a,int b , Map<Integer,List<Node>> graph){
		List<Node> edges;
		if(graph.containsKey(a)){
			edges = graph.get(a);
		}else{
			edges = new LinkedList<Node>();
			graph.put(a, edges);
		}
		edges.add(new Node(b));
	}
	
}
