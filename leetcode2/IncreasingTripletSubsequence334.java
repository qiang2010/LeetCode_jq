package qiang.leetcode2;

public class IncreasingTripletSubsequence334 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,1,-2,6};
		System.out.println(increasingTriplet(nums));
	}
    public static boolean increasingTriplet(int[] nums) {
     
    	if(nums == null || nums.length < 3)return false;
    	int min = nums[0];
    	int bigger = Integer.MAX_VALUE;
    	int cur;
    	for(int i =1;i<nums.length;i++){
    		cur = nums[i];
    		if(cur <= min){
    			min = cur;
    		}else if(cur <=  bigger ){
    			bigger = cur;
    		}else if(cur > bigger){
    			return true;
    		}
    	}
    	return false;
    }
}
