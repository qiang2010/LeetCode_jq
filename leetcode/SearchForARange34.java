package qiang.leetcode;

public class SearchForARange34 {

    public int[] searchRange(int[] nums, int target) {
     
    	int []ans={-1,-1};
    	int left = 0;
    	int right = nums.length-1;
    	int pos = binarySearch(nums, left,right, target);
    	System.out.println("pos"+ pos);
    	if(pos==-1){
    		return ans;
    	}
    	int leftPos=pos,lastLeftPos=pos, rightPos=pos,lastRightPos=pos;	
    	int mid = (left + right)/2;
    	if(pos < mid){
        		right = mid-1;
        	}else{
        		if(pos > mid)
        			left = mid+1;
        	}
    	// 一直找左侧，因为lastLeftPos 到 pos之间肯定都是target
    	while(lastLeftPos != -1){
    		leftPos = lastLeftPos;
    		lastLeftPos = binarySearch(nums, left, leftPos-1, target);
    		
     	}
    	// 一直找右侧侧，因为 pos到lastRightPos 到之间肯定都是target
    	while(lastRightPos != -1){
    		rightPos = lastRightPos;
    		lastRightPos = binarySearch(nums, rightPos+1, right, target);
    		
     	}
    	if(rightPos==-1){
    		rightPos = pos;
    	}
    	if(leftPos == -1){
    		leftPos=pos;
    	}
    	ans[0] = leftPos;
    	ans[1] = rightPos;
    	return ans;
    }
	
    public int binarySearch(int []nums,int left ,int right,int target){
    	
    	if(nums == null || nums.length == 0) return -1;
    	
    	int mid;
    	while(left <= right){
    		mid = (left + right)/2;
    		if(nums[mid] == target)return mid;
    		if(nums[mid] < target){
    			left = mid+1;
    		}else{
    			right = mid-1;
    		}
    	}
    	return -1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchForARange34 sf = new SearchForARange34();
		int []nums = {0,1,2,3,4,4,4};
		int []ans = sf.searchRange(nums,2);
		System.out.println(ans[0]);
		System.out.println(ans[1]);
	}

}
