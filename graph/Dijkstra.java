package qiang.graph;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {

	public static void main(String[] args) {
		
		Dijkstra dd = new Dijkstra();
		int [][]edges = new int[4][4];
		for(int i =0;i<4;i++)
			for(int j =0;j<4;j++)
				edges[i][j] =-1;
		edges[0][1] = edges[1][0] = 1;  
		edges[3][1] = edges[1][3] = 5;  
		edges[0][3] = edges[3][0] = 2;  
		edges[3][2] = edges[2][3] = 6;  
		int [] ans = dd.dijkstra(4, 1, edges);
		for(int i=0;i<4;i++){
			System.out.println(ans[i]);
		}
		
		
	}
	
	class OneNode{
		int label;
		int len;
		public OneNode(int l,int len){
			this.label = l;
			this.len = len;
		}
	}
	/**
	 * Dijkstra 的实现
	 * 点的标记是 0到n-1
	 * @param n
	 * @param target
	 * @param edges  边集，如果不存在边，存放的是-1
	 * @return
	 */
	public int[] dijkstra(int n, int target, int [][]edges){
		if(edges == null || n< 1 || target < 0 || target >n-1) return  new int[0];
		Comparator<OneNode> com = new Comparator<OneNode>(){
			public int compare(OneNode n1,OneNode n2){
				return Integer.compare(n1.len,n2.len);
			}
			
		};
		OneNode []allNode = new OneNode[n];
		PriorityQueue<OneNode> prio = new PriorityQueue<OneNode>(com); 
		for(int i =0;i<n;i++){
			if(i != target){
				int le = Integer.MAX_VALUE;
				if(edges [target][i]!=-1)
					le = edges [target][i];
				allNode[i] = new OneNode(i,le);
				prio.add(allNode[i]);
			}
		}
		while(prio.isEmpty()==false){
			OneNode top = prio.poll();
			int mid = top.label;
			//更新其他节点的边长
			for(OneNode  cur:prio){
				int ll = edges[mid][cur.label];
				if(ll ==-1 )continue;
				if(cur.len  > ll+ top.len ){
					cur.len = ll+ top.len;
				}
			}
		}
		int []dist = new int[n];
		int i =0;
		for(OneNode one:allNode){
			if(one != null)
				dist[i++] = one.len;
			else dist[i++] = -1;
		}
		return dist;
	}
	
}
