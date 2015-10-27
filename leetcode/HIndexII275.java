package qiang.leetcode;

import java.util.Arrays;
import java.util.Locale.Category;

public class HIndexII275 {
	
	public static void main(String[] args) {
		int []citations = {3};
		System.out.println(new HIndexII275().hIndex(citations));
	}
	
 
	    
	
	public int hIndex(int[] citations) {
	    
		if(citations == null || citations.length == 0) return 0;
		int i = citations.length;
		if(citations[citations.length-1]==0) return 0;
		for(int j = 0;j < citations.length;j++){
			if(citations[j] >= i){
				return i;
			}
			i--;
		}
		return 0;
	}
}
