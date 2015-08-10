package qiang.leetcode;

public class ContainsDuplicateII_219 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
         boolean flag = false;
    	int size = nums.length;
    	if(size == 0 || k == 0)return flag;
    	if( k> size ) return false;
    	
    	for(int i = 0 ; i < size-k+1;i++){
    		for(int j=i+1;j<i+k;j++)
    			if(nums[i] == nums[j]){
    				 return true;
    			}
    	}
    	return false;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {-1,-1};
		System.out.println(containsNearbyDuplicate(nums,1));
	}

}
