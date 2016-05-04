package qiang.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MinimumHeightTrees310_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumHeightTrees310_2 mi = new MinimumHeightTrees310_2();
		int n = 2;
		int [][]edges ={{0, 1}};
//		System.out.println(mi.findMinHeightTrees(n, edges));
	}
	class Node{
		int val;
		List<Integer> adj;
		Node(int val){
			this.val= val;
			adj = new LinkedList<>();
		}
	}
//	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//		// 构建图。
//		Node[] graph = new Node[n];
//		for(int i=0;i< n;i++)graph[i] = new Node(i);
//		int []degrees = new int[n];
//		for(int[] edge:edges){
//			graph[edge[0]].adj.add(edge[1]);
//			graph[edge[1]].adj.add(edge[0]);
//			degrees[edge[0]]++;
//			degrees[edge[1]]++;
//		}
//		int rem = n;
//		List<Integer> zero = new LinkedList<>();
//		LinkedList<Integer> leaves = new LinkedList<>();
//		
//		
//	}
	
}
