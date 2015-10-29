package qiang.tree;

import java.util.TreeSet;

public class ContainsDuplicateIII220 {
   
	public static void main(String[] args) {
		
		int nums[]={-1,2147483647};
		System.out.println(new ContainsDuplicateIII220().containsNearbyAlmostDuplicate(nums, 1, 2147483647));
		
	}
	
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		
		if(nums == null || nums.length <2) return false;
    
		if(k == 0) return false;
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(nums[0]);
		for(int i =1;i<nums.length;i++){
			Integer cel = set.ceiling(nums[i]);
			if(cel != null){
				long a = (long)((long)cel - (long)nums[i]); 
				if(a<=t)return true;
			}
			Integer foo = set.floor(nums[i]);
			if(foo !=null){
				long a = (long)((long)nums[i] - (long)foo); 
				if(a <=t)return true;
			}
			if(set.size() > k-1){
				set.remove(nums[i-k]);
			}
			set.add(nums[i]);
		}
		return false;
	}
}
