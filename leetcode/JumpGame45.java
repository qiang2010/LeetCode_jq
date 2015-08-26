package qiang.leetcode;

public class JumpGame45 {

	
	
	 public int jump(int[] nums) {
	        
	    	if(nums == null || nums.length == 0) return -1;
	    	int size = nums.length;
	    	int ret = 0;
	    	int step = 0; // 当前所能到达的最远的位置
	    	int last = 0; // 上一跳所能到达的最远位置
	    	for( int i= 0; i< size; i++){
	    		
	    		if(i > step){
	    			return -1;
	    		}
	    		if(i > last){
	    			last = step;
	    			ret ++;
	    		}
	    		
	    		// 更新当前所能到达的最远位置。
	    		step = step >i+ nums[i]? step : i+nums[i];
	    	}
	    	return ret;
	    }	
	
	
	/**
	 * 错误代码
	 * @param nums
	 * @return
	 */
    public int jump2(int[] nums) {
        
    	if(nums == null || nums.length == 0) return -1;
    	int size = nums.length;
    	if(size == 1) return 0;
    	int ret = 1;
    	int step = nums[0];
    	
    	for( int i= 1; i< size; i++){
    		
    		if(step >0){
    			if(step + i >= nums.length) return ret;
    			step--;
    			if(nums[i] > step ){
    				step = nums[i];
    				ret++;
    			}
    			
    		}else{
    			return -1;
    		}
    	}
    	return ret;
    }	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
		JumpGame45 jg = new JumpGame45();
		System.out.println(jg.jump(nums));
	}

}
