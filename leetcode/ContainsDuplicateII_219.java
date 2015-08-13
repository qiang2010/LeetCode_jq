package qiang.leetcode;

import java.util.HashMap;

public class ContainsDuplicateII_219 {

	/**
	 *  由217 当判断一个数组中是否有重复的元素的时候，使用一个Set就可以了。
	 *  这里限制了i和j的范围是k以内，
	 *  可以使用一个map，key是数组元素，value是数组元素对应在原来的index。
	 *  对于当前元素，首先在map中看是否存在该元素，
	 *  如果存在获取其value，判断value和当前元素的index之差是否在k内。
	 * @param nums
	 * @param k
	 * @return
	 */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
    	boolean flag = false;
    	int size = nums.length;
    	if(size <= 1 || k ==0 )return flag;
    	HashMap<Integer,Integer>  map = new HashMap<Integer,Integer>();
    	map.put(nums[0], 0);
    	for(int i = 1 ; i < size;i++){
    		if(map.containsKey(nums[i])){
    			int j = map.get(nums[i]);
    			if(i-j<= k) return true;
    		}
    		map.put(nums[i], i);
 
    	}
    	return false;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {-1,1,-1,0,0};
		System.out.println(containsNearbyDuplicate(nums,1));
	}

}
