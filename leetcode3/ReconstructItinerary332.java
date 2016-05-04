package qiang.leetcode3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReconstructItinerary332 {

	public static void main(String[] args) {
		ReconstructItinerary332 rr = new ReconstructItinerary332();
//		String [][]tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
//		String [][]tickets = {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
		String [][]tickets ={{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		System.out.println(rr.findItinerary(tickets));
	}
    

    
    /**
     * 这里使用list来存放一条边的终点
     * 
     * 
     * */
    public List<String> findItinerary(String[][] tickets) {
    	    
    	 Map<String,List<String>> graph = new HashMap<>();
    	 for(int i =0;i< tickets.length;i++){   
    	     String [] e = tickets[i];
    	     if(graph.containsKey(e[0])){
    	         graph.get(e[0]).add(e[1]);
    	     }else{
    	         graph.put(e[0],new ArrayList<String>());
    	         graph.get(e[0]).add(e[1]);
    	     }
    	 }
    	 for(String k:graph.keySet()){
    	     Collections.sort(graph.get(k));
    	 }
    	 LinkedList<String> ans = new LinkedList<>();
    	 ans.add("JFK");
    	 dfs("JFK",ans,tickets.length,graph);
    	 return ans;
    }
    boolean dfs(String curNode,LinkedList<String> tempAns,int size,Map<String,List<String>> graph){
        
        if(tempAns.size()-1 == size){
            return true;
        }
        List<String> edges = graph.get(curNode);
        if(edges == null) return false;
        for(int i =0;i< edges.size();i++){
            String end = edges.get(i);
            tempAns.addLast(end);
            edges.remove(i);
            if(dfs(end,tempAns,size,graph)){
                return true;
            }
            edges.add(i,end);
            tempAns.removeLast();
        }
        return false;
    }

}
