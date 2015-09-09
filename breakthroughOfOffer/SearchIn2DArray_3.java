package qiang.breakthroughOfOffer;

public class SearchIn2DArray_3 {

	
	
	/**
	 *  给定数组的每一行每一列都是有序的，找到target是否在该数组中。
	 * @param nums
	 * @param target
	 * @return
	 */
	public static boolean findIn2DArray(int [][]nums,int target){
		
		if(nums == null || nums.length == 0) return false; 
		
		int row = nums.length;
		int col = nums[0].length;
		
		int tempRow = 0;
		int tempCol = col-1;
		while(true){
			if(target == nums[tempRow][tempCol]){
				return true;
			}else{
				if(target < nums[tempRow][tempCol]){
					tempCol--;
				}else{
					tempRow++;
				}
				if(tempCol <0 || tempRow > row-1)
					return false;
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]nums = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		System.out.println(findIn2DArray(nums, 0));
	}

}
