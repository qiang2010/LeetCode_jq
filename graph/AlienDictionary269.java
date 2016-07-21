package qiang.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class AlienDictionary269 {
	 
	public static void main(String[] args) {
		AlienDictionary269  as = new AlienDictionary269();
		String []words = {"wrt", "wrf", "er", "ett", "rftt"};
		System.out.println(as.alienOrder(words));
//		"dd".toCharArray()
	}
	
	public String alienOrder(String[] words) { 
		
		if(words == null || words.length == 0) return "";
		Map<Character,HashSet<Character>> graph = new HashMap<Character,HashSet<Character>>();
		boolean [] charFlag = new boolean[26];
		int []indegree = new int[26];
		// 构建图
		for(int i=1;i< words.length;i++){
			String first = words[i-1];
			String second = words[i];
			int s1 = first.length();
			int s2 = second.length();
			int m =0,n=0;
			while(m<s1 && n<s2 && first.charAt(m)==second.charAt(n)){
				charFlag[first.charAt(m)-'a']=true;
				m++;n++;
			}
			if(n==s2)continue; // abc ab 这种情况 还有 abc 和abc这种
			char a = first.charAt(m);
			char b = second.charAt(n);
			while(m<s1){
				charFlag[first.charAt(m++)-'a']=true;
			}
			while(n<s2){
				charFlag[second.charAt(n++)-'a']=true;
			}
			
			if(!graph.containsKey(a)){
				graph.put(a, new HashSet<Character>());
			}
			graph.get(a).add(b);
			indegree[b-'a']++;
		}
	
		// 拓扑排序
		LinkedList<Character> indegreeZero = new LinkedList<>();
		for(int i =0;i<26;i++){
			if(indegree[i] == 0 && charFlag[i]){
				indegreeZero.add((char)(i+'a'));
			}
		}
		StringBuilder sb = new StringBuilder();
		Set<Character> cover = new HashSet<Character>();
		while(indegreeZero.isEmpty()==false){
			char top = indegreeZero.getLast();
			indegreeZero.removeLast();
			sb.append(top);
			cover.add(top);
			HashSet<Character> edges = graph.get(top);
			if(edges ==null)continue;
			for(char ed:edges){
				indegree[ed-'a']--;
				if(indegree[ed-'a']==0){
					indegreeZero.add(ed);
				}
			}
		}
//		for(int i =0;i<26;i++){
//			if(!cover.contains((char)(i+'a')) && charFlag[i])
//				sb.append((char)(i+'a'));
//		}
		return sb.toString();
	}
}
