package qiang.leetcode4;

import java.util.Arrays;
import java.util.Comparator;

public class LineReflection356 {

	
	public static void main(String[] args) {
		
		int [][]points = {{1,1},{-1,-1}};
		
		LineReflection356 ss = new LineReflection356();
		System.out.println(ss.isRelected(points));
	}
	boolean isRelected(int [][] points){

		if(points == null || points.length < 2) return true;
		
		Comparator<int[]> com = new Comparator<int []>(){
			
			public int compare(int [] a,int[]b){
				
				if(a[1] != b[1]) return Integer.compare(a[1], b[1]);
				return Integer.compare(a[0], b[0]);
			}
		};
		Arrays.sort(points,com);
		int curY = points[0][1];
		int begin = 0;
		int end = 0;
		int len = points.length;
		double curX = 0;
		boolean first = true;
		while(end < len){
			
			while(end< len && points[end][1] == curY){
				end++;
			}
			double x = this.getYReflection(points, begin, end-1);
			if(reFlag == false) return false;
			if(first ){
				curX = x;first = false;
			}else{
				if(Math.abs(x-curX) > 0.01) return false;
			}
			
			begin = end;
			
		}
		return true;
	}	
	// 获取从 begin 到end的这些点的对称点。这些点的y都是相等的，所以选择x的中间值。
	// 并且x已经按照升序排序好了。
	boolean reFlag ;
	double getYReflection(int [][]points, int begin, int end){
		reFlag = true;
		if(begin > end) {
			reFlag = false;return Integer.MIN_VALUE;
		}
		if(begin == end) return points[begin][0];
		double x = (points[begin][0]+points[end][0])/2.0;
		begin++;end--;
		while(begin <= end){
			double nex = (points[begin][0]+points[end][0])/2.0;
			if(Math.abs(x-nex) > 0.001 ){
			   reFlag = false;
			   return Integer.MIN_VALUE;
			}
			begin ++;end--;
		}
		reFlag = true;
		return x;
	}

}
