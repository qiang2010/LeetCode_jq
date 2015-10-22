package qiang.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CourseSchedule207 {
   
	
	
	
	/**
	 * 使用拓扑排序解决
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public boolean canFinish2(int numCourses, int[][] prerequisites) {
		
		if(prerequisites == null || prerequisites.length < 2) return true;
	    
		Map<Integer,ArrayList<Integer>> graph = new HashMap<>();
		int edgeLen = prerequisites.length;
		if(prerequisites[0].length != 2) return false;
		
		// 满足下面条件肯定有回路
		if(edgeLen > (numCourses-1)*numCourses/2) return false;
		int []degrees = new int[numCourses];
		int a,b;
		ArrayList<Integer> list;
		for(int i =0; i <edgeLen;i++){
			a = prerequisites[i][0];
			b = prerequisites[i][1];
			degrees[b]++; // 认为没有重复的边
			if(graph.containsKey(a)){
				list = graph.get(a);
			}else{
				list = new ArrayList<Integer>();
			}
			list.add(b);
			graph.put(a, list);
		}
		
		
		int countZero=0;
		LinkedList<Integer> zerosDegree = new LinkedList<>();
		for(int i =0; i < numCourses;i++){
			if(degrees[i] == 0) {
				zerosDegree.addLast(i);
				countZero++;
			}
		}
		if(zerosDegree.isEmpty()) return false;
		List<Integer> lst;
		while(!zerosDegree.isEmpty()){
			int top = zerosDegree.getFirst();
			zerosDegree.removeFirst();
			lst = graph.get(top);
			if(lst != null){
				for(int a1:lst){
					degrees[a1]--;
					if(degrees[a1]==0){
						zerosDegree.addLast(a1);
						countZero++;
					}
				}
			}
		}
		if(countZero == numCourses)return true;
		return false;
	}
	
	/**
	 * 广度优先难以解决问题
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		
		if(prerequisites == null || prerequisites.length < 2) return true;
    
		Map<Integer,ArrayList<Integer>> graph = new HashMap<>();
		int edgeLen = prerequisites.length;
		if(prerequisites[0].length != 2) return false;
		
		// 满足下面条件肯定有回路
		if(edgeLen > (numCourses-1)*numCourses/2) return false;
		
		int a,b;
		ArrayList<Integer> list;
		for(int i =0; i <edgeLen;i++){
			a = prerequisites[i][0];
			b = prerequisites[i][1];
			if(graph.containsKey(a)){
				list = graph.get(a);
			}else{
				list = new ArrayList<Integer>();
			}
			list.add(b);
		}
		boolean []visited = new boolean[numCourses];
		for(int i =0; i < numCourses;i++){
			if(!visited[i]){
				if(bfs_cirle(visited, graph, i)){
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean bfs_cirle(boolean[]visited,Map<Integer,ArrayList<Integer>> graph,int i){
		LinkedList<Integer> queue = new LinkedList<>();
		if(visited[i]){
			return true;
		}
		visited[i] = true;
		queue.addLast(i);
		int top;
		List<Integer> edges;
		while(!queue.isEmpty()){
			top = queue.getFirst();
			queue.removeFirst();
			edges = graph.get(top);
			if(edges!=null){
				for(int j = 0 ; j< edges.size();j++){
					if(visited[edges.get(j)]){
						return true;
					}else{
						visited[edges.get(j)] = true;
						queue.add(edges.get(j));
					}
				}
			}
			
		}
		return false;
	}
	public static void main(String[] args) {
		int [][] prerequisites= {{0,2},{1,2},{2,0}};
		System.out.println(new CourseSchedule207().canFinish2(3, prerequisites));
		
	}
	
}
