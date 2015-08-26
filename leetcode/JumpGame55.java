package qiang.leetcode;

public class JumpGame55 {

	
	
    public boolean canJump(int[] nums) {
    	if(nums == null || nums.length == 0) return false;
    	int size = nums.length;
    	
    	int step = nums[0];
    	for(int j = 1 ; j< size; j++){
    		
    		if(step>0){
    			
    			step--;
    			if(step + j>nums.length ) return true;
    			step = step > nums[j] ?  step:nums[j];
    		}else{
    			return false;
    		}
    	}
    	 return true;
    }	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {3,2,1,0,4};
		JumpGame55 jg = new JumpGame55();
		System.out.println(jg.canJump(nums));
	}

}
