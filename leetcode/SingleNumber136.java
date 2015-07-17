package qiang.leetcode;

public class SingleNumber136 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int sigleNum(int[]nums){
		int len = nums.length;
		int res=nums[0];
		for(int i =1;i<len;i++){
			res= res^nums[i];
		}
	
		return res;
	}

}
