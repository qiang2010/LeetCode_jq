package qiang.leetcode5;

public class RemoveElement27 {

	  public static  int removeElement(int[] nums, int val) {
	        int count =0;
	        int size = nums.length;
	        for(int i = 0 ; i < size; i++){
	        	if(nums[i]!= val)
	        		nums[count++] = nums[i];
	        } 
	        for(int x:nums)System.out.print(x+" ");
	        System.out.println();
	        return count; 
	    }
	
    public static  int removeElement1(int[] nums, int val) {
        int count =0;
        int size = nums.length;
        for(int i = 0 ; i < size; i++){
        	if(nums[i]== val)continue;
        	nums[count++] = nums[i];
        } 
        for(int x:nums)System.out.print(x+" ");
        System.out.println();
        return count; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {1,3,4,5,2,3};
		System.out.println(removeElement(nums, 3));
	}

}
