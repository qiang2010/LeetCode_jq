package qiang.leetcode5;

public class SingleNumber137 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums []={3,3,3,2};
		
		System.out.println(singleNumber(nums));
	}
	/**
	 * Given an array of integers, every element appears three times except for one.
	 *  Find that single one.
	 *  这里和136题目相似,但是这里是三个数字
	 * @param nums
	 * @return
	 */
    public static int singleNumber(int[] nums) {
        int count[] = new int[32];
        int res =0;
        int size = nums.length;
        for(int i =0;i<32;i++){
        	count[i]=0;
        	for(int j=0;j< size;j++){
        		count[i] += (nums[j] &1);
        		nums[j] = nums[j]>>1;
        	}
        	res |= (count[i]%3)<<i;
        }
        return res;
    }
	

}
