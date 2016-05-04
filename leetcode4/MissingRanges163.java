package qiang.leetcode4;

import java.util.LinkedList;
import java.util.List;

public class MissingRanges163 {

	public static void main(String[] args) {
		
		MissingRanges163 mis = new MissingRanges163();
		System.out.println(mis.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));
	}
	
	public List<String> findMissingRanges(int[] A, int lower, int upper) {  
    
		List<String> ans = new LinkedList<>();
		if(A == null || A.length == 0) {
			if(lower == upper)
				ans.add(lower+"");
			else ans.add(lower+"->"+upper);
			return ans;
		}

		int size = A.length;
		// 找到第一个大于等于lower的
		int i =0;
		while(i<size && A[i]<lower)i++;
		if(i == size){
			if(lower == upper)
				ans.add(lower+"");
			else ans.add(lower+"->"+upper);
			return ans;
		}
		
		// 处理一下lower
		addOneGap(lower-1,A[i],ans); // 这里也要包括lower，因此是lower-1
		int last = A[i],cur;
		i++;
		for(;i<size && A[i]<upper;i++){
			cur = A[i];
			addOneGap(last,cur,ans);
			last = cur;
		}
		// 最后处理upper
		addOneGap(last,upper+1,ans); // 注意这里要包括upper，所以是upper+1
		return ans;
	}
	// begin 和 end就是两个边界
	void addOneGap(int begin,int end,List<String> ans){
		int gap = end - begin;
		switch(gap){
		case 0: // 两个数相等。
			break;
		case 1: // 两个数相差1 不处理，比如 2 3，中间没有缺失
			break;
		case 2: // 两个数相差2 ，缺了1个，比如 2,4
			ans.add(begin+1+"");
			break;
		default:		
			ans.add(begin+1+"->"+(end-1));
		}
		
	}

}
