package qiang.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CloneGraph133 {
    
	public static void main(String[] args) {
		
		UndirectedGraphNode node = GraphAlg.getGraphFromSerializedString("-1,1#1");
		GraphAlg.bfsGraph(node);
		System.out.println();
		UndirectedGraphNode newNode =cloneGraph(node); 
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
        
		if(node == null) return null;
		Set<Integer> visited = new HashSet<Integer>();
		LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
		Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
		UndirectedGraphNode tempNode,newG,topNode,newTop=null;
		newG = new UndirectedGraphNode(node.label);
		queue.addLast(node);
		visited.add(node.label);
		map.put(node, newG);
		List<UndirectedGraphNode> nei;
		while(!queue.isEmpty()){
			topNode = queue.getFirst();
			queue.removeFirst();
			newTop = map.get(topNode);
			nei = topNode.neighbors;
			for(UndirectedGraphNode n:nei){
				if(!visited.contains(n.label)){
					queue.addLast(n);
					visited.add(n.label);
				}
				if(map.containsKey(n)){
					tempNode = map.get(n);
				}else{
					tempNode = new UndirectedGraphNode(n.label);
					map.put(n, tempNode);
					newTop.neighbors.add(tempNode);
				}
				
			}
		}
		return newG;
	
	}
}
