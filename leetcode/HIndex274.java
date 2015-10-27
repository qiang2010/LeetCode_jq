package qiang.leetcode;

import java.util.Arrays;

public class HIndex274 {
	
	public static void main(String[] args) {
		int []citations = {3};
		System.out.println(new HIndex274().hIndex(citations));
		System.out.println(new HIndex274().hIndex2(citations));
	}
	
	
	public int hIndex2(int[] citations) {
		
		if(citations == null || citations.length == 0) return 0;
		int s = citations.length;
				
		int count[] = new int[s+1];
		for(int a:citations){
			if(a >s-1){
				count[s]++;
			}else{
				count[a]++;
			}
		}
		if(count[s]>=s) return s;
		for(int j =s-1; j>-1;j--){
			count[j] = count[j]+count[j+1];
			if(count[j] >= j)return j;
		}
		return 0;
	}
	    
	
	public int hIndex(int[] citations) {
	    
		if(citations == null || citations.length == 0) return 0;
		Arrays.sort(citations);
		int i =1;
		if(citations[citations.length-1]==0) return 0;
		for(int j = citations.length-1;j>-1;j--){
			if(citations[j] < i){
				break;
			}
			i++;
		}
		return i-1;
	}
}
