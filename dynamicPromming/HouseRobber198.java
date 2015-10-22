package qiang.dynamicPromming;

public class HouseRobber198 {

	
    
	
	public int rob(int[] nums) {
        
		if(nums == null || nums.length ==0) return 0;
		if(nums.length == 1) return nums[0];
		int last0 = 0 ;
		int last1 = nums[0] ;
		int tempLast;
		for(int i =1; i < nums.length;i++){
			tempLast = Math.max(last1, last0);
			last1 = last0 + nums[i];
			last0 = tempLast;
		}
		return Math.max(last1, last0);
	}
	
	public static void main(String[] args) {
		int []nums = {1};
		System.out.println(new HouseRobber198().rob(nums));
	}
	
	
}
