package qiang.leetcode;

import java.util.Arrays;

public class KthLargestElementInAnArray215_2 {

	public static void main(String[] args) {
		
		int [] nums = {2,1,33,3,20,3,3,3,3};
		System.out.println(Arrays.toString(nums));
//		System.out.println(new KthLargestElementInAnArray215_2().findKthLargest(nums, 2));
		new KthLargestElementInAnArray215_2().quickSort(nums, 0, nums.length-1);
		System.out.println(Arrays.toString(nums));
	}
		public int findKthLargest(int[] nums, int k) { 
			if(nums == null) return -1;
			int i =0;
			int j = nums.length-1;
			int find = -1;
			while(true){
				find = this.partation(nums, i, j);
				if(find+1 == k) return nums[find];
				else{
					if(find+1 < k){
						i = find+1;
					}else j = find-1;
				}
			}
		}
		public void quickSort(int []nums,int i,int j){
			if( i >= j) return;
			int f = this.partation(nums, i, j);
			this.quickSort(nums, i, f-1);
			this.quickSort(nums, f+1, j);
		}
		
		int partation(int[]nums,int i,int j){
			int tempI = i;
			i++;
			int pivo = nums[tempI];
			while(i<=j){
				while(i<=j && nums[i]>= pivo)i++;
				while(i<=j && nums[j]< pivo) j--;
				if(i<j){
					swap(nums,i,j);
				}
			}
//	 		j = j < tempI?tempI:j;
			swap(nums,tempI,j);
			return j;
		}
		void swap(int []nums,int i,int j){
			int t = nums[i];
			nums[i] = nums[j];
			nums[j]= t;
		}
		
}
