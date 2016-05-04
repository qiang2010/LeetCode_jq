package qiang.leetcode2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TheSkylineProblem218_divdeAndConquer { 
	
	
    public List<int[]> getSkyline(int[][] buildings) {
        if(buildings == null || buildings.length == 0) return new ArrayList<int[]>();
    	return divideAndConquer(buildings,0,buildings.length-1);
    }
	public List<int[]> divideAndConquer(int [][]buildings,int i ,int j ){
		if(i==j){
			List<int[]> ans = new ArrayList<>();
			ans.add(new int[]{buildings[i][0],buildings[i][2]});
			ans.add(new int[]{buildings[i][1],0});
			return ans;
		}
		int mid = (i+j)/2;
		List<int[]> left = divideAndConquer(buildings, i, mid);
		List<int[]> right = divideAndConquer(buildings, mid+1, j);
		return merge(left,right);
		
	}
	List<int []> merge(List<int[]> left,List<int[]> right){
		List<int[]> ans = new ArrayList<>();
		int l1 = 0 ,size1 = left.size();
		int l2 = 0,size2 = right.size();
		int []r1,r2;
		int sky =0;
		int loca=0;
		int h1 = 0;
		int h2 =0;
		while(l1 < size1 && l2 < size2){
			r1 = left.get(l1);
			r2 = right.get(l2);
			if(r1[0] < r2[0]){
				loca = r1[0];
				h1= r1[1];
				l1++;
			}else{
				if(r1[0] > r2[0]){
					loca = r2[0];
					h2 = r2[1];
					l2++;
				}else{
					loca = r1[0];
					h1 = r1[1];
					h2 = r2[1];
					l1++;l2++;
				}
			}
			if(sky != Math.max(h1, h2)){
				sky = Math.max(h1, h2);
				ans.add(new int[]{loca,sky});
			}
		}
		while(l1<size1){
			ans.add(left.get(l1++));
		}
		while(l2<size2) ans.add(right.get(l2++));
		return ans;
	}
}
