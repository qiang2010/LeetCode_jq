package qiang.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseScheduleII210 {
   
	/**
	 * 使用拓扑排序解决
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public int[] canFinish(int numCourses, int[][] prerequisites) {
		
		int emptyAns[]={};
		if(prerequisites == null || prerequisites.length==0){
			
			int an [] = new int[numCourses];
			for(int i =0;i< numCourses;i++){
			    an[i] =i;
			}
			return an;
		}
		
	
		int edgeLen = prerequisites.length;
 
		if(prerequisites[0].length != 2) return emptyAns;
		if(edgeLen > (numCourses-1)*numCourses/2) return emptyAns;
		int ans []=new int[numCourses];
		Map<Integer,Set<Integer>> graph = new HashMap<>();
		
		int []degrees = new int[numCourses];
		int a,b;
		Set<Integer> list;
		for(int i =0; i <edgeLen;i++){
			a = prerequisites[i][1];
			b = prerequisites[i][0];
			if(graph.containsKey(a)){
				list = graph.get(a);
			}else{
				list = new HashSet<Integer>();
			}
			if(!list.contains(b)){
				list.add(b);
				degrees[b]++; // 认为没有重复的边
			}
			graph.put(a, list);
		}
		
		
		int countZero=0;
		LinkedList<Integer> zerosDegree = new LinkedList<>();
		for(int i =0; i < numCourses;i++){
			if(degrees[i] == 0) {
				zerosDegree.addLast(i);
				ans[countZero++] = i;
			}
		}
		if(zerosDegree.isEmpty()) return new int[0];
		Set<Integer> lst;
		while(!zerosDegree.isEmpty()){
			int top = zerosDegree.getFirst();
			zerosDegree.removeFirst();
			lst = graph.get(top);
			if(lst != null){
				for(int a1:lst){
					degrees[a1]--;
					if(degrees[a1] == 0){
						zerosDegree.addLast(a1);
						ans[countZero++] = a1;
					}
				}
			}
		}
		if(countZero == numCourses)return ans;
		return emptyAns; //2 6 8 9 0 5 7 1 3 4 
	}
	
	
	/**
	 * 使用拓扑排序解决
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public int[] canFinish2(int numCourses, int[][] prerequisites) {
		
		int emptyAns[]={};
		if(prerequisites == null || prerequisites.length==0){
			return emptyAns;
		}
		
	
		int edgeLen = prerequisites.length;
		if(edgeLen == 1){
			int [] an = {0};
			return an;
		}
		if(prerequisites[0].length != 2) return emptyAns;
		if(edgeLen > (numCourses-1)*numCourses/2) return emptyAns;
		int ans []=new int[numCourses];
		Map<Integer,ArrayList<Integer>> graph = new HashMap<>();
		
		int []degrees = new int[numCourses];
		int a,b;
		ArrayList<Integer> list;
		for(int i =0; i <edgeLen;i++){
			a = prerequisites[i][1];
			b = prerequisites[i][0];
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
				ans[countZero++] = i;
			}
		}
		if(zerosDegree.isEmpty()) return new int[0];
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
						ans[countZero++] = a1;
					}
				}
			}
		}
		if(countZero == numCourses)return ans;
		return emptyAns;
	}
	
	 
	public static void main(String[] args) {
		int [][] prerequisites= {{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
		int []ans = new CourseScheduleII210().canFinish2(10, prerequisites);
		int []ans2 = new CourseScheduleII210().canFinish(10, prerequisites);
		for(int a:ans)
		System.out.print(a+" ");
	
		System.out.println();
		for(int a:ans2)
			System.out.print(a+" ");
			
	}
	
}
