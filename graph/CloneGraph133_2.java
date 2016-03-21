package qiang.graph;

import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CloneGraph133_2 {
    
	public static void main(String[] args) {
		
		UndirectedGraphNode node = GraphAlg.getGraphFromSerializedString("0,0,0");
		GraphAlg.bfsGraph(node);
		System.out.println();
		UndirectedGraphNode newNode =cloneGraph2(node); 
		GraphAlg.bfsGraph(newNode);
		System.out.println();
		GraphAlg.dfsGraph(newNode, new HashSet<Integer>());
	}
	
	
	/**
	 * 使用宽度优先的方法遍历图的时候复制
	 * @param node
	 * @return
	 */
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) { 
		if(node == null)return null;
		Set<Integer> visited = new HashSet<>();	
		LinkedList<UndirectedGraphNode > queue = new LinkedList<>();
		Map<UndirectedGraphNode,UndirectedGraphNode> oldNew = new HashMap<>();
		UndirectedGraphNode ans = new UndirectedGraphNode(node.label);
		
		UndirectedGraphNode top,tempNode,newN;
		queue.addLast(node);
		oldNew.put(node, ans);
		visited.add(node.label);
		List<UndirectedGraphNode> nei;
		while(!queue.isEmpty()){
			top = queue.getFirst();queue.removeFirst();
			newN = oldNew.get(top);
			nei = top.neighbors;
			for(UndirectedGraphNode cur:nei){
				if(!visited.contains(cur.label)){
					visited.add(cur.label);
					queue.addLast(cur);
				}
				if(oldNew.containsKey(cur)){
					tempNode = oldNew.get(cur);
				}else{
					tempNode = new UndirectedGraphNode(cur.label);
					oldNew.put(cur, tempNode);
				}
				newN.neighbors.add(tempNode);
			}
		}
		return ans;
	}
	/**
	 * 广搜索，不过map存放的时候key是label
	 * @param node
	 * @return
	 */
	public static UndirectedGraphNode cloneGraph3(UndirectedGraphNode node) { 
		if(node == null)return null;
		Set<Integer> visited = new HashSet<>();	
		LinkedList<UndirectedGraphNode > queue = new LinkedList<>();
		Map<Integer,UndirectedGraphNode> oldNew = new HashMap<>();
		UndirectedGraphNode ans = new UndirectedGraphNode(node.label);
		
		UndirectedGraphNode top,tempNode,newN;
		queue.addLast(node);
		oldNew.put(node.label, ans);
		visited.add(node.label);
		List<UndirectedGraphNode> nei;
		while(!queue.isEmpty()){
			top = queue.getFirst();queue.removeFirst();
			newN = oldNew.get(top.label);
			nei = top.neighbors;
			for(UndirectedGraphNode cur:nei){
				if(!visited.contains(cur.label)){
					visited.add(cur.label);
					queue.addLast(cur);
				}
				if(oldNew.containsKey(cur)){
					tempNode = oldNew.get(cur);
				}else{
					tempNode = new UndirectedGraphNode(cur.label);
					oldNew.put(cur.label, tempNode);
				}
				newN.neighbors.add(tempNode);
			}
		}
		return ans;
	}
	/**
	 * 使用深度优先的方法遍历图的时候复制,map中不在
	 * @param node
	 * @return
	 */
	public static UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) { 
		return  dfs(node, new HashMap<Integer,UndirectedGraphNode>());
	}
	public static UndirectedGraphNode dfs(UndirectedGraphNode node,Map<Integer,UndirectedGraphNode> map){
		if(node == null)return null;
		if(map.containsKey(node.label)){
			return map.get(node.label);
		}
		UndirectedGraphNode tempN = new UndirectedGraphNode(node.label);
		map.put(node.label, tempN);
		for(UndirectedGraphNode n:node.neighbors){
			tempN.neighbors.add(dfs(n, map));
		}
		return tempN;
	}
	
}
