package qiang.leetcode4;

import java.util.LinkedList;
import java.util.List;

public class MissingRanges163_2 {

	public static void main(String[] args) {
		
		MissingRanges163_2 mis = new MissingRanges163_2();
		System.out.println(mis.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));
		StringBuilder sb = new StringBuilder();
//		sb.substring(start, end);
	}
	
	public List<String> findMissingRanges(int[] A, int lower, int upper) {
		// 假设输入的lower <= upper
		List<String> ans = new LinkedList<>();
		if(A==null || A.length ==0){
			if(lower == upper){
				ans.add(lower+"");
				return ans;
			}
			ans.add(lower+"->"+upper);
			return ans;
		}
		int i =0; 
		int s = A.length;
		while(i < s && A[i]< lower) i++;
		if(i == s){
			if(lower == upper){
				ans.add(lower+"");
				return ans;
			}
			ans.add(lower+"->"+upper);
			return ans;
		}
		addOneInter(lower-1,A[i],ans);
		int cur = A[i];
		int j;
		int ne=A[i];
		for( j =i+1; j< s;j++){
			 ne = A[j];
			if(ne >= upper) break;
			this.addOneInter(cur, ne, ans);
			cur = ne;
		}
		this.addOneInter(ne, upper+1, ans);
		return ans;
	}
	void addOneInter(int begin, int end, List<String> ans){
		int diff= end - begin;
		if(diff <2) return;
		if(diff == 2){
			ans.add(begin+1+"");
			return ;
		}
		ans.add(begin+1+"->"+(end-1));
	}
}

