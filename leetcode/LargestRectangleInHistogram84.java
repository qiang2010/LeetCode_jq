package qiang.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LargestRectangleInHistogram84 {
    
	
	
	
	/**
	 * 这里使用栈来解决问题，不会超时
	 * 
	 * @param height
	 * @return
	 */
	public static int largestRectangleArea(int[] height) {
		
		if(height == null || height.length ==0) return 0;
		LinkedList<Integer> heightStack = new LinkedList<>();
		LinkedList<Integer> indexStack  = new LinkedList<>();
		
		int s = height.length;
		int tempH,topH;
		int tempA,maxA =0;
		int lastIndex;
		int lastTop;
		for(int i =0; i <s+1 ; i++ ){
			if(i==s) 
				tempH = 0;
			else
				tempH = height[i];
			if(heightStack.isEmpty() || tempH > heightStack.getLast()){
				heightStack.addLast(tempH);
				indexStack.addLast(i);
			}else{
				topH = heightStack.getLast();
				lastIndex = i;
				lastTop = topH;
				while(tempH < topH ){
					lastTop = heightStack.getLast();
					heightStack.removeLast();
					lastIndex = indexStack.getLast();
							
					indexStack.removeLast();
					if(heightStack.isEmpty())break;
					topH = heightStack.getLast();
				}
				heightStack.addLast(tempH);
				indexStack.add(lastIndex);
				tempA = (i-lastIndex)*lastTop;
				if(tempA > maxA){
					maxA = tempA;
				}
			}
		}
		if(heightStack.isEmpty())return maxA;
		// 如果栈里面还有剩余的值
		int la = heightStack.getFirst();
		lastIndex = indexStack.getFirst();
		tempA =0;
		//maxA =0;
		while(la ==0 ) {
			heightStack.removeFirst();
			indexStack.removeFirst();
			if( heightStack.isEmpty()) break;
			la = heightStack.getFirst();
			lastIndex = indexStack.getFirst();
		}
		tempA = (s-lastIndex)*la;
		return tempA > maxA? tempA:maxA;
	}
	
	
	
	
	public static int largestRectangleArea2(int[] height) {
		
		int maxArea = 0;
		if(height == null || height.length ==0) return maxArea;
		int size = height.length;
		int left,right;
		int tempA;
		for(int i = 0 ; i < size ; i++){
			
			
			// 向左找
			left = i-1;
			while(left > -1 && height[left] >= height[i]){
				left--;
			}
			
			// 向右侧找
			right = i+1;
			while(right < size && height[right] >= height[i]){
				right++;
			}
			// right 和left分布是右侧和左侧不满足条件的边界。
			tempA = (right-left-1)*height[i];
			if(tempA > maxArea){
				maxArea = tempA;
			}
		}
    	
    	
    	return maxArea;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []h = {1,2,2};
		System.out.println(largestRectangleArea(h));
	}

}
