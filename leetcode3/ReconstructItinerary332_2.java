package qiang.leetcode3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ReconstructItinerary332_2 {

	public static void main(String[] args) {
		ReconstructItinerary332_2 rr = new ReconstructItinerary332_2();
//		String [][]tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
//		String [][]tickets = {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
//		String [][]tickets ={{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		String [][]tickets ={{"AXA","EZE"},{"EZE","AUA"},
				{"ADL","JFK"},{"ADL","TIA"},{"AUA","AXA"},
				{"EZE","TIA"},{"EZE","TIA"},{"AXA","EZE"},{"EZE","ADL"},
				{"ANU","EZE"},{"TIA","EZE"},{"JFK","ADL"},{"AUA","JFK"},
				{"JFK","EZE"},{"EZE","ANU"},{"ADL","AUA"},{"ANU","AXA"},
				{"AXA","ADL"},{"AUA","JFK"},{"EZE","ADL"},{"ANU","TIA"},
				{"AUA","JFK"},{"TIA","JFK"},{"EZE","AUA"},{"AXA","EZE"},
				{"AUA","ANU"},{"ADL","AXA"},{"EZE","ADL"},{"AUA","ANU"},
				{"AXA","EZE"},{"TIA","AUA"},{"AXA","EZE"},{"AUA","SYD"},
				{"ADL","JFK"},{"EZE","AUA"},{"ADL","ANU"},{"AUA","TIA"},
				{"ADL","EZE"},{"TIA","JFK"},{"AXA","ANU"},{"JFK","AXA"},
				{"JFK","ADL"},{"ADL","EZE"},{"AXA","TIA"},{"JFK","AUA"},{"ADL","EZE"},{"JFK","ADL"},{"ADL","AXA"},{"TIA","AUA"},{"AXA","JFK"},{"ADL","AUA"},{"TIA","JFK"},{"JFK","ADL"},{"JFK","ADL"},{"ANU","AXA"},{"TIA","AXA"},{"EZE","JFK"},{"EZE","AXA"},{"ADL","TIA"},{"JFK","AUA"},{"TIA","EZE"},{"EZE","ADL"},{"JFK","ANU"},{"TIA","AUA"},{"EZE","ADL"},{"ADL","JFK"},{"ANU","AXA"},{"AUA","AXA"},{"ANU","EZE"},{"ADL","AXA"},{"ANU","AXA"},{"TIA","ADL"},{"JFK","ADL"},{"JFK","TIA"},{"AUA","ADL"},{"AUA","TIA"},{"TIA","JFK"},{"EZE","JFK"},{"AUA","ADL"},{"ADL","AUA"},{"EZE","ANU"},{"ADL","ANU"},{"AUA","AXA"},{"AXA","TIA"},{"AXA","TIA"},{"ADL","AXA"},{"EZE","AXA"},{"AXA","JFK"},{"JFK","AUA"},{"ANU","ADL"},{"AXA","TIA"},{"ANU","AUA"},{"JFK","EZE"},{"AXA","ADL"},{"TIA","EZE"},{"JFK","AXA"},{"AXA","ADL"},{"EZE","AUA"},{"AXA","ANU"},{"ADL","EZE"},{"AUA","EZE"}};
		System.out.println(rr.findItinerary(tickets));
	}
	public List<String> findItinerary(String[][] tickets) {
		LinkedList<String> ans = new LinkedList<>();
		Map<String,TreeSet<String>> graph = new HashMap<>();
		String []edge;
		for(int i =0;i< tickets.length;i++){
			edge = tickets[i];
			addOneEdge(edge[0],edge[1],graph);
//			addOneEdge(edge[1],edge[0],graph);
		}
		Set<String> visited = new HashSet<>();
		ans.add("JFK");
		dfsGraph("JFK",visited,graph,ans,tickets.length);
		return ans;
	
	}
	boolean dfsGraph(String curNode,Set<String> visited ,Map<String,TreeSet<String>> graph,LinkedList<String> ans,int size){
		if(ans.size()-1==size){
			return true; // 已经获得解
		}
		TreeSet<String> edges = graph.get(curNode);
		if(edges==null)return false; // 开始忘记判断这个
		for(String s:edges){
			String key = curNode+s;
			if(!visited.contains(key)){
				visited.add(key);
				ans.addLast(s);
				if(dfsGraph(s,visited,graph, ans,size))return true;;
				ans.removeLast();
				visited.remove(key);
			}
		}
		return false;
	}
	void addOneEdge(String a,String b,Map<String,TreeSet<String>> graph){
		TreeSet<String> edge;
		if(graph.containsKey(a)){
			edge = graph.get(a);
		}else{
			 edge = new TreeSet<String>();
			 graph.put(a, edge);
		}
		 edge.add(b);
	}
}
