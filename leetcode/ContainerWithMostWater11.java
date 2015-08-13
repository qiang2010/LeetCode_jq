package qiang.leetcode;

/**
 * Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, 
 * such that the container contains the most waterNote: You may not slant the container.
 * @author qiang
 *
 */
public class ContainerWithMostWater11 {

	
	
	/**
	 * 这里使用最基本的方法，暴力枚举方法
	 * @param height
	 * @return
	 */
	public static int maxArea(int[] height) {
	       int ans = 0;
	       int size = height.length;
	       int tempCap = 0 ;
	       int tempMin = 0 ; 
	       for(int i = 0; i<size-1;i++){
	    	   for(int j = i+1; j< size; j++){
	    		   tempMin = height[i];
	    		   if(tempMin > height[j])tempMin= height[j];
	    		   tempCap = (j-i)*tempMin;
	    		   if(tempCap > ans ) ans = tempCap;
	    	   }
	       }
	       return ans;
	}
	
	public static int maxArea2(int[] height) {
		int ans = 0 ; 
		int right = height.length -1;
		int left = 0 ;
		int cap=0;
		while(left < right){
			cap = (right-left)*Math.min(height[left], height[right]);
			if(cap > ans) ans = cap;
			if(height[left] < height[right]) left++;
			else right--;
		}
		
		return  ans;
	}
	/**
	 *  对 maxArea2 改进，使得效率更高了
	 *  
	 * @param height
	 * @return
	 */
	public static int maxArea3(int[] height) {
		int ans = 0 ; 
		int right = height.length -1;
		int left = 0 ;
		int cap=0;
		while(left < right){
			cap = (right-left)*Math.min(height[left], height[right]);
			if(cap > ans) ans = cap;
			if(height[left] < height[right]){
				int k = left+1;
				// 将left 和right之间不可能成为 矩形左边的值略过
				while( k < right && height[k]< height[left]) k++;
				left = k ;
			}
			else {
				int k = right-1;
				while( k > left && height[k]< height[right]) k--;
				right = k;
			}
		}
		
		return  ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []height = {3,3,3,3,9};
		System.out.println(maxArea(height));
		System.out.println(maxArea2(height));
		System.out.println(maxArea3(height));
	}

}
