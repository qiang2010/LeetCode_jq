package qiang.leetcode6;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceII244 {
	
	public static void main(String[] args) {
		
		String []words ={"practice", "makes", "perfect", "coding", "makes"};
		ShortestWordDistanceII244 ss = new ShortestWordDistanceII244(words);
		String word1 ="coding";
		String word2 = "practice";
		System.out.println(ss.shortestDistance(word1, word2));
	}
	Map<String, List<Integer>> map;
	public ShortestWordDistanceII244(String[] words) {
		map = new HashMap<>();
		for(int i =0;i<words.length;i++){
			if(map.containsKey(words[i])==false){
				map.put(words[i], new LinkedList<Integer>());
			}
			map.get(words[i]).add(i);
		}
	}
	public int shortestDistance( String word1, String word2) { 
		List<Integer> l1 = map.get(word1);
		List<Integer> l2 = map.get(word2);
		int s1 = l1.size();
		int s2 = l2.size();
		int min = Integer.MAX_VALUE;
		int i =0,j=0;
		while(i<s1 && j < s2){
			min = Math.min(Math.abs(l1.get(i)-l2.get(j)), min);
			if(min == 1) return 1;
			if(l1.get(i) < l2.get(j)) i++;
			else j++;
		}	
		return min;
	}
 
}
