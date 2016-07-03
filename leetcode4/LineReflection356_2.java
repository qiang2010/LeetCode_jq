package qiang.leetcode4;

import java.util.HashSet;
import java.util.Set;

public class LineReflection356_2 {

	
	public static void main(String[] args) {
		
		int [][]points = {{1,1},{-1,1}};
		
		LineReflection356_2 ss = new LineReflection356_2();
		System.out.println(ss.isRelected(points));
	}
	boolean isRelected(int [][] points){
		
		if(points == null || points.length <2)return true;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		Set<String> allP = new HashSet<>();
		
		for(int []p : points){
			
			allP.add(p[0]+" "+p[1]);
			min = Math.min(min, p[0]);
			max = Math.max(max, p[0]);
		}
		
		int sum = min+max;
		for(int []p: points){
			if(! allP.contains((sum-p[0])+" "+p[1])){
				return false;
			}
		}
		return true;
	}	
	 

}
