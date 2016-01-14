package qiang.leetcode2;

import java.util.SortedSet;
import java.util.TreeSet;

public class CountOfRangeSum327 {

	public static void main(String[] args) {
		
		int []nums = {-2,5,-1};
		System.out.println(countRangeSum(nums, -2, 2));
		
	}
	   
	public static  int countRangeSum(int[] nums, int lower, int upper) {
	
		int ans = 0;
		if(nums == null || nums.length ==0)return ans;
		TreeSet<Integer> sumSort = new TreeSet<>();
		sumSort.add(nums[0]);
		int sum = nums[0];
		int up,low;
		SortedSet<Integer> temp;
		//if(sum<=upper && sum>=lower )ans++;
		for (int i =1; i < nums.length;i++){
			sum +=nums[i];
			up = sum - lower;
			low = sum  - upper;
			temp = sumSort.subSet(low, up);
			System.out.println(temp.toString()+":"+sumSort.toString());
			ans +=temp.size();
			sumSort.add(sum);
		}
		
		return ans;
	}
	
}
