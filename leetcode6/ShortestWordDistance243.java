package qiang.leetcode6;

import java.util.LinkedList;
import java.util.List;

public class ShortestWordDistance243 {
	
	public static void main(String[] args) {
		
		ShortestWordDistance243 ss = new ShortestWordDistance243();
		String []words ={"practice", "makes", "perfect", "coding", "makes"};
		String word1 ="coding";
		String word2 = "practice";
		System.out.println(ss.shortestDistance(words, word1, word2));
		System.out.println(ss.shortestDistance2(words, word1, word2));
	}
	public int shortestDistance(String[] words, String word1, String word2) { 
		if(words == null || words.length == 0) return Integer.MAX_VALUE;
		LinkedList<Integer> l1 = new LinkedList<>();
		LinkedList<Integer> l2 = new LinkedList<>();
		for(int i =0;i<words.length;i++){
			if(word1.equals(words[i])){
				l1.addLast(i);
			}else{
				if(word2.equals(words[i])){
					l2.addLast(i);
				}
			}
		}
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
