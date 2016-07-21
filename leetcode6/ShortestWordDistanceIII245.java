package qiang.leetcode6;

import java.util.ArrayList;
import java.util.List;

public class ShortestWordDistanceIII245 {
	
	public static void main(String[] args) {
		
		ShortestWordDistanceIII245 ss = new ShortestWordDistanceIII245();
		String []words ={"practice", "makes", "perfect", "coding", "makes"};
		String word1 ="makes";
		String word2 = "makes";
		System.out.println(ss.shortestDistance(words, word1, word2));
	}
	public int shortestDistance(String[] words, String word1, String word2) { 
		if(words == null || words.length == 0) return Integer.MAX_VALUE;
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		for(int i =0;i<words.length;i++){
			if(word1.equals(words[i])){
				l1.add(i);
			}else{
				if(word2.equals(words[i])){
					l2.add(i);
				}
			}
		}

		int s1 = l1.size();
		int s2 = l2.size();
		int min = Integer.MAX_VALUE;
		if(word1.equals(word2)){
			int k1 = l1.get(0);
			int k2;
			for(int i =1; i < s1;i++){
				k2 = l1.get(i);
				min = Math.min(k2-k1, min);
				k1 = k2;
			}
			return min;
		}
		int i =0,j=0;
		while(i<s1 && j < s2){
			min = Math.min(Math.abs(l1.get(i)-l2.get(j)), min);
			if(min == 1) return 1;
			if(l1.get(i) < l2.get(j)) i++;
			else j++;
		}	
		return min;
	}
	public int shortestDistance2(String[] words, String word1, String word2) { 
		if(words == null || words.length == 0) return Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		int i = -1,j =-1;
		for(int cur = 0;cur < words.length;cur++){
			if(words[cur].equals(word1)){
				if(j != -1 && i==-1){
					min  = cur - j;
				}else{
					if(i!=-1 && j!=-1)
					min = Math.min(min, cur-j);
				}
				i = cur;
			}else{
				if(words[cur].equals(word2)){
					if(i!=-1 &&  j ==-1){
						min = cur -i;
					}else{
						if(i!=-1 && j!=-1)
							min = Math.min(min, cur - i);
					}
					j = cur;
				}
			}
			if( min == 1){
				return 1;
			}
		}
		return min;
	}
	
}
