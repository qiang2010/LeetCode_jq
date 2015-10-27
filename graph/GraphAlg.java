package qiang.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *  该类包含图的各种算法
 *  1. leetcode中构建图的函数
 *  2. 图的基本遍历算法
 * @author jq
 *
 */
public class GraphAlg {

	
	public static void main(String[] args) {
		UndirectedGraphNode node = getGraphFromSerializedString("0,1,2#1,2#2,2,3");
		dfsGraph(node, new HashSet<Integer>());
		System.out.println("bfs:");
		bfsGraph(node);
		
	}
	// 这里图的存储方式，返回一个节点，（保证是连通图？）
	public static UndirectedGraphNode getGraphFromSerializedString(String g){
		
		if(g == null || g.length() == 0) return null;
		String splits[] = g.split("#");
		int size = splits.length;
		String tempSplit[];
		UndirectedGraphNode first=null,cur;
		int firstLabel,curLabel;
		Map<Integer,UndirectedGraphNode> allNodes= new HashMap<>();
		for(int i=0;i<size;i++){
			tempSplit = splits[i].split(",");
			int tempSize = tempSplit.length;
			firstLabel = Integer.parseInt(tempSplit[0]);
			if(allNodes.containsKey(firstLabel)){
				first = allNodes.get(firstLabel);
			}else{
				first = new UndirectedGraphNode(firstLabel);
				allNodes.put(firstLabel, first);
			}
			for(int j=1;j<tempSize;j++){
				curLabel = Integer.parseInt(tempSplit[j]);
				if(allNodes.containsKey(curLabel)){
					cur = allNodes.get(curLabel);
				}else{
					cur = new UndirectedGraphNode(curLabel);
					allNodes.put(curLabel, cur);
				}
				first.neighbors.add(cur);
				cur.neighbors.add(first);
			}
		}
		return first;
	}
	
	// 深度优先
	public static void dfsGraph(UndirectedGraphNode node,Set<Integer> visited){
		
		if(node == null) return;
		List<UndirectedGraphNode> neig = node.neighbors;
		if(!visited.contains(node.label)){
			visited.add(node.label);
			System.out.println(node.label);
		}
		if(neig == null)return;
		for(UndirectedGraphNode n:neig){
			if(!visited.contains(n.label)){
				visited.add(n.label);
				System.out.println(n.label);
				dfsGraph(n, visited);
			}
		}
		
	}
	public static void bfsGraph(UndirectedGraphNode node){
		
		if(node == null) return;
		LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<Integer>();
		System.out.println(node.label);
		queue.addLast(node);
		visited.add(node.label);
		UndirectedGraphNode cur;
		List<UndirectedGraphNode> nei;
		while(!queue.isEmpty()){
			cur = queue.getFirst();
			queue.removeFirst();
			nei = cur.neighbors;
			for(UndirectedGraphNode n:nei){
				if(!visited.contains(n.label)){
					System.out.println(n.label);
					visited.add(n.label);
					queue.addLast(n);
				}
			}
			
		}
	}
	
	
}
