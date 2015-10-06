package qiang.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence128 {

	
	   
	
	public int longestConsecutive(int[] nums) {
	        
		if(nums == null || nums.length ==0) return 0;
		Set<Integer> allNum  = new HashSet<>();
		for(int a:nums){
			allNum.add(a);
		}
		int max = -1;
		int tempCount;
		int temp = 0 ; 
		for(int a:nums){
			tempCount = 0 ; 
			if(allNum.contains(a)){
				tempCount++;
				allNum.remove(a);
				temp = a;
				while(allNum.contains(++a)){
					tempCount++;
					allNum.remove(a);
				}
				while(allNum.contains(--temp)){
					tempCount++;
					allNum.remove(temp);
				}
				max = max > tempCount?max : tempCount;
			}
		}
		return max;
	}
	

	
	public static void main(String[] args) {
	
		int nums[]= {0,-1};
		System.out.println(new LongestConsecutiveSequence128().longestConsecutive(nums));

	
	}	
}
