package qiang.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumHeightTrees310 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumHeightTrees310 mi = new MinimumHeightTrees310();
		int n = 2;
		int [][]edges ={{0, 1}};
		System.out.println(mi.findMinHeightTrees(n, edges));
	}
	class Node{
        int val;
       List<Integer> adj;
       Node( int val){
              this. val= val;
              adj = new LinkedList<>();
       }
 }
 public List<Integer> findMinHeightTrees( int n, int[][] edges) {
        
        // 构建图。
       Node[] graph = new Node[n];
        for( int i=0;i< n;i++)graph[i] = new Node(i);
        int []degrees = new int[n];
        for( int[] edge:edges){
             graph[edge[0]]. adj.add(edge[1]);
             graph[edge[1]]. adj.add(edge[0]);
             degrees[edge[0]]++;
             degrees[edge[1]]++;
       }
        int rem = n;
        while(rem >2){
             List<Integer> zero = new LinkedList<>();
              for( int i =0;i<n;i++){
                    if(degrees[i] == 1){
                         degrees[i] =-1;
                         zero.add(i);
                         rem--;
                   }
             }
              for( int a:zero){
                    for( int k:graph[a]. adj){
                         degrees[k]--;
                   }
             }
       }
       List<Integer> an = new ArrayList<>();
        for( int i =0;i<n;i++) if(degrees[i] >= 0) an.add(i); // 最后的大于等于0的都是解。
        return an;
 }

}
