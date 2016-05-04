package qiang.leetcode3;

public class TrappingRainWater42 {

    public int trap(int[] height) {
      
    	if(height == null || height.length ==0) return 0;
    	int maxPos = 0;
    	int max = height[0];
    	int right = height.length-1;
    	for(int i=0;i<right+1; i++){
    		if(height[i] > max){
    			max = height[i];
    			maxPos = i;
    		}
    	}
    	int left =0;
    	int size = height.length;
    	while(left < size &&height[left]==0)left++;
    	while(right > -1 && height[right]==0) right--;
    	int ans =0;
    	while(left < maxPos){
    		int j= left+1;
    		int co = 0 ;
    		while(j < maxPos && height[j]< height[left]){
    			co+=height[j];
    			j++;
    		}
    		ans += (j-left-1)*height[left]-co;
    		left = j;
    	}
    	while(right > maxPos){
    		int j = right-1;
    		int co = 0 ;
    		while( j > maxPos && height[j] < height[right]){
    			co+=height[j];
    			j--;
    		}
    		ans+=(right-j-1)*height[right]-co;
    		right = j;
    	}
    	return ans;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrappingRainWater42 tr = new TrappingRainWater42();
		int []height = {0};
		System.out.println(tr.trap(height));
	}

}
