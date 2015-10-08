package qiang.leetcode;

public class MajorityElement169 {
    
	
	/**
	 *  使用两个变量，一个记录当前的数，一个记录次数。
	 * 
	 * @param nums
	 * @return
	 */
	public   int majorityElement2(int[] nums) {
		
		if(nums == null )return -1;
		if(nums.length <3)return nums[0];
		
		int cur = nums[0];
		int count = 0 ; 
		
		for(int num:nums){
			if(num != cur){
				count--;
			}else{
				count++;
			}
			if(count == 0){
				cur = num;
				count = 1;
			}
		}
		return cur;
	}
	
	public int majorityElement(int[] nums) {
		int left =0;
		int right = nums.length;
		int mid = (nums.length >>1 );
		int k = partation(nums, left, right); 
		
		while( k != mid){
			if( k < mid){
				left = k+1;
				k = partation(nums, left, right);
				
			}else{
				right = k-1;
				k = partation(nums, left, right);
			}
			
		}
    	return nums[k];
    }
	
	
	
	int partation(int []nums,int left,int right){
		
		if(left > right) return -1;
		int target = nums[left];
		int targetIndex = left;
		left++;
		int temp ;
		while(left < right){
			while(left < nums.length && nums[left] <=  target){
				left++;
			}
			while(right > -1 && nums[right] > target){
				right--;
			}
			if(left > right){
				break;
			}
			// 交换
			temp = nums[left];
			nums[left]  = nums[right];
			nums[right]  = temp;
			
			left++;
			right--;
		}
		temp = nums[right];
		nums[right ]= target;
		nums[targetIndex] = temp;
		return right;
	}
    
    public static void main(String[] args) {
    	//{2,5,2,5,8,2,8,8,8,8,8};//{2,2,2,56,1};
    	
    

    	int[] nums =  {3,3,4,5,3};
    	
    	System.out.println(nums.length);
    	System.out.println(new MajorityElement169().partation(nums, 0, nums.length-1));
	
    	System.out.println(new MajorityElement169().majorityElement2(nums));
    }
   
}
